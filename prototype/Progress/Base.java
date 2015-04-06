package Progress;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

/****
 * Class Base provides a basic GUI layout for all Progress features.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 6Apr15
 */
public class Base extends JPanel
{
    private JPanel topSpace;
    private JPanel bottomSpace;
    private JPanel content;
    private JPanel main;
    private JPanel bar;
    private JScrollPane barPane;
    private final int barWidth = 200;
    private final int barHeight = 500;
    
    public Base()
    {
        super();
        init();       
    }
    
    /**
     * Initializes the layout of the base GUI.
     */
    private void init()
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
    
    /**
     * Provides the code for the middle section of the base GUI, which includes
     * the side bar and the main content section.
     */
    private void layoutMiddle()
    {
        /*
         * Create the side bar
         */
        bar = new SideBar();
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        
        /* 
         * Create the main content section 
         */
        main = new MainContent();
      
        /*
         * Create the overall panel that contains the sidebar, 
         * main content, and spacers.
         */ 
        content = new JPanel();
        content.add(Box.createHorizontalStrut(20));
        content.add(bar);
        content.add(Box.createHorizontalStrut(30));
        content.add(main); 
        content.add(Box.createHorizontalStrut(20));
        content.setBackground(new Color(255,255,255));
    }
    
    /**
     * Returns the side bar of the base.
     */ 
    public JPanel getSideBar()
    {
        return bar;
    }
    
    /**
     * Returns the main content section of the base.
     */
    public JPanel getMain()
    {
        return main;
    }
}
