package CSTutor.Model.Chat.Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class that represents the chat server.  Holds a list of chat clients, and broadcasts messages.
 * 
 * @author stephen
 *
 */

public class ChatServer {
	

	private ArrayList<ObjectOutputStream> chatClients;
	
	
	
	/**
	 * Constructor
	 * @throws RemoteException
	 */
	protected ChatServer() { 
		chatClients = new ArrayList<ObjectOutputStream>();
	}
	
	
	/**
	 * Takes messages and sends them to each of the registered chat clients.
	 * 
	 * @param message The message to be broadcasted to all the registered clients.
	 */
	public synchronized void broadcastMessage(Object message) {
		for(ObjectOutputStream stream : chatClients) {
			try {
				stream.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Registers the chat clients with the server. 
	 * 
	 * @param chatClient A client that to be added to the server list.
	 */

	
	public synchronized void registerChatClient(ObjectOutputStream stream){
		this.chatClients.add(stream);
	}
}