import java.util.*;
import java.sql.*;

// CSTutor Data Access Object
public class CstDAO {
   private static final String db_name = "test.db";
   private static final String create_students_table = "CREATE TABLE IF NOT EXISTS "
    + "students (username TEXT PRIMARY KEY, first TEXT NOT NULL, last TEXT NOT NULL);";

   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:" + db_name);
         create_tables(c);
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(1);
      }
      System.out.println("Opened database successfully");
   } 
   
   
   public static void create_tables(Connection c) throws Exception { 
      Statement s = c.createStatement();
      s.executeUpdate(create_students_table);
      s.close();
   }

   // Given a student, update the student if already exists or create if not.
   public int upsert_student(String username, String first, String last) {
      return 0;
   }

   // Return a student row as a list of strings
   public List<String> get_student(String username) {
      return new ArrayList<String>(Arrays.asList("", "", ""));
   }
}
