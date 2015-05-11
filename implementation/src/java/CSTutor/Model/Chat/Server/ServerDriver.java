package CSTutor.Model.Chat.Server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * A class that represents the server driver. This is the program that starts the RMI chat server
 * 
 * @author stephen
 *
 */

public class ServerDriver {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		if (1 != args.length) {
			System.out.println("Usage: java ChatServer <server_port>");
			System.out.println("Example: java ChatServer 2001");
			return;
		}
		ChatServer server = new ChatServer();
		
		int port = Integer.parseUnsignedInt(args[0]);
        LocateRegistry.getRegistry(port).bind("RMIChatServer", server);
        System.out.println("Server started at {0}, waiting for connections...");
		
		//Naming.rebind("RMIChatServer", new ChatServer());
	}
}
