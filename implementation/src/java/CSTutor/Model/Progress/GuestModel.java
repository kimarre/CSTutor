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
    
    /**
     * Returns the message that prompts guest users to login to see their progress.
     */
    public String getMessage()
    {
        System.out.println("In GuestModel.getMessage");
        return new String("To view quiz results and tutorial progress, please sign in here.");
    }

}
