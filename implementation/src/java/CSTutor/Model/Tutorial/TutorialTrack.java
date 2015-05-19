
package CSTutor.Model.Tutorial;

import java.util.*;
import CSTutor.Model.Tutorial.*;
import CSTutor.Model.Database.*;

/**
 * Overall structure for the list of tutorials.
 * @author Kim Arre (karre@calpoly.edu)
 * @version 07May2015
 */
public class TutorialTrack {
    /** Overall structure that houses the list of tutorials. */
    public static ArrayList<Integer> track;
    public static int maxIndex = 0;
    public static TutorDB database;
    
    public static int getNextID() {
        maxIndex++;
        return maxIndex-1;
    }
    
    public TutorialTrack() {
        track = new ArrayList<Integer>();
        database = new TutorDB();
        
        // First sample tutorial Content
        String newTitle = "For Loops";
        String desc = "For loops are a type of control structure that "
          + "allow code to be repeatedly executed. They take three arguments"
          + " in the order of:<br>     1. starting condition;<br>     2. condition "
          + "to exit the loop;<br>     3. post loop increment";
        
        String syn = "for (int i=start; i&#60;upperLimit; i++) {<br>&#32;&#32;&#32;...<br>}";
        String output = "Hello world<br>Hello world<br>Hello world<br>Hello world<br>Hello world";
        String code = "for (int i=0; i&#60;5; i++) {<br>&#32;&#32;&#32;printf(\"Hello world\\n\");<br>}";
        String tryIt = "Write a program that outputs every multiple of 5 from 0 to 25. (ex. 0 5 10 15 20 15)";
        
        int ndx = getNextID();
        TutorialData first = new TutorialData(ndx, newTitle, desc, syn, code, output, tryIt);
        
        database.setTutorialData(first);
        
        // Second sample tutorial content
        
        newTitle = "While Loops";
        desc = "While loops are only sometimes as cool as for loops.";
        syn = "while (condition) { <br><br>}";
        
        TutorialData second = new TutorialData(getNextID(), newTitle, desc, syn, "", "", "");
        database.setTutorialData(second);
    }
}
