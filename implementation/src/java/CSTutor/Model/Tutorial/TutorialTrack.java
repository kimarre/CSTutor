
package CSTutor.Model.Tutorial;

import java.util.*;
import CSTutor.Model.Tutorial.*;

/**
 * Overall structure for the list of tutorials.
 * @author Kim Arre (karre@calpoly.edu)
 * @version 07May2015
 */
public class TutorialTrack {
    /** Overall structure that houses the list of tutorials. */
    public static LinkedList<TutorialData> track;
    
    public TutorialTrack() {
        track = new LinkedList<TutorialData>();
        
        // First sample tutorial Content
        TutorialData first = new TutorialData();
        String newTitle = "For Loops";
        String desc = "For loops are a type of control structure that "
          + "allow code to be repeatedly executed. They take three arguments"
          + " in the order of:<br>     1. starting condition;<br>     2. condition "
          + "to exit the loop;<br>     3. post loop increment";
        
        String syn = "for (int i=start; i<upperLimit; i++) {<br>   ...<br>}";
        String output = "Hello world<br>Hello world<br>Hello world<br>Hello world<br>Hello world";
        String code = "for (int i=0; i<5; i++) {<br>    printf(\"Hello world\\n\");<br>}";
        String tryIt = "Write a program that outputs every multiple of 5 from 0 to 25. (ex. 0 5 10 15 20 15)";
        
        first.setAll(newTitle, desc, syn, output, code, tryIt);
        track.add(first);
        
        // Second sample tutorial content
        TutorialData second = new TutorialData();
        newTitle = "While Loops";
        desc = "While loops are only sometimes as cool as for loops.";
        syn = "while (condition) { <br><br>}";
        
        second.setAll(newTitle, desc, syn, "", "", "");
        track.add(second);
    }
}
