package CSTutor.View.Progress;

import javax.swing.*;
import java.awt.*;

public class BarGraph extends JPanel
{
    private int[] scores;
    private final int padding = 15;
    private int graphWidth;
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
