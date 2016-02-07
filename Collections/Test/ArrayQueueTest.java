package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Queue.ArrayQueue;
import util.EmptyCollectionException;

public class ArrayQueueTest {

	ArrayQueue<String> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new ArrayQueue<String>();
	}

	@Test
	public void testArrayQueue() {
		ArrayQueue<String> res = new ArrayQueue<String>(1);
		res.enqueue("A");
		res.enqueue("b");
		res.enqueue("C");
		assertEquals(3, res.size());
	}
	@Test
	public void testEnqueue() {
		queue.enqueue("A");
		try {
			assertEquals("A", queue.first());
			assertTrue((queue.size() == 1));
		} catch (Exception e) {
			fail();
		}
	}

	@Test(expected=EmptyCollectionException.class)
	public void testDequeue() throws EmptyCollectionException {
		queue.dequeue();
	}
	
	@Test
	public void testDequeue2() throws EmptyCollectionException {
		queue.enqueue("A");
		String res = queue.dequeue();
		assertTrue(queue.isEmpty());
		assertEquals("A", res);
	}

	@Test
	public void testFirst() throws EmptyCollectionException {
		queue.enqueue("A");
		assertTrue((queue.size() == 1));
		assertEquals("A", queue.first());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testFirst2() throws EmptyCollectionException {
		queue.first();
	}

	@Test
	public void testIndexOf() {
		int res = queue.indexOf("A");
		assertEquals(-1, res);
		queue.enqueue("A");
		queue.enqueue("B");
		res = queue.indexOf("B");
		assertEquals(1, res);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue("A");
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, queue.size());
		queue.enqueue("A");
		assertEquals(1, queue.size());
	}

}
