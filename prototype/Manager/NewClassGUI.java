package Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class NewClassGUI extends JFrame{
	StudentPicker picker;
	public NewClassGUI() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("New Class");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        
        picker = new StudentPicker();
        picker.setVisible(false);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        
        
        addNamePanel();
        addStudentPanel();
        addPermissions();
        addButtons();
        
        this.pack();
        this.setVisible(false);
	}
	public void addNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Class Name: ");
		JTextField nameField = new JTextField("Untitled");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	public void addStudentPanel(){
		JPanel studPanel = new JPanel();
		studPanel.setLayout(new BoxLayout(studPanel, BoxLayout.X_AXIS));
		JLabel studLabel = new JLabel("Students: ");
		String[] exampleNames = {"Thomas Haas", "Jackson Howard", "Bernice Mai", "Jack Weyland"}; 
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
		final JComboBox perOptions = new JComboBox(permissions);
		perOptions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(perOptions.getSelectedItem());
			}
		});
		
		perPanel.add(perLabel);
		perPanel.add(perOptions);
		this.add(perPanel);
	
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
