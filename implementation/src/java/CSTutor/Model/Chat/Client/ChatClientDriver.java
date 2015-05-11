package CSTutor.Model.Chat.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import CSTutor.Model.Chat.Server.ServerIF;

public class ChatClientDriver {
	public static void main (String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String chatServerURL = "rmi://localhost:2001/RMIChatServer";
		ServerIF chatServer = (ServerIF) Naming.lookup(chatServerURL);
		//new Thread(new ChatClient (args[0], chatServer)).start();
	}
}
