/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.Tutorial;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Kim Arre (karre@calpoly.edu)
 * @version 18May2015
 */

/****
 *
 * Class TutorialDataTest is the companion testing class for TutorialData.  
 * It implements the following module test plan:
 *									  <pre>
 *    Phase 1: Unit test getters for all components
 *      - getTitle, getDescription, getSyntax, getExampleCode, getExampleOutput, getTryIt
 * 
 *    Phase 2: Unit test setAll and verify correct data
 * 
 *    Phase 3: Unit test the run method
 * 
 *    Phase 4: Unit test the previous and next methods
 *									 </pre>
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
     * Test of next method, of class TutorialData.
     */
    @Test
    public void testNext() {
        TutorialData temp = new TutorialData();
        temp.next();
    }

    /**
     * Test of prev method, of class TutorialData.
     */
    @Test
    public void testPrev() {
        TutorialData temp = new TutorialData();
        temp.prev();
    }
    
}
