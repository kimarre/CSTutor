package CSTutor.Model.Database;

import org.junit.*;

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
      cols = Arrays.asList("username, hash, firstname, lastname, accessLevel");
      vals = Arrays.asList("sdali", "DEADBEEF", "Salvador", "Dali", "Professor");
      correctrow  = mapFromLists(cols, vals);
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row", correctrow, testrow);
   }

   /**
     * Test methods setUser and getUser by adding a new user, getting it back, and
     * verifying its values. Then set a new hash, get the user back, and verify.
     */
   @Test
   public void testSetGetUserTwice() {
      List<String> cols, vals;
      Map<String, String> correctrow, testrow;
      cols = Arrays.asList("username, hash, firstname, lastname, accessLevel"); 
      vals = Arrays.asList("bobsmith", "DEADBEEF", "Bob", "Smith", "Student");
      correctrow  = mapFromLists(cols, vals);
      TutorDB.setUser(vals.get(0), vals.get(1), vals.get(2), vals.get(3), vals.get(4));
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row", correctrow, testrow);

      vals = Arrays.asList("bobsmith", "808FACED", "Bob", "Smith", "Student");
      correctrow  = mapFromLists(cols, vals);
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row", correctrow, testrow);
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
       "example output", "try it yourself", "has seen");
      TutorDB.setTutorialData(data);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description, testdata.description);
      assertEquals("Comparing correct data and test data", correctdata.syntax, testdata.syntax);
      assertEquals("Comparing correct data and test data", correctdata.exampleCode, testdata.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.exampleOutput, testdata.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);
      assertEquals("Comparing correct data and test data", correctdata.hasSeen, testdata.hasSeen);
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
       "example output", "try it yourself", "has seen");
      TutorDB.setTutorialData(data);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description, testdata.description);
      assertEquals("Comparing correct data and test data", correctdata.syntax, testdata.syntax);
      assertEquals("Comparing correct data and test data", correctdata.exampleCode, testdata.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.exampleOutput, testdata.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);
      assertEquals("Comparing correct data and test data", correctdata.hasSeen, testdata.hasSeen);

      correctdata = new CSTutor.Model.Tutorial.TutorialData(
       1111, "title", "different description", "syntax", "example code",
       "example output", "try it yourself", "has seen");
      TutorDB.setTutorialData(data);
      testdata = TutorDB.getTutorialData(1111);
      assertEquals("Comparing correct data and test data", correctdata.pageId, testdata.pageId);
      assertEquals("Comparing correct data and test data", correctdata.title, testdata.title);
      assertEquals("Comparing correct data and test data", correctdata.description, testdata.description);
      assertEquals("Comparing correct data and test data", correctdata.syntax, testdata.syntax);
      assertEquals("Comparing correct data and test data", correctdata.exampleCode, testdata.exampleCode);
      assertEquals("Comparing correct data and test data", correctdata.exampleOutput, testdata.exampleOutput);
      assertEquals("Comparing correct data and test data", correctdata.tryItYourself, testdata.tryItYourself);
      assertEquals("Comparing correct data and test data", correctdata.hasSeen, testdata.hasSeen);
   }


}