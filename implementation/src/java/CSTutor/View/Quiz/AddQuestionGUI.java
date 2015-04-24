package CSTutor.View.Quiz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddQuestionGUI extends JFrame {
	private JPanel midPanel;
	private MultiChoiceGUI mc;
	private CodeGUI code;
	public AddQuestionGUI() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Add Question");
      this.setLocationRelativeTo(null);
      
      
      this.setLayout(new BorderLayout());
      mc = new MultiChoiceGUI();
      code = new CodeGUI();
      
      
		addSelectPanel();
		midPanel = new JPanel();
		this.add(midPanel);
		addComp(mc);
		addButtons();
      

      this.setSize(400, 400);
      this.setVisible(false);
	}
	
   public void addComp(JPanel c) {
      midPanel.removeAll();
      midPanel.add(c);
      this.pack();
      this.setSize(400, 400);
      this.repaint();
   }
	
	public void addSelectPanel() {
		String[] qOptions = {"Multiple Choice", "Coding"};
		final JComboBox<String> optionBox = new JComboBox<String>(qOptions);
		optionBox.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
         	if (optionBox.getSelectedItem().equals("Multiple Choice")) {
         		addComp(mc);
         	}

         	else if (optionBox.getSelectedItem().equals("Coding")) {
         		addComp(code);
         	}
         }
      });
		JPanel selectPanel = new JPanel();
		selectPanel.add(optionBox);
		add(selectPanel, BorderLayout.NORTH);
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
