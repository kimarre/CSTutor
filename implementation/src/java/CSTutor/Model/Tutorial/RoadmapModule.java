package CSTutor.Model.Tutorial;

/**
 * The Roadmap Module is the bar on the left side of the student's tutorial
 * that allows them to quickly navigate sections of the tutorial track.
 *
 * @author Kim Arre
 */
public class RoadmapModule {
   String[] pageLinks;

   /**
   * Jumps to the very first tutorial page.
   */
   public void toBeginning() {
       System.out.println("Called RoadmapModule's toBeginning() method.");
   }

   /**
   * Jumps to the very last tutorial page.
   */
   public void toEnd() {
       System.out.println("Called RoadmapModule's toEnd() method.");

   }
}