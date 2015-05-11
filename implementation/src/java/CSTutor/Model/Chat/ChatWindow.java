package CSTutor.Model.Chat;

import java.util.*;

/**
 * The ChatWindow object is derived from an overall view of Sections 2.6.1 - 2.6.4 of the requirements.
 * The ChatWindow is one of the primary data object of the Chat Tool.
 *
 * The data components of the ChatWindow are a Console window for output and a text box for input.
 * 
 *  @author Stephen Daily
 */

public class ChatWindow {
    public TextBox textInput;
	Boolean isShowing;
	
	/**
	 * Constructor
	 */
	public ChatWindow() {}
	
    /**
     * Enter is a button that transfers the text from the text box from a given student and adds it to the
     * list in the console
     *
         * pre:
             //
             // The textBox isn't empty and the text isn't just whitespace
             //
         (textInput != null)
         &&
         exists(char c; textIput.buffer.contains(c); c == isalpha());
     *
     */

    public Boolean Enter(String text){
    	if(!text.equals("") && text.trim().length() > 0) {
    		return true;
    	}
    	return false;
    }
	
	/**
     * showWindow will pop the window out if isShowing is false
     /
    pre:
            //
            // isShowing != true
            //
        (isShowing != true);
    *
    */
    void showWindow(Boolean isShowing){}

    /**
     * hideWindow will minimize the ChatWindow if isShowing is true;
     /
     pre:
             //
             // isShowing != true
             //
         (isShowing != true);
     *
     */
    void hideWindow(Boolean isShowing){}
}
