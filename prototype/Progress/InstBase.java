package Progress;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;


public class InstBase extends JPanel
{
    private JPanel topSpace;
    private JPanel bottomSpace;
    private JPanel scrollable;
    private JPanel content;
    private MainContent main;
    private JPanel bar;
    private JScrollPane barPane;
    private Vector<String> classes;
    private JPanel classPanel;
    private ListRenderer renderer;
    private final int barWidth = 200;
    private final int barHeight = 500;
    
    
    public InstBase()
    {
        super();
        init();
        renderer = new ListRenderer(main);
        
    }
    
    public void init()
    {
       
        setVisible(true);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setPreferredSize(new Dimension(1100,700));
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
        content.add(bar);
        
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
        
        JPanel space = new JPanel();
        space.setMinimumSize(new Dimension(200, 25));
        space.setPreferredSize(new Dimension(200,25));
        space.setMaximumSize(new Dimension(200, 25));
        space.setBackground(new Color(153, 153, 153));
        space.setVisible(true);
        //bar.add(space);
        
        classes = new Vector<String>();
        
        scrollable = new JPanel();
        scrollable.setLayout(new BoxLayout(scrollable, BoxLayout.Y_AXIS));
        scrollable.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollable.setMinimumSize(new Dimension(barWidth, barHeight));
        scrollable.setPreferredSize(new Dimension(barWidth, barHeight));
        scrollable.setMaximumSize(new Dimension(barWidth, barHeight));
        scrollable.setBackground(new Color(208, 226, 245));
        scrollable.setVisible(true);
        
        
    
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
        
        DefaultListModel<String> classesModel = new DefaultListModel<>();
        classesModel.addElement("Classes");
        classesModel.addElement("   - CPE 123");
        classesModel.addElement("   - CPE 101");
        classesModel.addElement("   - CPE 102");
        classesModel.addElement("   - CPE 103");
        classesModel.addElement("   - CPE 357");
        classesModel.addElement("   - CPE 305");
        classesModel.addElement("   - CPE 308");
        
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        listModel2.addElement("   - Hello World!");
        
        JList<String> tutorialList = new JList<>(tutorialsModel);
        tutorialList.setCellRenderer(new ListRenderer(main));
        
        JList<String> classesList = new JList<>(classesModel);
        classesList.setCellRenderer(new ListRenderer(main));
        
        
        
        ExpandableListItem tutorials = new ExpandableListItem("CPE 101", tutorialList, new ListRenderer(main));
        ExpandableListItem classes = new ExpandableListItem("CPE 102", classesList, new ListRenderer(main));
        
        
        classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setMinimumSize(new Dimension(barWidth, 500));
        classPanel.setMaximumSize(new Dimension(barWidth, 500));
        classPanel.add(tutorials);
        classPanel.add(classes);
        classPanel.add(Box.createVerticalGlue());
        classPanel.setVisible(true);
        
        barPane = new JScrollPane(classPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        barPane.setColumnHeaderView(space);
        
        JPanel corner = new JPanel();
        corner.setBackground(new Color(153, 153, 153));
        corner.setVisible(true);
        barPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                corner);
        //bar.add(space);
        
        
        scrollable.add(barPane);
        //scrollable.setVisible(true);
        bar.add(scrollable);

        //bar.add(space);
    }
    
}
