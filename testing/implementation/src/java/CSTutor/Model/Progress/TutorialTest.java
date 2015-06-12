/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.Progress;

import CSTutor.Model.Progress.Tutorial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May2015
 */

/****
 *
 * Class TutorialTest is the companion testing class for TutorialData.  
 * It implements the following module test plan:
 *									  <pre>
 *    Phase 1: Unit test the constructor.
 *     
 *    Phase 2: Unit test the toString method.
 * 
 *    Phase 3: Unit test the equals method against other TutorialData objects.
 * 
 *    Phase 4: Stress test the equals method with many other TutorialData objects.
 *									 </pre>
 */
public class TutorialTest 
{
    Tutorial data;
    
    public TutorialTest() 
    {
        data = new Tutorial("Hello World");
    }
    
    /**
     * Test method for toString().
     */
    @Test
    public void testToString()
    {
        assert(data.toString().equals("Hello World"));
    }
    
    /**
     * Test method for equals().
     */
    @Test
    public void equals()
    {
        
    }
    
    /**
     * Test method for setStudents().
     */
    @Test
    public void testSetStudents()
    {
        
    }
    
    /**
     * Test method for getStudents().
     */
    @Test
    public void testGetStudents()
    {
        
    }
    
    /**
     * Test method for getAverageQuizScores().
     */
    @Test
    public void testGetAverageQuizScores()
    {
        
       
    }
    
    /**
     * Test method for getQuizScores().
     */
    @Test
    public void testGetQuizScores()
    {
        
    }

}
