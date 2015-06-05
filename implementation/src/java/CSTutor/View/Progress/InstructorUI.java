package CSTutor.View.Progress;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;


import CSTutor.Model.Manager.*;
import CSTutor.Model.Progress.*;

/****
 * InstructorUI is the view class that displays the information 
 * from the InstructorModel class.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May15
 */
public class InstructorUI extends JPanel
{
    
    private JPanel topSpace;
    private JPanel bottomSpace;
    private JPanel finalClassesPane, finalStudentPane, finalTutorialPane;
    private JPanel content;
    private JPanel classSpace, studentSpace, tutorialSpace;
    private JPanel classCorner, studentCorner, tutorialCorner;
    private MainContent main;
    private JTabbedPane tabPane;
    private JTextField classField, studentField, tutorialField;
    private JScrollPane classScroll, studentScroll, tutorialScroll;
    private JPanel classPanel, studentPanel, tutorialPanel;
    private JPanel classSearchPanel, studentSearchPanel, tutorialSearchPanel;
    private ListRenderer renderer;
    private final int barWidth = 200;
    private final int barHeight = 515;
    private final int searchHeight = 30;
    private InstructorModel model;
    private JList<ScoredTutorialTrack> tutorialList;
    private JList<CSTutor.Model.Progress.Class> classList;
    private JList<Student> studentList;
    private JButton classSearchButton, tutorialSearchButton, studentSearchButton;
    
    
    public InstructorUI(InstructorModel model)
    {
        this.model = model;
        init();
        renderer = new ListRenderer(); 
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
        makeSideBar();
        content.add(Box.createHorizontalStrut(20));
        content.add(tabPane);
        
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
        JPanel classSpace = new JPanel();
        classSpace.setMinimumSize(new Dimension(200, 25));
        classSpace.setPreferredSize(new Dimension(200,25));
        classSpace.setMaximumSize(new Dimension(200, 25));
        classSpace.setBackground(new Color(153, 153, 153));
        classSpace.setVisible(true);
        
        JPanel studentSpace = new JPanel();
        studentSpace.setMinimumSize(new Dimension(200, 25));
        studentSpace.setPreferredSize(new Dimension(200,25));
        studentSpace.setMaximumSize(new Dimension(200, 25));
        studentSpace.setBackground(new Color(153, 153, 153));
        studentSpace.setVisible(true);
        
        JPanel tutorialSpace = new JPanel();
        tutorialSpace.setMinimumSize(new Dimension(200, 25));
        tutorialSpace.setPreferredSize(new Dimension(200,25));
        tutorialSpace.setMaximumSize(new Dimension(200, 25));
        tutorialSpace.setBackground(new Color(153, 153, 153));
        tutorialSpace.setVisible(true);
        
        JPanel classCorner = new JPanel();
        classCorner.setBackground(new Color(153, 153, 153));
        classCorner.setVisible(true);
        
        JPanel studentCorner = new JPanel();
        studentCorner.setBackground(new Color(153, 153, 153));
        studentCorner.setVisible(true);
        
        JPanel tutorialCorner = new JPanel();
        tutorialCorner.setBackground(new Color(153, 153, 153));
        tutorialCorner.setVisible(true);
    }
    
    /**
     * Gets the data from the model and creates JLists to populate the sidebar.
     */
    private void formatContent()
    {
        /* JList Sturf */
        tutorialList = model.getTutorialList();
        classList = model.getClassList();
        studentList = model.getStudentList();
        tutorialList.setCellRenderer(new ListRenderer());
        tutorialList.addListSelectionListener(
                new ListListener(main, model));
        classList.setCellRenderer(new ListRenderer());
        classList.addListSelectionListener(
                new ListListener(main, model));
        studentList.setCellRenderer(new ListRenderer());
        studentList.addListSelectionListener(
                new ListListener(main, model));
    }
    
