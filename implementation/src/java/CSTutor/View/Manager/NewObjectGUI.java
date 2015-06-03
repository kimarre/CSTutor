package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.util.*;
/****
 * Class NewObjectGUI provides methods to generate a GUI element for 
 * adding a new object to the model, whether it is a class, section,
 * unit, or tutorial.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */

public class NewObjectGUI extends JFrame {
	
	//test main method
	/*public static void main(String[] args) {
		NewObjectGUI test = new NewObjectGUI();
		test.setVisible(true);
	}*/
	
	private NewClassGUI newClass;
	private NewSectionGUI newSect;
	private NewUnitGUI newUnit;
	private NewTutGUI newTut;
	private JPanel midPanel;
	JComboBox<String> objectSelect;
	
	/**
	 * Initializes private variables, generates the frame, and adds
	 * elements to the frame.
	 */
	public NewObjectGUI() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      this.setTitle("New...");
      this.setSize(300, 400);
      this.setLocationRelativeTo(null);
      getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
      
      newClass = new NewClassGUI();
      newSect = new NewSectionGUI();
      newUnit = new NewUnitGUI();
      newTut = new NewTutGUI();
      
      midPanel = new JPanel();
      
      addObjectSelect();
      add(midPanel);

      newClass.onOpenPanel();
      addComp(newClass);
      addButtons();
      this.pack();
      this.setVisible(false);
	}
	
   /**
    * Adds the panel c for the object being created after removing the previous panel.
    */
   public void addComp(JPanel c) {
      midPanel.removeAll();
      midPanel.add(c);
      pack();
   }
	
   /**
    * Adds the JComboBox for selecting the type of object to add
    */
   public void addObjectSelect() {
      String[] options = {"Class", "Section", "Unit", "Tutorial"};
      objectSelect = new JComboBox<String>(options);
      objectSelect.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
         	if (objectSelect.getSelectedItem().equals("Class")) {
         		newClass.onOpenPanel();
         		addComp(newClass);
         	}
         	else if (objectSelect.getSelectedItem().equals("Section")) {
         		newSect.onOpenPanel();
         		addComp(newSect);
         	}
         	else if (objectSelect.getSelectedItem().equals("Unit")) {
         		newUnit.onOpenPanel();
         		addComp(newUnit);
         	}
         	else if (objectSelect.getSelectedItem().equals("Tutorial")) {
         		newTut.onOpenPanel();
         		addComp(newTut);
         	}
      	
      	   System.out.println(objectSelect.getSelectedItem());
         }
      });
		add(objectSelect);
	}
	
   /**
    * Adds the 'OK' and 'Cancel' buttons to this.
    */
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
        	   boolean nameExists = false;
	         	if (objectSelect.getSelectedItem().equals("Class")) {
	         		for (CSTutor.Model.Manager.Class c : ManagerGUI.managerModel.data) {
	         			if (c.name.equals(newClass.getNewClass().name )) {
	         				nameExists = true;
	         			}
	         		}
	         		if (!nameExists) {
	         			System.out.println("adding new class: " + newClass.getNewClass());
	         			ManagerGUI.addClass(newClass.getNewClass());
	         		}
	         		else {
	         			System.out.println("Duplicate class name");
	         		}
	         	}
	         	else if (objectSelect.getSelectedItem().equals("Section")) {
	         		for (CSTutor.Model.Manager.Section c : ManagerGUI.managerModel.selectedClass.sections) {
	         			if (c.name.equals(newSect.getNewSection().name )) {
	         				nameExists = true;
	         			}
	         		}
	         		if (!nameExists) {
	         			System.out.println("adding new section: " + newSect.getNewSection());
	         			ManagerGUI.addSection(newSect.getNewSection());
	         		}
	         		else {
	         			System.out.println("Duplicate sect name");
	         		}
	         	}
	         	else if (objectSelect.getSelectedItem().equals("Unit")) {
	         		for (CSTutor.Model.Manager.Unit c : ManagerGUI.managerModel.selectedSection.units) {
	         			if (c.name.equals(newUnit.getNewUnit().name )) {
	         				nameExists = true;
	         			}
	         		}
	         		if (!nameExists) {
	         			System.out.println("adding new unit: " + newUnit.getNewUnit());
	         			ManagerGUI.addUnit(newUnit.getNewUnit());
	         		}
	         		else {
	         			System.out.println("Duplicate unit name");
	         		}
	         	}
	         	else if (objectSelect.getSelectedItem().equals("Tutorial")) {
	         		for (CSTutor.Model.Manager.Tutorial c : ManagerGUI.managerModel.selectedUnit.tutorials) {
	         			if (c.name.equals(newTut.getNewTut().name )) {
	         				nameExists = true;
	         			}
	         		}
	         		if (!nameExists) {
	         			System.out.println("adding new tutorial: " + newTut.getNewTut());
	         			ManagerGUI.addTutorial(newTut.getNewTut());
	         		}
	         		else {
	         			System.out.println("Duplicate tut name");
	         		}
	         	}
	        	setVisible(false);
           }
        });
        butPanel.add(kBut);
        
        this.add(butPanel);
	}
}
