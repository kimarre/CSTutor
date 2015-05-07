package CSTutor.Model.Tutorial;

import CSTutor.Model.Tutorial.*;

/**
* Contains the data that is used to construct the tutorial page. This is 
* the page that students interact with to take the tutorials on.
* 
* @author Kim Arre (karre@calpoly.edu)
* @version 20Apr2015
*/
public class TutorialData {
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
   
   public TutorialData() {
       description = new Description();
       example = new CodeExample();
       tryItYourself = "";
   }
   
   /** Retrieves the tutorial's title */
   public String getTitle() {
       return title;
   }
   
   /** Retrieves the tutorial's description */
   public String getDescription() {
       return description.intro;
   }
   
   /** Retrieves the tutorial's syntax*/
   public String getSyntax() {
       return description.syntax;
   }
   
   /** Retrieves the tutorial's example code*/
   public String getExampleCode() {
       return example.sampleCode;
   }
   
   /** Retrieves the tutorial's example output */
   public String getExampleOutput() {
       return example.sampleOutput;
   }
   
   /** Sets the tutorial's title */
   public void setTitle(String newTitle) {
       title = newTitle;
   }
   
   /** Sets the tutorial's description */
   public void setDescription(String desc) {
       description.intro = desc;
   }
   
   /** Sets the tutorial's syntax */
   public void setSyntax(String syntax) {
       description.syntax = syntax;
   }
   
   /** Sets the tutorial's example code */
   public void setExampleCode(String code) {
       example.sampleCode = code;
   }
   
   /** Sets the tutorial's example output */
   public void setExampleOutput(String output) {
       example.sampleOutput = output;
   }

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
