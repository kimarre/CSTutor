package Tutorial.StudentTutorial;

import Tutorial.*;

/**
* A Student page is an individual topic page within a tutorial track. This is 
* the page that students interact with to take the tutorials on.
*/
public abstract class StudentPage {
   Description description;
   CodeExample example;
   String tryItYourself;
   String textEditor;
   String console;

   RoadmapModule module;

   abstract void run();

   /*
      pre:                                                          <pre>
         //
         // There must be a page to navigate to that's next in the track.
         //
         exists(this.next());
   */
   abstract void next();

   /*
      pre:                                                          <pre>
         //
         // There must be a page to navigate to that's previous in the track.
         // Cannot navigate to previous if it's the first one.
         //
         exists(this.previous());
   */
   abstract void prev();

   //ChatToolbar chat;
}