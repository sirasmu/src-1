package ca.main.game.network.TCPServer;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import ca.main.game.utilities.SetADT;

public class UnitTestIterator {
	private SetADT<String> set;

	@Before
	public void setUp() throws Exception {
		set = new dbClientList<String>();
	}

	@Test
	public final void testHasNext_BaseCase()
			throws ConcurrentModificationException {
		SetADT<String> s = new dbClientList<String>();
		s.add("cat");
		s.add("dog");
		Iterator<String> itr = s.iterator();
		assertTrue(itr.hasNext());
	}// TestHasNext_BaseCase

	public final void testHasNext_C1() throws ConcurrentModificationException {
		SetADT<String> s = new dbClientList<String>();
		Iterator<String> itr = s.iterator();
		assertFalse(itr.hasNext());
	}// TestHasNext_C1

	@Test
	public final void testNext_BaseCase()
			throws ConcurrentModificationException {
		SetADT<String> s = new dbClientList<String>();
		s.add("cat");
		Iterator<String> itr = s.iterator();
		assertTrue(itr.hasNext());
		assertEquals("cat", itr.next());
	}// testNext_BaseCase

	@Test(expected = NoSuchElementException.class)
	public final void testNext_C1() throws ConcurrentModificationException {
		SetADT<String> s = new dbClientList<String>();
		Iterator<String> itr = s.iterator();
		assertFalse(itr.hasNext());
		itr.next();
	}// testNext_C1

	@Test
	public final void testNext_C2() throws ConcurrentModificationException {
		SetADT<String> s = new dbClientList<String>();
		try {
			set.add(null);
			fail("Should not allow null");
		} catch (IllegalArgumentException e) {
			// OK
		}
		Iterator<String> itr = s.iterator();
		assertFalse(itr.hasNext());
	}// testNext_C2

	@Test
	public void testAddElement() {
		set.add("$A$");
		assertTrue(set.size() == 1 && set.contains("$A$"));
		set.add("$B$");
		assertTrue(set.size() == 2 && set.contains("$A$")
				&& set.contains("$B$"));
		set.add("$B$");
		assertTrue(set.size() == 2 && set.contains("$A$")
				&& set.contains("$B$"));
		set.add("$C$");
		assertTrue(set.size() == 3 && set.contains("$A$")
				&& set.contains("$B$") && set.contains("$C$"));

		try {
			set.add(null);
			fail("Should not allow null");
		} catch (IllegalArgumentException e) {
			// OK
		}
		assertTrue(set.size() == 3 && set.contains("$A$")
				&& set.contains("$B$") && set.contains("$C$"));

	}

