package CSTutor.Model.Chat.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import CSTutor.Model.Chat.Server.ServerIF;

/**
 * Chat client is a class that represents the individual client each user will be using. 
 * 
 * @author stephen
 *
 */

public class ChatClient extends UnicastRemoteObject implements ClientIF, Runnable {
	
	/**
	 * The server that the chat client is connecting to
	 */
	private ServerIF chatServer;
	
	/**
	 * The name of the user
	 */
	private String name = null;

	/**
	 * The constructor for the chatClient class
	 * 
	 * @param name The name of the user
	 * @param chatServer The server to connect to
	 * @throws RemoteException
	 */
	protected ChatClient(String name, ServerIF chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}
	
	/**
	 * Takes messages that are broadcast from the server, and prints them to the screen.
	 */
	@Override
	public void recieveMessage(String message) throws RemoteException {
		System.out.println(message);
		
	}
	
	/**
	 * A thread that will run the chat client. Constantly checks for user input, and then broadcasts the user input when recieved. 
	 */
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message;
		while(true) {
			message = scanner.nextLine();
			try {
				chatServer.broadcastMessage(name + " : " + message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
