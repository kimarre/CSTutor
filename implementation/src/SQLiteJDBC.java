import java.sql.*;

public class SQLiteJDBC {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
         init_tables(c);
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   } 
   public static void init_tables(Connection c) throws Exception { 
      Statement s = c.createStatement();
      String query =
       "CREATE TABLE students (username TEXT PRIMARY KEY, first TEXT NOT NULL, last TEXT NOT NULL);";
      s.executeUpdate(query);
      s.close();
   }
}
