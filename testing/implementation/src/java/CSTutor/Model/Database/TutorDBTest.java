package CSTutor.Model.Database;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;
import CSTutor.Model.Database.TutorDB;

public class TutorDBTest {
   public TutorDBTest() {
   }

   @BeforeClass
   public static void setUpClass() {
   }
    
   @AfterClass
   public static void tearDownClass() {
   }
    
   @Before
   public void setUp() {
   }
    
   @After
   public void tearDown() {
   }


    /**
     * Helper function for other tests. Creates maps from lists.
     */
   public Map<String, String> mapFromLists(List<String> cols, List<String> vals) {
      Map<String, String> map = new HashMap<String, String>();
      for (int i = 0; i < cols.size(); i++) {
         map.put(cols.get(i), vals.get(i));
      }
      return map;
   }

    /**
     * Test methods setUser, getUser and deleteUser by adding a new user, getting it back,
     * and verifying its values.
     */
   @Test
   public void testSetGetUser() {
      CSTutor.Model.User.User testuser, correctuser;
      correctuser = new CSTutor.Model.User.User("Bob", "Smith", "sdali", "DEADBEEF", false, true);
      assertEquals("Looking for nonexistent user", TutorDB.getUser("blahblahblah237284"), null);
      TutorDB.setUser("sdali", "DEADBEEF", "Bob", "Smith", "Student");
      testuser = TutorDB.getUser("sdali");
      assertEquals("Comparing correct and test user", correctuser.getName(), testuser.getName());
      assertEquals("Comparing correct and test user", correctuser.getEmail(), testuser.getEmail());
      assertEquals("Comparing correct and test user", correctuser.getFirstName(), testuser.getFirstName());
      assertEquals("Comparing correct and test user", correctuser.getLastName(), testuser.getLastName());
      assertEquals("Comparing correct and test user", correctuser.isInstructor(), testuser.isInstructor());
      TutorDB.deleteUser("sdali");
      assertEquals("Looking for nonexistent user", null, TutorDB.getUser("sdali"));
   }

    /**
     * Test methods setUser and getUser by adding a new user, getting it back, and
     * verifying its values. Then set a new hash, get the user back, and verify.
     */
   @Test
   public void testSetGetUserTwice() {
      CSTutor.Model.User.User testuser, correctuser;
      correctuser = new CSTutor.Model.User.User("Bob", "Smith", "sdali", "DEADBEEF", false, true);
      TutorDB.setUser("sdali", "DEADBEEF", "Bob", "Smith", "Student");
      testuser = TutorDB.getUser("sdali");
      assertEquals("Comparing correct and test user", correctuser.getName(), testuser.getName());
      assertEquals("Comparing correct and test user", correctuser.getEmail(), testuser.getEmail());
      assertEquals("Comparing correct and test user", correctuser.getFirstName(), testuser.getFirstName());
      assertEquals("Comparing correct and test user", correctuser.getLastName(), testuser.getLastName());
      assertEquals("Comparing correct and test user", correctuser.isInstructor(), testuser.isInstructor());

      correctuser = new CSTutor.Model.User.User("Bob", "Smith", "sdali", "808FACED", false, true);
      TutorDB.setUser("sdali", "808FACED", "Bob", "Smith", "Student");
      testuser = TutorDB.getUser("sdali");
      assertEquals("Comparing correct and test user", correctuser.getName(), testuser.getName());
      assertEquals("Comparing correct and test user", correctuser.getEmail(), testuser.getEmail());
      assertEquals("Comparing correct and test user", correctuser.getFirstName(), testuser.getFirstName());
      assertEquals("Comparing correct and test user", correctuser.getLastName(), testuser.getLastName());
      assertEquals("Comparing correct and test user", correctuser.isInstructor(), testuser.isInstructor());
   }

