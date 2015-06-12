package CSTutor.Model.Chat;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChatOverlayTest {
	ChatOverlay co;
	
	@Test
	public void testChatOverlay() {
		co = new ChatOverlay(null);
		assertTrue("ChatOverlay constructor works", co != null);
	}

	@Test
	public void testEnter() {
		Boolean test1 = co.Enter("This is a test.");
		Boolean test2 = co.Enter("       ");
		
		assertTrue("Making sure that enter button works", test1 == true && test2 == false);
	}

	@Test
	public void testPushText() {
		co.pushText("Test");
		assertTrue(true);
	}

	@Test
	public void testSetLastString() {
		co.setLastString("Happy Friday!");
		Boolean test1 = (co.lastStringInput.equals("Happy Friday!\n"));
		assertTrue("Making sure the string changed", test1);
	}

	@Test
	public void testGetLastString() {
		co.setLastString("Happy.");
		assertTrue("Making sure that it returns the correct string.", co.getLastString().equals("Happy.\n"));
	}

}
