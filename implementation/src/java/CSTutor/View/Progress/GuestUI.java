package CSTutor.View.Progress;

import javax.swing.JPanel;
import CSTutor.Model.Progress.GuestModel;

/****
 * GuestUI is the view class that displays the information in the
 * GuestModel class. 
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 18May15
 */
public class GuestUI extends JPanel
{
    private GuestModel model;
    
    public GuestUI(GuestModel model)
    {
        this.model = model;
    }
}
