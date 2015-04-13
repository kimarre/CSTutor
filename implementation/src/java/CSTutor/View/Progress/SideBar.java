package Progress;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class SideBar extends JPanel
{
    private final int width = 200;
    private final int height = 500;
    
    public SideBar()
    {
        super();
        init();
    }
    
    private void init()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setBackground(new Color(208, 226, 245));
        setVisible(true);
        
        /*JPanel space = new JPanel();
        
        space.setMinimumSize(new Dimension(200, 25));
        space.setPreferredSize(new Dimension(200,25));
        space.setMaximumSize(new Dimension(200, 25));
        space.setBackground(new Color(153, 153, 153));
        space.setVisible(true);
        
        add(space);*/
    }
}
