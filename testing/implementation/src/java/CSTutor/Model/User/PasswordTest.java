/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.*;

/**
 *
 * @author kylereis
 */
public class PasswordTest {
    
    public PasswordTest() {
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
     * Test of getHash method, of class Password.
     */
    @Test
    public void testValidateHash() {
        System.out.println("validateHash");
        Password instance = new Password();
        instance.setPassword("password");
        boolean result = instance.validateHash("password");
        assertTrue("Testing validation of password", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of getHash method, of class Password.
     */
    @Test
    public void testValidateHash1() {
        System.out.println("validateHash1");
        Password instance = new Password();
        instance.setPassword("password");
        boolean result = instance.validateHash("bob");
        assertFalse("Testing validation of password vs bob", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Password.
     */
    //@Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Password instance = new Password();
        boolean expResult = false;
        boolean result = instance.setPassword(password);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker() {
        System.out.println("lower");
        String lower = "qwertyuioplkjhgfdsazxcvbnm";
        Password instance = new Password();
        assertTrue("all lower",instance.checker(lower));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker1() {
        System.out.println("upper");
        String upper = "MNBVCXZASDFGHJKLPOIUYTREWQ";
        Password instance = new Password();
        assertTrue("all upper",instance.checker(upper));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker2() {
        System.out.println("symbol");
        String symbol = "!@#$%^&*()";
        Password instance = new Password();
        assertTrue("all symbol",instance.checker(symbol));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker3() {
        System.out.println("number");
        String num = "1234567890";
        Password instance = new Password();
        assertTrue("all num",instance.checker(num));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker4() {
        System.out.println("Short");
        String tooshort = "1234";
        Password instance = new Password();
        assertFalse("too short",instance.checker(tooshort));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker5() {
        System.out.println("Long");
        String toolong = "qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ!@#$%^&*()1234567890";
        Password instance = new Password();
        assertFalse("too long",instance.checker(toolong));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker6() {
        System.out.println("checker6");
        String invalid = "12345-";
        Password instance = new Password();
        assertFalse("invalid character: -",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker7() {
        System.out.println("checker7");
        String invalid = "12345_";
        Password instance = new Password();
        assertFalse("invalid character: _",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker8() {
        System.out.println("checker8");
        String invalid = "12345=";
        Password instance = new Password();
        assertFalse("invalid character: =",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker9() {
        System.out.println("checker9");
        String invalid = "12345+";
        Password instance = new Password();
        assertFalse("invalid character: +",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker10() {
        System.out.println("checker10");
        String invalid = "12345`";
        Password instance = new Password();
        assertFalse("invalid character: `",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker11() {
        System.out.println("checker11");
        String invalid = "12345~";
        Password instance = new Password();
        assertFalse("invalid character: ~",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker12() {
        System.out.println("checker12");
        String invalid = "12345{";
        Password instance = new Password();
        assertFalse("invalid character: {",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker13() {
        System.out.println("checker13");
        String invalid = "12345}";
        Password instance = new Password();
        assertFalse("invalid character: }",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker14() {
        System.out.println("checker14");
        String invalid = "12345[";
        Password instance = new Password();
        assertFalse("invalid character: [",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker15() {
        System.out.println("checker15");
        String invalid = "12345]";
        Password instance = new Password();
        assertFalse("invalid character: ]",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker16() {
        System.out.println("checker16");
        String invalid = "12345|";
        Password instance = new Password();
        assertFalse("invalid character: |",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker17() {
        System.out.println("checker17");
        String invalid = "12345:";
        Password instance = new Password();
        assertFalse("invalid character: :",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker18() {
        System.out.println("checker18");
        String invalid = "12345;";
        Password instance = new Password();
        assertFalse("invalid character: ;",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker19() {
        System.out.println("checker19");
        String invalid = "12345'";
        Password instance = new Password();
        assertFalse("invalid character: '",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker20() {
        System.out.println("checker20");
        String invalid = "12345<";
        Password instance = new Password();
        assertFalse("invalid character: <",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker21() {
        System.out.println("checker21");
        String invalid = "12345>";
        Password instance = new Password();
        assertFalse("invalid character: >",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker22() {
        System.out.println("checker22");
        String invalid = "12345,";
        Password instance = new Password();
        assertFalse("invalid character: ,",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker23() {
        System.out.println("checker23");
        String invalid = "12345.";
        Password instance = new Password();
        assertFalse("invalid character: .",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker24() {
        System.out.println("checker24");
        String invalid = "12345?";
        Password instance = new Password();
        assertFalse("invalid character: ?",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker25() {
        System.out.println("checker6");
        String invalid = "12345/";
        Password instance = new Password();
        assertFalse("invalid character: /",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker26() {
        System.out.println("checker26");
        String invalid = "12345\"";
        Password instance = new Password();
        assertFalse("invalid character: \"",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker27() {
        System.out.println("checker27");
        String invalid = "12345\\";
        Password instance = new Password();
        System.out.println(instance.checker(invalid));
        assertFalse("invalid character: \\",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker28() {
        System.out.println("checker28");
        String invalid = " ";
        Password instance = new Password();
        assertFalse("invalid character: ' '",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of checker method, of class Password.
     */
    @Test
    public void testChecker29() {
        System.out.println("checker29");
        String invalid = "-_=+`~{}[]|:;'<>,.?/\"\\ ";
        Password instance = new Password();
        System.out.println("all invalid: " + instance.checker(invalid));
        assertFalse("all invalid",instance.checker(invalid));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    //@Test
    public void testMatch() {
        String full = "";
        for (int i = 32; i < 127; i++)
        {
            String str = "" + ((char) i);
            full += str;
            boolean valid = str.matches("[!@#$%^&*()a-zA-Z0-9]");
            
            System.out.println(str + ": " + valid);
        }
        
        boolean valid = full.matches("[!@#$%^&*()a-zA-Z0-9]");
            
        System.out.println(full + ": " + valid);
        
        System.out.println("\"-_=+`~{}[]|:;'<>,.?/\"\\ \" : " + "-_=+`~{}[]|:;'<>,.?/\"\\ ".matches("[!@#$%^&*()a-zA-Z0-9]"));
    }
    
    //@Test
    public void testMatch2() {
        Pattern regex = Pattern.compile("[^!@#$%^&*()a-zA-Z0-9]");
        System.out.println("\"-_=+`~{}[]|:;'<>,.?/\"\\ \" : " + !regex.matcher("-_=+`~{}[]|:;'<>,.?/\"\\").find());
        System.out.println("qwertyuiopasdfghjklzxcvbnm : " + !regex.matcher("qwertyuiopasdfghjklzxcvbnm").find());
        System.out.println("QWERTYUIOPASDFGHJKLZXCVBNM : " + !regex.matcher("QWERTYUIOPASDFGHJKLZXCVBNM").find());
        System.out.println("1234567890 : " + !regex.matcher("1234567890").find());
    }
}