    /**
     * Test method getUsernamesByAccessLevel by adding a few users of different levels,
     * then getting them.
     */
   @Test
   public void testGetUsernamesByAccessLevel() {
      List<String> cols, vals;
      cols = Arrays.asList("username", "hash", "firstname", "lastname", "accessLevel");
      vals = Arrays.asList("sdali", "DEADBEEF", "Salvador", "Dali", "Professor");
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      List<String> profs = TutorDB.getUsernamesByAccessLevel(CSTutor.Model.Manager.Class.ClassAccessLevel.Professor);
      List<String> students = TutorDB.getUsernamesByAccessLevel(CSTutor.Model.Manager.Class.ClassAccessLevel.Student);
      assertTrue("Testing getUsernamesByAccessLevel", profs.contains("sdali"));
      assertFalse("Testing getUsernamesByAccessLevel", students.contains("sdali"));
   }

    /**
     * Test methods setTutorialData and getTutorialData by adding a new entry,
     * getting it back, and verifying its values.
     */
   @Test
   public void testSetGetTutorialData() {
      CSTutor.Model.Tutorial.TutorialData correctdata, testdata;
      correctdata = new CSTutor.Model.Tutorial.TutorialData(
       1111, "title", "description", "syntax", "example code",
       "example output", "try it yourself");
      assertEquals("Looking for nonexistent TutorialData", TutorDB.getTutorialData(76585274), null);
      TutorDB.setTutorialData(correctdata);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description.intro, testdata.description.intro);
      assertEquals("Comparing correct data and test data", correctdata.description.syntax, testdata.description.syntax);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleCode, testdata.description.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleOutput, testdata.description.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);
   }

    /**
     * Test methods setTutorialData and getTutorialData by adding a new entry,
     * getting it back, and verifying its values. Then do it again to the same
     * pageId but with different values
     */
   @Test
   public void testSetGetTutorialDataTwice() {
      CSTutor.Model.Tutorial.TutorialData correctdata, testdata;
      correctdata = new CSTutor.Model.Tutorial.TutorialData(
       1111, "title", "description", "syntax", "example code",
       "example output", "try it yourself");
      TutorDB.setTutorialData(correctdata);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description.intro, testdata.description.intro);
      assertEquals("Comparing correct data and test data", correctdata.description.syntax, testdata.description.syntax);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleCode, testdata.description.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleOutput, testdata.description.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);

      correctdata = new CSTutor.Model.Tutorial.TutorialData(
       1111, "title", "different description", "syntax", "example code",
       "example output", "try it yourself");
      TutorDB.setTutorialData(correctdata);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description.intro, testdata.description.intro);
      assertEquals("Comparing correct data and test data", correctdata.description.syntax, testdata.description.syntax);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleCode, testdata.description.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.description.exampleOutput, testdata.description.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);
   }

    /**
     * Test methods getAllTutorialData and getAllUserData.
     */
   @Test
   public void testGetAllThings() {
      List<CSTutor.Model.Tutorial.TutorialData> all;
      CSTutor.Model.Tutorial.TutorialData data = new CSTutor.Model.Tutorial.TutorialData(
       1111, "title", "description", "syntax", "example code",
       "example output", "try it yourself");
      TutorDB.setTutorialData(data);
      all = TutorDB.getAllTutorialData();
      assertTrue("Testing getAllTutorialData", all.size() > 0);

      List<CSTutor.Model.Progress.QuizData> quizzes = TutorDB.getAllQuizData();
      assertNotNull("Testing getAllTQuizData", quizzes);
   }

    /**
     * Test class hierarchy methods.
     */
   @Test
   public void testClassHierarchy() {
      List<CSTutor.Model.Manager.Class> classes = TutorDB.getClasses();
      TutorDB.setUser("sdali12345", "DEADBEEF", "Bob", "Smith", "Student");
      TutorDB.saveClasses(classes);
      assertNotNull("Checking getClassNames", TutorDB.getClassNames());
      assertEquals("Comparing class hierarchies", classes.size(), TutorDB.getClasses().size());
   }

    /**
     * Test exception handling
     */
   @Test
   public void testExceptions() {
      
   }


}