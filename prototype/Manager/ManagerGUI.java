package Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.*;
import java.io.*;


public class ManagerGUI extends JPanel {
	public NewClassGUI newClass;
	public MoveGUI moveTut;
	public NewSectionGUI newSection;
	public NewUnitGUI newUnit;
	public NewTutGUI newTut;
    public static void main(String[] args)
    {
        new ManagerGUI();
    }
    public ManagerGUI() {
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setTitle("Manager");
        //this.setSize(800, 600);
        //this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        newClass = new NewClassGUI();
        moveTut = new MoveGUI();
        newSection = new NewSectionGUI();
        newUnit = new NewUnitGUI();
        newTut = new NewTutGUI();
        
        //addMenuBar();        
        addManagerContent();
        //addBottomBar();
        //this.pack();
        this.setVisible(true);
    }
    /*public void addMenuBar() {
    	JPanel menu = new JPanel();
    	menu.setSize(300, 100);
    	menu.add(new JButton("MENU GOES HERE!!!"));
    	this.add(menu);
    }*/
    /*public void addBottomBar() {
    	JPanel botMenu = new JPanel();
    	botMenu.setSize(300, 100);
    	botMenu.add(new JButton("BOTMENU GOES HERE!!!"));
    	this.add(botMenu);
    }*/
    public void addManagerContent() {
        JPanel manPanel = new JPanel();
        manPanel.setLayout(new BoxLayout(manPanel, BoxLayout.X_AXIS));
        addClassSection(manPanel);
        addTutorialSection(manPanel);
        addRightButtons(manPanel);
        this.add(manPanel);
    }
    
