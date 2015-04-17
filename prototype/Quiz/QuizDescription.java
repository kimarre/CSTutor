package Quiz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class QuizDescription extends JFrame{
	public QuizDescription() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("New Class");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        addStudentPanel();
        addNamePanel();
        addNamePanel();
        addNamePanel();
        addNamePanel();
        addButtons();
        
        this.pack();
        this.setVisible(false);
	}
	public void addNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		JLabel nameLabel = new JLabel("Answer Option: ");
		JTextField nameField = new JTextField("");
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		this.add(namePanel);
	}
	public void addStudentPanel(){
		JPanel studPanel = new JPanel();
      studPanel.setPreferredSize(new Dimension(400, 200));
		studPanel.setLayout(new BoxLayout(studPanel, BoxLayout.X_AXIS));
		JLabel studLabel = new JLabel("Students: ");
		String[] exampleNames = {""}; 
		final JList enrollList = new JList(exampleNames);
		enrollList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(enrollList.getSelectedValue());
			}
		});
		
		studPanel.add(studLabel);
		studPanel.add(new JScrollPane(enrollList));
		this.add(studPanel);
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
