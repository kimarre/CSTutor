package CSTutor.Model.Chat.Server;

import java.rmi.*;

import CSTutor.Model.Chat.Client.ClientIF;

public interface ServerIF extends Remote {
	void registerChatClient (ClientIF chatClient) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;
}
