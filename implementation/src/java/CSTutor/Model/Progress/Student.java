package CSTutor.Model.Progress;

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
    
    public Student(String name)
    {
        this.name = name;
    }
    
    public String toString()
    {
        return name;
    }
}
