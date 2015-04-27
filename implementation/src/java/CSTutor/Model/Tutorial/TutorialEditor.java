package CSTutor.Model.Tutorial;

import CSTutor.View.Tutorial.*;
import CSTutor.Model.Tutorial.*;

/**
* An Author page is an individual topic page within a tutorial track. This is 
* the page that authors fill out their tutorial content on.
*
* @author Kim Arre (karre@calpoly.edu)
* @version 20Apr2015
*/
public class TutorialEditor {
	/** Describes the overall concept of the subject at hand.*/
   public Description description;
   
   /** Contains the example code and output */
   public CodeExample example;
   
   /** Contains the instructor's problem for the student */
   public String tryItYourself;

   /** Contains the editing options for a Tutorial Editor page*/
   public EditTextButtons toolbar;
   
   /** 
    * Constructs a new instance of a TutorialEditor
    */
   public TutorialEditor() {
	   
   }

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
      System.out.println("String received was: " + tryItYourself);
   }
   
   /**
   * Shows the tutorial changes from the student point of view.
   */
   public void preview() {
      System.out.println("Called tutorial previow() method.");
   }

}