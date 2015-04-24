package CSTutor.View.Quiz;

import javax.swing.*;

public class MultiChoiceGUI extends JPanel{
	private JTextField question;
	public MultiChoiceGUI() {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      addQuestionInput();
      addAnswers();
      setVisible(true);
	}
	public void addQuestionInput() {
		question = new JTextField(10);
		JPanel qPanel = new JPanel();
		qPanel.add(question);
		this.add(qPanel);
	}
	public void addAnswers() {
		JPanel a1 = new JPanel();
		JPanel a2 = new JPanel();
		JPanel a3 = new JPanel();
		JPanel a4 = new JPanel();
      a1.setLayout(new BoxLayout(a1, BoxLayout.X_AXIS));
      a2.setLayout(new BoxLayout(a2, BoxLayout.X_AXIS));
      a3.setLayout(new BoxLayout(a3, BoxLayout.X_AXIS));
      a4.setLayout(new BoxLayout(a4, BoxLayout.X_AXIS));
      
      JRadioButton a1but = new JRadioButton();
      JRadioButton a2but = new JRadioButton();
      JRadioButton a3but = new JRadioButton();
      JRadioButton a4but = new JRadioButton();
      a1.add(a1but);
      a2.add(a2but);
      a3.add(a3but);
      a4.add(a4but);

      JTextField a1field = new JTextField();
      JTextField a2field = new JTextField();
      JTextField a3field = new JTextField();
      JTextField a4field = new JTextField();
      a1.add(a1field);
      a2.add(a2field);
      a3.add(a3field);
      a4.add(a4field);

      this.add(a1);
      this.add(a2);
      this.add(a3);
      this.add(a4);
	}
}
