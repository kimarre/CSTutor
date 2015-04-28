package CSTutor.Model.Progress;

/****
 * Class TutorialData is a data structure that represents a tutorial listed
 * under a class. Class TutorialData provides methods to get the name of
 * the tutorial.
 * @author Erica Solum (esolum@calpoly.edu)
 */
public class TutorialData
{
    private String name;
    private boolean complete;
    
    public TutorialData(String name)
    {
        this.name = name;
        complete = false;
    }
    
    /**
     * Returns a string representation of TutorialData, also know as the name of
     * the tutorial.
     */
    public String toString()
    {
        return name;
    }

}