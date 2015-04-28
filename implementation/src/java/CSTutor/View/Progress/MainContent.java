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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder(1));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width,height));
        setBackground(new Color(208, 226, 245));
        setVisible(true);
    }
    
    /**
     * Makes the content in the main section not visible.
     */
    public void eraseContent()
    {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

}
