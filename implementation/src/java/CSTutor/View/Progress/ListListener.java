package CSTutor.View.Progress;

import java.awt.Font;

import javax.swing.*;
import javax.swing.event.*;

import CSTutor.Model.Progress.InstructorModel;

/**
 * @author Erica Solum
 *
 */
public class ListListener implements ListSelectionListener
{
    private MainContent main;
    private InstructorModel model;
    public ListListener(MainContent main, InstructorModel model)
    {
        this.main = main;
        this.model = model;
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
            testLabel.setFont(new Font("Avenir", Font.PLAIN, 25));
            main.removeAll();
            main.add(testLabel);
            
            
            
            
            main.revalidate();
            main.repaint();
            
            
        }
    }
}
