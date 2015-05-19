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
     * Returns a collection of Student items with names that
     * match the name of the input student.
     *                                                  <pre>
     pre:
       // Student st must not be null.
       st != null;
     *
     */
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