    /**
     * Creates the final panes that are placed in the tabbed pane in the side bar.
     */
    private void createFinalPanes()
    {
        /* Final Panes/Tabs */
        finalTutorialPane = new JPanel();
        finalTutorialPane.setLayout(new BoxLayout(finalTutorialPane, BoxLayout.Y_AXIS));
        finalTutorialPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        finalTutorialPane.setMinimumSize(new Dimension(barWidth, barHeight));
        finalTutorialPane.setPreferredSize(new Dimension(barWidth, barHeight));
        finalTutorialPane.setMaximumSize(new Dimension(barWidth, barHeight));
        finalTutorialPane.setBackground(new Color(208, 226, 245));
        finalTutorialPane.setVisible(true);
        
        finalClassesPane = new JPanel();
        finalClassesPane.setLayout(new BoxLayout(finalClassesPane, BoxLayout.Y_AXIS));
        finalClassesPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        finalClassesPane.setMinimumSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setPreferredSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setMaximumSize(new Dimension(barWidth, barHeight));
        finalClassesPane.setBackground(new Color(255, 226, 245));
        finalClassesPane.setVisible(true);
        
        finalStudentPane = new JPanel();
        finalStudentPane.setLayout(new BoxLayout(finalStudentPane, BoxLayout.Y_AXIS));
        finalStudentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        finalStudentPane.setMinimumSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setPreferredSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setMaximumSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setBackground(new Color(208, 226, 245));
        finalStudentPane.setVisible(true);
    }
    
