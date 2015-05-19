package CSTutor.View.Progress;

import javax.swing.JPanel;
import CSTutor.Model.Progress.StudentModel;

/****
 * StudentUI is the view class that displays the information in the
 * StudentModel class.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May15
 */
public class StudentUI extends JPanel
{
    private StudentModel model;
    
    public StudentUI(StudentModel model)
    {
        this.model = model;
    }

     
}
