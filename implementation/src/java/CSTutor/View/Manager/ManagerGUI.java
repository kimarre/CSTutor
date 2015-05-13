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
	
	DefaultMutableTreeNode root;
	DefaultTreeModel treeModel;
	JTree tree;
	
	public static CSTutor.Model.Manager.Manager managerModel = new CSTutor.Model.Manager.Manager();

    public ManagerGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        newObject = new NewObjectGUI();
        managerModel.data.add(new CSTutor.Model.Manager.Class("CSC 101"));
        managerModel.data.add(new CSTutor.Model.Manager.Class("CSC 102"));
        managerModel.data.add(new CSTutor.Model.Manager.Class("CSC 103"));
        managerModel.selectClass(managerModel.data.get(0));
        managerModel.createSection(new CSTutor.Model.Manager.Section("Section 1", null, null, managerModel.selectedClass));
        managerModel.selectSection(managerModel.selectedClass.sections.get(1));
        managerModel.createUnit(new CSTutor.Model.Manager.Unit("Printing Text", managerModel.selectedSection));
        managerModel.selectUnit(managerModel.selectedSection.units.get(1));
        managerModel.createTutorial(new CSTutor.Model.Manager.Tutorial("Hello World", managerModel.selectedUnit));
        managerModel.createTutorial(new CSTutor.Model.Manager.Tutorial("Conditionals", managerModel.selectedUnit));
        managerModel.createTutorial(new CSTutor.Model.Manager.Tutorial("Loops", managerModel.selectedUnit));
        
        
        addManagerContent();
        this.setVisible(true);
    }
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
   	          	System.out.println(node.toString() + " " + node.getLevel());
   	          	switch(node.getLevel()) {
	   	          	case 1:
	   	          		managerModel.selectClass((CSTutor.Model.Manager.Class)node.getUserObject());
	   	          		break;
	   	          	case 2:
	   	          		managerModel.selectSection((CSTutor.Model.Manager.Section)node.getUserObject());
	   	          		break;
	   	          	case 3:
	   	          		managerModel.selectUnit((CSTutor.Model.Manager.Unit)node.getUserObject());
	   	          		break;
	   	          	case 4:
	   	          		managerModel.selectTutorial((CSTutor.Model.Manager.Tutorial)node.getUserObject());
	   	          		break;
   	          	 }
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

        // Make classnode for each in class in db
        java.util.List<String> classes = CSTutor.Model.Database.TutorDAO.getClasses();
        java.util.List<DefaultMutableTreeNode> classNodes = new ArrayList<DefaultMutableTreeNode>();
        /*
        for (int i = 0; i < classes.size(); i++) {
            //classNodes.add(new DefaultMutableTreeNode(classes.get(i)));
        	managerModel.createClass(new CSTutor.Model.Manager.Class(classes.get(i)));
        }*/

        root = new DefaultMutableTreeNode("Classes");
        treeModel = new DefaultTreeModel(root);
        treeModel.addTreeModelListener(new MyTreeModelListener());
        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        /*
        root.removeAllChildren();
        treeModel.reload();
        */
        for (int i = 0; i < managerModel.data.size(); i++) {
      	   DefaultMutableTreeNode node = new DefaultMutableTreeNode(managerModel.data.get(i));
        	   treeModel.insertNodeInto(node, root, root.getChildCount());
        	   for (int j = 0; j < managerModel.data.get(i).sections.size(); j++) {
        	   	 DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(managerModel.data.get(i).sections.get(j));
        	   	 treeModel.insertNodeInto(node2, node, node.getChildCount());
        	   	 for(int k = 0; k < managerModel.data.get(i).sections.get(j).units.size(); k++) {
        	   		 DefaultMutableTreeNode node3
        	   		     = new DefaultMutableTreeNode(managerModel.data.get(i).sections.get(j).units.get(k));
        	   		 treeModel.insertNodeInto(node3, node2, node2.getChildCount());
          	        for(int l = 0; l <managerModel.data.get(i).sections.get(j).units.get(k).tutorials.size(); l++) {
            	   		 DefaultMutableTreeNode node4
          	   		     = new DefaultMutableTreeNode(managerModel.data.get(i).sections.get(j).units.get(k).tutorials.get(l));
              	   		 treeModel.insertNodeInto(node4, node3, node3.getChildCount());
          	        }
        	   	 }
        	   }
        }
        
        /*
        DefaultMutableTreeNode s1 = new DefaultMutableTreeNode("Section 1");
        DefaultMutableTreeNode s2 = new DefaultMutableTreeNode("Section 2");
        DefaultMutableTreeNode s3 = new DefaultMutableTreeNode("Section 3");
        DefaultMutableTreeNode s4 = new DefaultMutableTreeNode("Section 4");
        
        classNodes.get(0).add(s1);
        classNodes.get(0).add(s2);
        classNodes.get(0).add(s3);
        classNodes.get(0).add(s4);

        // Add all class nodes
        for (int i = 0; i < classNodes.size(); i++) {
            root.add(classNodes.get(i));
        }
        
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

        final JTree fileTree = new JTree(root); */
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if (node == null){
                	System.out.println("Nothing selected");
                }
                else {
                	System.out.println(node.toString() + " selected");
   	          	System.out.println(node.toString() + " " + node.getLevel());
   	          	switch(node.getLevel()) {
	   	          	case 1:
	   	          		managerModel.selectClass((CSTutor.Model.Manager.Class)node.getUserObject());
	   	          		break;
	   	          	case 2:
	   	          		managerModel.selectSection((CSTutor.Model.Manager.Section)node.getUserObject());
	   	          		break;
	   	          	case 3:
	   	          		managerModel.selectUnit((CSTutor.Model.Manager.Unit)node.getUserObject());
	   	          		break;
	   	          	case 4:
	   	          		managerModel.selectTutorial((CSTutor.Model.Manager.Tutorial)node.getUserObject());
	   	          		break;
   	          	}
                }
            }
        });
        /*
        //fileTree.setVisibleRowCount(15);
        JScrollPane fileTreeScroll = new JScrollPane(fileTree);*/
        JScrollPane fileTreeScroll = new JScrollPane(tree);
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
	        	 DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	          if (node == null){
	          	System.out.println("Nothing selected");
	          }
	          else {
	          	System.out.println(node.toString() + " selected");
	          	System.out.println(node.toString() + " " + node.getLevel());
	          	switch(node.getLevel()) {
	          	case 1:
	          		managerModel.deleteClass();
	          		break;
	          	case 2:
	          		managerModel.deleteSection();
	          		break;
	          	case 3:
	          		managerModel.deleteUnit();
	          		break;
	          	case 4:
	          		managerModel.deleteTutorial();
	          		break;
	          	case 5:
	          		managerModel.deletePage(null);
	          		break;
	          	default:
	          		//root or error
	          	}
               TreePath currentSelection = tree.getSelectionPath();
               if (currentSelection != null) {
                   DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
                                (currentSelection.getLastPathComponent());
                   MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
                   if (parent != null) {
                       treeModel.removeNodeFromParent(currentNode);
                   }
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
    
    	class MyTreeModelListener implements TreeModelListener {
    		public void treeNodesChanged(TreeModelEvent e) {
				DefaultMutableTreeNode node;
				node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());
 
				int index;
				try {
					index = e.getChildIndices()[0];
				}catch (Exception ex) { //NPE
					System.out.println("Error, were you editing the root?");
					return;	
				}
				node = (DefaultMutableTreeNode)(node.getChildAt(index));
				switch(node.getLevel()) {
          	case 1:
          		managerModel.selectedClass.name = node.getUserObject().toString();
          		node.setUserObject(managerModel.selectedClass);
          		break;
          	case 2:
          		managerModel.selectedSection.name = node.getUserObject().toString();
          		node.setUserObject(managerModel.selectedSection);
          		break;
          	case 3:
          		managerModel.selectedUnit.name = node.getUserObject().toString();
          		node.setUserObject(managerModel.selectedUnit);
          		break;
          	case 4:
          		managerModel.selectedTutorial.name = node.getUserObject().toString();
          		node.setUserObject(managerModel.selectedTutorial);
          		break;
				}
				System.out.println("Renamed the node to " + node.getUserObject());
        }
        public void treeNodesInserted(TreeModelEvent e) {
        }
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
}
