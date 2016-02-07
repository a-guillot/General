package util;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import Set.ArraySet;
import Set.SetADT;

public class SetTest {

	private SetADT<String> set;
	
	@Before
	public void setUp() throws Exception {
		set = new ArraySet<>();
	}

	@Test
	public void testArraySet() {
		assertTrue(set.isEmpty());
	}

	@Test
	public void testArraySetInt() {
		SetADT<String> set2 = new ArraySet<>(1);
		assertTrue(set2.isEmpty());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testArraySetInt2() {
		SetADT<String> set2 = new ArraySet<>(-1);
	}

	@Test
	public void testAdd() {
		set.add("A");
		set.add("B");
		
		assertEquals(2, set.size());
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertFalse(set.contains("C"));
	}

	@Test
	public void testAddAll() {
		SetADT<String> temp = new ArraySet<>();
		
		temp.add("A");
		temp.add("B");
		
		set.addAll(temp);
		
		assertEquals(2, set.size());
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
	}

	@Test
	public void testRemove() {
		set.add("A");
		set.remove("A");
		
		assertTrue(set.isEmpty());
		assertFalse(set.contains("A"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void testRemove2() {
		set.remove("A");
	}
	
	@Test
	public void testUnion() {
		set.add("A");
		
		SetADT<String> temp = new ArraySet<>();
		temp.add("B");
		
		SetADT<String> res = set.union(temp);
		assertTrue(res.contains("A"));
		assertTrue(res.contains("B"));		
	}

	@Test
	public void testContains() {
		assertFalse(set.contains("A"));
		set.add("A");
		assertTrue(set.contains("A"));
		set.remove("A");
		assertFalse(set.contains("A"));
	}

	@Test
	public void testEqualsSetADTOfT() {
		assertFalse(set.equals(new String()));
		
		SetADT<String> set2 = new ArraySet<String>();
		set.add("A");
		
		assertFalse(set.equals(set2));
		
		set2.add("A");
		
		assertTrue(set.equals(set2));
	}

	@Test
	public void testIsSubset() {
		set.add("A");
		set.add("B");
		set.add("C");
		
		SetADT<String> set2 = new ArraySet<>();
		set2.add("A");
		
		assertFalse(set.isSubset(set2));
		assertTrue(set2.isSubset(set));
	}

	@Test
	public void testIntersection() {
		set.add("A");
		set.add("B");
		
		SetADT<String> set2 = new ArraySet<>();
		set2.add("B");
		set2.add("C");
		
		SetADT<String> result = set.intersection(set2);
		
		assertTrue(result.size() == 1);
		assertTrue(result.contains("B"));
		assertFalse(result.contains("A"));
		assertFalse(result.contains("C"));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(set.isEmpty());
		set.add("A");
		assertFalse(set.isEmpty());
	}

	@Test
	public void testSize() {
		assertTrue(set.size() == 0);
		set.add("A");
		assertTrue(set.size() == 1);
	}

	@Test
	public void testIterator() {
		set.add("A");
		set.add("B");
		
		int count = 0;
		
		Iterator<String> scan = set.iterator();
		while (scan.hasNext()) {
			count++;
			scan.next();
		}
		
		assertTrue(count == 2);
	}
}
