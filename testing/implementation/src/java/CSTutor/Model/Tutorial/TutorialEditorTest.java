/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.Model.Tutorial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 18May2015
 */
public class TutorialEditorTest {
    TutorialTrack track = new TutorialTrack();
    
    public TutorialEditorTest() {
    }

    /**
     * Test of save method, verify that it adds a new node in the linked list and that tutorials have a complete description.
     */
    @Test
    public void testSave() {
        System.out.println("TutorialEditor->save...");
        TutorialData pageData = new TutorialData();
        boolean result;
      
        TutorialEditor instance = new CSTutor.Model.Tutorial.TutorialEditor();
        
        // expect to not add the tutorial with incomplete data
        // i.e. tutorial length stay the default 2.
        result = instance.save(pageData);
        assertEquals(track.track.size(), 2);
        assertEquals(result, false);
        System.out.println("   Passed invalid content test");
        
        
        // Give good data that should pass
        pageData.title = "A title!";
        pageData.description.intro = "Codestuff, woop";
        pageData.description.syntax = "...";
        
        result = instance.save(pageData);
        assertEquals(result, true);
        assertEquals(track.track.size(), 3);
        System.out.println("   Passed add new content test - new node");
        
        // Verify that the correct content was added to the linkedlist
        int ndx = track.track.size() - 1;
        System.out.println("Grabbing node #" + ndx);
        TutorialData last = track.track.get(ndx);
        
        assertEquals(last.title, "A title!");
        assertEquals(last.description.intro, "Codestuff, woop");
        assertEquals(last.description.syntax, "...");
        System.out.println("   Passed verification of new tutorial content");
        
        System.out.println("   ALL PASS");
        
    }

    /**
     * Test of preview method, make sure it opens a new instance of a Tutorial with disabled buttons.
     */
    @Test
    public void testPreview() {
       
    }
    
}