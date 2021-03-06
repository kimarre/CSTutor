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
   
   /** Contains the instructor's problem for the student */
   public String tryItYourself;
   
   /** Allows the student to enter their own code to try to solve the 'Try It Yourself' problem given by the instructor */
   public String textEditor;
   
   /** Output of the student program gets redirected to this text field for feedback and results */
   public String console;
   
   /** Unique identifier for the page for the database */
   public int pageId;
   
   /** Tracker for Progress that indicates if a tutorial has been seen or not. */
   public boolean hasSeen;

   public TutorialData() {
       description = new Description();
       tryItYourself = "";
   }
   
   public TutorialData(int pageNum, String t, String desc, String syn, String ec, String eo, String tryIt) {
       this.pageId = pageNum;
       this.title = t;
       this.description = new Description();
       this.description.intro = desc;
       this.description.syntax = syn;
       this.description.exampleCode = ec;
       this.description.exampleOutput = eo;
       this.tryItYourself = tryIt;
       this.hasSeen = false;
   }
   
   public TutorialData(int pageNum, String t, String desc, String syn, String ec, String eo, String tryIt, boolean seen) {
       this.pageId = pageNum;
       this.title = t;
       this.description = new Description();
       this.description.intro = desc;
       this.description.syntax = syn;
       this.description.exampleCode = ec;
       this.description.exampleOutput = eo;
       this.tryItYourself = tryIt;
       this.hasSeen = seen;
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
       return description.exampleCode;
   }
   
   /** Retrieves the tutorial's example output */
   public String getExampleOutput() {
       return description.exampleOutput;
   }
   
   /** Retrieves the tutorial's Try It Yourself question */
   public String getTryIt() {
       return tryItYourself;
   }
   
   /** Sets all the fields for TutorialData */
   public void setAll(String newTitle, String desc, String syn, String code, String output, String tryIt) {
       title = newTitle;
       description.intro = desc;
       description.syntax = syn;
       description.exampleCode = code;
       description.exampleOutput = output;
       tryItYourself = tryIt;
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
