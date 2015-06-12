package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
/****
 * Class NewClassGUI provides the GUI for creating a new class.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class NewClassGUI extends JPanel{
	StudentPicker picker;
	JTextField nameField;
	JList<String> enrollList;
	public static CSTutor.Model.Manager.Class newClass;
	public NewClassGUI() {
        
        picker = new StudentPicker();
        picker.setVisible(false);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addNamePanel();
        addStudentPanel();
        addPermissions();
	}
	public void onOpenPanel() {
		newClass = new CSTutor.Model.Manager.Class("");
	}
	public void addNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Class Name: ");
		nameField = new JTextField("Untitled");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	public void addStudentPanel(){
		JPanel studPanel = new JPanel();
		studPanel.setLayout(new BoxLayout(studPanel, BoxLayout.X_AXIS));
		JLabel studLabel = new JLabel("Students: ");
		String[] exampleNames = {"Thomas Haas", "Jackson Howard", "Bernice Mai", "Jack Weyland"}; 
		enrollList = new JList<String>(exampleNames);

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
        	   newClass.students.remove(null);
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
				if (perOptions.getSelectedItem().equals("All Users")) {
					newClass.access = CSTutor.Model.Manager.Class.ClassAccessLevel.Guest;
				}
				if (perOptions.getSelectedItem().equals("Students")) {
					newClass.access = CSTutor.Model.Manager.Class.ClassAccessLevel.Student;
				}
				if (perOptions.getSelectedItem().equals("Professors")) {
					newClass.access = CSTutor.Model.Manager.Class.ClassAccessLevel.Professor;
				}
				System.out.println(perOptions.getSelectedItem());
			}
		});
		
		perPanel.add(perLabel);
		perPanel.add(perOptions);
		this.add(perPanel);
	
	}
	
	public CSTutor.Model.Manager.Class getNewClass() {
		newClass.name = nameField.getText();
		System.out.println("New class of " + newClass);
	   return newClass;
	}
}
