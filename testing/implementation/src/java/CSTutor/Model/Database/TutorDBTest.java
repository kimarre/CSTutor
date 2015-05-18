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
      assertEquals("Comparing correct and test user row.", correctrow, testrow);
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
      assertEquals("Comparing correct and test row.", correctrow, testrow);

      vals = Arrays.asList("bobsmith", "808FACED", "Bob", "Smith", "Student");
      correctrow  = mapFromLists(cols, vals);
      testrow = TutorDB.getUser(vals.get(0));
      assertEquals("Comparing correct and test row.", correctrow, testrow);
   }


}