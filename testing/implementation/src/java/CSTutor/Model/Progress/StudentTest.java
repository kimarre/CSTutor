package CSTutor.Model.Progress;
import CSTutor.Model.Progress.Student;
import CSTutor.Model.Progress.Class;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;


/****
 * Class StudentTest is the companion testing class for Student.
 * It implements the following module test plan:
 *                                                         <pre>
 * Phase 1: Unit test the constructor.
 *
 * Phase 2: Unit test the get methods.
 *
 * Phase 3: Unit test the toString method.
 *                                                         </pre>
 */
public class StudentTest
{
    Student testStudent;
    ArrayList<Class> enrolledClasses;
    
    public StudentTest()
    {
        enrolledClasses = new ArrayList<Class>();
        enrolledClasses.add(new Class("CPE 101"));
        testStudent = new Student("John Lennon", enrolledClasses);
    }
    
    /**
     * Test method for the Student constructor.
     */
    @Test
    public void testConstructor()
    {
        assert(testStudent.toString().equals("John Lennon"));
        assert(testStudent.getEnrolledClasses().equals(enrolledClasses));
    }
    
    /**
     * Tests the toString method.
     */
    @Test
    public void testToString()
    {
        
    }
    
    /**
     * Tests the addClass method.
     */
    @Test
    public void testAddClass()
    {
        
    }
    
    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals()
    {
        Student newStudent = new Student("Ringo Star", enrolledClasses);
        assert(!newStudent.equals(testStudent));
        
    }
    
    /**
     * Test method for the getEnrolled Classes method.
     */
    @Test
    public void testGetEnrolledClasses()
    {
        
    }
}