    /**
     * Sets up the search field and button on the Class tab and implements a
     * corresponding action listener for it.
     */
    private void makeClassSearchField()
    {
        classField = new JTextField();   
        classSearchButton = new JButton("Search");
        
        classSearchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String searchString = classField.getText();
                
                System.out.print("Searching for " + searchString);
                classList = model.searchForClass(searchString);
                
                classList.setCellRenderer(new ListRenderer());
                classList.addListSelectionListener(
                        new ListListener(main, model));
                classPanel.removeAll();
                classPanel.add(classList);
                classPanel.add(Box.createVerticalGlue());
                classPanel.revalidate();
                classPanel.repaint();
                
            }
            
        });
    }

    /**
     * Sets up the search field and button on the Students tab and implements a
     * corresponding action listener for it.
     */
    private void makeStudentSearchField()
    {
        studentField = new JTextField();
        
        studentSearchButton = new JButton("Search");
        
        studentSearchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String searchString = studentField.getText();
                
                System.out.print("Searching for " + searchString);
                studentList = model.searchForStudent(searchString);
                
                studentList.setCellRenderer(new ListRenderer());
                studentList.addListSelectionListener(
                        new ListListener(main, model));
                studentPanel.removeAll();
                studentPanel.add(studentList);
                studentPanel.add(Box.createVerticalGlue());
                studentPanel.revalidate();
                studentPanel.repaint();
                
            }
        });
    }
    
    /**
     * Sets up the search field and button on the Tutorials tab and implements a
     * corresponding action listener for it.
     */
    private void makeTutorialSearchField()
    {
        tutorialField = new JTextField();
        tutorialSearchButton = new JButton("Search");
        
        tutorialSearchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String searchString = tutorialField.getText();
                
                System.out.print("Searching for " + searchString);
                tutorialList = model.searchForTutorial(searchString);
                
                tutorialList.setCellRenderer(new ListRenderer());
                tutorialList.addListSelectionListener(
                        new ListListener(main, model));
                tutorialPanel.removeAll();
                tutorialPanel.add(tutorialList);
                tutorialPanel.add(Box.createVerticalGlue());
                tutorialPanel.revalidate();
                tutorialPanel.repaint();
                
            }
        });
    }
    
    /**
     * Creates the search box on the bottom of the side bar.
     */
    private void createSearchPanels()
    {
        makeClassSearchField();
        makeStudentSearchField();
        makeTutorialSearchField();
        tutorialSearchPanel = new JPanel();
        tutorialSearchPanel.setLayout(new BoxLayout(tutorialSearchPanel, BoxLayout.X_AXIS));
        tutorialSearchPanel.setBackground(new Color(153, 153, 153));
        tutorialSearchPanel.add(Box.createHorizontalStrut(5));
        tutorialSearchPanel.add(tutorialField);
        tutorialSearchPanel.add(Box.createHorizontalStrut(5));
        tutorialSearchPanel.add(tutorialSearchButton);
        tutorialSearchPanel.setMinimumSize(new Dimension(200, searchHeight));
        tutorialSearchPanel.setPreferredSize(new Dimension(200, searchHeight));
        tutorialSearchPanel.setMaximumSize(new Dimension(200, searchHeight));
        
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
        
        studentSearchPanel = new JPanel();
        studentSearchPanel.setLayout(new BoxLayout(studentSearchPanel, BoxLayout.X_AXIS));
        studentSearchPanel.setBackground(new Color(153, 153, 153));
        studentSearchPanel.add(Box.createHorizontalStrut(5));
        studentSearchPanel.add(studentField);
        studentSearchPanel.add(Box.createHorizontalStrut(5));
        studentSearchPanel.add(studentSearchButton);
        studentSearchPanel.setMinimumSize(new Dimension(200, searchHeight));
        studentSearchPanel.setPreferredSize(new Dimension(200, searchHeight));
        studentSearchPanel.setMaximumSize(new Dimension(200, searchHeight));
    }
    
    /**
     * Creates the scroll panels for the side bar.
     */
    private void createScrollPanels()
    {
        /* Scroll Stuff */
        tutorialScroll = new JScrollPane(tutorialPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tutorialScroll.setColumnHeaderView(classSpace);
        tutorialScroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                tutorialCorner);
        
        
        classScroll = new JScrollPane(classPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        classScroll.setColumnHeaderView(studentSpace);
        classScroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                    classCorner);
        classScroll.setBackground(new Color(208, 226, 245));

        
        studentScroll = new JScrollPane(studentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        studentScroll.setColumnHeaderView(tutorialSpace);
        studentScroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                    studentCorner);
    }
    
    /**
     * Creates the panels that house the JLists in the side bar.
     */
    private void createListPanels()
    {
        /* Panel Stuff */
        tutorialPanel = new JPanel();
        tutorialPanel.setLayout(new BoxLayout(tutorialPanel, BoxLayout.Y_AXIS));
        tutorialPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        tutorialPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        tutorialPanel.setBackground(new Color(208, 226, 245));
        tutorialPanel.add(tutorialList);
        tutorialPanel.add(Box.createVerticalGlue());
        tutorialPanel.setVisible(true);
        
        classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        classPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        classPanel.add(classList);
        classPanel.add(Box.createVerticalGlue());
        classPanel.setBackground(new Color(208, 226, 245));
        classPanel.setVisible(true);
        
        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        studentPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        studentPanel.setBackground(new Color(208, 226, 245));
        studentPanel.add(studentList);
        studentPanel.add(Box.createVerticalGlue());
        studentPanel.setVisible(true);
    }
    
    /**
     * Formats the instructor's side bar.
     */
    public void makeSideBar()
    {    
        /* Sidebar Formatting*/
        formatSpaces();     
        createFinalPanes();
        formatContent();
        createListPanels();
        createScrollPanels();
        createSearchPanels();
        
        /* Final Pane stuff */
        finalTutorialPane.add(tutorialScroll);
        finalClassesPane.add(classScroll);
        finalStudentPane.add(studentScroll);       
        finalTutorialPane.add(tutorialSearchPanel);
        finalClassesPane.add(classSearchPanel);
        finalStudentPane.add(studentSearchPanel);  
        
        /* TABBED PANE STUFF */
        tabPane = new JTabbedPane();
        tabPane.addTab("Classes", finalClassesPane);
        tabPane.addTab("Students", finalStudentPane);
        tabPane.addTab("Tutorials", finalTutorialPane); 
    }
    
    
  
}
