package CSTutor.Model.Chat.Client;

import java.rmi.*;


public interface ClientIF extends Remote {
	void recieveMessage (String message) throws RemoteException;
}
