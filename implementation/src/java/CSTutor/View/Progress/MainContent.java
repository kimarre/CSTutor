package CSTutor.View.Progress;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/****
 * Class MainContent is the base section where information is displayed.
 * @author Erica Solum
 * @version 13Apr15
 */
public class MainContent extends JPanel
{
    private final int width = 750;
    private final int height = 500;
    private JPanel content;
    
    public MainContent()
    {
        super();
        init();
        
    }
    
    /**
     * Initializes the JPanel.
     */
    public void init()
    {
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
  
        content.setBackground(new Color(208, 226, 245));
        displaySampleData();
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEtchedBorder(1));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width,height));
        setBackground(new Color(208, 226, 245));
        setVisible(true);
        add(content);
    }
    
    /**
     * Makes the content in the main section not visible.
     */
    public void eraseContent()
    {
        content.setVisible(false);
    }
    
    /**
     * Displays a sample graph in the main content section.
     */
    public void displaySampleData()
    {
        try
        {
            BufferedImage myPicture = ImageIO.read(new File("sampleBarTransparent.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBackground(new Color(183, 183, 183));
            picLabel.setOpaque(true);
            content.add(Box.createHorizontalStrut(115));
            content.add(picLabel);
        }
        catch(Exception exc)
        {
            //blah blah blah
        }
        
    }

}
