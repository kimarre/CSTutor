package CSTutor.Model.User;

import CSTutor.Model.Database.TutorDB;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>May 15, 2015</pre> 
* @version 1.0 
*/ 
public class UserTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

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
