package CSTutor.Model.Tutorial;

/**
 * EditTextButtons comprise the toolbar that gives the authors or editors the
 * ability to format text within any of the text input fields.
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
}