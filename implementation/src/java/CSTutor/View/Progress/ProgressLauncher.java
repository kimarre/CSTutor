package Progress;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class ProgressLauncher
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        /* Instructor Stuff */
        InstructorView inst = new InstructorView();
        inst.setVisible(true);
        
        JFrame frame = new JFrame("CSTutor - Instructor view");
        frame.setContentPane(inst);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        
        
        /* Student Stuff */
        //StudentView student = new StudentView();

    }

}
