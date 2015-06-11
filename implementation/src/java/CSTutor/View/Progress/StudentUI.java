package CSTutor.View.Progress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import CSTutor.Model.Progress.FullStudentTutorial;
import CSTutor.Model.Progress.InstructorModel;
import CSTutor.Model.Progress.ScoredTutorialTrack;
import CSTutor.Model.Progress.Student;
import CSTutor.Model.Progress.StudentModel;

/****
 * StudentUI is the view class that displays the information in the
 * StudentModel class to a user with Student access.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May15
 */
public class StudentUI extends JPanel
{
    /** Model that contains all the information to be displayed */
    private StudentModel model;
    /** Space for the top of the side bar */
    private JPanel topSpace;
    /** Space for the bottom of the side bar */
    private JPanel bottomSpace;
    /** Final pane for the list of classes */
    private JPanel finalClassesPane;
    /** Panel containing everything in the main section except for the title */
    private JPanel content;
    /** Space panels for each tab in the side bar */
    private JPanel classSpace;
    /** Corners used in the scroll panes of each tab */
    private JPanel classCorner;
    /** Primary section where data will be displayed */
    private MainContent main;
    /** Input field for the search functionality */
    private JTextField classField;
    /** Scroll panes for every tab */
    private JScrollPane classScroll;
    /** Panel that contains the list of Classes */
    private JPanel classPanel;
    /** Panel containing the UI elements for the search functionality */
    private JPanel classSearchPanel;
    /** Width of the side bar */
    private final int barWidth = 200;
    /** Height of the side bar */
    private final int barHeight = 550;
    /** Height of the search panels and buttons */
    private final int searchHeight = 30;
    /** Search button */
    private JButton classSearchButton;
    /** Reset buttons to reset the search */
    private JButton classResetButton;
    /** Reset panel */
    private JPanel classResetPanel;
    /** UI element for the Tree containing the classes and their tutorials */
    private JTree modelTree;
    
    public StudentUI(StudentModel model)
    {
        this.model = model;
        init();
    }
    
