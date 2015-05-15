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
   //private static List<CSTutor.Model.Manager.Class> classes = getClasses();

   /*private static int print_hierarchy(List<CSTutor.Model.Manager.Class> classes) {
      for (CSTutor.Model.Manager.Class c : classes) {
         System.out.println("<" + c.name + ">");
         for (CSTutor.Model.Manager.Section s : c.sections) {
            System.out.println("  <" + s.name + ">");
            for (CSTutor.Model.Manager.Unit u : s.units) {
               System.out.println("    <" + u.name + ">");
               for (CSTutor.Model.Manager.Tutorial t : u.tutorials) {
                  System.out.println("      <" + t.name + ">");
                  for (CSTutor.Model.Manager.Page p : t.pages) {
                     System.out.println("        <" + p.name + ">");
                  }
               }
            }
         }
      }
      return 0;
   }*/
   
   /**
   * Connect to the database
   *
   * @return Connection to the database
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
    * @param con Connection to the database
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

   
/*** User methods *********************************************************************************/

   /**
    * Add new user
    *
    * @param username user's username
    * @param hash user's hash
    * @param firstname user's first name
    * @param lastname user's last name
    * @param accessLevel the access identifier (Guest, Student, Assistant, Professor) of the user
    */
   public static void addUser(String username, String hash, String firstname,
    String lastname, String accessLevel) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO Users VALUES (?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(username, hash, firstname, lastname, accessLevel);
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


/*** TutorialData methods *************************************************************************/

   /**
    * Add new tutorial 
    *
    * @param tutorial the Tutorial to add
    */
   public static void addTutorialData(CSTutor.Model.Tutorial.TutorialData tutorial) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO TutorialData VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(String.valueOf(tutorial.pageId), tutorial.title,
          tutorial.description.intro, tutorial.description.syntax, tutorial.description.exampleCode,
          tutorial.description.exampleOutput, tutorial.tryItYourself);
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
    * Get TutorialData by id
    *
    * @param id the identifier for the TutorialData
    * @return specified TutorialData object, or null if not found
    */
   public static CSTutor.Model.Tutorial.TutorialData getTutorialData(int id) {
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM TutorialData WHERE id=?");
         s.setInt(1, id);
         ResultSet r = s.executeQuery();
         CSTutor.Model.Tutorial.TutorialData data = new CSTutor.Model.Tutorial.TutorialData(
          id, r.getString("title"), r.getString("description"), r.getString("syntax"),
          r.getString("exampleCode"), r.getString("exampleOutput"), r.getString("tryitYourself"));
         s.close();
         return data;
      } catch(Exception e) { // tutorial data not in db
         return null;
      }
   }


/*** Page methods *********************************************************************************/

   /**
    * Get list of Pages for the specified Tutorial
    *
    * @param tutorial the Tutorial to look up Pages for
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
            p = new CSTutor.Model.Manager.Page(r.getString("pageName"), tutorial);
            pages.add(p);
         }
         s.close();
         return pages;
      } catch(Exception e) { // tutorial not in db
         return pages;
      }
   }


/*** Tutorial methods *****************************************************************************/

   /**
    * Get list of Tutorials for the specified Unit
    *
    * @param unit the Unit to look up Tutorials for
    * @return List of Tutorials
    */
   public static List<CSTutor.Model.Manager.Tutorial> getTutorials(CSTutor.Model.Manager.Unit unit) {
      List<CSTutor.Model.Manager.Tutorial> tutorials = new ArrayList<CSTutor.Model.Manager.Tutorial>();
      CSTutor.Model.Manager.Tutorial t;
      try {
         PreparedStatement s = conn.prepareStatement(
          "SELECT * FROM Tutorials WHERE unitName=? AND sectionName=? AND className=?");
         List<String> values = Arrays.asList(unit.name, unit.parent.name, unit.parent.parent.name);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         ResultSet r = s.executeQuery();
         while (r.next()) {
            t = new CSTutor.Model.Manager.Tutorial(r.getString("tutorialName"), unit);
            t.pages = getPages(t);
            tutorials.add(t);
         }
         s.close();
         return tutorials;
      } catch(Exception e) { // unit not in db
         return tutorials;
      }
   }


