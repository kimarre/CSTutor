package CSTutor.View.Quiz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScoringGUI extends JFrame {

	public ScoringGUI() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Scoring");
      this.setLocationRelativeTo(null);
      
      
      this.setLayout(new BorderLayout());
      
      
		addScorePanel();
		addButtons();
      
      
      this.pack();
      this.setVisible(false);
	}
	public void addScorePanel() {
		JPanel scoreGridPanel = new JPanel();
		scoreGridPanel.setLayout(new BoxLayout(scoreGridPanel, BoxLayout.Y_AXIS));

		//set up list of pages here
		String[] pages = {"Start", "Page 1", "Page 2", "Page 3", "Next Tutorial"};
		
		JPanel failPanel = new JPanel();
		failPanel.setLayout(new GridLayout(1, 2));
		failPanel.add(new JLabel("0-50:"));
		JComboBox<String> failBox = new JComboBox<String>(pages);
		failPanel.add(failBox);
		scoreGridPanel.add(failPanel);	
		
		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(1, 2));
		midPanel.add(new JLabel("51-75:"));
		JComboBox<String> midBox = new JComboBox<String>(pages);
		midPanel.add(midBox);
		scoreGridPanel.add(midPanel);
		
		JPanel passPanel = new JPanel();
		passPanel.setLayout(new GridLayout(1, 2));
		passPanel.add(new JLabel("76-100:"));
		JComboBox<String> passBox = new JComboBox<String>(pages);
		passPanel.add(passBox);
		scoreGridPanel.add(passPanel);
		
		this.add(scoreGridPanel, BorderLayout.CENTER);
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
        
        this.add(butPanel, BorderLayout.SOUTH);
	}
}
