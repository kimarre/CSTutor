package CSTutor.Model.Tutorial;

import CSTutor.View.Tutorial.*;

/**
* An Author page is an individual topic page within a tutorial track. This is 
* the page that authors fill out their tutorial content on.
*
* @author Kim Arre (karre@calpoly.edu)
* @version 20Apr2015
*/
public class TutorialEditor {
	/** */
   public Description description;
   public CodeExample example;
   public String tryItYourself;

   public EditTextButtons toolbar;

   /*
      pre:                                                          <pre>
         //
         // The Description cannot be empty.
         //
         (description.intro.length() > 0) && (description.syntax.length() > 0);

      post:
         //
         // The edited page exists or has been added to the tutorial track.
         //
         authorPages'.contains(this);

   */

   /**
   * Saves the changes on the editing page to the tutorial.
   */
   public void save() {
      System.out.println("Called tutorial save() method.");
      System.out.println("String received was: " + description.intro);
   }
   
   /**
   * Shows the tutorial changes from the student point of view.
   */
   public void preview() {
      System.out.println("Called tutorial previow() method.");
   }

}