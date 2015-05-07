package CSTutor.Model.Tutorial;

import java.util.*;
import CSTutor.Model.Tutorial.*;

/**
 * The Roadmap Module is the bar on the left side of the student's tutorial
 * that allows them to quickly navigate sections of the tutorial track.
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 20Apr2015
 */
public class RoadmapModule {

   /** 
    * Initializes the Roadmap Module to have an empty LinkedList.
    * */
   public RoadmapModule() {
      
   }

   /**
   * Jumps to the very first tutorial page.
   */
   public void toBeginning(LinkedList<TutorialData> pageLinks) {
      TutorialData newPage = pageLinks.getFirst();
      System.out.println("Called RoadmapModule's toBeginning() method.");
   }

   /**
   * Jumps to the very last tutorial page.
   */
   public void toEnd(LinkedList<TutorialData> pageLinks) {
       TutorialData newPage = pageLinks.getLast();
       System.out.println("Called RoadmapModule's toEnd() method.");

   }
}
