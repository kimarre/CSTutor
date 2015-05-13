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
        System.exit(1);
      }
      return null;
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
    * Given a user, update the user if already exists or create if not.
    *
    * @param username user's username
    * @param hash user's hash
    * @param first user's first name
    * @param last user's last name
    * @param permissions the permission identifier (ie instructor) of the user
    */
   public static void addUser(String username, String hash, String firstname, String lastname, String permissions) {
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
    * Get user (as string list) by username.
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
    * Given a quiz, update the quiz if already exists or create if not.
    *
    * @param id Quiz id
    * @param quiz Content of the quiz
    */
   public static void upsertQuiz(int id, String quiz, String permissions, String owner) throws Exception {
      Statement s = c.createStatement();
      //s.executeUpdate(String.format(upsertQuiz_query, String.valueOf(id), quiz, permissions, owner));
      s.close();
   }

   /**
    * Get quiz by id
    *
    * @param id Quiz id
    * @return Content of the quiz.
    */
   public static String getQuiz(int id) throws Exception {
      Statement s = c.createStatement();
      //ResultSet r = s.executeQuery(String.format(getQuiz_query, String.valueOf(id)));
      //String quiz = r.getString("name");
      //s.close();
      return null;//quiz;
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