package CSTutor.Model.Manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SectionTest {

	@Test
	public void testSectionStringListOfUserUserClass() {
		Section s = new Section("s1", new ArrayList<CSTutor.Model.User.User>(), null, null);
		assertEquals(s.name, "s1");
		assertEquals(s.students.size(), 0);
		assertNull(s.professor);
		assertNull(s.parent);
		assertEquals(s.units.size(), 1);
	}

	@Test
	public void testSectionStringClass() {
		Section s = new Section("s1", null);
		assertEquals(s.name, "s1");
		assertEquals(s.students.size(), 0);
		assertNull(s.professor);
		assertNull(s.parent);
		assertEquals(s.units.size(), 1);
	}

	@Test
	public void testToString() {
		Section s = new Section("s1", null);
		assertEquals(s.toString(), "s1");
	}

}
