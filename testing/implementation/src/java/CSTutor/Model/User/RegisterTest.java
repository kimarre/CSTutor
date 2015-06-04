package CSTutor.Model.User;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by kylereis on 5/15/15.
 */
public class RegisterTest
{

    @Test
    public void testCreateUser() throws Exception
    {
        assertTrue(Register.createUser("Kyle", "Reis", "kjreis@calpoly.edu", "password", true));
    }
}