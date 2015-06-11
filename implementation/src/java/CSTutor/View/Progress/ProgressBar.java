package CSTutor.View.Progress;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/****
 * Class ProgressBar provides a graphical representation of how
 * much of a specific Tutorial a student user has viewed or completed.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class ProgressBar extends JPanel
{
    /** Constant that represents a complete tutorial in pixels */
    private final int COMPLETE_VALUE = 400;
    /** Constant that represents a semi-complete tutorial in pixels */
    private final int MEDIUM_VALUE = 200;
    /** Width of the progress bar */
    private int width;
    /** Height of the progress bar */
    private int height;
    /** Width in pixels that the completion bar should be in respect to the width of the entire bar */
    private int ratio;
    
    public ProgressBar(int width, int height, int numSeen, int numTotal)
    {
        super();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        
        ratio = (int)(((double)numSeen)/((double)numTotal) * width);
    }
    
    /**
     * Paints the shapes and lines onto the JPanel.
     */
    public void paint(Graphics g)
    {
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width+2, height+2);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect (1, 1, width-2, height-2);
        
        if(ratio == COMPLETE_VALUE)
        {
            g.setColor(Color.green);
        }
        else if(ratio >= MEDIUM_VALUE)
        {
            g.setColor(Color.yellow);
        }
        else
        {
            g.setColor(Color.red);
        }
        
        g.fillRect (1, 1, ratio-2, height-2);
            
        
    }

}
