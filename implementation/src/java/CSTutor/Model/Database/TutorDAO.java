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
  private static Connection c = connect();
   
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
         Statement s = c.createStatement();
         String statement = "INSERT OR IGNORE INTO Users VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";
         s.executeUpdate(String.format(statement, username, hash, firstname, lastname, permissions));
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
         Statement s = c.createStatement();
         String statement = "SELECT * FROM Users WHERE username=\"" + username + "\"";
         ResultSet r = s.executeQuery(statement);
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
   public static void addTutorial(int id, String title, String description,
    String syntax, String exampleCode, String tryitYourself, String hasSeen) {
      try {
         Statement s = c.createStatement();
         String statement = "INSERT OR IGNORE INTO TutorialData VALUES (%d, \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";
         s.executeUpdate(String.format(id, title, description, syntax, exampleCode, tryitYourself, hasSeen));
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
   public static Map<String, String> getTutorial(int id) {
      try {
         Statement s = c.createStatement();
         String statement = "SELECT * FROM TutorialData WHERE id=\"" + id + "\"";
         ResultSet r = s.executeQuery(statement);
         Map<String, String> data = new HashMap<String, String>();
         List<String> cols = Arrays.asList("id", "title", "description", "syntax", "exampleCode", "tryitYourself", "hasSeen");
         for (String col : cols) {
            data.put(col, r.getString(col));
         }
         s.close();
         return data;
      } catch(Exception e) { // tutorial not in db
        return null;
      }

   /**
    * Get a list of class names.
    *
    * @return List of class names.
    */
   public static List<String> getClasses() {
      List<String> classes = new ArrayList<String>();
      try {
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("SELECT name FROM classes;");
        while (r.next()) {
          classes.add(r.getString("name"));
        }
        return classes;
      } catch(Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(1); return null;
      }
   }

   /**
    * Get a list of section numbers for a class.
    *
    * @param className Name of the class for which to look up sections.
    * @return List of section numbers (as a String)
    */
   public static List<String> getSections(String className) {
      try {
         Statement s = c.createStatement();
         ResultSet r = s.executeQuery(String.format(
          "SELECT sectionNum FROM sections WHERE className = \"%s\";", className));
         List<String> sections = new ArrayList<String>();
         while (r.next()) {
           sections.add(r.getString("sectionNum"));
         }
         return sections;
      } catch(Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(1); return null;
      }
   }

   /**
    * Get class hierarchy from database.
    *
    * @return List of list of strings representing class hierarchy from database.
    */
   public static List<List<String>> getClassHierarchy() throws Exception {
      Statement s = c.createStatement();
      List<String> classes = getClasses();
      List<List<String>> hierarchy = null;
      return hierarchy;
   }
}