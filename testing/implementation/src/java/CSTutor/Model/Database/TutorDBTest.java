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
     * Test methods setUser and getUser by adding a new user, getting it back,
     * and verifying its values.
     */
   @Test
   public void testSetGetUser() {
      List<String> cols, vals;
      Map<String, String> correctrow, testrow;
      cols = Arrays.asList("username", "hash", "firstname", "lastname", "accessLevel");
      vals = Arrays.asList("sdali", "DEADBEEF", "Salvador", "Dali", "Professor");
      correctrow  = mapFromLists(cols, vals);
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row length", correctrow.size(), testrow.size());
      for (String col : cols) {
        assertEquals("Comparing correct and test row", correctrow.get(col), testrow.get(col));
      }
   }

   /**
     * Test methods setUser and getUser by adding a new user, getting it back, and
     * verifying its values. Then set a new hash, get the user back, and verify.
     */
   @Test
   public void testSetGetUserTwice() {
      List<String> cols, vals;
      Map<String, String> correctrow, testrow;
      cols = Arrays.asList("username", "hash", "firstname", "lastname", "accessLevel");
      vals = Arrays.asList("bobsmith", "DEADBEEF", "Bob", "Smith", "Student");
      correctrow  = mapFromLists(cols, vals);
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row length", correctrow.size(), testrow.size());
      for (String col : cols) {
        assertEquals("Comparing correct and test row", correctrow.get(col), testrow.get(col));
      }

      vals = Arrays.asList("bobsmith", "808FACED", "Bob", "Smith", "Student");
      correctrow  = mapFromLists(cols, vals);
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row length", correctrow.size(), testrow.size());
      for (String col : cols) {
        assertEquals("Comparing correct and test row", correctrow.get(col), testrow.get(col));
      }
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


}