package CSTutor.Model.Progress;

import java.util.*;

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
    /** Displayable name of the student */
    private String name;
    /** List of classes the student is enrolled in */
    private ArrayList<Class> enrolledClasses;
    
    public Student(String name, ArrayList<Class> enrolled)
    {
        this.name = name;
        enrolledClasses = enrolled;
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
    
    /**
     * Returns the list of classes this student is enrolled in.
     * @return  enrolledClasses
     */
    public ArrayList<Class> getEnrolledClasses()
    {
        return enrolledClasses;
    }
}
