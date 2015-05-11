package CSTutor.Model.Chat;

import java.util.*;

/**
 * The OnlineWindow object is derived from an overall view of Sections 2.6.1 - 2.6.4 of the requirements.
 * The OnlineWindow is one of the primary data object of the Chat Tool.
 * 
 * The OnlineWindow will consist of a collection of students and each of those students will have 
 * methods associated with them.  
 * 
 *  @author Stephen Daily
 */

public class OnlineWindow {

    Collection<Student> students;
	Boolean isShowing;

	
	/**
	 * Constructor
	 * @return 
	 * 
	 */
	
	public OnlineWindow() {
		students = new ArrayList<Student>();
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
    void showWindow(Boolean isShowing) {
    	return;
    }

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
    void hideWindow(Boolean isShowing) {
    	return;
    }
}
