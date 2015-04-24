package CSTutor.View.Quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class QuizBuildGUI extends JPanel {
	
	private JList<String> questions; 		
	private ScoringGUI scoreGUI;
	private AddQuestionGUI addGUI;
	DefaultListModel<String> questionList; 
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new QuizBuildGUI());
		f.pack();
		f.setVisible(true);
	}
	public QuizBuildGUI () {
		scoreGUI = new ScoringGUI();
		addGUI = new AddQuestionGUI();
		
		this.setLayout(new BorderLayout());
		addQuestions();
		addButtons();
	}
	
	public void addQuestions() {
		JPanel questionPanel = new JPanel();
		
		questionList = new DefaultListModel<String>();
		
		questions = new JList<String>(questionList);
		//add questions here (pull from model?)
		questionList.addElement("What is your name?");
		questionList.addElement("What is your quest?");
		questionList.addElement("What is your favorite color?");
		questionList.addElement("Write code to calculate the average airspeed velocity of an unladen swallow.");
		
		
		questionPanel.add(questions);
		
		this.add(new JScrollPane(questionPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
	}
	
	public void addButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));

		JButton addQBut = new JButton("Add Question");
		JButton editQBut = new JButton("Edit Question");
		JButton delQBut = new JButton("Delete Question");
		JButton scoreBut = new JButton("Scoring");
		JButton viewBut = new JButton("View Quiz");
		
		addQBut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
      	   addGUI.setVisible(true);
         }
      });
		
		delQBut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
      	   if (questions.getSelectedValue() != null) {
      	   	questionList.removeElement(questions.getSelectedValue());
      	   }
         }
      });
		
		scoreBut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
      	   scoreGUI.setVisible(true);
         }
      });

		buttonPanel.add(addQBut);
		buttonPanel.add(editQBut);
		buttonPanel.add(delQBut);
		buttonPanel.add(scoreBut);
		buttonPanel.add(viewBut);
		
		this.add(buttonPanel, BorderLayout.WEST);
	}
}
