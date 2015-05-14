package CSTutor.Model.Database;

import java.nio.file.*;
import java.sql.*;
import java.util.*;

/**
 * CSTutor Data Access Object.
 * Interfaces with the sqlite database.
 *
 * @author dlgordon
 */
public class TutorDAO {
   private static final String db_path = "tutordb.db";
   private static final String init_db_path = "/CSTutor/Model/Database/tutordb.sql";
   private static Connection conn = connect();
   
   /**
   * Connect to the db
   * 
   */
   private static Connection connect() {
      try {
         Class.forName("org.sqlite.JDBC");
         Connection c = DriverManager.getConnection("jdbc:sqlite:" + db_path);
         init_db(c);
         return c;
      } catch(Exception e) {
         System.err.println("Couldn't open db connection.");
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }  
   
   /**
    * Initialize the database by running the SQL statements in tutordb.sql.
    * Create tables if they don't exist, and populate with initial data.
    *
    * @param con connection to the db
    */
   private static void init_db(Connection con) throws Exception { 
      Statement s = con.createStatement();
      java.io.InputStream input = TutorDAO.class.getResourceAsStream(init_db_path);
      java.util.Scanner scan = new java.util.Scanner(input).useDelimiter(";\n*");
      while (scan.hasNext()) {
         s.executeUpdate(scan.next());
      }
      s.close();
   }

   /**
    * Add new user
    *
    * @param username user's username
    * @param hash user's hash
    * @param firstname user's first name
    * @param lastname user's last name
    * @param permissions the permission identifier (ie instructor) of the user
    */
   public static void addUser(String username, String hash, String firstname,
    String lastname, String permissions) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO Users VALUES (?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(username, hash, firstname, lastname, permissions);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         s.executeUpdate();
         s.close();
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

   /**
    * Get user info (as column/value map) by username
    *
    * @param username user's username
    * @return Map of columns to values, or null if not found.
    */
   public static Map<String, String> getUser(String username) {
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM Users WHERE username=?");
         s.setString(1, username);
         ResultSet r = s.executeQuery();
         Map<String, String> user = new HashMap<String, String>();
         List<String> cols = Arrays.asList("username", "hash", "firstname", "lastname", "instructor");
         for (String col : cols) {
            user.put(col, r.getString(col));
         }
         s.close();
         return user;
      } catch(Exception e) { // user not in db
         return null;
      }
   }

   /**
    * Add new tutorial 
    *
    * @param id the identifier for the tutorial
    * @param title the title for the tutorial
    * @param description the description for the tutorial
    * @param syntax the syntax for the tutorial
    * @param exampleCode the example code for the tutorial
    * @param tryitYourself the try it yourself text for the tutorial
    * @param hasSeen whether the tutorial has been seen, yes/no.
    */
   public static void addTutorialData(int id, String title, String description,
    String syntax, String exampleCode, String tryitYourself, String hasSeen) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO TutorialData VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(String.valueOf(id), title, description, syntax, exampleCode, tryitYourself, hasSeen);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         s.executeUpdate();
         s.close();
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

   /**
    * Get tutorial data (as column/value map) by id
    *
    * @param id the identifier for the tutorial
    * @return Map of columns to values, or null if not found
    */
   public static Map<String, String> getTutorialData(int id) {
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM TutorialData WHERE id=?");
         s.setInt(1, id);
         ResultSet r = s.executeQuery();
         Map<String, String> data = new HashMap<String, String>();
         List<String> cols = Arrays.asList("id", "title", "description", "syntax", "exampleCode", "tryitYourself", "hasSeen");
         for (String col : cols) {
            data.put(col, r.getString(col));
         }
         s.close();
         return data;
      } catch(Exception e) { // tutorial data not in db
         return null;
      }
   }

   /**
    * Get list of Pages for the specified tutorial
    *
    * @return List of Pages
    */
   public static List<CSTutor.Model.Manager.Page> getPages(CSTutor.Model.Manager.Tutorial tutorial) {
      List<CSTutor.Model.Manager.Page> pages = new ArrayList<CSTutor.Model.Manager.Page>();
      CSTutor.Model.Manager.Page p;
      try {
         PreparedStatement s = conn.prepareStatement(
          "SELECT * FROM Pages WHERE tutorialName=? AND unitName=? AND sectionName=? AND className=?");
         List<String> values = Arrays.asList(tutorial.name, tutorial.parent.name,
          tutorial.parent.parent.name, tutorial.parent.parent.parent.name);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         ResultSet r = s.executeQuery();
         while (r.next()) {
            p = new CSTutor.Model.Manager.Page(r.getString("name"), tutorial);
            pages.add(p);
         }
         s.close();
         return pages;
      } catch(Exception e) { // tutorial not in db
         return pages;
      }
   }

   /**
    * Get class hierarchy from database.
    *
    * @return List of classes
    */
   /*public static List<CSTutor.Model.Manager.Class> getClasses() {
      List<CSTutor.Model.Manager.Class> classes = new ArrayList<CSTutor.Model.Manager.Class>();
      CSTutor.Model.Manager.Class c;
      try {
         Statement s = conn.createStatement();
         ResultSet r = s.executeQuery("SELECT name FROM classes;");
         while (r.next()) {
            c = new CSTutor.Model.Manager.Class(r.getString("name"));
            classes.add(c);
         }
         s.close();
         return classes;

      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }*/

   /**
    * Get a list of class names.
    *
    * @return List of class names.
    */
   public static List<String> getClassNames() {
      List<String> classes = new ArrayList<String>();
      try {
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT name FROM classes;");
        while (r.next()) {
          classes.add(r.getString("name"));
        }
        s.close();
        return classes;
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }
}