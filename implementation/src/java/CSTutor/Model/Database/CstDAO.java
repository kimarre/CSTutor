import java.util.*;
import java.sql.*;

// CSTutor Data Access Object
public class CstDAO {
   private static final String db_name = "test.db";
   private static final String create_students_table = "CREATE TABLE IF NOT EXISTS "
    + "students (username TEXT PRIMARY KEY, first TEXT NOT NULL, last TEXT NOT NULL);";
   private static final String upsert_student_query =
    "INSERT OR REPLACE INTO students VALUES (\"%s\", \"%s\", \"%s\");";
   private static final String get_student_query =
    "SELECT * FROM students WHERE username=\"%s\";";

   private Connection c;
   
   public CstDAO() throws Exception {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:" + db_name);
   }  
   
   // Create each table if it doesn't exist
   public void create_tables() throws Exception { 
      Statement s = c.createStatement();
      s.executeUpdate(create_students_table);
      s.close();
   }

   // Given a student, update the student if already exists or create if not.
   public void upsert_student(String username, String first, String last) throws Exception {
      Statement s = c.createStatement();
      s.executeUpdate(String.format(upsert_student_query, username, first, last));
      s.close();
   }

   // Get student (as string list) by username
   public List<String> get_student(String username) throws Exception {
      Statement s = c.createStatement();
      ResultSet r = s.executeQuery(String.format(get_student_query, username));
      ArrayList<String> student = new ArrayList<String>(Arrays.asList(
       r.getString("username"), r.getString("first"), r.getString("last")));
      s.close();
      return student;
   }

   public static void test() {
      CstDAO d;
      List<String> student;
      try {
         d = new CstDAO();
         d.create_tables();
         d.upsert_student("dlgordon", "Luke", "Gordon");
         student = d.get_student("dlgordon");
         if (!student.get(1).equals("Luke"))
            throw new Exception();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(1);
      }
      System.out.println("Test successful.");
   }

   public static void main(String[] args) {
      test();
   }
}
