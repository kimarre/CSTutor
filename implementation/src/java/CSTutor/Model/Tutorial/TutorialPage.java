package CSTutor.Model.Tutorial;

import CSTutor.Model.Tutorial.*;

/**
* A Student page is an individual topic page within a tutorial track. This is 
* the page that students interact with to take the tutorials on.
*/
public class TutorialPage {
   String title;
   Description description;
   CodeExample example;
   String tryItYourself;
   String textEditor;
   String console;

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
