package CSTutor.Model.Tutorial;

/**
 * EditTextButtons comprise the toolbar that gives the authors or editors the
 * ability to format text within any of the text input fields.
 *
 * @author Kim Arre (karre@calpoly.edu)
 * @version 20Apr2015
 */
public abstract class EditTextButtons {
   String fontStyle;
   boolean isBold;
   boolean isItalicized;
   boolean isUnderlined;
   int fontSize;

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