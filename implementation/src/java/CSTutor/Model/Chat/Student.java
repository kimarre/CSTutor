package CSTutor.Model.Chat;

/**
 * The student class houses all the information that the ChatWindow needs from students.
 * It will house student ID, online status, and session ID.
 * 
 *  @author Stephen Daily
 */


public class Student{
    String firstName;
    String lastName;
    int studentID;
    Boolean onlineStatus;
	Boolean isInstructor;
    int sessionID;
	
    public Student() {
    	
    }
    
	public void requestPrivateMessage() {
		System.out.println("Calling from requestPrivateMessage in Model.Chat.Student");
	}
	
	public void requestScreenSharing() {
		System.out.println("Calling from requestScreenSharing in Model.Chat.Student");
	}
	
	
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
	
	public void inviteScreenSharing() {
		System.out.println("Calling from inviteScreenSharing in Model.Chat.Student");
	}
}
