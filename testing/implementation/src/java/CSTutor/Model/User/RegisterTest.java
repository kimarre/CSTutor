package CSTutor.Model.User;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Registration of a User
 *
 * @author Kyle Reis (kjreis@calpoly.edu)
 *
 * Phase 1: Test that a user can be registered.
 *
 * Phase 2: Test that if a user is already registered they can not be registered again.
 */
public class RegisterTest
{

    @Test
    public void testCreateUser() throws Exception
    {
        assertFalse(Register.createUser("Kyle", "Reis", "kjreis@calpoly.edu", "password", true));
    }
}