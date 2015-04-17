package CSTutor.Model.Progress;

import javax.swing.JPanel;

import CSTutor.View.Progress.*;

/****
 * Class Progress is the top-level model class for the Calendar Tool progress and
 * assessment feature. It contains methods to launch the for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Apr15
 */
public class Progress
{
    private final int GUEST_ACCESS = 0;
    private final int STUDENT_ACCESS = 1;
    private final int INSTRUCTOR_ACCESS = 2;   
    private JPanel viewPanel;
    
    
    /**
     * Launches the progress feature with the provided access.
     */
    public Progress(int accessCode)
    {
        if(accessCode == INSTRUCTOR_ACCESS)
        {
            InstructorModel model = new InstructorModel();
            InstructorUI view = new InstructorUI(model);
            viewPanel = view;    
        }
        else if(accessCode == STUDENT_ACCESS)
        {
            StudentModel model = new StudentModel();
            StudentUI view = new StudentUI(model);
            viewPanel = view;
        }
        else if(accessCode == GUEST_ACCESS)
        {
            GuestModel model = new GuestModel();
            GuestUI view = new GuestUI(model);
            viewPanel = view;
        } 
    }
    
    /**
     * Returns the panel that is made from launching the Progress feature.
     */
    public JPanel getView()
    {
        return viewPanel;
    }

    

}
