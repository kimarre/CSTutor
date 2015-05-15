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
