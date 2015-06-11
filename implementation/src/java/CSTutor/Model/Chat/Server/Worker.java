package CSTutor.Model.Chat.Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author stephen daily
 * 
 * This class represents a thread for each individual chat client that's connnected to the server
 */

public class Worker implements Runnable {
	protected Socket clientSocket = null;
	protected ChatServer parent = null;
	Object inputObject = null;
	
	/**
	 * Constructor
	 * 
	 * Accepts a socket and a reference to the chat server.
	 */
	public Worker (Socket soc, ChatServer parent) {
		this.clientSocket = soc;
		this.parent = parent;
	}
	
	
	/**
	 * Thread function
	 * 
	 * Initializes input and output streams and registers the client with the server. 
	 */
	public void run() {
		ObjectInputStream input;
		ObjectOutputStream output;
		
		try {
			input = new ObjectInputStream(clientSocket.getInputStream());
			output = new ObjectOutputStream(clientSocket.getOutputStream());
			
			parent.registerChatClient(output);
			
			while(true) {
				try {
					inputObject = input.readObject();
					parent.broadcastMessage(inputObject);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					break;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
