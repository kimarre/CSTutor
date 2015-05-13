package CSTutor.Model.Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;

import CSTutor.Model.Chat.Client.ChatClient;
import CSTutor.Model.Chat.Server.ServerIF;

import CSTutor.View.Chat.*;

/**
 * ChatOverlay is a class that will encompass the overlay bar at the bottom of our application.
 * It will house data such as the ChatWindow, and will have methods that show and hide the window, respectively.
 * 
 * @author Stephen Daily
 */

public class ChatOverlay {
    
	Collection<Student> students;
	private ChatClient chatClient;
	String lastStringInput = "";
	public ChatBar chatBar;
	
	public ChatOverlay(ChatBar chatBar) throws MalformedURLException, RemoteException, NotBoundException {
		
        //Creates the client that will talk with the RMIServer
        String chatServerURL = "rmi://localhost:2001/RMIChatServer";
    	ServerIF chatServer = (ServerIF) Naming.lookup(chatServerURL);
    	this.chatClient = new ChatClient ("Temp Name", chatServer, this);
    	
    	this.chatBar = chatBar;
	}
	
    public Boolean Enter(String text){
    	if(!text.equals("") && text.trim().length() > 0) {
    		return true;
    	}
    	return false;
    }
    
    public void pushText(String buffer) {
    	chatClient.broadcastMessage(buffer);
    }
    
    public void setLastString(String str) {
    	lastStringInput = str + "\n";
    }
    
    public String getLastString() {
    	return lastStringInput;
    }
}
