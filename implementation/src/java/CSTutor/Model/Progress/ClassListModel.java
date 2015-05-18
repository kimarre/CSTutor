package CSTutor.Model.Progress;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ClassListModel<Class> extends DefaultListModel<Class>
{
    public ClassListModel()
    {
        super();
    }
    
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
