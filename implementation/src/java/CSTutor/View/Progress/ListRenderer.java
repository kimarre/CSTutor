package CSTutor.View.Progress;

import java.awt.*;

import javax.swing.*;

/****
 * Class ListRenderer stylizes the list items that populate the side bar. 
 * @author Erica Solum
 * @version 13Apr15
 */
public class ListRenderer extends JLabel implements ListCellRenderer<Object>
{
    public ListRenderer()
    {
        super();
        setOpaque(true);
        
    }

    /**
     * Returns the rendered JLabel of the list item.
     */
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Color background;
        setText("   " + value.toString());
        if(isSelected)
        {
            background = new Color(183, 183, 183);
            setFont(new Font("Avenir", Font.PLAIN, 16));
            
        }
        else
        {
            background = new Color(208, 226, 245);
            setFont(new Font("Avenir", Font.PLAIN, 16));
        }

        setMinimumSize(new Dimension(200, 35));
        setPreferredSize(new Dimension(200, 35));
        setMaximumSize(new Dimension(200, 35));
        setBackground(background);
        return this;
    }

}
