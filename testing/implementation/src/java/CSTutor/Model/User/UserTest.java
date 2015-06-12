package CSTutor.Model.User;

import CSTutor.Model.Database.TutorDB;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * User Tester.
 *
 * @author Kyle Reis (kjreis@calpoly.edu)
 *
 * Phase 1: Test getName.
 *
 * Phase 2: Test getFirstName.
 *
 * Phase 3: Test getLastName.
 *
 * Phase 4: Test getEmail.
 *
 * Phase 5: Test isInstructor.
 *
 * Phase 6: Test setInstructor.
 *
 * Phase 7: Test getPassword.
 */
public class UserTest {

    /**
    *
    * Method: getPassword()
    *
    */
    @Test
    public void testGetPassword() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertTrue(test.getPassword() != null);
    }

    /**
    *
    * Method: getEmail()
    *
    */
    @Test
    public void testGetEmail() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertEquals("Getting email", "kjreis@calpoly.edu", test.getEmail());
    }

    /**
    *
    * Method: getName()
    *
    */
    @Test
    public void testGetFirstName() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertEquals("Getting First name", "Kyle", test.getFirstName());
    }

    /**
     *
     * Method: getName()
     *
     */
    @Test
    public void testGetLastName() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertEquals("Getting Last name", "Reis", test.getLastName());
    }

    /**
     *
     * Method: getName()
     *
     */
    @Test
    public void testGetName() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertEquals("Getting name", "Kyle Reis", test.getName());
    }

    /**
    *
    * Method: isInstructor()
    *
    */
    @Test
    public void testIsInstructor() throws Exception {
        assertTrue(TutorDB.getUser("kjreis@calpoly.edu").isInstructor());
    }

    /**
    *
    * Method: setInstructor()
    *
    */
    @Test
    public void testSetInstructor() throws Exception {
        User test = new User("Kyle", "Reis", "kjreis@calpoly.edu", "password", false, true);
        assertFalse(test.isInstructor());
        test.setInstructor();
        assertTrue(test.isInstructor());
    }


} 
