package CSTutor.Model.Chat.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import CSTutor.Model.Chat.Server.ServerIF;

public class ChatClient extends UnicastRemoteObject implements ClientIF, Runnable {
	
	private ServerIF chatServer;
	private String name = null;

	protected ChatClient(String name, ServerIF chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}

	@Override
	public void recieveMessage(String message) throws RemoteException {
		System.out.println(message);
		
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message;
		while(true) {
			message = scanner.nextLine();
			try {
				chatServer.broadcastMessage(name + " : " + message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