/*** Unit methods *********************************************************************************/

   /**
    * Get list of Units for the specified Section
    *
    * @param section the Section to look up Units for
    * @return List of Units
    */
   public static List<CSTutor.Model.Manager.Unit> getUnits(CSTutor.Model.Manager.Section section) {
      List<CSTutor.Model.Manager.Unit> units = new ArrayList<CSTutor.Model.Manager.Unit>();
      CSTutor.Model.Manager.Unit u;
      try {
         PreparedStatement s = conn.prepareStatement(
          "SELECT * FROM Units WHERE sectionName=? AND className=?");
         List<String> values = Arrays.asList(section.name, section.parent.name);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         ResultSet r = s.executeQuery();
         while (r.next()) {
            u = new CSTutor.Model.Manager.Unit(r.getString("unitName"), section);
            u.tutorials = getTutorials(u);
            units.add(u);
         }
         s.close();
         return units;
      } catch(Exception e) { // section not in db
         return units;
      }
   }

/*** Section methods ******************************************************************************/

   /**
    * Get list of Sections for the specified Class
    *
    * @param clas the Class to look up Sections for
    * @return List of Sections
    */
   public static List<CSTutor.Model.Manager.Section> getSections(CSTutor.Model.Manager.Class clas) {
      List<CSTutor.Model.Manager.Section> sections = new ArrayList<CSTutor.Model.Manager.Section>();
      CSTutor.Model.Manager.Section sec;
      try {
         PreparedStatement s = conn.prepareStatement(
          "SELECT * FROM Sections WHERE className=?");
         List<String> values = Arrays.asList(clas.name);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         ResultSet r = s.executeQuery();
         while (r.next()) {
            sec = new CSTutor.Model.Manager.Section(r.getString("sectionName"), clas);
            sec.units = getUnits(sec);
            sections.add(sec);
         }
         s.close();
         return sections;
      } catch(Exception e) { // class not in db
         return sections;
      }
   }


/*** Class methods ********************************************************************************/

   /**
    * Determine the ClassAccessLevel enum for the access string
    *
    * @param access string representing the access level (Guest, Student, Assistant, Professor)
    * @return ClassAccessLevel enum
    */
   private static CSTutor.Model.Manager.Class.ClassAccessLevel getAccessEnum(String access) {
      switch (access) {
         case "Guest":
            return CSTutor.Model.Manager.Class.ClassAccessLevel.Guest;
         case "Student":
            return CSTutor.Model.Manager.Class.ClassAccessLevel.Student;
         case "Assistant":
            return CSTutor.Model.Manager.Class.ClassAccessLevel.Assistant;
         case "Professor":
            return CSTutor.Model.Manager.Class.ClassAccessLevel.Professor;
      }
      return null;
   }

   /**
    * Get a list of classes from the database
    *
    * @return List of classes
    */
   public static List<CSTutor.Model.Manager.Class> getClasses() {
      List<CSTutor.Model.Manager.Class> classes = new ArrayList<CSTutor.Model.Manager.Class>();
      CSTutor.Model.Manager.Class c;
      try {
         Statement s = conn.createStatement();
         ResultSet r = s.executeQuery("SELECT * FROM classes;");
         while (r.next()) {
            c = new CSTutor.Model.Manager.Class(r.getString("className"));
            c.sections = getSections(c);
            c.access = getAccessEnum(r.getString("accessLevel"));
            classes.add(c);
         }
         s.close();
         return classes;
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }

   /**
    * Get a list of class names.
    *
    * @return List of class names.
    */
   public static List<String> getClassNames() {
      List<String> classes = new ArrayList<String>();
      try {
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT className FROM classes;");
        while (r.next()) {
          classes.add(r.getString("className"));
        }
        s.close();
        return classes;
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }
}