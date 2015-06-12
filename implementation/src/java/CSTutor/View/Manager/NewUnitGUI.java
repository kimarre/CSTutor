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
	CSTutor.Model.Manager.Unit newUnit;
	JTextField nameField;
	public NewUnitGUI() {

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        addName();
	}
	
	public void onOpenPanel() {
		newUnit = new CSTutor.Model.Manager.Unit("", null);
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
	
	public CSTutor.Model.Manager.Unit getNewUnit() {
		newUnit.name = nameField.getText();
		newUnit.parent = ManagerGUI.managerModel.selectedSection;
		return newUnit;
	}
	
}
