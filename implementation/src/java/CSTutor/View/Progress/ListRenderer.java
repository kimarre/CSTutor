package Progress;

import java.awt.*;

import javax.swing.*;

/****
 * Class ListRenderer stylizes the collapsable lists that appear in the left side bars of the Instructor 
 * and Student UIs.
 */
public class ListRenderer extends JLabel implements ListCellRenderer<String>
{
    private MainContent main;
    public ListRenderer(MainContent main)
    {
        super();
        setOpaque(true);
        this.main = main;
        
    }

    
    public Component getListCellRendererComponent(JList<? extends String> list,
            String value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Color background;
        setText(value);
        
        
        if(index == 0)
        {
            background = new Color(159, 198, 233);
            setFont(new Font("Avenir Black", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        }
        else if(isSelected && index != 0)
        {
            background = new Color(183, 183, 183);
            setFont(new Font("Avenir", Font.PLAIN, 16));
            
        }
        else
        {
            background = new Color(208, 226, 245);
            setFont(new Font("Avenir", Font.PLAIN, 16));
        }
        
        
        Dimension dim = getMaximumSize();
        setMaximumSize(new Dimension(200, dim.height));
        setPreferredSize(new Dimension(200, dim.height));
        setMinimumSize(new Dimension(200, dim.height));
        
        if(index == 0)
        {
            setMinimumSize(new Dimension(200, getMaximumSize().height + 10));
            setPreferredSize(new Dimension(200, getMaximumSize().height + 10));
            setMaximumSize(new Dimension(200, getMaximumSize().height + 10));
        }
        
        setBackground(background);
        
        
        return this;
    }

}
