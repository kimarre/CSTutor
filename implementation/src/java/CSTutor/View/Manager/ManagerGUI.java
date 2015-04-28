package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.*;
import java.io.*;
/**
 * @author Simon Vurens
 */

public class ManagerGUI extends JPanel {
	public NewObjectGUI newObject;
	public MoveGUI moveTut;
	public static CSTutor.Model.Manager.Manager managerModel = new CSTutor.Model.Manager.Manager();
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
        
        newObject = new NewObjectGUI();
        
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
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("PREVIEW GOES HERE");

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
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));

        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        JButton editBut = new JButton("Edit");
        editBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Edit button pressed");
           }
        });
        buttonPanel.add(editBut);
        
        JButton viewBut = new JButton("View");
        viewBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("View button pressed");
           }
        });
        buttonPanel.add(viewBut);
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        tutPanel.add(buttonPanel);
        
        panel.add(tutPanel);
    }
    
    public void addClassSection(JPanel panel) {
    	JPanel classPanel = new JPanel();
    	classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        /*CSTutor.Model.Database.TutorDAO dao = new CSTutor.Model.Database.TutorDAO();
        java.util.List<String> classes = dao.getClasses();
        java.util.List<DefaultMutableTreeNode> classNodes = new ArrayList<DefaultMutableTreeNode>();
        for (int i = 0; i < classes.size(); i++) {
            classNodes.add(new DefaultMutableTreeNode(classes.get(i)));
        }*/

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
        /*classNodes.get(0).add(s1);
        classNodes.get(0).add(s2);
        classNodes.get(0).add(s3);
        classNodes.get(0).add(s4);*/
        c1.add(s1);
        c1.add(s2);
        c1.add(s3);
        c1.add(s4);
        /*// Add all class nodes
        for (int i = 0; i < classNodes.size(); i++) {
            root.add(classNodes.get(i));
        }*/
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
        
        DefaultMutableTreeNode u1 = new DefaultMutableTreeNode("(no unit)");
        DefaultMutableTreeNode u2 = new DefaultMutableTreeNode("Final Review");
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("Hello World");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("Variables");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("Conditionals");
        DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("Introduction");
        DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("Printing Text");
        DefaultMutableTreeNode p3 = new DefaultMutableTreeNode("Special Characters");
        t1.add(p1);
        t1.add(p2);
        t1.add(p3);
        u1.add(t1);
        u1.add(t2);
        u1.add(t3);
        s1.add(u1);
        s1.add(u2);

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
        
        JButton newCBut = new JButton("New...");
        /**
         * For the purposes of this milestone, it opens directly to the new class
         * interface rather than anything else. By next milestone it should be more
         * functional.
         */
        newCBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("New Class button pressed");
        	   newObject.setVisible(true);
           }
        });
        buttonPanel.add(newCBut);
        
        
        JButton delBut = new JButton("Delete");
        delBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
         	  
         	 System.out.println("Delete button pressed");
	        	 DefaultMutableTreeNode node = (DefaultMutableTreeNode)fileTree.getLastSelectedPathComponent();
	          if (node == null){
	          	System.out.println("Nothing selected");
	          }
	          else {
	          	System.out.println(node.toString() + " selected");
	          	System.out.println(node.toString() + " " + node.getLevel());
	          	switch(node.getLevel()) {
	          	case 1:
	          		managerModel.deleteClass(null);
	          		break;
	          	case 2:
	          		managerModel.deleteSection(null);
	          		break;
	          	case 3:
	          		managerModel.deleteUnit(null);
	          		break;
	          	case 4:
	          		managerModel.deleteTutorial(null);
	          		break;
	          	case 5:
	          		managerModel.deletePage(null);
	          		break;
	          	default:
	          		//root or error
	          	}
	          }
           }
        });
        buttonPanel.add(delBut);
        
        JButton renameBut = new JButton("Rename...");
        renameBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Rename button pressed");
           }
        });
        buttonPanel.add(renameBut);
        
        JButton moveBut = new JButton("Move...");
        moveBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(moveBut);
        
        JButton moveupBut = new JButton("Move Up");
        moveupBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(moveupBut);
        
        JButton movedownBut = new JButton("Move Down");
        movedownBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(movedownBut);


        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        buttonPanel.add(new JPanel());
        
        classPanel.add(buttonPanel);
        panel.add(classPanel);
    }
}
