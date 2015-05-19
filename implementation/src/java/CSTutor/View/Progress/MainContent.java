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
 * Class MainContent is the JPanel where information about the item selected
 * in the side bar is displayed.
 * @author Erica Solum
 * @version 13Apr15
 */
public class MainContent extends JPanel
{
    private final int width = 750;
    private final int height = 500;
    private JPanel content;
    private JLabel title;
    
    public MainContent()
    {
        super();
        init();
        
    }
    
    /**
     * Initializes the JPanel with the desired size, background color,
     * and sets the initial title to "Progress". Also creates separators between
     * the title and the content below.
     */
    public void init()
    {   
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder(1));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setBackground(new Color(208, 226, 245));
        setVisible(true);
        title = new JLabel(new String("Progress"));
        title.setFont(new Font("Avenir", Font.PLAIN, 25));
        title.setVisible(true);
        this.add(title);
        
        JPanel linePanel = new JPanel();
        linePanel.setPreferredSize(new Dimension(1000, 5));
        linePanel.setMinimumSize(new Dimension(1000, 5));
        linePanel.setMaximumSize(new Dimension(1000, 5));
        linePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(linePanel);
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEtchedBorder(1));
        
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        content.setMaximumSize(new Dimension(750, 350));
        content.setPreferredSize(new Dimension(750, 350));
        content.setMinimumSize(new Dimension(750, 350));
        this.add(content);
    }
    
    /**
     * Deletes all content in the MainContent JPanel.
     */
    public void eraseContent()
    {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Changes the header to the provided text.
     */
    public void setTitleText(String text)
    {
         title.setText(text);
         this.revalidate();
         this.repaint();
    }

}
