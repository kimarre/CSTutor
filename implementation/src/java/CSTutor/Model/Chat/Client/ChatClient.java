package CSTutor.Model.Chat.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import java.net.UnknownHostException;

import CSTutor.Model.Chat.ChatOverlay;


public class ChatClient implements Runnable {
    	Socket socket = null;
    	ObjectInputStream input = null; 
    	ObjectOutputStream output = null;
    	
    	private ChatOverlay chatOverlay;
    	
    	/**
    	 * The name of the user
    	 */
    	private String name = null;

    	/**
    	 * The constructor for the chatClient class
    	 * 
    	 * @param name The name of the user
    	 * @param chatServer The server to connect to
    	 * @throws IOException 
    	 * @throws UnknownHostException 
    	 * @throws RemoteException
    	 */
    	public ChatClient(String name, ChatOverlay chatOverlay) throws UnknownHostException, IOException {
    		this.name = name;
    		socket = new Socket("bunnytails.org", 8045);
    		
    		this.chatOverlay = chatOverlay;
    		
    		new Thread(this).start();
    	}
    	
    	/**
    	 * Takes messages that are broadcast from the server, and prints them to the screen.
    	 * @return 
    	 */
    	public void recieveMessage(String message){
    		chatOverlay.setLastString(name + ": " + message);
    		chatOverlay.chatBar.box.updateConsole();
    	}
    	
    	public void broadcastMessage(String message) {
    		try {
				output.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	public void run() {
    		try {
    			output = new ObjectOutputStream(socket.getOutputStream());
				input = new ObjectInputStream(socket.getInputStream());
				while(true) {
					try {
						recieveMessage((String) input.readObject());
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	}
    }