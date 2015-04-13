/**
 * REMEMBER TO CHANGE THE PACKAGE TO CSTUTOR.VIEW.PROGRESS
 */
package CSTutor.View.Progress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import CSTutor.Model.Progress.InstructorModel;

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
    private JPanel bar;
    private JTabbedPane tabPane;
    private JScrollPane tutorialScroll;
    private JScrollPane studentScroll;
    private JScrollPane classScroll;
    private JPanel classPanel;
    private JPanel tutorialPanel;
    private JPanel studentPanel;
    private ListRenderer renderer;
    private final int barWidth = 200;
    private final int barHeight = 500;
    private InstructorModel model;
    
    public InstructorUI(InstructorModel model)
    {
        this.model = model;
        init();
        renderer = new ListRenderer(); 
    }
    
        
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
        
    public void layoutMiddle()
    {
        makeSideBar();
        
        content = new JPanel();
        main = new MainContent();
        //content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        content.add(Box.createHorizontalStrut(20));
        content.add(tabPane);
        
        content.add(Box.createHorizontalStrut(30));
        
       
        content.add(main); 
        content.add(Box.createHorizontalStrut(20));
        content.setBackground(new Color(255,255,255));
    }
    
    public JPanel getSideBar()
    {
        return bar;
    }
    
    public MainContent getMain()
    {
        return main;
    }
    
    
    public void makeSideBar()
    {
        bar = new JPanel();
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        bar.setVisible(true);
        
        
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
        finalClassesPane.setBackground(new Color(208, 226, 245));
        finalClassesPane.setVisible(true);
        
        finalStudentPane = new JPanel();
        finalStudentPane.setLayout(new BoxLayout(finalStudentPane, BoxLayout.Y_AXIS));
        finalStudentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        finalStudentPane.setMinimumSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setPreferredSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setMaximumSize(new Dimension(barWidth, barHeight));
        finalStudentPane.setBackground(new Color(208, 226, 245));
        finalStudentPane.setVisible(true);
        
        /* Classes list */
        DefaultListModel<String> classesModel = new DefaultListModel<>();
        classesModel.addElement("Classes");
        classesModel.addElement("   - CPE 123");
        classesModel.addElement("   - CPE 101");
        classesModel.addElement("   - CPE 102");
        classesModel.addElement("   - CPE 103");
        classesModel.addElement("   - CPE 357");
        classesModel.addElement("   - CPE 305");
        classesModel.addElement("   - CPE 308");
        JList<String> classesList = new JList<>(classesModel);
        classesList.setCellRenderer(new ListRenderer());
        
        /* Students List */
        DefaultListModel<String> studentModel = new DefaultListModel<>();
        studentModel.addElement("Students");
        studentModel.addElement("   - Maria Auxier");
        studentModel.addElement("   - Marian Bell");
        studentModel.addElement("   - Eugene Brown");
        studentModel.addElement("   - Jamie Bryant");
        studentModel.addElement("   - Danielle Carter");
        studentModel.addElement("   - Vernon Chilton");
        studentModel.addElement("   - Mary Clark");
        studentModel.addElement("   - Laurie Crawford");
        studentModel.addElement("   - Geoffrey Dunning");
        studentModel.addElement("   - Lester Flores");
        studentModel.addElement("   - Suzanne Gridley");
        studentModel.addElement("   - Bruce Griffin");
        studentModel.addElement("   - Jennifer Headrick");
        studentModel.addElement("   - Kevin Hoover");
        studentModel.addElement("   - Constance Jackson");
        studentModel.addElement("   - Chris Kapp");
        studentModel.addElement("   - Leon Lewis");
        studentModel.addElement("   - Victor Massey");
        studentModel.addElement("   - Blanche Natal");
        studentModel.addElement("   - Dianne Ohara");
        studentModel.addElement("   - Charlotte Perry");
        studentModel.addElement("   - Eric Prince");
        studentModel.addElement("   - Frank Reed");
        studentModel.addElement("   - Nicole Rios");
        studentModel.addElement("   - David Rodriguez");
        studentModel.addElement("   - James Scott");
        studentModel.addElement("   - Robert Taylor");
        studentModel.addElement("   - Anna Turley");
        studentModel.addElement("   - Paula Webb");
        studentModel.addElement("   - James Welsh");
        studentModel.addElement("   - Marlene Williams");
        JList<String> studentList = new JList<>(studentModel);
        studentList.setCellRenderer(new ListRenderer());
        
        /* Tutorials list */
        DefaultListModel<String> tutorialsModel = new DefaultListModel<>();
        tutorialsModel.addElement("Tutorials");
        tutorialsModel.addElement("   - Hello World!");
        tutorialsModel.addElement("   - Intro. to C");
        tutorialsModel.addElement("   - Data Types");
        tutorialsModel.addElement("   - If Statements");
        tutorialsModel.addElement("   - Loops in C");
        tutorialsModel.addElement("   - Functions");
        tutorialsModel.addElement("   - The Stack");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        tutorialsModel.addElement("     ...");
        JList<String> tutorialList = new JList<>(tutorialsModel);
        tutorialList.setCellRenderer(new ListRenderer());
        
        
        /* Lists Stuff */
        ExpandableListItem tutorials = new ExpandableListItem("Tutorials", model.getTutorialList(), new ListRenderer());
        ExpandableListItem classes = new ExpandableListItem("Classes", model.getClassList(), new ListRenderer()); 
        ExpandableListItem students = new ExpandableListItem("Students", model.getStudentList(), new ListRenderer()); 
        
        /* Panel Stuff */
        tutorialPanel = new JPanel();
        tutorialPanel.setLayout(new BoxLayout(tutorialPanel, BoxLayout.Y_AXIS));
        tutorialPanel.setMinimumSize(new Dimension(barWidth, 500));
        tutorialPanel.setMaximumSize(new Dimension(barWidth, 500));
        tutorialPanel.add(tutorials);
        tutorialPanel.add(Box.createVerticalGlue());
        tutorialPanel.setVisible(true);
        
        classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setMinimumSize(new Dimension(barWidth, 500));
        classPanel.setMaximumSize(new Dimension(barWidth, 500));
        classPanel.add(classes);
        classPanel.add(Box.createVerticalGlue());
        classPanel.setBackground(new Color(208, 226, 245));
        classPanel.setVisible(true);
        
        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        studentPanel.setMinimumSize(new Dimension(barWidth, 500));
        studentPanel.setMaximumSize(new Dimension(barWidth, 500));
        studentPanel.add(students);
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
        finalClassesPane.add(classScroll);
        finalStudentPane.add(studentScroll);
        
        
        /* TABBED PANE STUFF */
        tabPane = new JTabbedPane();
        tabPane.addTab("Classes", finalClassesPane);
        tabPane.addTab("Students", finalStudentPane);
        tabPane.addTab("Tutorials", finalTutorialPane);
        
        
    }
}
