/**
 * REMEMBER TO CHANGE THE PACKAGE TO CSTUTOR.MODEL.PROGRESS
 */
package CSTutor.Model.Progress;

/****
 * Class Student is a model class for the Calendar Tool progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class GuestModel
{

    public GuestModel()
    {
    }
    
    public String getMessage()
    {
        System.out.println("In GuestModel.getMessage");
        return new String("To view quiz results and tutorial progress, pleas sign in here.");
    }

}
