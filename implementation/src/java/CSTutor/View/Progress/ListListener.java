package CSTutor.View.Progress;

import java.awt.Font;

import javax.swing.*;
import javax.swing.event.*;

import CSTutor.Model.Progress.*;

/**
 * Class ListListener provides the method that is called when changes occur
 * in the list displayed in the side bar, such as when a user selects a new
 * list item. 
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May15
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
     * This method is called every time a change occurs in the list
     * displayed in the left side bar. If a selection change occurs,
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
            
            main.setTitleText(obj.toString());
            
            if(obj instanceof CSTutor.Model.Progress.Class)
            {
                CSTutor.Model.Progress.Class selectedClass = (CSTutor.Model.Progress.Class) obj;
                main.displayClassStatistics(selectedClass);
            }
            
            else if(obj instanceof Student)
            {
                Student selectedStudent = (Student) obj;
                main.displayStudentStatistics(selectedStudent);
            }
            
            else if(obj instanceof ScoredTutorialTrack)
            {
                ScoredTutorialTrack selectedTut = (ScoredTutorialTrack) obj;
                main.displayTutorialStatistics(selectedTut);
            }
            
            
            
        }
    }
}
