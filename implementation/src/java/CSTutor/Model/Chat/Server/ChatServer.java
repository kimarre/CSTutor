package CSTutor.Model.Chat.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import CSTutor.Model.Chat.Client.ClientIF;

/**
 * Class that represents the chat server.  Holds a list of chat clients, and broadcasts messages.
 * 
 * @author stephen
 *
 */

public class ChatServer extends UnicastRemoteObject implements ServerIF{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ClientIF> chatClients;
	
	/**
	 * Constructor
	 * @throws RemoteException
	 */
	protected ChatServer() throws RemoteException {
		super(0);
		chatClients = new ArrayList<ClientIF>();
	}
	
	
	/**
	 * Takes messages and sends them to each of the registered chat clients.
	 * 
	 * @param message The message to be broadcasted to all the registered clients.
	 */
	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i = 0;
		while (i < chatClients.size()) {
			chatClients.get(i++).recieveMessage(message);
		}
	}
	/**
	 * Registers the chat clients with the server. 
	 * 
	 * @param chatClient A client that to be added to the server list.
	 */
	@Override
	public synchronized void registerChatClient(ClientIF chatClient) throws RemoteException {
		this.chatClients.add(chatClient);
	}
}