
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
    }
    
    public void add(TutorialData toAdd) {
        track.add(toAdd);
    }
    
    public TutorialData getFirst() {
        return track.peekFirst();
    }
}
