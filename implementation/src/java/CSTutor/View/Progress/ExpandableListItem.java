package CSTutor.View.Progress;
import java.awt.*;

import javax.swing.*;




/****
 * Class ExpandableListItem is used to populate the side bar on the Progress section
 * of the CSTutor tool.
 * @author Erica Solum
 *
 */
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
    
    /**
     * Converts the list item to a String.
     */
    public String toString()
    {
        return title;
    }
    
    /**
     * Returns all the children under the list item. 
     */
    public JList<String> getChildren()
    {
        return children;
    }
    
    /**
     * Expand the list item.
     */
    public void expand()
    {
        expanded = true;
    }
    
    /**
     * Compress the list item.
     */
    public void compress()
    {
        expanded = false;
    }
    
    /**
     * Returns if the list item is expanded.
     */
    public boolean isExpanded()
    {
        return expanded;
    }
}
