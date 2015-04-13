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
    
    public void init()
    {
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
  
        content.setBackground(new Color(208, 226, 245));
        makeCrap();
        
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
    
    public void injectContent()
    {
        content.setVisible(true);
    }
    
    public void eraseContent()
    {
        content.setVisible(false);
    }
    
    public void makeCrap()
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
