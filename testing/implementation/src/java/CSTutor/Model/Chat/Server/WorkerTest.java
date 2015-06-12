package CSTutor.Model.Chat.Server;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkerTest {
	Worker w;
	
	@Test
	public void testWorker() {
		Socket s = new Socket();
		ChatServer cs = new ChatServer();
		
		w = new Worker(s, cs);
		assertTrue("Worker constructor works: ", w != null);
	}

	@Test
	public void testRun() {
	}

}
