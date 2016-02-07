package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ListSDJ.ArrayList;
import ListSDJ.DoubleLinkedList;
import ListSDJ.ListADT;

public class ListTest {

	ListADT<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new DoubleLinkedList<String>();
		//list = new ArrayList<String>();
	}

	@Test
	public void testArrayList() {
		assertEquals(0, list.size());
	}

	@Test
	public void testArrayListInt() {
		ArrayList<String> list2 = new ArrayList<String>(1);
		assertEquals(0, list2.size());
	}

	@Test
	public void testAddIntT() {
		list.add(0, "A");
		list.add(0, "B");
		list.add(1, "C");
		
		//assertEquals(3, list.size());
		assertEquals("B", list.get(0));
		assertEquals("C", list.get(1));
		assertEquals("A", list.get(2));
	}
	@Test(expected=IllegalStateException.class)
	public void testAddIntT2() {
		ArrayList<String> list2 = new ArrayList<String>(1);
		list2.add("A");
		list2.add("B");
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddIntT3() throws IndexOutOfBoundsException{
		list.add(9000, "A");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddIntT4() {
		list.add(0, null);
	}

	@Test
	public void testAddT() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddT2() {
		list.add(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddT3() {
		list.add(null);
	}

	@Test
	public void testContains() {
		assertFalse(list.contains("A"));
		list.add("A");
		assertTrue(list.contains("A"));
	}

	@Test
	public void testGet() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGet2() {
		list.get(-1);
	}

	@Test
	public void testIndexOf() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(0, list.indexOf("A"));
		assertEquals(1, list.indexOf("B"));
		assertEquals(2, list.indexOf("C"));
	}

	@Test
	public void testRemoveInt() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.remove(1);
		
		assertEquals(0, list.indexOf("A"));
		assertEquals(1, list.indexOf("C"));
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveInt2() {
		list.remove(-1);
	}

	@Test
	public void testRemoveT() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.remove("B");
		
		assertEquals(0, list.indexOf("A"));
		assertEquals(1, list.indexOf("C"));
	}

	@Test
	public void testSet() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.set(1, "b");
		
		assertEquals(0, list.indexOf("A"));
		assertEquals(1, list.indexOf("b"));
		assertEquals(2, list.indexOf("C"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSet2() {
		list.set(0, null);
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSet3() {
		list.set(-1, "azerty");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.add("A");
		assertFalse(list.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, list.size());
		list.add("A");
		assertEquals(1, list.size());
	}

}
