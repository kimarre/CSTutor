package CSTutor.View.Quiz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.*;
import java.io.*;


public class QuizGui extends JPanel {
	public QuizDescription newClass;
	public QuizQuestion moveTut;
        DefaultMutableTreeNode nodeToDel;
        DefaultMutableTreeNode root;
        DefaultMutableTreeNode selected; 
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.add(new QuizGui());
        frame.pack();
        frame.setVisible(true);
    }
    public QuizGui() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        newClass = new QuizDescription();
        moveTut = new QuizQuestion();
        
        addManagerContent();
        addBottomBar();
    }
    public void addBottomBar() {
    	JPanel botMenu = new JPanel();
    	botMenu.setSize(300, 100);
        
      JButton addQues = new JButton("Add Question");
      addQues.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
        	   newClass.setVisible(true);
         }
      });
      botMenu.add(addQues);
        
      JButton editQues = new JButton("Edit Question");
      editQues.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
         }
      });
      botMenu.add(editQues);
        
      JButton deleteQues = new JButton("Delete Question");
      deleteQues.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
           root.removeAllChildren();
         }
      });
        botMenu.add(deleteQues);
        
    	  this.add(botMenu);
    }
    public void addManagerContent() {
        JPanel manPanel = new JPanel();
        manPanel.setLayout(new BoxLayout(manPanel, BoxLayout.X_AXIS));
        addClassSection(manPanel);
        addQuestionSection(manPanel);
        this.add(manPanel);
    }
    
    
    public void addQuestionSection(JPanel panel) {
    	JPanel classPanel = new JPanel();
        classPanel.setPreferredSize(new Dimension(400, 400));
    	classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JTextField text = new JTextField("Question 1");
        root = new DefaultMutableTreeNode("CSC 101 Quiz 1");
        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("Question 1");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Question 2");
        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("Question 3");
        root.add(c1);
        root.add(c2);
        root.add(c3);
        final JTree fileTree = new JTree(root);
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)fileTree.getLastSelectedPathComponent();
                if (node == null){
                	System.out.println("Nothing selected");
                }
                else {
                	System.out.println(node.toString() + " selected");
                }
            }
        });
        //fileTree.setVisibleRowCount(15);
        JScrollPane fileTreeScroll = new JScrollPane(fileTree);
        classPanel.add(fileTreeScroll);
        
        //-------------------BUTTONS-------------------
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
        
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        classPanel.add(buttonPanel);
        panel.add(classPanel);
    }

    public void addClassSection(JPanel panel) {
    	JPanel classPanel = new JPanel();
    	classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setPreferredSize(new Dimension(400, 400));
        classPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Classes Quizzes");
        
        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("CSC 101 Quiz 1");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("CSC 101 Quiz 2");
        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("CSC 101 Quiz 3");
        DefaultMutableTreeNode c4 = new DefaultMutableTreeNode("CSC 102 Quiz 1");
        DefaultMutableTreeNode c5 = new DefaultMutableTreeNode("CSC 102 Quiz 2");
        DefaultMutableTreeNode c6 = new DefaultMutableTreeNode("CSC 103 Quiz 1");
        DefaultMutableTreeNode c7 = new DefaultMutableTreeNode("CSC 103 Quiz 2");
        root.add(c1);
        root.add(c2);
        root.add(c3);
        root.add(c4);
        root.add(c5);
        root.add(c6);
        root.add(c7);

        final JTree fileTree = new JTree(root);
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                selected = (DefaultMutableTreeNode)fileTree.getLastSelectedPathComponent();
                if (selected == null){
                	System.out.println("Nothing selected");
                }
                else {
                	 System.out.println(selected.toString() + " selected");
                }
            }
        });
        //fileTree.setVisibleRowCount(15);
        JScrollPane fileTreeScroll = new JScrollPane(fileTree);
        classPanel.add(fileTreeScroll);
        
        
        
        
        
        //-------------------BUTTONS-------------------
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
        
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        classPanel.add(buttonPanel);
        panel.add(classPanel);
    }
}
