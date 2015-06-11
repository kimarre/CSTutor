package CSTutor.Model.Progress;

import CSTutor.Model.Manager.*;

/****
 * Class TrackedPage represents a page of a tutorial that can be tracked and analyzed 
 * if it has been seen by a student user. 
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class TrackedPage
{
    /** Raw Page variable from the Manager */
    private Page page;
    /** Representents if the page has been viewed by the user */
    private boolean hasSeen;
    
    public TrackedPage(Page page, boolean seen)
    {
        this.page = page;
        hasSeen = seen;
    }
    
    /**
     * Returns the variable representing if this page has been seen by the user or not.
     * @return hasSeen   variable representing if this page has been seen
     */
    public boolean beenSeen()
    {
        return hasSeen;
    }
    

}
