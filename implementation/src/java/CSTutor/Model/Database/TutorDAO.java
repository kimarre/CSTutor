//package CSTutor.Model.Database;

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
   private static final String upsert_student_query =
    "INSERT OR REPLACE INTO students VALUES (\"%s\", \"%s\", \"%s\");";
   private static final String get_student_query =
    "SELECT * FROM students WHERE username=\"%s\";";
   private static final String upsert_quiz_query =
    "INSERT OR REPLACE INTO quizzes VALUES (\"%s\", \"%s\");";
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

   /*private ResultSet upsert(String table, String key_name, String key) {


   }*/

   /**
    * Given a student, update the student if already exists or create if not.
    *
    * @precondition Student table exists.
    * @postcondition Student is upserted into table.
    * @param username Student's username
    * @param first Student's first name
    * @param last Student's last name
    */
   public void upsert_student(String username, String first, String last) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsert_student_query, username, first, last));
      s.close();
   }

   /**
    * Get student (as string list) by username.
    *
    * @precondition Student exists in table.
    * @postcondition None.
    * @param username Student's username
    * @return String list of the student's columns
    */
   public List<String> get_student(String username) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(get_student_query, username));
      ArrayList<String> student = new ArrayList<String>(Arrays.asList(
       r.getString("username"), r.getString("first"), r.getString("last")));
      s.close();
      return student;
   }

   /**
    * Given a quiz, update the quiz if already exists or create if not.
    *
    * @precondition Quiz table exists.
    * @postcondition Quiz is upserted into table.
    * @param id Quiz id
    * @param quiz Content of the quiz
    */
   public void upsert_quiz(int id, String quiz) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsert_quiz_query, String.valueOf(id), quiz));
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
      String quiz = r.getString("quiz");
      s.close();
      return quiz;
   }

   /**
    * Test each method, throw Exception on error
    *
    * @precondition None.
    * @postcondition None.
    */
   public static void test() {
      TutorDAO d;
      List<String> student;
      String quiz;
      try {
         d = new TutorDAO();
         d.upsert_student("dlgordon", "Luke", "Gordon");
         student = d.get_student("dlgordon");
         if (!student.get(1).equals("Luke"))
            throw new Exception();
         d.upsert_quiz(1, "Test");
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
