package CSTutor.Model.Chat.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import CSTutor.Model.Chat.Client.ClientIF;


public class ChatServer extends UnicastRemoteObject implements ServerIF{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ClientIF> chatClients;
	
	
	protected ChatServer() throws RemoteException {
		chatClients = new ArrayList<ClientIF>();
	}
	
	
	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i = 0;
		while (i < chatClients.size()) {
			chatClients.get(i++).recieveMessage(message);
		}
	}

	@Override
	public synchronized void registerChatClient(ClientIF chatClient) throws RemoteException {
		this.chatClients.add(chatClient);
	}
}