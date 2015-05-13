package CSTutor.Model.Progress;

import model.Tutorial;

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
     * Returns a string representation of a tutorial, also know as the name of
     * the tutorial.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
     *
     */
    public String toString()
    {
        return name;
    }
    
    public boolean equals(TutorialData tutorial)
    {
        if(tutorial.toString().equals(name))
        {
            return true;
        }
        return false;
    }

}