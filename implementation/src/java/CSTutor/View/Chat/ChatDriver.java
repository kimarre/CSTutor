package CSTutor.View.Chat;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


/**
 * 
 * 
 * @author Simon Vurens
 */

public class ChatDriver extends JFrame{
	//public static 
	public static ChatDriver thisOne;
	public static void main(String[] args) {
		thisOne = new ChatDriver();
	}
	public ChatDriver() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(5, 100);
		this.setLayout(new BorderLayout());
		this.add(new ChatBar(), BorderLayout.SOUTH);
		this.add(new JLabel("Hello World"), BorderLayout.CENTER);
		//this.add(box);
		this.setSize(500, 300);
		//this.pack();
	}
}
