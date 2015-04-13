package CSTutor.View.Progress;
import java.awt.*;

import javax.swing.*;




@SuppressWarnings("serial")
public class ExpandableListItem extends JPanel
{
    private JList<String> children;
    private String title;
    private final int width = 200;
    private boolean expanded;
    private ListRenderer renderer;
    

    
    public ExpandableListItem(String title, JList<String> list, ListRenderer renderer)
    {
        expanded = false;
        children = list;
        this.title = title;
        children.setCellRenderer(renderer);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMinimumSize(new Dimension(width, 0));
        setMaximumSize(new Dimension(width, 500));
        //setPreferredSize(new Dimension(200, Short.MAX_VALUE));
        add(children);
        setVisible(true);
    }  
    
    public String toString()
    {
        return title;
    }
    
    public JList<String> getChildren()
    {
        return children;
    }
    
    public void expand()
    {
        System.out.println("Expanding!");
        expanded = true;
    }
    public void compress()
    {
        expanded = false;
    }
    
    public boolean isExpanded()
    {
        return expanded;
    }
    
    
    

}
