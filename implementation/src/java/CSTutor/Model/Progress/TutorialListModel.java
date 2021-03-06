package CSTutor.Model.Progress;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import CSTutor.Model.Tutorial.*;

/****
 * Class TutorialListModel inherits the characteristics of a DefaultListModel but
 * contains only ScoredTutorialTrack variable types. It provides methods to query the list
 * that is contained in the Tutorials tab of the side bar. 
 * @author Erica Solum (esolum@calpoly.edu)
 */
public class TutorialListModel<ScoredTutorialTrack> extends DefaultListModel<ScoredTutorialTrack>
{
    public TutorialListModel()
    {
        super();
    }
    
    /**
     * Returns true if the given object is in the list and false otherwise.
     *                                                  <pre>
     pre:
       // String name must not be null.
       obj != null;
     *
     */
    public boolean contains(Object obj)
    {
        for(int i=0; i<this.size(); i++)
        {
            if(this.get(i).toString().equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the given object in the list if it is in
     * the list model. Returns -1 if given object is not found. 
     * Overrides DefaultListModel's indexOf method.
     *                                                  <pre>
     pre:
       // Object obj must not be null.
       obj != null;
     *
     */
    public int indexOf(Object obj)
    {
        ScoredTutorialTrack tut = (ScoredTutorialTrack)obj;
        if(this.contains(tut))
        {
            for(int i=0; i<this.size(); i++)
            {
                if(this.get(i).toString().equals(tut.toString()))
                {
                    return i;
                }
            }
            return -1;
        }
        else
        {
            return -1;
        }
    }
    
    /**
     * Returns a collection of Tutorial items with names that
     * match the name of the input tutorial.
     *                                                  <pre>
     pre:
       // TutorialData tut must not be null.
       tut != null;
     *
     */
    public ArrayList<ScoredTutorialTrack> getSimilarTutorials(Object obj)
    {
        if(obj instanceof java.lang.String)
        {
            String objStr = (String)obj;
            
            ArrayList<ScoredTutorialTrack> simTuts  = new ArrayList<ScoredTutorialTrack>();
            
            for(int i=0; i<this.size(); i++)
            {
                if(this.get(i).toString().contains(objStr))
                {
                    simTuts.add(this.get(i));
                }
            }
            return simTuts;
        }
        else
        {
            return null;
        }
        
    }

}
