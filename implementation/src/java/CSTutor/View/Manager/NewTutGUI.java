package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
/****
 * Class NewTutGUI provides the GUI for creating a new tutorial.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class NewTutGUI extends JPanel{
	JTextField nameField;
	CSTutor.Model.Manager.Tutorial newTut;
	
	public NewTutGUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addName();
	}
	
	public void onOpenPanel() {
		newTut = new CSTutor.Model.Manager.Tutorial("", null);
	}
	
	public void addName() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField("Untitled");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	
	public CSTutor.Model.Manager.Tutorial getNewTut() {
		newTut.name = nameField.getText();
		newTut.parent = ManagerGUI.managerModel.selectedUnit;
		return newTut;
	}
}
