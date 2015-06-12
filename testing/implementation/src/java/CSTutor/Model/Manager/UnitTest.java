package CSTutor.Model.Manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testUnit() {
		Unit s = new Unit("u1", null);
		assertEquals(s.name, "u1");
		assertNull(s.parent);
		assertEquals(s.tutorials.size(), 0);
	}

	@Test
	public void testToString() {
		Unit s = new Unit("u1", null);
		assertEquals(s.toString(), "u1");
	}

}
