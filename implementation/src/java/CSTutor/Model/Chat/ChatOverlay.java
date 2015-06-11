package CSTutor.Model.Chat;

import java.io.IOException;

import java.util.Collection;

import CSTutor.Model.Chat.Client.*;
import CSTutor.View.Chat.*;

/**
 * ChatOverlay is a class that will encompass the overlay bar at the bottom of our application.
 * It will house data such as the ChatWindow, and will have methods that show and hide the window, respectively.
 * 
 * @author Stephen Daily
 */

public class ChatOverlay {
    
	Collection<Student> students;
	public ChatClient chatClient;
	String lastStringInput = "";
	public ChatBar chatBar;
	
	/**
	 * Constructor
	 * 
	 * Takes a reference to the parent chatBar (view)
	 * 
	 * Attemps to create a new connection to the server via initializing a new chatClient class
	 */
	public ChatOverlay(ChatBar chatBar) {
    	try {
			chatClient = new ChatClient(null, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	this.chatBar = chatBar;
	}
	
	/**
	 * Verification for the chatBox input. Returns true if the text entered is not just whitespace
	 */
    public Boolean Enter(String text){
    	if(!text.equals("") && text.trim().length() > 0) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * A method to send the inputted text to the server, via a method call in the ChatClient class
     */
    public void pushText(String buffer) {
    	chatClient.broadcastMessage(buffer);
    }
    
    /**
     * Adds a new line to the end of the input text.
     */
    public void setLastString(String str) {
    	lastStringInput = str + "\n";
    }
    
    /**
     * Returns the last string input by the user. 
     */
    public String getLastString() {
    	return lastStringInput;
    }
}
