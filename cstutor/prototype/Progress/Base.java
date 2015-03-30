package Progress;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


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
       
       
        bar = new SideBar();
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        
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
    
    public JPanel getMain()
    {
        return main;
    }
}