    public void addRightButtons(JPanel panel) {
    	JPanel butPanel = new JPanel();
        butPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    	butPanel.setLayout(new GridLayout(5, 1, 1, 50));
    	
        JButton progBut = new JButton("Student Progress");
        progBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Student Progress button pressed");
           }
        });
        butPanel.add(progBut); 
        
        JButton offBut = new JButton("Office Hours");
        offBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Office Hours button pressed");
           }
        });
        butPanel.add(offBut);
        
    	panel.add(butPanel);
    }
    
    public void addTutorialSection(JPanel panel) {
    	JPanel tutPanel = new JPanel();
    	tutPanel.setLayout(new BoxLayout(tutPanel, BoxLayout.Y_AXIS));
        tutPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("CSC 101");
        DefaultMutableTreeNode u1 = new DefaultMutableTreeNode("(no unit)");
        DefaultMutableTreeNode u2 = new DefaultMutableTreeNode("Final Review");
        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("Hello World");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Variables");
        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("Conditionals");
        DefaultMutableTreeNode s1 = new DefaultMutableTreeNode("Introduction");
        DefaultMutableTreeNode s2 = new DefaultMutableTreeNode("Printing Text");
        DefaultMutableTreeNode s3 = new DefaultMutableTreeNode("Special Characters");
        c1.add(s1);
        c1.add(s2);
        c1.add(s3);
        u1.add(c1);
        u1.add(c2);
        u1.add(c3);
        root.add(u1);
        root.add(u2);

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
        tutPanel.add(fileTreeScroll);
        
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
        
        JButton newUBut = new JButton("New Unit");
        newUBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Unit button pressed");
        	   newUnit.setVisible(true);
           }
        });
        buttonPanel.add(newUBut);
        
        JButton newTBut = new JButton("New Tutorial");
        newTBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Tutorial button pressed");
        	   newTut.setVisible(true);
           }
        });
        buttonPanel.add(newTBut);
        
        JButton newPBut = new JButton("New Page");
        newPBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Page button pressed");
           }
        });
        buttonPanel.add(newPBut);
        
        JButton editBut = new JButton("Edit");
        editBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Edit button pressed");
           }
        });
        buttonPanel.add(editBut);
        
        JButton renameBut = new JButton("Rename");
        renameBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Rename button pressed");
           }
        });
        buttonPanel.add(renameBut);
        
        JButton delBut = new JButton("Delete");
        delBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Delete button pressed");
           }
        });
        buttonPanel.add(delBut);
        
        JButton moveBut = new JButton("Move...");
        moveBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move... button pressed");
        	   moveTut.setVisible(true);
           }
        });
        buttonPanel.add(moveBut);
        
        JButton moveUpBut = new JButton("Move Up");
        moveUpBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Up button pressed");
           }
        });
        buttonPanel.add(moveUpBut);
        
        JButton moveDownBut = new JButton("Move Down");
        moveDownBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Down button pressed");
           }
        });
        buttonPanel.add(moveDownBut);
        
        tutPanel.add(buttonPanel);
        
        panel.add(tutPanel);
    }
    
    public void addClassSection(JPanel panel) {
    	JPanel classPanel = new JPanel();
    	classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Classes");
        DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("CSC 101");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("CSC 102");
        DefaultMutableTreeNode c3 = new DefaultMutableTreeNode("CSC 103");
        DefaultMutableTreeNode c4 = new DefaultMutableTreeNode("CSC 121");
        DefaultMutableTreeNode c5 = new DefaultMutableTreeNode("CSC 225");
        DefaultMutableTreeNode c6 = new DefaultMutableTreeNode("CSC 300");
        DefaultMutableTreeNode c7 = new DefaultMutableTreeNode("CSC 305");
        DefaultMutableTreeNode c8 = new DefaultMutableTreeNode("CSC 307");
        DefaultMutableTreeNode c9 = new DefaultMutableTreeNode("CSC 308");
        DefaultMutableTreeNode c10 = new DefaultMutableTreeNode("CSC 309");
        DefaultMutableTreeNode c11 = new DefaultMutableTreeNode("CSC 349");
        DefaultMutableTreeNode c12 = new DefaultMutableTreeNode("CSC 357");
        DefaultMutableTreeNode c13 = new DefaultMutableTreeNode("CSC 365");
        DefaultMutableTreeNode c14 = new DefaultMutableTreeNode("CSC 378");
        DefaultMutableTreeNode s1 = new DefaultMutableTreeNode("Section 1");
        DefaultMutableTreeNode s2 = new DefaultMutableTreeNode("Section 2");
        DefaultMutableTreeNode s3 = new DefaultMutableTreeNode("Section 3");
        DefaultMutableTreeNode s4 = new DefaultMutableTreeNode("Section 4");
        c1.add(s1);
        c1.add(s2);
        c1.add(s3);
        c1.add(s4);
        root.add(c1);
        root.add(c2);
        root.add(c3);
        root.add(c4);
        root.add(c5);
        root.add(c6);
        root.add(c7);
        root.add(c8);
        root.add(c9);
        root.add(c10);
        root.add(c11);
        root.add(c12);
        root.add(c13);
        root.add(c14);

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
        
        JButton newCBut = new JButton("New Class");
        newCBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Class button pressed");
        	   newClass.setVisible(true);
           }
        });
        buttonPanel.add(newCBut);
        
        JButton newSBut = new JButton("New Section");
        newSBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Section button pressed");
        	   newSection.setVisible(true);
           }
        });
        buttonPanel.add(newSBut);
        
        JButton delBut = new JButton("Delete");
        delBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Delete button pressed");
           }
        });
        buttonPanel.add(delBut);
        
        JButton editBut = new JButton("Edit");
        editBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Edit button pressed");
           }
        });
        buttonPanel.add(editBut);
        
        JButton moveBut = new JButton("Move Section");
        moveBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(moveBut);
        
        JButton renameBut = new JButton("Rename");
        renameBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Rename button pressed");
           }
        });
        buttonPanel.add(renameBut);

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        classPanel.add(buttonPanel);
        panel.add(classPanel);
    }
}
