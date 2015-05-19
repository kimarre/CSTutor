package test.CSTutor.Model.User;

import CSTutor.Model.User.Register;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

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