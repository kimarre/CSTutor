package Progress;
import java.awt.*;

import javax.swing.*;



public class ExpandableListRenderer extends JLabel implements ListCellRenderer<ExpandableListItem>
{

    public ExpandableListRenderer()
    {
        setOpaque(true);
    }
   
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
