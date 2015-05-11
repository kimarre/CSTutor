package CSTutor.Model.Chat;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * studentText is a class that will be used by the Console class. It's an object
 * that encompasses a text string, and some student data to output information to
 * the console.
 * 
 *  @author Stephen Daily
 */


public class StudentText {
	//The text that's being input.
    String text;
    //The student's screen name.
    int studentID;
    //The time at which the input was given
    Date time;
    
    
    /**
     * Constructor
     */
    public StudentText(String text) {
    	this.text = text;
    	this.studentID = 123456;
    	this.time = new Date();
    }
    
    private String formatTime() {
    	SimpleDateFormat ft = new SimpleDateFormat ("HH.mm.ss a");
    	return ft.format(time);
    }
    
    /**
     * Converts a regular string into student text. 
     */
    public String strToStudentText() {
    	return (formatTime() + studentID + text);
    }
}
