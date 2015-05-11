package CSTutor.Model.Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import CSTutor.Model.Chat.Client.ChatClient;
import CSTutor.Model.Chat.Server.ServerIF;

/**
 * ChatOverlay is a class that will encompass the overlay bar at the bottom of our application.
 * It will house data such as the ChatWindow, and will have methods that show and hide the window, respectively.
 * 
 * @author Stephen Daily
 */

public class ChatOverlay {
    
	private static final String chatServerURL = "rmi://localhost:2001/RMIChatServer";
	public ChatWindow chatWindow;
	public OnlineWindow onlineWindow;
	public ChatClient rmiClient;
	
	public ChatOverlay() throws MalformedURLException, RemoteException, NotBoundException {
		chatWindow = new ChatWindow();
		onlineWindow = new OnlineWindow();
		connectToChatServer();
	}
	
	public void connectToChatServer() throws MalformedURLException, RemoteException, NotBoundException {
		ServerIF chatServer = (ServerIF) Naming.lookup(chatServerURL);
		rmiClient = new ChatClient ("TemporaryID", chatServer);
	}

	
}
