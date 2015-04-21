package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
/****
 * Class NewUnitGUI provides the GUI for creating a new unit.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class NewUnitGUI extends JPanel{
	public NewUnitGUI() {

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        addName();
	}
	
	public void addName() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField("Untitled");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	
	public void addButtons() {
		JPanel butPanel = new JPanel();
		
        JButton canBut = new JButton("Cancel");
        canBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Cancel button pressed");
        	   setVisible(false);
           }
        });
        butPanel.add(canBut);
        
        JButton kBut = new JButton("OK");
        kBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("OK button pressed");
        	   setVisible(false);
           }
        });
        butPanel.add(kBut);
        
        this.add(butPanel);
	}
}
