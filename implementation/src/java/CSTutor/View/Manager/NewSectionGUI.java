package CSTutor.View.Manager;
/****
 * Class NewSectionGUI provides the GUI for creating a new section.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class NewSectionGUI extends JPanel{
	SectionStudentPicker picker;
	CSTutor.Model.Manager.Section newSect;
	JTextField nameField;
	public NewSectionGUI() {
        
        picker = new SectionStudentPicker();
        picker.setVisible(false);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        
        addNamePanel();
        addStudentPanel();
        addPermissions();
        addProf();
	}
	public void onOpenPanel() {
		newSect = new CSTutor.Model.Manager.Section("", null, null, null);
		newSect.parent = ManagerGUI.managerModel.selectedClass;
	}
	public void addNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Section Name: ");
		nameField = new JTextField("Untitled");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	public void addStudentPanel(){
		JPanel studPanel = new JPanel();
		studPanel.setLayout(new BoxLayout(studPanel, BoxLayout.X_AXIS));
		JLabel studLabel = new JLabel("Students: ");
		String[] exampleNames = {"Thomas Haas", "Jack Weyland"}; 
		final JList enrollList = new JList(exampleNames);

		enrollList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(enrollList.getSelectedValue());
			}
		});
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(3, 1, 10, 10));
		
        JButton addBut = new JButton("Add");
        addBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Add button pressed");
        	   picker.setVisible(true);
           }
        });
        options.add(addBut);
        
        JButton remBut = new JButton("Remove");
        remBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Remove button pressed");
           }
        });
        options.add(remBut);
        
        options.add(new JPanel());
		
		studPanel.add(studLabel);
		studPanel.add(new JScrollPane(enrollList));
		studPanel.add(options);
		this.add(studPanel);
	}
	
	public void addPermissions() {
		JPanel perPanel = new JPanel();
		JLabel perLabel = new JLabel("Permissions: ");
		String[] permissions = {"All Users", "Students", "Professors"};
		final JComboBox<String> perOptions = new JComboBox<String>(permissions);
		perOptions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(perOptions.getSelectedItem());
			}
		});
		
		perPanel.add(perLabel);
		perPanel.add(perOptions);
		this.add(perPanel);
	
	}
	
	public void addProf() {
		JPanel profPanel = new JPanel();
		JLabel profLabel = new JLabel("Professor: ");
		String[] profs = {"none","John Clements", "Alex Dekhtyar", "Gene Fisher", "Aaron Keen", "Clint Staley"};
		JComboBox profBox = new JComboBox(profs);
		
		profPanel.add(profLabel);
		profPanel.add(profBox);
		this.add(profPanel);
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
	public CSTutor.Model.Manager.Section getNewSection() {
		newSect.name = nameField.getText();
		//students?
		return newSect;
	}
}
