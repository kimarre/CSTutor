package CSTutor.View.Progress;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import CSTutor.Model.Progress.FullStudentTutorial;

/****
 * Class TreeCellRenderer provides code that customizes the appearance of the JTree in the
 * side bar of the StudentUI class. 
 * @author Erica Solum (esoluM@calpoly.edu)
 * @version 10Jun15
 */
public class TreeCellRenderer extends DefaultTreeCellRenderer
{

    public TreeCellRenderer()
    {
        super();
        
        setOpaque(true);
    }
    
    /**
     * Returns a JLabel that is displayed on the screen.
     */
    public Component getTreeCellRendererComponent(JTree tree, Object value, 
            boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        
        Object obj = ((DefaultMutableTreeNode)value).getUserObject();
        //System.out.println(obj.getClass().toString());
        
        Color background = new Color(67, 67, 67);
        if(obj instanceof CSTutor.Model.Manager.Class)
        {
            CSTutor.Model.Manager.Class classItem = (CSTutor.Model.Manager.Class)obj;
            setFont(new Font("Avenir", Font.PLAIN, 20));
            background = new Color(158, 195, 230);
            setText(classItem.name);
            setMinimumSize(new Dimension(200, 40));
            setPreferredSize(new Dimension(200, 40));
            setMaximumSize(new Dimension(200, 40));
        }
        else if(obj instanceof FullStudentTutorial)
        {
            FullStudentTutorial tutorialItem = (FullStudentTutorial)obj;
            setText(tutorialItem.getTutorialName());
            setFont(new Font("Avenir", Font.PLAIN, 16));
            background = new Color(208, 226, 245);
            setMinimumSize(new Dimension(200, 35));
            setPreferredSize(new Dimension(200, 35));
            setMaximumSize(new Dimension(200, 35));
            
            if(selected)
            {
                background = new Color(182, 182, 182);
            }
        }
        setBackground(background);
        
        return this;
    }

}
