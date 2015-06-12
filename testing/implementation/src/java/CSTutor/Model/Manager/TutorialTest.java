package CSTutor.Model.Manager;

import static org.junit.Assert.*;

import org.junit.Test;

public class TutorialTest {

	@Test
	public void testTutorial() {
		Tutorial s = new Tutorial("t1", null);
		assertEquals(s.name, "t1");
		assertNull(s.parent);
	}

	@Test
	public void testToString() {
		Tutorial s = new Tutorial("t1", null);
		assertEquals(s.toString(), "t1");
	}

}
