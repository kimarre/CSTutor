package CSTutor.Model.Manager;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {
	
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
	
	/*
      m.selectUnit(m.selectedSection.units.get(1));
      m.createTutorial(new CSTutor.Model.Manager.Tutorial("Hello World", m.selectedUnit));
      m.createTutorial(new CSTutor.Model.Manager.Tutorial("Conditionals", m.selectedUnit));
      m.createTutorial(new CSTutor.Model.Manager.Tutorial("Loops", m.selectedUnit));
     */ 
      

}