    /**
     * Initializes the Instructor UI.
     */    
    public void init()
    {
       
        setVisible(true);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));
        
        add(Box.createVerticalStrut(25));
        layoutMiddle();
        
        add(content);
        add(Box.createVerticalStrut(25));
        
    
    }
    
    /**
     * Provides the code for the middle portion of the GUI.
     */
    public void layoutMiddle()
    { 
        content = new JPanel();
        main = new MainContent();
        makeRefreshButton();
        makeSideBar();
        content.add(Box.createHorizontalStrut(20));
        content.add(finalClassesPane);
        
        content.add(Box.createHorizontalStrut(30));
        
       
        content.add(main); 
        content.add(Box.createHorizontalStrut(20));
        content.setBackground(new Color(255,255,255));
    }
    
    /**
     * Returns the side bar.
     */
    public JPanel getSideBar()
    {
        return null;
    }
    
    /**
     * Returns the main content section of the UI.
     */
    public MainContent getMain()
    {
        return main;
    }
    
    /**
     * Code to format the side bar's top and bottom frame.
     */
    private void formatSpaces()
    {
        classSpace = new JPanel();
        classSpace.setMinimumSize(new Dimension(200, 25));
        classSpace.setPreferredSize(new Dimension(200,25));
        classSpace.setMaximumSize(new Dimension(200, 25));
        classSpace.setBackground(new Color(153, 153, 153));
        classSpace.setVisible(true);
        
        classCorner = new JPanel();
        classCorner.setBackground(new Color(153, 153, 153));
        classCorner.setVisible(true);
        
    }
    
    /**
     * Creates the final panes that are placed in the tabbed pane in the side bar.
     */
    private void createFinalPanes()
    {
        /* Final Panes/Tabs */
        
        finalClassesPane = new JPanel();
        finalClassesPane.setLayout(new BoxLayout(finalClassesPane, BoxLayout.Y_AXIS));
        finalClassesPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        finalClassesPane.setMinimumSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setPreferredSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setMaximumSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setBackground(new Color(255, 226, 245));
        finalClassesPane.setVisible(true);
    }
    
    /**
     * Sets up the search field and button on the Class tab and implements a
     * corresponding action listener for it.
     */
    private void makeClassSearchField()
    {
        classResetPanel = new JPanel();
        classResetPanel.setLayout(new BoxLayout(classResetPanel, BoxLayout.Y_AXIS));
        classResetPanel.setBackground(new Color(153, 153, 153));
        
        classResetPanel.setMinimumSize(new Dimension(200, searchHeight));
        classResetPanel.setPreferredSize(new Dimension(200, searchHeight));
        classResetPanel.setMaximumSize(new Dimension(200, searchHeight));
        
        classField = new JTextField();   
        classSearchButton = new JButton("Search");
        classResetButton = new JButton("Reset");
        classResetPanel.setVisible(false);
        classResetButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //classList = model.search("");
                
                //classList.setCellRenderer(new ListRenderer());
                //classList.addListSelectionListener(new ListListener(main, model));
                //classPanel.removeAll();
                //classPanel.add(classList);
                //classPanel.add(Box.createVerticalGlue());
                //classPanel.revalidate();
                //classPanel.repaint();
                
                //classResetPanel.setVisible(false);
            }
            
        });
        
        classSearchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String searchString = classField.getText();
                
                System.out.print("Searching for " + searchString);
                //classList = model.search(searchString);
                
                //classList.setCellRenderer(new ListRenderer());
                //classList.addListSelectionListener(new ListListener(main, model));
                //classPanel.removeAll();
                //classPanel.add(classList);
                //classPanel.add(Box.createVerticalGlue());
                //classPanel.revalidate();
                //classPanel.repaint();
                
                //classResetPanel.setVisible(true);
            }
            
        });
        classResetPanel.add(classResetButton);
    }

    
    
    
    
    /**
     * Creates the search box on the bottom of the side bar.
     */
    private void createSearchPanels()
    {
        makeClassSearchField();
        
        
        classSearchPanel = new JPanel();
        classSearchPanel.setLayout(new BoxLayout(classSearchPanel, BoxLayout.X_AXIS));
        classSearchPanel.setBackground(new Color(153, 153, 153));
        classSearchPanel.add(Box.createHorizontalStrut(5));
        classSearchPanel.add(classField);
        classSearchPanel.add(Box.createHorizontalStrut(5));
        classSearchPanel.add(classSearchButton);
        classSearchPanel.setMinimumSize(new Dimension(200, searchHeight));
        classSearchPanel.setPreferredSize(new Dimension(200, searchHeight));
        classSearchPanel.setMaximumSize(new Dimension(200, searchHeight)); 
    }
    
    /**
     * Creates the scroll panels for the side bar.
     */
    private void createScrollPanels()
    {
        /* Scroll Stuff */
  
        //classScroll = new JScrollPane(classPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        modelTree = model.getTree();
        modelTree.putClientProperty("JTree.lineStyle", "None");
        modelTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                                   modelTree.getLastSelectedPathComponent();

            /* if nothing is selected */ 
                if (node == null) return;

            /* retrieve the node that was selected */ 
                Object nodeInfo = node.getUserObject();
                if(nodeInfo instanceof FullStudentTutorial)
                {
                    FullStudentTutorial tut = (FullStudentTutorial)nodeInfo;
                    
                    
                    main.displayStudentUI(tut);
                }
                
            /* React to the node selection. */
                
            }
        });
        
        modelTree.setRootVisible(false);
        TreeCellRenderer renderer = new TreeCellRenderer();
        renderer.setLeafIcon(null);
        
        modelTree.setCellRenderer(renderer);
        classScroll = new JScrollPane(modelTree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        classScroll.setColumnHeaderView(classSpace);
        classScroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                    classCorner);
        classScroll.setBackground(new Color(208, 226, 245));
    }
    
    /**
     * Creates the panels that house the JLists in the side bar.
     */
    private void createListPanels()
    {
        /* Panel Stuff */
        
        classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        classPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        classPanel.add(model.getTree());
        classPanel.add(Box.createVerticalGlue());
        classPanel.setBackground(new Color(208, 226, 245));
        classPanel.setVisible(true);
        
    }
    
    /**
     * Formats the instructor's side bar.
     */
    public void makeSideBar()
    {    
        formatSpaces();     
        createFinalPanes();
        createListPanels();
        createScrollPanels();
        createSearchPanels();
        
        finalClassesPane.add(classScroll);
        finalClassesPane.add(classSearchPanel);
        finalClassesPane.add(classResetPanel);
    }
    
    /**
     * Makes the refresh button that updates the tree in the side bar.
     */
    public void makeRefreshButton()
    {
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Refreshing");
               update();
            }
        });
        main.sendRefreshButton(refreshButton);
    }
    
    /**
     * Redraws the UI so that updated content can be shown.
     */
    public void update()
    {
        System.out.println("Updating");
        
        this.revalidate();
        this.repaint();
    }
}
