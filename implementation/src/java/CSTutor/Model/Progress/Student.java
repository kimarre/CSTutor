package CSTutor.Model.Progress;

import java.util.ArrayList;
import java.util.Collection;

/****
 * Class Student is a data structure that represents a student who is enrolled
 * in an instructor's class and completing tutorials. Class Student provides
 * methods to access the name of the student and the list of classes they
 * are enrolled in.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class Student
{ 
    private String name;
    private Collection<Class> enrolledClasses;
    
    public Student(String name)
    {
        this.name = name;
        enrolledClasses = new ArrayList<Class>();
    }
    
    /**
     * Returns a string representation of Student, also know as the name of
     * the student.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
     *                                                  </pre>
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * Adds a class to the student's list of enrolled classes.
     * @param cl  class to be added
     *                                                   <pre>
     pre:
       // Class cl must not be null.
       cl != null;
       
     post:
       // The class cl is now in this.enrolledClasses.
       enrolledClasses'.contains(cl);
     *                                                  </pre>
     */
    public void addClass(Class cl)
    {
        System.out.println("In Student.addClass");
        enrolledClasses.add(cl);
    }
    
    /**
     * Returns if the names of the students are the same.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
       // Student st must not be null.
       st != null;
     *                                                  </pre>
     */
    public boolean equals(Student student)
    {
        if(student.toString().equals(name))
        {
            return true;
        }
        return false;
    }
}
