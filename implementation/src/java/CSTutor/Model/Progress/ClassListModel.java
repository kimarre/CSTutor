package CSTutor.Model.Progress;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

/****
 * Class ClassListModel is the list model that supports the Class data
 * type. ClassListModel is used as the list model for JList in the left
 * side bar while the Classes tab is selected. Class ClassListModel provides
 * methods to get the index of an item, get a list of items with names
 * matching a search query, and check to see if the item is in the list.
 * @author Erica Solum
 * @version 18May15
 */
public class ClassListModel<Class> extends DefaultListModel<Class>
{
    public ClassListModel()
    {
        super();
    }
    
    /**
     * Returns true if the given object is in the list and false otherwise.
     *                                                  <pre>
     pre:
       // String name must not be null.
       obj != null;
     *                                                  </pre>
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
     *                                                  </pre>
     */
    public int indexOf(Object obj)
    {
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
     * Returns a collection of Class items with names that
     * match the name of the input class.
     *                                                  <pre>
     pre:
       // Class cl must not be null.
       cl != null;
     *                                                  </pre>
     */
    public ArrayList<Class> getSimilarClasses(Class cl)
    {
        ArrayList<Class> simClasses  = new ArrayList<Class>();
        
        for(int i=0; i<this.size(); i++)
        {
            if(this.get(i).toString().contains(cl.toString()))
            {
                simClasses.add(this.get(i));
            }
        }
        return simClasses;
    }

}
