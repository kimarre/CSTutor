package CSTutor.Model.Tutorial;

/**
 * The description is intended for the author to include any background 
 * information about the topic at hand.
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 20Apr2015
 */
public abstract class Description {
	/** String text to hold the introduction of the tutorial's description */
   public String intro;
   
   /** String text to hold the syntax of the tutorial's subject */
   public String syntax;
   
   /**
    * Initiates a new instance of a description
    */
   public Description() {
	   intro = "";
	   syntax = "";
   }
}