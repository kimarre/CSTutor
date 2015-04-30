package CSTutor.Model.Chat.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * A class that represents the server driver. This is the program that starts the RMI chat server
 * 
 * @author stephen
 *
 */

public class ServerDriver {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind("RMIChatServer", new ChatServer());
	}
}
