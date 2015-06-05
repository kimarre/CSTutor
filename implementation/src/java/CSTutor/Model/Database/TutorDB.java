package CSTutor.Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import CSTutor.Model.Manager.Class.ClassAccessLevel;

/**
 * Class TutorDB provides an interface to the sqlite database. Contains methods
 * for getting and setting values to and from the database. At startup the
 * connection to the database is instantiated and the sql statements in an SQL
 * script are executed to ensure all tables are created and the initial data
 * exists in the database. 
 *
 * @author dlgordon (dlgordon@calpoly.edu)
 */
public class TutorDB {
   private static final String db_path = "tutordb.db"; // Path to the database
   private static final String init_db_path = "/CSTutor/Model/Database/tutordb.sql"; // Path to the SQL script
   private static Connection conn = connect(); // The db connection used by all access methods
   
/*** Helper methods *******************************************************************************/

   /**
   * Returns a connection to the database for later use. This method is executed
   * only once, at startup.
   *
   * @return Connection to the database
   * pre:
   *  new java.io.File(db_path).exists();
   * post:
   *  return != null;
   */
   private static Connection connect() {
      try {
         // Connect to the sqlite file
         Class.forName("org.sqlite.JDBC");
         Connection c = DriverManager.getConnection("jdbc:sqlite:" + db_path);
         c.setAutoCommit(false);
         init_db(c);
         return c;
      } catch(Exception e) {
         // Since the program is unuseable without a db connection, crash on exception
         System.err.println("Couldn't open db connection. " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
         return null;
      }
   }  
   
   /**
    * Initialize the database by running the statements in the SQL script.
    * Create tables if they don't exist, and populate with initial data.
    *
    * @param con Connection to the database
    * pre:
    *  con != null && TutorDB.class.getResourceAsStream(init_db_path) != null;
    */
   private static void init_db(Connection con) throws Exception { 
      // Scanner to the SQL script
      java.util.Scanner scan = new java.util.Scanner(
       TutorDB.class.getResourceAsStream(init_db_path)).useDelimiter(";\n*");
      Statement s = con.createStatement();
      while (scan.hasNext()) {
         s.executeUpdate(scan.next()); // Execute each line
      }
      con.commit();
      s.close();
      System.out.println("Initialized database.");

   }

   /**
    * Commit changes to the database. Must be called for db writes to take effect.
    *
    * pre:
    *  conn != null;
    */
   public static void commit() {
      try {
         conn.commit();
      } catch(Exception e) {
         // Committing should never throw an exception in normal operation
         System.err.println("Error in commit(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

   
/*** User methods *********************************************************************************/

   /**
    * Set a user's attributes. If the username does not exist in the database, add a new entry.
    * Otherwise overwrite the entry.
    *
    * @param username user's username
    * @param hash user's hash
    * @param firstname user's first name
    * @param lastname user's last name
    * @param accessLevel the access identifier (Guest, Student, Assistant, Professor) of the user
    * pre:
    *  username != null && hash != null && firstname != null
    *  && lastname != null && accessLevel != null;
    */
   public static void setUser(String username, String hash, String firstname,
    String lastname, String accessLevel) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR REPLACE INTO Users VALUES (?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(username, hash, firstname, lastname, accessLevel); // Column values
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         s.executeUpdate();
         s.close();
         commit();
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in setUser(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

   /**
    * Get user info (as column/value map) by username
    *
    * @param username user's username
    * @return The requested User object
    * pre:
    *  username != null;
    */
   public static CSTutor.Model.User.User getUser(String username) {
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM Users WHERE username=?");
         s.setString(1, username);
         ResultSet r = s.executeQuery();
         CSTutor.Model.User.User user = null;// = new CSTutor.Model.User.User();
         s.close();
         return user;
      } catch(Exception e) {
         // User is not in db so return null
         return null;
      }
   }

   /**
    * Get a list of usernames from the database by accessLevel
    *
    * @param accessLevel The access level enum
    * @return List of usernames by accessLevel
    * post:
    *  return != null;
    */
   public static List<String> getUsernamesByAccessLevel(CSTutor.Model.Manager.Class.ClassAccessLevel accessLevel) {
      List<String> usernames = new ArrayList<String>();
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM Users WHERE username=?");
         s.setString(1, getAccessString(accessLevel));
         ResultSet r = s.executeQuery();
         while (r.next()) {
            usernames.add(r.getString("username"));
         }
         s.close();
         return usernames;
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in getAllUsers(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
         return null;
      }
   }


/*** TutorialData methods *************************************************************************/

   /**
    * Set a TutorialData row'a attributes. If the pageId does not exist in the database, add a new entry.
    * Otherwise overwrite the entry.
    *
    * @param tutorial the Tutorial to add
    * pre:
    *  tutorial != null && tutorial.description != null;
    */
   public static void setTutorialData(CSTutor.Model.Tutorial.TutorialData tutorial) {
      try {
         PreparedStatement s = conn.prepareStatement("INSERT OR REPLACE INTO TutorialData VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
         List<String> values = Arrays.asList(String.valueOf(tutorial.pageId), tutorial.title,
          tutorial.description.intro, tutorial.description.syntax, tutorial.description.exampleCode,
          tutorial.description.exampleOutput, tutorial.tryItYourself);
         for (int i = 0; i < values.size(); i++) {
            s.setString(i+1, values.get(i));
         }
         s.setBoolean(values.size()+1, tutorial.hasSeen);
         s.executeUpdate();
         s.close();
         commit();
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in setTutorialData(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

   /**
    * Get TutorialData by id
    *
    * @param id the identifier for the TutorialData
    * @return specified TutorialData object, or null if not found
    * pre:
    *  id >= 0;
    */
   public static CSTutor.Model.Tutorial.TutorialData getTutorialData(int id) {
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM TutorialData WHERE id=?");
         s.setInt(1, id);
         ResultSet r = s.executeQuery();
         CSTutor.Model.Tutorial.TutorialData data = new CSTutor.Model.Tutorial.TutorialData(
          id, r.getString("title"), r.getString("description"), r.getString("syntax"),
          r.getString("exampleCode"), r.getString("exampleOutput"), r.getString("tryitYourself"),
          r.getBoolean("hasSeen"));
         s.close();
         return data;
      } catch(Exception e) {
         // Tutorial is not in db so return null
         return null;
      }
   }

   /**
    * Get list of all TutorialData in the database
    *
    * @return List of all TutorialData
    * post:
    *  return != null;
    */
   public static List<CSTutor.Model.Tutorial.TutorialData> getAllTutorialData() {
      List<CSTutor.Model.Tutorial.TutorialData> tutorials = new ArrayList<CSTutor.Model.Tutorial.TutorialData>();
      CSTutor.Model.Tutorial.TutorialData t;
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM TutorialData");
         ResultSet r = s.executeQuery();
         while (r.next()) {
            t = new CSTutor.Model.Tutorial.TutorialData(
               r.getInt("id"), r.getString("title"), r.getString("description"), r.getString("syntax"),
               r.getString("exampleCode"), r.getString("exampleOutput"), r.getString("tryitYourself"),
               r.getBoolean("hasSeen")
            );
            tutorials.add(t);
         }
         s.close();
         return tutorials;
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in getAllTutorials(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
         return null;
      }
   }

/*** UserData methods *****************************************************************************/

   /**
    * Get list of all QuizData in the database
    *
    * @return List of all QuizData
    * post:
    *  return != null;
    */
   public static List<CSTutor.Model.Progress.QuizData> getAllQuizData() {
      List<CSTutor.Model.Progress.QuizData> quizzes = new ArrayList<CSTutor.Model.Progress.QuizData>();
      CSTutor.Model.Progress.QuizData q;
      try {
         PreparedStatement s = conn.prepareStatement("SELECT * FROM QuizData");
         ResultSet r = s.executeQuery();
         while (r.next()) {
            q = new CSTutor.Model.Progress.QuizData(r.getString("name"), r.getInt("id"), r.getInt("numPages"));
            quizzes.add(q);
         }
         s.close();
         return quizzes;
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in getAllTutorials(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
         return null;
      }
   }


/*** Page methods *********************************************************************************/

   /**
    * Get list of Pages for the specified Tutorial
    *
    * @param tutorial the Tutorial to look up Pages for
    * @return List of Pages
    * pre:
    *  tutorial != null && tutorial.parent != null && tutorial.parent.parent != null
    *  && tutorial.parent.parent.parent != null;
    * post:
    *  return != null;
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
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         return pages;
      }
   }

   /**
    * Save a list of Pages to the database
    *
    * @param pages list of Pages to save
    * pre:
    *  pages != null;
    */
   public static void savePages(List<CSTutor.Model.Manager.Page> pages) {
      try {
         for (CSTutor.Model.Manager.Page p : pages) {
            PreparedStatement s = conn.prepareStatement(
             "INSERT OR IGNORE INTO Pages(pageName, tutorialName, unitName, sectionName, className) VALUES (?, ?, ?, ?, ?)");
            s.setString(1, p.name);
            s.setString(2, p.parent.name);
            s.setString(3, p.parent.parent.name);
            s.setString(4, p.parent.parent.parent.name);
            s.setString(5, p.parent.parent.parent.parent.name);
            s.executeUpdate();
            s.close();
         }
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in savePages(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }


/*** Tutorial methods *****************************************************************************/

   /**
    * Get list of Tutorials for the specified Unit
    *
    * @param unit the Unit to look up Tutorials for
    * @return List of Tutorials
    * pre:
    *  unit != null && unit.parent != null && unit.parent.parent != null;
    * post:
    *  return != null;
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
      } catch(Exception e) {
         // User not in db so return empty
         return tutorials;
      }
   }

   /**
    * Save a list of Tutorials to the database
    *
    * @param tutorials list of Tutorials to save
    * pre:
    *  tutorials != null;
    */
   public static void saveTutorials(List<CSTutor.Model.Manager.Tutorial> tutorials) {
      try {
         for (CSTutor.Model.Manager.Tutorial t : tutorials) {
            PreparedStatement s = conn.prepareStatement(
             "INSERT OR IGNORE INTO Tutorials(tutorialName, unitName, sectionName, className) VALUES (?, ?, ?, ?)");
            s.setString(1, t.name);
            s.setString(2, t.parent.name);
            s.setString(3, t.parent.parent.name);
            s.setString(4, t.parent.parent.parent.name);
            s.executeUpdate();
            s.close();
            savePages(t.pages);
         }
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in saveTutorials(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }


/*** Unit methods *********************************************************************************/

   /**
    * Get list of Units for the specified Section
    *
    * @param section the Section to look up Units for
    * @return List of Units
    * pre:
    *  section != null && section.parent != null;
    * post:
    *  return != null;
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
      } catch(Exception e) {
         // Section not in db so return empty
         return units;
      }
   }

   /**
    * Save a list of Units to the database
    *
    * @param units list of Units to save
    * pre:
    *  units != null;
    */
   public static void saveUnits(List<CSTutor.Model.Manager.Unit> units) {
      try {
         for (CSTutor.Model.Manager.Unit u : units) {
            PreparedStatement s = conn.prepareStatement(
             "INSERT OR IGNORE INTO Units(unitName, sectionName, className) VALUES (?, ?, ?)");
            s.setString(1, u.name);
            s.setString(2, u.parent.name);
            s.setString(3, u.parent.parent.name);
            s.executeUpdate();
            s.close();
            saveTutorials(u.tutorials);
         }
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in saveUnits(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }

/*** Section methods ******************************************************************************/

   /**
    * Get list of Sections for the specified Class
    *
    * @param clas the Class to look up Sections for
    * @return List of Sections
    * pre:
    *  clas != null;
    * post:
    *  return != null;
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
      } catch(Exception e) {
         // Class not in db so return empty
         return sections;
      }
   }

   /**
    * Save a list of Sections to the database
    *
    * @param sections list of Sections to save
    * pre:
    *  sections != null;
    */
   public static void saveSections(List<CSTutor.Model.Manager.Section> sections) {
      try {
         for (CSTutor.Model.Manager.Section sec : sections) {
            PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO Sections(sectionName, className) VALUES (?, ?)");
            s.setString(1, sec.name);
            s.setString(2, sec.parent.name);
            s.executeUpdate();
            s.close();
            saveUnits(sec.units);
         }
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in saveSections(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
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
            return ClassAccessLevel.Guest;
         case "Student":
            return ClassAccessLevel.Student;
         case "Professor":
            return ClassAccessLevel.Professor;
      }
      return null;
   }

   /**
    * Determine the accessLevel string for the ClassAccessLevel enum
    *
    * @param access ClassAccessLevel enum
    * @return access string representing the access level (Guest, Student, Assistant, Professor)
    */
   private static String getAccessString(CSTutor.Model.Manager.Class.ClassAccessLevel access) {
      switch (access) {
         case Guest:
            return "Guest";
         case Student:
            return "Student";
         case Professor:
            return "Professor";
      }
      return null;
   }

   private static int printClassHierarchy(List<CSTutor.Model.Manager.Class> classes) {
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
   }

   /**
    * Get a list of classes from the database
    *
    * @return List of classes
    * post:
    *  return != null;
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
         printClassHierarchy(classes);
         return classes;
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in getClasses(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }

   /**
    * Get a list of class names.
    *
    * @return List of class names.
    * post:
    *  classes != null;
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
         // This method should never throw an exception in normal operation
         System.err.println("Error in getClassNames(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1); return null;
      }
   }

   /**
    * Delete rows from tables in class hierarchy
    *
    */
   private static void deleteClassHierarchy() throws Exception {
      List<String> values = Arrays.asList("Classes", "Sections", "Units", "Tutorials", "Pages");
      for (String val : values) {
         PreparedStatement s = conn.prepareStatement("DELETE FROM " + val + " WHERE 1=1");
         s.executeUpdate();
         s.close();
      }
      commit();
   }

   /**
    * Save a list of Classes to the database. Drops all classes, sections, etc not in list.
    *
    * @param classes list of Classes to save
    * pre:
    *  classes != null;
    */
   public static void saveClasses(List<CSTutor.Model.Manager.Class> classes) {
      try {
         printClassHierarchy(classes);
         deleteClassHierarchy();
         for (CSTutor.Model.Manager.Class c : classes) {
            PreparedStatement s = conn.prepareStatement("INSERT OR IGNORE INTO Classes VALUES (?, ?)");
            s.setString(1, c.name);
            s.setString(2, getAccessString(c.access));
            s.executeUpdate();
            s.close();
            saveSections(c.sections);
         }
         commit();
      } catch(Exception e) {
         // This method should never throw an exception in normal operation
         System.err.println("Error in saveClasses(). " + e.getClass().getName() + ": " + e.getMessage());
         System.exit(1);
      }
   }
}