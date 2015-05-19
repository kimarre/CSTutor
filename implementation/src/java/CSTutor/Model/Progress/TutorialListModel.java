package CSTutor.Model.Progress;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TutorialListModel<TutorialData> extends DefaultListModel<TutorialData>
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
            if(this.get(i).toString().equals(obj.toString()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the given object in the list if it is in
     * the list model. Returns -1 if given object is not found.
     *                                                  <pre>
     pre:
       // Object obj must not be null.
       obj != null;
     *
     */
    public int indexOf(Object obj)
    {
        //System.out.print(obj.toString());
        if(this.contains(obj))
        {
            for(int i=0; i<this.size(); i++)
            {
                if(this.get(i).toString().equals(obj.toString()))
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
    public ArrayList<TutorialData> getSimilarTutorials(TutorialData tut)
    {
        ArrayList<TutorialData> simTuts  = new ArrayList<TutorialData>();
        
        for(int i=0; i<this.size(); i++)
        {
            if(this.get(i).toString().contains(tut.toString()))
            {
                simTuts.add(this.get(i));
            }
        }
        return simTuts;
    }

}
