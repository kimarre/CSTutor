package CSTutor.Model.Manager;

import static org.junit.Assert.*;

import org.junit.Test;

import CSTutor.Model.Manager.Class.ClassAccessLevel;

public class ClassTest {

	@Test
	public void testClass() {
		Class c = new Class("CSC 101");
		assertEquals(c.name, "CSC 101");
		assertEquals(c.access, ClassAccessLevel.Guest);
		assertEquals(c.sections.size(), 1);
		assertEquals(c.students.size(), 0);
	}

	@Test
	public void testToString() {
		Class c = new Class("CSC 101");
		assertEquals(c.toString(), "CSC 101");
	}

}
