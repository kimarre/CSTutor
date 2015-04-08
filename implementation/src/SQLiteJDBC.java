import java.sql.*;

public class SQLiteJDBC {
   private static final String db_name = "test.db"
   private static final String create_students_table = 
    "CREATE TABLE students (username TEXT PRIMARY KEY, first TEXT NOT NULL, last TEXT NOT NULL);";

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
}
