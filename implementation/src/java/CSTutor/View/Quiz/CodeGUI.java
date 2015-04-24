package CSTutor.View.Quiz;

import java.awt.GridLayout;

import javax.swing.*;

public class CodeGUI extends JPanel {
	private JTextArea question;
	private JTextField prompt;
	public CodeGUI() {
      this.setLayout(new GridLayout(3, 1));
      addQuestionInput();
      addAnswers();
      setVisible(true);
	}
	
	public void addQuestionInput() {
		JPanel qPanel = new JPanel();
		qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.Y_AXIS));
		prompt = new JTextField("Enter question here.");
		qPanel.add(prompt);
		question = new JTextArea("Enter code here");
		question.setRows(10);
		question.setColumns(30);
		qPanel.add(question);
		this.add(new JScrollPane(qPanel));
	}
	
	public void addAnswers() {
		JPanel ans = new JPanel();
      ans.setLayout(new BoxLayout(ans, BoxLayout.X_AXIS));
      
      JTextArea answerArea = new JTextArea("Enter Expected Output Here");
      ans.add(answerArea);
      
      this.add(new JScrollPane(ans));
	}
}
