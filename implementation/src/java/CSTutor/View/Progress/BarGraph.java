package CSTutor.View.Progress;

import javax.swing.*;
import java.awt.*;

/****
 * Class BarGraph provides a Java Swing compatible bar graph that can be 
 * drawn as a JPanel with a given width, height, and and array of values.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class BarGraph extends JPanel
{
    /** List of scores that functions as a height for each bar */
    private int[] scores;
    /** Spacing value for sides of graph */
    private final int padding = 15;
    /** Width in pixels of the graph */
    private int graphWidth;
    /** Height in pixels of the graph */
    private int graphHeight;
    
    public BarGraph(int width, int height, int[] scores)
    {
        super();
        this.scores = scores;
        graphWidth = width;
        graphHeight = height;
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
    }
    
    /**
     * Method that draws the shapes and lines onto the JPanel using the
     * Graphics data type.
     */
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        int barWidth = (graphWidth - (padding * (scores.length+1)))/scores.length;
        
        for(int i=0; i<scores.length; i++)
        {
            
            int barHeight = (int) (scores[i]*2);
            int yPosition = graphHeight - barHeight - 6;
            g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256),(int)(Math.random()*256)));
            g.fillRect ((barWidth*i) + (padding*(i+1)), yPosition, barWidth, barHeight);
            
        }
           
    }

}
