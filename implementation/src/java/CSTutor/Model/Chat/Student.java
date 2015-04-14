package CSTutor.Model.Chat;

/**
 * The student class houses all the information that the ChatWindow needs from students.
 * It will house student ID, online status, and session ID.
 */


abstract class Student{
    String firstName;
    String lastName;
    int studentID;
    Boolean onlineStatus;
	Boolean isInstructor;
    int sessionID;
	
	abstract void requestPrivateMessage();
	
	abstract void requestScreenSharing();
	
	
	/**
     * inviteScreenSharing will only be active if the "Student" is an instructor
     *
    pre:
            //
            // Is the person trying to access the instructor?
            //
        (isInstructor == true);
     *
     */
	
	abstract void inviteScreenSharing();
}
