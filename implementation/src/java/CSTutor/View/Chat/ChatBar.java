/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.View.Chat;

import CSTutor.Model.Chat.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


/**
 *
 * @author Simon Vurens
 */
public class ChatBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form ChatBar
	 */
	public ChatBox box;
	public Online online;
	public ChatOverlay chatOverlay;
	public ChatBar() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	//@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		

		chatOverlay = new ChatOverlay(this);

		online = new Online(new Student());
		box = new ChatBox(chatOverlay);
		box.setVisible(false);
		online.setVisible(false);
		JPanel butPanel = new JPanel();
		JButton onlineBut = new JButton("Online");
		JButton chatBut = new JButton("Chat");

		onlineBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				online.setVisible(true);
			}
		});

		chatBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box.setVisible(true);
			}
		});

		butPanel.setLayout(new BoxLayout(butPanel, BoxLayout.X_AXIS));
		butPanel.add(chatBut);
		butPanel.add(onlineBut);
		this.setLayout(new GridLayout(1, 3));
		this.add(new JPanel());
		this.add(new JPanel());
		this.add(butPanel);
		//this.setVisible(false);
	}// </editor-fold>//GEN-END:initComponents

	// End of variables declaration                   
}
