
package CSTutor.Model.Manager;

import static org.junit.Assert.*;
import org.junit.Test;
//import CSTutor.Model.Manager;

/**
 * 
 * @author Simon
 *
 */
public class ManagerTest {
	
	/**
	 * Test Plan:
	 * Test constructors and selections alternating, then test the delete methods.
	 */
	@Test
	public void testConstructor() {
		Manager m = new Manager();
		assertTrue(m.data != null);
	}
	
	@Test
	public void testCreateClass() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      assertFalse(m.data.contains(c1));
      m.createClass(c1);
      assertTrue(m.data.contains(c1));
      m.createClass(c2);
      m.createClass(c3);
      assertTrue(m.data.contains(c1));
	}
	
	@Test
	public void testSelectClass() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      assertTrue(m.selectedClass == null);
      m.selectClass(c1);
      assertTrue(m.selectedClass.equals(c1));
	}
	
	public void testAddSection() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      assertFalse(c1.sections.contains(s1));
      m.selectClass(c1);
      m.createSection(s1);
      assertTrue(c1.sections.contains(s1));
	}
	
	public void testSelectSection() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      assertFalse(m.selectedSection.equals(s1));
      m.selectSection(s1);
      assertTrue(m.selectedSection.equals(s1));
      assertTrue(m.selectedClass.equals(c1));
	}
	
	@Test
	public void testAddUnit() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      assertFalse(s1.units.contains(u1));
      m.selectSection(s1);
      m.createUnit(u1);
      assertTrue(s1.units.contains(u1));
	}
	
	@Test
	public void testSelectUnit() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      m.selectSection(s1);
      m.createUnit(u1);
      assertTrue(m.selectedUnit == null);
      m.selectUnit(u1);
      assertTrue(m.selectedUnit.equals(u1));
      assertTrue(m.selectedSection.equals(s1));
      assertTrue(m.selectedClass.equals(c1));
	}
	
	@Test
	public void testAddTutorial() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      m.selectSection(s1);
      m.createUnit(u1);
      Tutorial t1 = new Tutorial("Hello World", u1);
      m.selectUnit(u1);
      assertFalse(u1.tutorials.contains(t1));
      m.createTutorial(t1);
      assertTrue(u1.tutorials.contains(t1));
	}
	
	@Test
	public void testSelectTutorial() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      m.selectSection(s1);
      m.createUnit(u1);
      Tutorial t1 = new Tutorial("Hello World", u1);
      m.selectUnit(u1);
      m.createTutorial(t1);
      assertTrue(m.selectedTutorial == null);
      m.selectTutorial(t1);
      assertTrue(m.selectedTutorial.equals(t1));
      assertTrue(m.selectedUnit.equals(u1));
      assertTrue(m.selectedSection.equals(s1));
      assertTrue(m.selectedClass.equals(c1));
	}
	
	@Test
	public void testDeletions() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      m.selectSection(s1);
      m.createUnit(u1);
      Tutorial t1 = new Tutorial("Hello World", u1);
      m.selectUnit(u1);
      m.createTutorial(t1);
      assertTrue(m.selectedTutorial == null);
      m.selectTutorial(t1);
      assertTrue(m.selectedTutorial.equals(t1));
      assertTrue(m.selectedUnit.equals(u1));
      assertTrue(m.selectedSection.equals(s1));
      assertTrue(m.selectedClass.equals(c1));
      m.deleteTutorial();
      assertFalse(u1.tutorials.contains(t1));
      m.deleteUnit();
      assertFalse(s1.units.contains(u1));
      m.deleteSection();
      assertFalse(c1.sections.contains(s1));
      m.deleteClass();
      assertFalse(m.data.contains(c1));
	}
	
	
	@Test
	public void testClear() {
		Manager m = new Manager();
      Class c1 = new Class("CSC 101");
      Class c2 = new Class("CSC 102");
      Class c3 = new Class("CSC 103");
      m.createClass(c1);
      m.createClass(c2);
      m.createClass(c3);
      Section s1 = new Section("Section 1", null, null, c1);
      m.createSection(s1);
      m.selectClass(c1);
      m.createSection(s1);
      Unit u1 = new Unit("Printing Text", s1);
      m.createUnit(u1);
      m.selectSection(s1);
      m.createUnit(u1);
      Tutorial t1 = new Tutorial("Hello World", u1);
      m.selectUnit(u1);
      m.createTutorial(t1);
      assertTrue(m.selectedTutorial == null);
      m.selectTutorial(t1);
      assertTrue(m.selectedTutorial.equals(t1));
      assertTrue(m.selectedUnit.equals(u1));
      assertTrue(m.selectedSection.equals(s1));
      assertTrue(m.selectedClass.equals(c1));
      m.clearSelections();
      assertTrue(m.selectedTutorial == null);
      assertTrue(m.selectedUnit == null);
      assertTrue(m.selectedSection == null);
      assertTrue(m.selectedClass == null);
	}
      

}
