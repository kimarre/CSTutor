package CSTutor.Model.Tutorial;

/**
 * EditTextButtons comprise the toolbar that gives the authors or editors the
 * ability to format text within any of the text input fields.
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 20Apr2015
 */
public abstract class EditTextButtons {
    /** Identifies which of several font styles are used to format within the tutorial editor */
   String fontStyle;
   
   /** Determines if the font should be bold */
   boolean isBold;
   
   /** Determines if the font should be italicized */
   boolean isItalicized;
   
   /** Determines if the font should be underlined */
   boolean isUnderlined;
   
   /** Determines what size font the tutorial's text should be */
   int fontSize;

   /** Allows the font colors to be more easily distinguished */
   enum FontColor {
      black, red, orange, yellow, green, blue, purple;
   }
   
   /**
    * The constructor initializes all fields to standard font: 12pt plain Arial.
    */
   public EditTextButtons() {
	   fontStyle = "Arial";
	   isBold = false;
	   isItalicized = false;
	   isUnderlined = false;
	   fontSize = 12;
   }
}