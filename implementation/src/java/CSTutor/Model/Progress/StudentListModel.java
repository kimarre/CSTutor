package CSTutor.Model.Progress;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class StudentListModel<Student> extends DefaultListModel<Student>
{
    public StudentListModel()
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
    public ArrayList<Student> getSimilarStudents(Student st)
    {
        ArrayList<Student> simStudents  = new ArrayList<Student>();
        
        for(int i=0; i<this.size(); i++)
        {
            if(this.get(i).toString().contains(st.toString()))
            {
                simStudents.add(this.get(i));
            }
        }
        return simStudents;
    }

}
