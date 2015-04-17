package CSTutor.Model.Chat;

/**
 * TextBox is an object that takes user inputted text and transfers to the data to the console.
 * 
 *  @author Stephen Daily
 */


abstract class TextBox{
    String buffer;

    /**
     * pushText will take the text in the buffer, and push it to the console.
     *
     * pre:
             //
             // The string isn't null
             //
         (text != null);
     *
     */
     abstract void pushText(String text);
}
