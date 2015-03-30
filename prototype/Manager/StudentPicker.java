package Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class StudentPicker extends JFrame{
	public StudentPicker() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        addSelections();
        addButtons();
        
        this.pack();
        this.setVisible(false);
	}
	
	public void addSelections() {
		JPanel selPanel = new JPanel();
		selPanel.setLayout(new BoxLayout(selPanel, BoxLayout.Y_AXIS));
		JTextField searchField = new JTextField("John");
		String[] options = {"John Masanori", "Raymond Flint", "Elizabeth Mills", "Caprice Nisei", "Toshiyuki Sakai", "Mark Yale"};
		JList stuList = new JList(options);
		selPanel.add(searchField);
		selPanel.add(stuList);
		this.add(selPanel);
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
