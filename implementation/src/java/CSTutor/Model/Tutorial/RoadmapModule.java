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
	/** (Temporary?) List of all tutorial pages to reference */
   LinkedList<Integer> pageLinks;

   /** 
    * Initializes the Roadmap Module to have an empty LinkedList.
    * */
   public RoadmapModule() {
      pageLinks = new LinkedList();

      // TO-DO: fill the array with StudentPage entries from the database.
   }

   /**
   * Jumps to the very first tutorial page.
   */
   public void toBeginning() {
      Integer newPage = pageLinks.getFirst();
      System.out.println("Called RoadmapModule's toBeginning() method.");
   }

   /**
   * Jumps to the very last tutorial page.
   */
   public void toEnd() {
       System.out.println("Called RoadmapModule's toEnd() method.");

   }
}
