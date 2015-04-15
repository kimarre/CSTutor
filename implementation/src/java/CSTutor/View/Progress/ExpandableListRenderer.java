package CSTutor.View.Progress;
import java.awt.*;

import javax.swing.*;


/****
 * Class ExpandableListRenderer stylizes the side bars.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Apr15
 */
public class ExpandableListRenderer extends JLabel implements ListCellRenderer<ExpandableListItem>
{

    public ExpandableListRenderer()
    {
        setOpaque(true);
    }
   
    /**
     * Returns the renderer for the list items.
     */
    public Component getListCellRendererComponent(JList<? extends ExpandableListItem> list,
            ExpandableListItem value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Color background = new Color(159, 198, 233);
        
        setText(value.toString());
        
        if(isSelected)
        {

            value.expand();
            
        }
        else
        {
            value.compress();
        }
        this.setFont(new Font("Avenir Heavy", Font.BOLD, 20));
        //setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(background);
        //setAlignmentX(Component.LEFT_ALIGNMENT);
        return this;
    }

}
