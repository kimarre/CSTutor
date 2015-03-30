package Chat;

import java.util.*;

/**
 * The OnlineWindow object is derived from an overall view of Sections 2.6.1 - 2.6.4 of the requirements.
 * The OnlineWindow is one of the primary data object of the Chat Tool.
 * 
 * The OnlineWindow will consist of a collection of students and each of those students will have 
 * methods associated with them.  
 */

public abstract class OnlineWindow {

    Collection<Student> students;
	Boolean isShowing;

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
    abstract void showWindow(Boolean isShowing);

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
    abstract void hideWindow(Boolean isShowing);
}
