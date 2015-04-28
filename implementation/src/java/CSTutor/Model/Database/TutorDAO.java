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
   private static final String init_db_path = "tutordb.sql";
   private static final String upsert_user_query =
    "INSERT OR REPLACE INTO users VALUES (\"%s\", \"%s\", \"%s\", \"%s\");";
   private static final String get_user_query =
    "SELECT * FROM users WHERE username=\"%s\";";
   private static final String upsert_quiz_query =
    "INSERT OR REPLACE INTO quizzes VALUES (\"%s\", \"%s\", \"%s\", \"%s\");";
   private static final String get_quiz_query =
    "SELECT * FROM quizzes WHERE id=\"%s\";";

   private Connection c;
   
   /**
    * Constructor.
    * 
    * @precondition Database exists in directory and JDBC is imported.
    * @postcondition Connection opened to database.
    */
   public TutorDAO() throws Exception {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + db_path);
      init_db();
   }  
   
   /**
    * Initialize the database by running the SQL statements in tutordb.sql.
    * Create tables if they don't exist, and populate with initial data.
    *
    * @precondition Database exists.
    * @postcondition Database is initialized.
    */
   private void init_db() throws Exception { 
      Statement s = c.createStatement();
      String[] statements = new String(Files.readAllBytes(Paths.get(init_db_path))).split(";\n");
      for (int i = 0; i < statements.length; i++) {
         s.executeUpdate(statements[i]);
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
   public void upsert_user(String username, String first, String last, String permissions) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsert_user_query, username, first, last, permissions));
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
   public List<String> get_user(String username) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(get_user_query, username));
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
   public void upsert_quiz(int id, String quiz, String permissions, String owner) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsert_quiz_query, String.valueOf(id), quiz, permissions, owner));
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
   public String get_quiz(int id) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(get_quiz_query, String.valueOf(id)));
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
   public List<String> getClasses() throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery("SELECT name FROM classes;");
      List<String> classes = new ArrayList<String>();
      while (r.next()) {
        classes.add(r.getString("name"));
      }
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
   public List<String> getSections(String className) throws Exception {
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
   public List<List<String>> getClassHierarchy() throws Exception {
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
      try {
         d = new TutorDAO();
         d.upsert_user("dlgordon", "Luke", "Gordon", "student");
         user = d.get_user("dlgordon");
         if (!user.get(1).equals("Luke"))
            throw new Exception();
         d.upsert_quiz(1, "Test", "all", "dlgordon");
         quiz = d.get_quiz(1);
         if (!quiz.equals("Test"))
            throw new Exception();
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
