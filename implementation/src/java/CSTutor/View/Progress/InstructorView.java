package Progress;
import javax.swing.*;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.*;

/**
 * GUI for the instructor user of the CSTutor tool.
 * @author Erica Solum
 * @version 3Mar15
 */
public class InstructorView extends JPanel
{
    private InstBase instBase;
    private JTabbedPane tabPane;
    private Vector<String> classes;
    private JList list;
    private MainContent main;
    private final int width = 200;
    private final int height = 500;
    private ListRenderer renderer;
    
    /**
     * Constructs a new Instructor View GUI.
     */
    public InstructorView()
    {
        instBase = new InstBase();
        main = instBase.getMain();
        renderer = new ListRenderer();
        
        addSideBar();
        
        instBase.setVisible(true);
        
        add(instBase);
    }
    
    /**
     *
     */
    public void addSideBar()
    {
        tabPane = new JTabbedPane();
        makeList();
        
        
    }
    
    private void makeList()
    {
        
    }
    
    public void setupList()
    {
        DefaultListModel<ListItem> listModel = new DefaultListModel<>();
        listModel.addElement(new ListItem("CPE 101", true));
        listModel.addElement(new ListItem("   - Hello World!", false));
        listModel.addElement(new ListItem("   - Intro. to C", false));
        listModel.addElement(new ListItem("   - Variables", false));
        listModel.addElement(new ListItem("   - If Statements", false));
        listModel.addElement(new ListItem("   - Loops in C", false));
        listModel.addElement(new ListItem("   - Functions", false));
        listModel.addElement(new ListItem("   - The Stack", false));
        listModel.addElement(new ListItem("CPE 102", true));
        listModel.addElement(new ListItem("   - Hello World!", false));
        listModel.addElement(new ListItem("   - Intro. to Java", false));
        listModel.addElement(new ListItem("   - Data Types", false));
        listModel.addElement(new ListItem("   - Classes & Objects", false));
        listModel.addElement(new ListItem("   - Methods", false));
        listModel.addElement(new ListItem("   - Basic I/O", false));
    }
    
    public void setupMain()
    {
        
    }
    
    
    
    
    
    

}
