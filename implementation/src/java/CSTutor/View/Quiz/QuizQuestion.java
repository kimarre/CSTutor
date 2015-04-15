package CSTutor.View.Quiz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class QuizQuestion extends JFrame{
	public QuizQuestion() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Move");
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
		selPanel.setLayout(new BoxLayout(selPanel, BoxLayout.X_AXIS));
		JLabel selLabel = new JLabel("Move to: ");
		String[] options = {"(no unit)", "Final Review"};
		JComboBox selOptions = new JComboBox(options);
		selPanel.add(selLabel);
		selPanel.add(selOptions);
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
