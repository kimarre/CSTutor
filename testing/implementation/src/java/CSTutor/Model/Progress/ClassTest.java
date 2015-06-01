/**
 * 
 */
package CSTutor.Model.Progress;

import static org.junit.Assert.*;
import CSTutor.Model.Progress.Class;
import org.junit.Test;

/****
*
* Class ClassTest is the companion testing class for Class.  
* It implements the following module test plan:
*                                    <pre>
*    Phase 1: Unit test the constructor.
*     
*    Phase 2: Unit test the toString method.
* 
*    Phase 3: Unit test the equals method.
*    
*    Phase 4: Unit test the get/set methods.
* 
*    Phase 5: Stress test the equals method with different objects.
*                                   </pre>
*/
public class ClassTest
{
    Class testClass;
    String nameString;
    
    public ClassTest()
    {
        testClass = new Class("CPE 101");
        nameString = new String("CPE 101");
    }
    
    /**
     * Test method for the Class' constructor.
     */
    @Test
    public void testClass()
    {
        Class sampleClass = new Class("CPE 102");
        assert(sampleClass != null);
        assert(sampleClass.toString().equals("CPE 102"));
    }

    /**
     * Test method for the toString method.
     */
    @Test
    public void testToString()
    {
        assert(testClass.toString().equals(nameString));
    }

    /**
     * Test method for the getSections method.
     */
    @Test
    public void testGetSections()
    {
        fail("Not yet implemented");
    }

    /**
     * Test method for the equals method.
     */
    @Test
    public void testEqualsClass()
    {
        Class sampleClass = new Class("CPE 102");
        Class equalClass = new Class("CPE 101");
        
        assertFalse(testClass.equals(sampleClass));
        assert(testClass.equals(equalClass));
    }

}
