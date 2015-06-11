package CSTutor.Model.Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A class that represents the server driver. This is the program that starts the RMI chat server
 * 
 * @author stephen
 *
 */

public class ServerDriver {
	@SuppressWarnings("resource")
	
	/**
	 * The main method for the chat server. This function initiates a socket and then constantly
	 * tries to except new connections
	 */
	public static void main(String[] args) {
		
		
		if (1 != args.length) {
			System.out.println("Usage: java ServerDriver <server_port>");
			System.out.println("Example: java ServerDriver 2001");
			return;
		}
		
		ServerSocket serverSocket = null;
	    int port = Integer.parseInt(args[0]);
	    ChatServer server = new ChatServer();
	    
		try {
			serverSocket = new ServerSocket (port);
			
			while(true) {
				Socket clientSocket = null;
				
				try {
					clientSocket = serverSocket.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				new Thread (new Worker(clientSocket, server)).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
