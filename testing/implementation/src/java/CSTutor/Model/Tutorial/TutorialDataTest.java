/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.Tutorial;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 18May2015
 */
public class TutorialDataTest {
    TutorialData instance;
    
    public TutorialDataTest() {
        instance = new TutorialData();
        instance.setAll("purple", "blue", "green", "yellow", "red", "orange");
    }

    /**
     * Test of getTitle method, of class TutorialData.
     */
    @Test
    public void testGetTitle() {
        assertEquals(instance.getTitle(), "purple");
    }

    /**
     * Test of getDescription method, of class TutorialData.
     */
    @Test
    public void testGetDescription() {
        assertEquals(instance.getDescription(), "blue");
    }

    /**
     * Test of getSyntax method, of class TutorialData.
     */
    @Test
    public void testGetSyntax() {
        assertEquals(instance.getSyntax(), "green");
    }

    /**
     * Test of getExampleCode method, of class TutorialData.
     */
    @Test
    public void testGetExampleCode() {
        assertEquals(instance.getExampleCode(), "yellow");

    }

    /**
     * Test of getExampleOutput method, of class TutorialData.
     */
    @Test
    public void testGetExampleOutput() {
        assertEquals(instance.getExampleOutput(), "red");
    }
    
    /**
     * Test of getTryIt method, of class TutorialData.
     */
    @Test
    public void testGetTryIt() {
        assertEquals(instance.getTryIt(), "orange");
    }

    /**
     * Test of setAll method, of class TutorialData.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        String newTitle = "Tutorial Title";
        String desc = "Test description";
        String syn = "Test syntax";
        String code = "Test example code";
        String output = "Test example output";
        String tryIt = "Test try it yourself";
        
        instance.setAll(newTitle, desc, syn, code, output, tryIt);
        
        assertEquals(instance.getTitle(), "Tutorial Title");
        assertEquals(instance.getDescription(), "Test description");
        assertEquals(instance.getSyntax(), "Test syntax");
        assertEquals(instance.getExampleCode(), "Test example code");
        assertEquals(instance.getExampleOutput(), "Test example output");
        assertEquals(instance.getTryIt(), "Test try it yourself");
    }

    /**
     * Test of run method, of class TutorialData.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TutorialData instance = new TutorialData();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class TutorialData.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        TutorialData instance = new TutorialData();
        instance.next();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of prev method, of class TutorialData.
     */
    @Test
    public void testPrev() {
        System.out.println("prev");
        TutorialData instance = new TutorialData();
        instance.prev();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
