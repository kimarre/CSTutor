/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.User;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Tests the Password Object.
 *
 * @author Kyle Reis (kjreis@calpoly.edu)
 *
 * Phase 1: Test setPassword.
 *
 * Phase 2: Test validateHash.
 */
public class PasswordTest {

    /**
     * Test of getHash method, of class Password.
     */
    @Test
    public void testValidateHash() {
        System.out.println("validateHash");
        Password instance = new Password();
        instance.setPassword("password");
        boolean result = Password.validateHash("password", instance.getHash());
        assertTrue("Testing validation of password", result);
    }
    
    /**
     * Test of getHash method, of class Password.
     */
    @Test
    public void testValidateHash1() {
        System.out.println("validateHash1");
        Password instance = new Password();
        instance.setPassword("password");
        boolean result = Password.validateHash("bob", instance.getHash());
        assertFalse("Testing validation of password vs bob", result);
    }

    /**
     * Test of setPassword method, of class Password.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Password instance = new Password();
        boolean expResult = false;
        boolean result = instance.setPassword(password);
        assertEquals(expResult, result);
    }
}