package CSTutor.Model.Chat.Client;

import java.rmi.*;

/**
 * Interface for the Client
 * 
 * @author stephen
 *
 */

public interface ClientIF extends Remote {
	void recieveMessage (String message) throws RemoteException;
}
