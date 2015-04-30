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
   private static Connection c = init();
   
   private static final String upsertUser_query =
    "INSERT OR REPLACE INTO users VALUES (\"%s\", \"%s\", \"%s\", \"%s\");";
   private static final String getUser_query =
    "SELECT * FROM users WHERE username=\"%s\";";
   private static final String upsertQuiz_query =
    "INSERT OR REPLACE INTO quizzes VALUES (\"%s\", \"%s\", \"%s\", \"%s\");";
   private static final String getQuiz_query =
    "SELECT * FROM quizzes WHERE id=\"%s\";";
   
   /**
    * Constructor.
    * 
    * @precondition Database exists in directory and JDBC is imported.
    * @postcondition Connection opened to database.
    */
   private static Connection init() {
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
    * @precondition Database exists.
    * @postcondition Database is initialized.
    */
   private static void init_db(Connection con) throws Exception { 
      Statement s = con.createStatement();
      java.io.InputStream input = TutorDAO.class.getResourceAsStream(init_db_path);
      java.util.Scanner scan = new java.util.Scanner(input).useDelimiter(";");
      while (scan.hasNext()) {
        s.executeUpdate(scan.next());
      }
      s.close();
   }

   /**
    * Given a user, update the user if already exists or create if not.
    *
    * @precondition user table exists.
    * @postcondition user is upserted into table.
    * @param username user's username
    * @param first user's first name
    * @param last user's last name
    */
   public static void upsertUser(String username, String first, String last, String permissions) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsertUser_query, username, first, last, permissions));
      s.close();
   }

   /**
    * Get user (as string list) by username.
    *
    * @precondition user exists in table.
    * @postcondition None.
    * @param username user's username
    * @return String list of the user's columns
    */
   public static List<String> getUser(String username) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(getUser_query, username));
      ArrayList<String> user = new ArrayList<String>(Arrays.asList(
       r.getString("username"), r.getString("first"), r.getString("last")));
      s.close();
      return user;
   }

   /**
    * Given a quiz, update the quiz if already exists or create if not.
    *
    * @precondition Quiz table exists.
    * @postcondition Quiz is upserted into table.
    * @param id Quiz id
    * @param quiz Content of the quiz
    */
   public static void upsertQuiz(int id, String quiz, String permissions, String owner) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsertQuiz_query, String.valueOf(id), quiz, permissions, owner));
      s.close();
   }

   /**
    * Get quiz by id
    *
    * @precondition Quiz exists in table.
    * @postcondition None.
    * @param id Quiz id
    * @return Content of the quiz.
    */
   public static String getQuiz(int id) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(getQuiz_query, String.valueOf(id)));
      String quiz = r.getString("name");
      s.close();
      return quiz;
   }

   /**
    * Get a list of class names.
    *
    * @precondition None.
    * @postcondition None.
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
      } catch(Exception e) {System.out.println(e);}
      return classes;
   }

   /**
    * Get a list of section numbers for a class.
    *
    * @precondition None.
    * @postcondition None.
    * @param className Name of the class for which to look up sections.
    * @return List of section numbers (as a String)
    */
   public static List<String> getSections(String className) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(
       "SELECT sectionNum FROM sections WHERE className = \"%s\";", className));
      List<String> sections = new ArrayList<String>();
      while (r.next()) {
        sections.add(r.getString("sectionNum"));
      }
      return sections;
   }

   /**
    * Get class hierarchy from database.
    *
    * @precondition None.
    * @postcondition None.
    * @return List of list of strings representing class hierarchy from database.
    */
   public static List<List<String>> getClassHierarchy() throws Exception {
      Statement s = c.createStatement();
      List<String> classes = getClasses();
      List<List<String>> hierarchy = null;
      return hierarchy;
   }

   /**
    * Test each method, throw Exception on error
    *
    * @precondition None.
    * @postcondition None.
    */
   public static void test() {
      TutorDAO d;
      List<String> user;
      String quiz;
      List<String> classes;
      try {
         d = new TutorDAO();
         d.upsertUser("dlgordon", "Luke", "Gordon", "student");
         user = d.getUser("dlgordon");
         if (!user.get(1).equals("Luke"))
            throw new Exception();
         d.upsertQuiz(1, "Test", "all", "dlgordon");
         quiz = d.getQuiz(1);
         if (!quiz.equals("Test"))
            throw new Exception();
         classes = d.getClasses();
         System.out.println(classes);

      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(1);
      }
      System.out.println("Test successful.");
   }

   /**
    * Main for testing only
    */
   public static void main(String[] args) {
      test();
   }
}
