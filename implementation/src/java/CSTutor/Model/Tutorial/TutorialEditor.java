package CSTutor.Model.Tutorial;

import CSTutor.View.Tutorial.*;
import CSTutor.Model.Tutorial.*;
import javax.swing.JOptionPane;

/**
* An Author page is an individual topic page within a tutorial track. This is 
* the page that authors fill out their tutorial content on.
*
* @author Kim Arre (karre@calpoly.edu)
* @version 20Apr2015
*/
public class TutorialEditor {
    /** Gate to the tutorial track */
    public TutorialTrack tutorialTrack;

   /** Contains the editing options for a Tutorial Editor page*/
   public EditTextButtons toolbar;
   
   /** 
    * Constructs a new instance of a TutorialEditor
    */
   public TutorialEditor() {
       //new instance of tutorial track?
   }

   /*
      pre:                                                          <pre>
         //
         // The Description cannot be empty.
         //
         (description.intro.length() > 0) && (description.syntax.length() > 0);

      post:
         //
         // All pages in tutorialTrack are valid pages containing titles, syntax, and a description.
         //
         forall(PageData page; tutorialTrack.contains(page); 
          !page.title.equals("") && !page.description.intro.equals("") && !page.description.syntax.equals("");

   */

   /**
   * Saves the changes on the editing page to the tutorial.
   * @return Boolean indicating if the content was valid or not.
   */
   public boolean save(TutorialData pageData) {
      if (pageData.description.intro.equals("") || pageData.description.syntax.equals("") || pageData.title.equals("")) {
          return false;
      } else {
        pageData.pageId = tutorialTrack.getNextID();
        tutorialTrack.database.setTutorialData(pageData);
        tutorialTrack.track.add(pageData.pageId);
        
        System.out.println("Saved! There are now " + tutorialTrack.maxIndex + " tutorials.");
        return true;
      }
   }
   
   /**
   * Shows the tutorial changes from the student point of view.
   */
   public void preview() {
      System.out.println("Called tutorial previow() method.");
   }

}