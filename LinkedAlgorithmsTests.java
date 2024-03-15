import static org.junit.jupiter.api.Assertions.*;

// Copyright 2020 Samuel Fisher
// CSE274 - Section G
// Professor: Dr. Kiper
// Program #2
// September 20, 2020
// This is the tester class for LinkedAlgorithms
// Tests each method individually w/ their similarly named counterparts

import org.junit.jupiter.api.Test;

class LinkedAlgorithmsTests {

	@Test
	void testEmptyConstructor() {
		LinkedAlgorithms list = new LinkedAlgorithms();
		
		assertEquals(0, list.size());
		assertEquals("[]", list.toString());
	}
	
	@Test
	void testConstructor() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		String[] items2 = null;
		
		LinkedAlgorithms list2;
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
	}
	
	@Test
	void testCopyConstructor() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(list);
		
		assertEquals(11, list2.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list2.toString());
		assertTrue(list.equalsLinkedList(list2));
	}
	
	@Test
	void testToArray() {
		String[] result = {"hi", "Sam"};
		
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(result);
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(items);
		
		assertArrayEquals(result, list.toArray());
		assertArrayEquals(items, list2.toArray());
	}
	
	@Test
	void testToString() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		String[] items2 = {};
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(items2);
		
		assertEquals(0, list2.size());
		assertEquals("[]", list2.toString());
		
		String[] items3 = {"Hi"};
		
		LinkedAlgorithms list3 = new LinkedAlgorithms(items3);
		
		assertEquals(1, list3.size());
		assertEquals("[Hi]", list3.toString());
	}
	
	@Test
	void testSize() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertBefore("Hi", "Sam");
		assertEquals(12, list.size());
		
		assertEquals("[Hello, world, my, name, is, Zaza, Hi, Sam, Hello, how, are, you]", list.toString());
		
		list.removeLast();
		assertEquals(11, list.size());
		
		LinkedAlgorithms list2 = new LinkedAlgorithms();
		
		assertEquals(0, list2.size());
	}
	
	@Test
	void equalsLinkedList() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(list);
		
		String[] items2 = {"Hi", "how"};
		
		String[] items3 = {"world", "Sam", "Hello", "my", "name", "Zaza", "is", "Hello", "how", "you", "are"};
		
		LinkedAlgorithms list3 = new LinkedAlgorithms(items2);
		
		LinkedAlgorithms list4 = new LinkedAlgorithms(items3);
		
		assertTrue(list.equalsLinkedList(list2));
		assertFalse(list.equalsLinkedList(list3));
		assertFalse(list.equalsLinkedList(list4));
	}
	
	@Test
	void testContains() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertTrue(list.contains("Hello"));
		assertTrue(list.contains("is"));
		assertTrue(list.contains("how"));
		assertTrue(list.contains("you"));
		assertTrue(list.contains("world"));
		assertTrue(list.contains("my"));
		assertTrue(list.contains("name"));
		assertTrue(list.contains("Zaza"));
		assertTrue(list.contains("Sam"));
		assertFalse(list.contains("bag"));
		assertFalse(list.contains("sam"));
	}
	
	@Test
	void testFind() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals(3, list.find("name"));
		assertEquals(0, list.find("Hello"));
		assertEquals(10, list.find("you"));
		assertEquals(5, list.find("Zaza"));
		assertEquals(1, list.find("world"));
		assertEquals(8, list.find("how"));
		assertEquals(-1, list.find("bag"));
		assertEquals(-1, list.find("sam"));
	}
	
	@Test
	void testGetFirst() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals("Hello", list.getFirst());
	}
	
	@Test
	void testGetLast() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals("you", list.getLast());
	}
	
	@Test
	void testGetAt() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals("Hello", list.getAt(0));
		assertEquals("world", list.getAt(1));
		assertEquals("my", list.getAt(2));
		assertEquals("name", list.getAt(3));
		assertEquals("is", list.getAt(4));
		assertEquals("Zaza", list.getAt(5));
		assertEquals("Sam", list.getAt(6));
		assertEquals("Hello", list.getAt(7));
		assertEquals("how", list.getAt(8));
		assertEquals("are", list.getAt(9));
		assertEquals("you", list.getAt(10));
	}
	
	@Test
	void testInsertFirst() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertFirst("hi");
		
		assertEquals(12, list.size());
		assertEquals("[hi, Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		String[] items2 = {};
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(items2);
		
		list2.insertFirst("hi");
		assertEquals(1, list2.size());
		assertEquals("[hi]", list2.toString());
	}
	
	@Test
	void testInsertLast() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertLast("hi");
		
		assertEquals(12, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you, hi]", list.toString());
		
		String[] items2 = {};
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(items2);
		
		list2.insertLast("hi");
		assertEquals(1, list2.size());
		assertEquals("[hi]", list2.toString());
	}
	
	@Test
	void testInsertAt() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertAt(0, "hi");
		assertEquals(12, list.size());
		assertEquals("[hi, Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertAt(5,  "hi");
		assertEquals(13, list.size());
		assertEquals("[hi, Hello, world, my, name, hi, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertAt(9, "hi");
		assertEquals(14, list.size());
		assertEquals("[hi, Hello, world, my, name, hi, is, Zaza, Sam, hi, Hello, how, are, you]", list.toString());
		
		list.insertAt(13, "hi");
		assertEquals(15, list.size());
		assertEquals("[hi, Hello, world, my, name, hi, is, Zaza, Sam, hi, Hello, how, are, hi, you]", list.toString());
		
		list.insertAt(15, "hi");
		assertEquals(16, list.size());
	}
	
	@Test
	void testInsertBefore() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertBefore("hi", "world");
		assertEquals(12, list.size());
		assertEquals("[Hello, hi, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertBefore("hi", "Hello");
		assertEquals(13, list.size());
		assertEquals("[hi, Hello, hi, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertBefore("hi", "you");
		assertEquals(14, list.size());
		assertEquals("[hi, Hello, hi, world, my, name, is, Zaza, Sam, Hello, how, are, hi, you]", list.toString());
	}
	
	@Test
	void testInsertAfter() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertAfter("hi", "Hello");
		assertEquals(12, list.size());
		assertEquals("[Hello, hi, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.insertAfter("hi", "you");
		assertEquals(13, list.size());
		assertEquals("[Hello, hi, world, my, name, is, Zaza, Sam, Hello, how, are, you, hi]", list.toString());
	}

	@Test
	void testRemoveFirst() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeFirst();
		assertEquals(10, list.size());
		assertEquals("[world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
	}
	
	@Test
	void testRemoveLast() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeLast();
		assertEquals(10, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are]", list.toString());
		
		list.removeLast();
		assertEquals(9, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how]", list.toString());
	}
	
	@Test
	void testRemoveAt() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeAt(5);
		assertEquals(10, list.size());
		assertEquals("[Hello, world, my, name, is, Sam, Hello, how, are, you]", list.toString());
	}
	
	@Test
	void testRemoveFirstOccurenceOf() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeFirstOccurrenceOf("world");
		assertEquals(10, list.size());
		assertEquals("[Hello, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeFirstOccurrenceOf("Hello");
		assertEquals(9, list.size());
		assertEquals("[my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
	}
	
	@Test
	void testRemoveAllOccurencesOf() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.removeAllOccurrencesOf("Hello");
		assertEquals(9, list.size());
		assertEquals("[world, my, name, is, Zaza, Sam, how, are, you]", list.toString());
		
		list.removeAllOccurrencesOf("world");
		assertEquals(8, list.size());
		assertEquals("[my, name, is, Zaza, Sam, how, are, you]", list.toString());
	}
	
	@Test
	void testReverse() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		list.reverse();
		assertEquals("[you, are, how, Hello, Sam, Zaza, is, name, my, world, Hello]", list.toString());
	}
	
	@Test
	void testToUpper() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		list.toUpper();
		assertEquals(11, list.size());
		assertEquals("[HELLO, WORLD, MY, NAME, IS, ZAZA, SAM, HELLO, HOW, ARE, YOU]", list.toString());
	}
	
	@Test
	void testGetConcatenation() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals("HelloworldmynameisZazaSamHellohowareyou", list.getConcatenation());
	}
	
	@Test
	void testGetAplhabeticallyLast() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals("Zaza", list.getAlphabeticallyLast());
	}
	
	@Test
	void testIndexOfAlphabeticallyLast() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "Hello", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		assertEquals(11, list.size());
		assertEquals("[Hello, world, my, name, is, Zaza, Sam, Hello, how, are, you]", list.toString());
		
		assertEquals(5, list.indexOfAlphabeticallyLast());
	}
	
	@Test
	void testAnagrams() {
		String[] items = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "how", "are", "you"};
		
		LinkedAlgorithms list = new LinkedAlgorithms(items);
		
		String[] items2 = {"you", "are", "how", "Hello", "Sam", "is", "Zaza", "name", "my", "world"};
		
		LinkedAlgorithms list2 = new LinkedAlgorithms(items2);
		
		assertTrue(list.anagrams(list2));
		
		String[] items3 = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "how", "are", "you", "Hello"};
		
		LinkedAlgorithms list3 = new LinkedAlgorithms(items3);
		
		String[] items4 = {"you", "are", "how", "Hello", "Sam", "is", "Zaza", "name", "my", "world", "Hello"};
		
		LinkedAlgorithms list4 = new LinkedAlgorithms(items4);
		
		assertTrue(list3.anagrams(list4));
		
		LinkedAlgorithms list5 = new LinkedAlgorithms();
		
		assertFalse(list.anagrams(list5));
		
		String[] items6 = {"Hello", "world", "my", "name", "is", "Zaza", "Sam", "how", "are", "Hello"};
		
		LinkedAlgorithms list6 = new LinkedAlgorithms(items6);
		
		assertFalse(list3.anagrams(list6));
		
		String[] items7 = {"you", "are", "how", "Hello", "Sam", "is", "Zaza", "name", "my", "Biscuit", "Hello"};
		
		LinkedAlgorithms list7 = new LinkedAlgorithms(items7);
		
		assertFalse(list3.anagrams(list7));
	}
}