	@Test
	public void testRemoveElement() {
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		assertEquals("$C$", set.remove("$C$")); // middle
		assertTrue(set.size() == 3 && set.contains("$A$")
				&& set.contains("$B$") && set.contains("$D$"));
		assertEquals("$A$", set.remove("$A$")); // first
		assertTrue(set.size() == 2 && set.contains("$B$")
				&& set.contains("$D$"));
		assertEquals("$D$", set.remove("$D$")); // last
		assertTrue(set.size() == 1 && set.contains("$B$"));
		assertEquals("$B$", set.remove("$B$")); // emptying
		assertTrue(set.size() == 0);

		// add and remove some again
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		assertEquals("$C$", set.remove("$C$")); // middle
		assertTrue(set.size() == 3 && set.contains("$A$")
				&& set.contains("$B$") && set.contains("$D$"));
		assertEquals("$A$", set.remove("$A$")); // first
		assertTrue(set.size() == 2 && set.contains("$B$")
				&& set.contains("$D$"));

		// add and remove some again having duplicates
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		assertTrue(set.size() == 4 && set.contains("$B$")
				&& set.contains("$D$") && set.contains("$A$")
				&& set.contains("$C$"));
		assertEquals("$C$", set.remove("$C$")); // middle
		assertTrue(set.size() == 3 && set.contains("$B$")
				&& set.contains("$D$") && set.contains("$A$"));
		assertEquals("$B$", set.remove("$B$")); // first
		assertTrue(set.size() == 2 && set.contains("$D$") && set.contains("$A$"));
		
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveElementException1() {
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		set.remove("???");
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveElementException2() {
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		set.remove(null);
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveElementException3() {
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		try {
			set.remove("???");
		} catch (IllegalArgumentException e) {
			assertEquals(null, set.remove(null));
		}
	}

	@Test
	public void testContains() {
		assertFalse(set.contains("$A$"));
		assertFalse(set.contains(null));
		set.add("$A$");
		set.add("$B$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		set.add("$B$");
		assertTrue(set.contains("$A$"));
		assertTrue(set.contains("$B$"));
		assertTrue(set.contains("$C$"));
		assertTrue(set.contains("$D$"));
		assertFalse(set.contains("???"));
		assertFalse(set.contains(null));

	}

	@Test
	public void testIsEmpty() {
		assertTrue(set.isEmpty());
		set.add("$A$");
		assertFalse(set.isEmpty());
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		assertFalse(set.isEmpty());
		set.remove("$A$");
		set.remove("$B$");
		set.remove("$C$");
		set.remove("$D$");
		assertTrue(set.isEmpty());
		try {
			set.add(null);
			assertFalse(set.isEmpty());
			set.add(null);
			set.add("$C$");
			assertFalse(set.isEmpty());
			set.remove(null);
			set.remove(null);
			set.remove("$C$");
			assertTrue(set.isEmpty());
		} catch (IllegalArgumentException e) {
			// OK
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, set.size());
		set.add("$A$");
		assertEquals(1, set.size());
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		set.add("$X$");
		set.add("$Y$");
		assertEquals(6, set.size());
		set.remove("$B$");
		assertEquals(5, set.size());
		set.remove("$Y$");
		assertEquals(4, set.size());
		set.remove("$X$");
		set.remove("$D$");
		set.remove("$C$");
		set.remove("$A$");
		assertEquals(0, set.size());
		try {
			set.add(null);
			assertEquals(1, set.size());
			set.add(null);
			set.add("$C$");
			set.add(null);
			assertEquals(2, set.size());
			set.remove(null);
			assertEquals(1, set.size());
		} catch (IllegalArgumentException e) {
			// OK
		}
	}

	@Test
	public void testToString() {
		// format is not defined only order of elements
		set.add("$B$");
		set.add("$D$");
		set.add("$A$");
		set.add("$B$");
		set.add("$C$");
		set.add("$D$");
		assertTrue(containsToString("$B$", "$D$", "$A$", "$C$"));
		try {
			set.add(null);
			fail("Should not allow null");
		} catch (IllegalArgumentException e) {
			// OK
		}
		assertTrue(containsToString("$B$", "$D$", "$A$", "$C$"));
		set.add("$C$");
		assertTrue(containsToString("$B$", "$D$", "$A$", "$C$"));

	}

	private boolean containsToString(String... s) {
		String listString = set.toString();
		// System.out.println(listString);
		if (s.length < 1)
			return false;
		int index1 = listString.indexOf(s[0]);
		if (index1 == -1)
			return false;
		listString = replace(listString, s[0], '�');
		if (s.length == 1) {
			return index1 > -1;
		}
		for (int i = 1; i < s.length; i++) {
			int index2 = listString.indexOf(s[i]);
			if (index2 == -1)
				return false;
			listString = replace(listString, s[i], '�');
			if (index1 > index2)
				return false;
			index1 = index2;
		}
		return true;
	}

	private String replace(String s, String target, char replacementChar) {
		String replace = "";
		for (int k = 0; k < target.length(); k++)
			replace += replacementChar;
		int index = s.indexOf(target);
		if (index < 0)
			return s;
		String s2 = s.substring(0, index) + replace
				+ s.substring(index + replace.length());
		return s2;
	}

}
