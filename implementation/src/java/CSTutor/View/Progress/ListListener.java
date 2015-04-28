package CSTutor.View.Progress;

import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Erica Solum
 *
 */
public class ListListener implements ListSelectionListener
{
    private MainContent main;
    public ListListener(MainContent main)
    {
        this.main = main;
    }

    /**
     * 
     */
    public void valueChanged(ListSelectionEvent event)
    {
        JList<Object> source = (JList<Object>) event.getSource();
        
        int firstIndex = event.getFirstIndex();
        int lastIndex = event.getLastIndex();
        boolean isAdjusting = event.getValueIsAdjusting(); 
        
        if(!isAdjusting)
        {   
            Object obj = source.getSelectedValue();
            
            System.out.println("Selected " + obj.toString());
            
            JLabel testLabel = new JLabel(obj.toString());
            main.removeAll();
            main.add(testLabel);
            
            main.revalidate();
            main.repaint();  
        }
    }
}
