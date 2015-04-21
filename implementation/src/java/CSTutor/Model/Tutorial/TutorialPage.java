package CSTutor.Model.Tutorial;

import CSTutor.Model.Tutorial.*;

/**
* A Student page is an individual topic page within a tutorial track. This is 
* the page that students interact with to take the tutorials on.
* 
* @author Kim Arre (karre@calpoly.edu)
* @version 20Apr2015
*/
public class TutorialPage {
   /** Represents the overall title for the tutorial page */
   public String title;
   
   /** Describes the overall concept of the subject at hand.*/
   public Description description;
   
   /** Contains the example code and output */
   public CodeExample example;
   
   /** Contains the instructor's problem for the student */
   public String tryItYourself;
   
   /** Allows the student to enter their own code to try to solve the 'Try It Yourself' problem given by the instructor */
   public String textEditor;
   
   /** Output of the student program gets redirected to this text field for feedback and results */
   public String console;
   
   /** Unique identifier for the page for the database */
   int pageId;
   
   /** Contains all components of the tutorial track, with links to the beginning and end of the tutorial track */
   RoadmapModule module;

   /**
   * Runs the code in the text editor and shows output to the console.
   */
   void run() {
	   
   }

   /*
      pre:                                                          <pre>
         //
         // There must be a page to navigate to that's next in the track.
         //
         exists(this.next());
   */
   /**
   * Navigates to the next tutorial.
   */
   void next() {
      
   }

   /*
      pre:                                                          <pre>
         //
         // There must be a page to navigate to that's previous in the track.
         // Cannot navigate to previous if it's the first one.
         //
         exists(this.previous());
   */
   /**
   * Navigates to the previous tutorial.
   */
   void prev() {
	   
   }
}
