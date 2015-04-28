package CSTutor.View.Progress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;


import CSTutor.Model.Progress.InstructorModel;
import CSTutor.Model.Progress.Student;
import CSTutor.Model.Progress.Tutorial;
import CSTutor.Model.Progress.Class;

/**
 * 
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Apr15
 */
public class InstructorUI extends JPanel
{
    
    private JPanel topSpace;
    private JPanel bottomSpace;
    private JPanel finalTutorialPane;
    private JPanel finalClassesPane;
    private JPanel finalStudentPane;
    private JPanel content;
    private MainContent main;
    private JTabbedPane tabPane;
    private JScrollPane tutorialScroll;
    private JScrollPane studentScroll;
    private JScrollPane classScroll;
    private JPanel classPanel;
    private JPanel tutorialPanel;
    private JPanel studentPanel;
    private ListRenderer renderer;
    private final int barWidth = 200;
    private final int barHeight = 460;
    private InstructorModel model;
    private JTree tree;
    
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
     * Lays out the middle portion of the UI.
     */
    public void layoutMiddle()
    {
        content = new JPanel();
        main = new MainContent();
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
        //content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
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
     * Formats the instructor's side bar.
     */
    public void makeSideBar()
    {
        /* Sidebar Formatting*/
        
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
        
        /* JList Sturf */
        JList<Tutorial> tutorialJList = model.getTutorialList();
        JList<Class> classJList = model.getClassList();
        JList<Student> studentJList = model.getStudentList();
        tutorialJList.setCellRenderer(new ListRenderer());
        tutorialJList.addListSelectionListener(
                new ListListener(main));
        classJList.setCellRenderer(new ListRenderer());
        classJList.addListSelectionListener(
                new ListListener(main));
        studentJList.setCellRenderer(new ListRenderer());
        studentJList.addListSelectionListener(
                new ListListener(main));
        
        /* Panel Stuff */
        tutorialPanel = new JPanel();
        tutorialPanel.setLayout(new BoxLayout(tutorialPanel, BoxLayout.Y_AXIS));
        tutorialPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        tutorialPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        tutorialPanel.setBackground(new Color(208, 226, 245));
        tutorialPanel.add(tutorialJList);
        tutorialPanel.add(Box.createVerticalGlue());
        tutorialPanel.setVisible(true);
        
        classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        classPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        classPanel.add(classJList);
        classPanel.add(Box.createVerticalGlue());
        classPanel.setBackground(new Color(208, 226, 245));
        classPanel.setVisible(true);
        
        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.setMinimumSize(new Dimension(barWidth, barHeight));
        studentPanel.setMaximumSize(new Dimension(barWidth, barHeight));
        studentPanel.setBackground(new Color(208, 226, 245));
        studentPanel.add(studentJList);
        studentPanel.add(Box.createVerticalGlue());
        studentPanel.setVisible(true);
        
        
        
        
        
        
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
        
        
        
        /* Final Pane stuff */
        finalTutorialPane.add(tutorialScroll);
        //finalClassesPane.add(classSpace);
        finalClassesPane.add(classScroll);
        
        //finalClassesPane.add(treeView);
        
        finalStudentPane.add(studentScroll);
        
        JPanel tutorialSearchPanel = new JPanel();
        tutorialSearchPanel.setLayout(new BoxLayout(tutorialSearchPanel, BoxLayout.X_AXIS));
        tutorialSearchPanel.setBackground(new Color(153, 153, 153));
        tutorialSearchPanel.add(Box.createHorizontalStrut(5));
        tutorialSearchPanel.add(new JLabel("Search"));
        tutorialSearchPanel.add(Box.createHorizontalStrut(5));
        tutorialSearchPanel.add(new JTextField());
        tutorialSearchPanel.setMinimumSize(new Dimension(200, 40));
        tutorialSearchPanel.setPreferredSize(new Dimension(200, 40));
        tutorialSearchPanel.setMaximumSize(new Dimension(200, 40));
        finalTutorialPane.add(tutorialSearchPanel);
        
        JPanel classSearchPanel = new JPanel();
        classSearchPanel.setLayout(new BoxLayout(classSearchPanel, BoxLayout.X_AXIS));
        classSearchPanel.setBackground(new Color(153, 153, 153));
        classSearchPanel.add(Box.createHorizontalStrut(5));
        classSearchPanel.add(new JLabel("Search"));
        classSearchPanel.add(Box.createHorizontalStrut(5));
        classSearchPanel.add(new JTextField());
        classSearchPanel.setMinimumSize(new Dimension(200, 40));
        classSearchPanel.setPreferredSize(new Dimension(200, 40));
        classSearchPanel.setMaximumSize(new Dimension(200, 40));
        finalClassesPane.add(classSearchPanel);
        
        JPanel studentSearchPanel = new JPanel();
        studentSearchPanel.setLayout(new BoxLayout(studentSearchPanel, BoxLayout.X_AXIS));
        studentSearchPanel.setBackground(new Color(153, 153, 153));
        studentSearchPanel.add(Box.createHorizontalStrut(5));
        studentSearchPanel.add(new JLabel("Search"));
        studentSearchPanel.add(Box.createHorizontalStrut(5));
        studentSearchPanel.add(new JTextField());
        studentSearchPanel.setMinimumSize(new Dimension(200, 40));
        studentSearchPanel.setPreferredSize(new Dimension(200, 40));
        studentSearchPanel.setMaximumSize(new Dimension(200, 40));
        finalStudentPane.add(studentSearchPanel);
        
        
        /* TABBED PANE STUFF */
        tabPane = new JTabbedPane();
        tabPane.addTab("Classes", finalClassesPane);
        tabPane.addTab("Students", finalStudentPane);
        tabPane.addTab("Tutorials", finalTutorialPane);
        
        
    }
}
