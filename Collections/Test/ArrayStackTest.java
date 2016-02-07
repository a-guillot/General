package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.EmptyCollectionException;
import Stack.ArrayStack;
import Stack.StackADT;

public class ArrayStackTest {

	private StackADT<String> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new ArrayStack<String>();
	}

	@Test
	public void testArrayStack() {
		assertNotNull(stack);
	}

	@Test
	public void testArrayStackInt() {
		StackADT<String> st = new ArrayStack(100);
		assertNotNull(st);
	}

	@Test
	public void testPush() {
		stack.push("A");
		stack.push("B");
		try {
			stack.push(null);
			stack.push(null);
			assertEquals(4, stack.size());
			assertEquals(null, stack.pop());
			assertEquals(null, stack.pop());
			assertEquals("B", stack.pop());
			assertEquals(1, stack.size());
		}
		catch (IllegalArgumentException e) {}
		catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testPop() {
		stack.push("A");
		stack.push("B");
		assertFalse(stack.isEmpty());
		try {
			assertEquals("B", stack.pop());
			assertEquals("A", stack.pop());
			assertTrue(stack.isEmpty());

			stack.push(null);
			assertEquals(null, stack.pop());
			stack.push("A");
			stack.push(null);
			assertEquals(null, stack.pop());
			assertEquals("A", stack.pop());
			assertTrue(stack.isEmpty());
		} catch (EmptyCollectionException e) {
			fail();
		} catch (Exception e) {
			fail("Wrong exception type");
		}
	}
	
	@Test(expected = EmptyCollectionException.class)
	public void testPopEx() throws EmptyCollectionException {
		stack.pop();
	}

	@Test
	public void testPeek() {
		stack.push("A");
		stack.push("B");
		try {
			assertEquals("B", stack.peek());
			stack.pop();
			assertEquals("A", stack.peek());
		} catch (EmptyCollectionException e) {
			fail();
		}
	}
	
	@Test(expected = EmptyCollectionException.class)
	public void testPeekEx() throws EmptyCollectionException {
		stack.peek();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push("A");
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testSize() {
		assertTrue(stack.size() == 0);
		stack.push("A");
		assertTrue(stack.size() == 1);
	}

}
