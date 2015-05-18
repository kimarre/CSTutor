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
	
	public static DefaultMutableTreeNode root;
	public static DefaultTreeModel treeModel;
	public static JTree tree;
	
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
        manPanel.setLayout(new GridLayout(1, 2, 1, 50));
        manPanel.setBorder(new EmptyBorder(10, 50, 10, 50));
        addClassSection(manPanel);
        addTutorialSection(manPanel);
        this.add(manPanel);
    }
    
    public void addTutorialSection(JPanel panel) {
    	JPanel tutPanel = new JPanel();
    	tutPanel.setLayout(new BorderLayout());
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
                }
            }
        });
        //fileTree.setVisibleRowCount(15);
        JScrollPane fileTreeScroll = new JScrollPane(fileTree);
        tutPanel.add(fileTreeScroll, BorderLayout.CENTER);
        
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

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
        
        tutPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        panel.add(tutPanel);
    }
    
    public void addClassSection(JPanel panel) {
    	JPanel classPanel = new JPanel();
    	classPanel.setLayout(new BorderLayout());
        classPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Make classnode for each in class in db
        java.util.List<String> classes = CSTutor.Model.Database.TutorDB.getClassNames();
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
        classPanel.add(fileTreeScroll, BorderLayout.CENTER);
        
        
        
        
        
        //-------------------BUTTONS-------------------
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));
        
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

        JButton moveBut = new JButton("Move...");
        moveBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(moveBut);
        
        /*
        JButton moveupBut = new JButton("Move Up");
        moveupBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(moveupBut);*/
        
        JButton movedownBut = new JButton("Move Down");
        movedownBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Move Section button pressed");
           }
        });
        buttonPanel.add(movedownBut);
        
        classPanel.add(buttonPanel, BorderLayout.SOUTH);
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
    	
    public static void addClass(CSTutor.Model.Manager.Class toInsert) {
   	 DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(toInsert);
 		 treeModel.insertNodeInto(classNode, root, 0);
 		 DefaultMutableTreeNode sectNode = new DefaultMutableTreeNode(toInsert.sections.get(0));
 		 treeModel.insertNodeInto(sectNode, classNode, 0);
 		 DefaultMutableTreeNode unitNode = new DefaultMutableTreeNode(toInsert.sections.get(0).units.get(0));
 		 treeModel.insertNodeInto(unitNode, sectNode, 0);
    }
    public static void addSection(CSTutor.Model.Manager.Section toInsert) {
    	DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    	System.out.println("Node is " + node);
    	while (node.getLevel() > 1) {
    		node = (DefaultMutableTreeNode)node.getParent();
    	}
    	if (node.getLevel() != 1) {
    		System.out.println("Error: No class selected");
    		return;
    	}
		System.out.println("Inserting section " + toInsert + " into tree");
		DefaultMutableTreeNode sectNode = new DefaultMutableTreeNode(toInsert);
		treeModel.insertNodeInto(sectNode, node, 0);
 		DefaultMutableTreeNode unitNode = new DefaultMutableTreeNode(toInsert.units.get(0));
 		treeModel.insertNodeInto(unitNode, sectNode, 0);
    }
    
    public static void addTutorial(CSTutor.Model.Manager.Tutorial toInsert) {
    	DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    	while (node.getLevel() > 3) {
    		node = (DefaultMutableTreeNode)node.getParent();
    	}
    	if (node.getLevel() != 3) {
    		System.out.println("Error: No unit selected");
    		return;
    	}
    	System.out.println("Inserting tutorial " + toInsert +" into tree");
    	DefaultMutableTreeNode tutNode = new DefaultMutableTreeNode(toInsert);
    	treeModel.insertNodeInto(tutNode, node, 0);
    }    
    public static void addUnit(CSTutor.Model.Manager.Unit toInsert) {
    	DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    	while (node.getLevel() > 2) {
    		node = (DefaultMutableTreeNode)node.getParent();
    	}
    	if (node.getLevel() != 2) {
    		System.out.println("Error: No section selected");
    		return;
    	}
    	System.out.println("Inserting tutorial " + toInsert +" into tree");
    	DefaultMutableTreeNode tutNode = new DefaultMutableTreeNode(toInsert);
    	treeModel.insertNodeInto(tutNode, node, 0);
    }
}
