import java.util.NoSuchElementException;

// Copyright 2020 Samuel Fisher
// CSE274 - Section G
// Professor: Dr. Kiper
// Program #2
// September 20, 2020
// This program implements a LinkedList with many
// different algorithms to perform operations on LinkedLists, 
// comparisons between LinkedLists, getters, setters, etc.

public class LinkedAlgorithms {

	// Private node class, not edited by me, Samuel Fisher
	private class Node {
		private String data;
		private Node next;

		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head;
	public int numItems;

	/**
	 * Creates the empty list.
	 */
	public LinkedAlgorithms() {
		head = null;
		numItems = 0;
	}

	/**
	 * Creates a list containing all the elements of the passed array.
	 * {@code data[0]} will be the first element of the list, {@code data[1]} will
	 * be the second element of the list, and so on. *
	 * 
	 * @param data The array of values
	 * @throws NullPointerException - data is null
	 */
	public LinkedAlgorithms(String[] data) {
		Node nodePtr;
		Node node;
		
		if (data == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < data.length; i++) {
			node = new Node(data[i]);
			this.insertAt(i, data[i]);
			nodePtr = node.next;
		}
	}

	/**
	 * Constructs a deep copy of the linked list {@code original}
	 * 
	 * @param original The list to be copied
	 * @throws NullPointerException - original is null
	 */
	public LinkedAlgorithms(LinkedAlgorithms original) {
		Node nodePtr = original.head;
		int counter = 0;
		
		if (nodePtr == null) {
			throw new NullPointerException();
		}

		while (nodePtr != null) {
			this.insertAt(counter, nodePtr.data);
			nodePtr = nodePtr.next;
			counter++;
		}
	}

	/**
	 * Returns array with all the elements.
	 * 
	 * @return Array containing all elements.
	 */
	public String[] toArray() {
		Node nodePtr = head;
		String[] result = new String[this.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = nodePtr.data;
			nodePtr = nodePtr.next;
		}
		return result;
	}

	/**
	 * Formats the elements in the list using leading and ending brackets (i.e.,
	 * []), with the values comma separated. There will be one space between each of
	 * these but none at the beginning nor at the end. Some examples: if the list is
	 * empty, toString() gives [] if the list has these three elements in this
	 * order: "hello", "world", "everyone", then the result should be [hello, world,
	 * everyone]
	 */
	@Override
	public String toString() {
		String result = "[";
		Node nodePtr = head;

		if (this.size() == 0) {
			return "[]";
		} else if (this.size() == 1) {
			return "[" + nodePtr.data + "]";
		}
		while (nodePtr.next != null) {
			result += nodePtr.data + ", ";
			nodePtr = nodePtr.next;
		}
		result += nodePtr.data + "]";
		return result;
	}

	/**
	 * Returns the number of items in the list
	 *
	 * @return Number of items in the list
	 */
	public int size() {
		return numItems;
	}

	/**
	 * Determines if two lists contain exactly the same values, in exactly the same
	 * order.
	 * 
	 * @return {@code true} if and only if obj is an list that is equivalent to the
	 *         incoming list.
	 */
	public boolean equalsLinkedList(LinkedAlgorithms obj) {
		if (this.size() != obj.size()) {
			return false;
		}

		Node nodePtr = this.head;
		Node objPtr = obj.head;
		boolean isEqual = false;

		while (nodePtr != null) {
			if (nodePtr.data == objPtr.data) {
				isEqual = true;
			} else {
				return false;
			}
			nodePtr = nodePtr.next;
			objPtr = objPtr.next;
		}
		return isEqual;
	}

	/**
	 * Determines if {@code key} is in the linked list.
	 * 
	 * @param key The value to be found
	 * @return true if and only if {@code key} is in the list
	 */
	public boolean contains(String key) {
		return !(this.find(key) == -1);
	}

	/**
	 * Determines the index of {@code key}. -1 is returned if the value is not
	 * present in the linked list. If {@code key} is present present more than once,
	 * the first index is returned.
	 *
	 * @param key The value to be found
	 * @return The index of the {@code key}
	 */
	public int find(String key) {
		Node nodePtr = head;
		int counter = 0;

		while (nodePtr != null) {
			if (nodePtr.data.equals(key)) {
				return counter;
			}
			nodePtr = nodePtr.next;
			counter++;
		}
		return -1;
	}

	/**
	 * Returns the value of the first element of the list.
	 * 
	 * @return The first element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getFirst() {
		Node nodePtr = head;
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		String result = nodePtr.data;
		return result;
	}

	/**
	 * Returns the value of the last element of the list.
	 *
	 * @return The last element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getLast() {
		Node nodePtr = head;
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		while (nodePtr.next != null) {
			nodePtr = nodePtr.next;
		}
		return nodePtr.data;
	}

	/**
	 * Returns the value of the {@code ith} element of the list (0 based).
	 *
	 * @param i The target index
	 * @return The value of the ith element of the list.
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public String getAt(int i) {
		Node nodePtr = head;
		int counter = 0;
		String result = nodePtr.data;

		if (i > (this.size() - 1) || i < 0) {
			throw new IndexOutOfBoundsException();
		}

		while (nodePtr != null) {
			if (counter == i) {
				result = nodePtr.data;
			}
			counter++;
			nodePtr = nodePtr.next;
		}
		return result;
	}

	/**
	 * Adds {@code data} to the beginning of the list. All other values in the list
	 * remain but they are "shifted to the right."
	 * 
	 * @param data The value to add to the list
	 */
	public void insertFirst(String data) {
		Node node = new Node(data);

		node.next = head;
		head = node;
		numItems++;
	}

	/**
	 * 
	 * Adds {@code data} to the end of the list. All other values in the list remain
	 * in their current positions.
	 * 
	 * @param data The value to add to the list
	 */
	public void insertLast(String data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
			numItems++;
		} else {
			Node nodePtr = head;
			while (nodePtr.next != null) {
				nodePtr = nodePtr.next;
			}
			nodePtr.next = node;
			numItems++;
		}
	}

	/**
	 * Adds data to a specific spot in the list. The values in the list remain
	 * intact but {@code data} is inserted in the list at position {@code i}. When
	 * {@code i=0}, the result is the same as {@code insertFirst}.
	 *
	 * @param i    The target index
	 * @param data The value to add to the list
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public void insertAt(int i, String data) {
		Node node = new Node(data);
		Node nodePtr = head;
		int counter = 0;

		if (i > (this.size()) || i < 0) {
			throw new IndexOutOfBoundsException();
		} else if (i == 0) {
			node.next = head;
			head = node;
			numItems++;
		} else {
			while (nodePtr != null) {
				if (counter == (i - 1)) {
					// if (counter == i) {
					node.next = nodePtr.next;
					nodePtr.next = node;
					numItems++;
				}
				nodePtr = nodePtr.next;
				counter++;
			}
		}
	}

	/**
	 * Adds {@code newData} the position immediately preceding {@code existingData}.
	 * If the {@code existingData} appears multiple times, only the first one is
	 * used.
	 *
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertBefore(String newData, String existingData) {
		Node nodePtr = head;

		if (this.find(existingData) == -1) {
			throw new NoSuchElementException();
		}
		if (this.find(existingData) == this.size() - 1) {
			this.insertAt(this.size() - 1, newData);
		} else {

			for (int i = 0; i < this.find(existingData) + 1; i++) {
				if (nodePtr.data.equals(existingData)) {
					this.insertAt((i), newData);
				}
				nodePtr = nodePtr.next;
			}
		}
	}

	/**
	 * Adds {@code newData} the position immediately after {@code existingData}. If
	 * the {@code existingData} appears multiple times, only the first one is used.
	 *
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * 
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertAfter(String newData, String existingData) {
		Node nodePtr = head;

		if (this.find(existingData) == -1) {
			throw new NoSuchElementException();
		}
		if (this.find(existingData) == this.size() - 1) {
			insertLast(newData);
		} else {
			for (int i = 0; i < this.find(existingData) + 1; i++) {
				if (nodePtr.data.equals(existingData)) {
					this.insertAt(i + 1, newData);
				}
				nodePtr = nodePtr.next;
			}
		}
	}               

	/**
	 * Removes the first element of the list. The remaining elements are kept in
	 * their existing order.
	 *
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeFirst() {
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		Node nodePtr = head;

		head = nodePtr.next;
		numItems--;

		return nodePtr.data;
	}

	/**
	 * Removes the last element of the list. The remaining elements are kept in
	 * their existing order.
	 *
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeLast() {
		Node nodePtr = head;
		Node tracker = head;

		if (this.size() == 0) {
			throw new NoSuchElementException();
		}

		while (nodePtr.next != null) {
			tracker = nodePtr;
			nodePtr = nodePtr.next;
		}
		tracker.next = null;
		numItems--;
		return tracker.data;
	}

	/**
	 * Removes the ith element of the list. The remaining elements are kept in their
	 * existing order.
	 * 
	 * @param i The target index
	 * @return The value removed from the list
	 * @throws IndexOutOfBoundsException i does not represent a legal index
	 */
	public String removeAt(int i) {
		Node nodePtr = head;
		Node tracker = nodePtr;
		int counter = 0;

		if (i < 0 || i > this.size() - 1) {
			throw new IndexOutOfBoundsException();
		}

		if (i == 0) {
			head = nodePtr.next;
			numItems--;
		} else {
			while (nodePtr != null) {
				if (counter == i) {
					tracker.next = nodePtr.next;
					numItems--;
					return nodePtr.data;
				}
				tracker = nodePtr;
				nodePtr = nodePtr.next;
				counter++;
			}
		}
		return nodePtr.data;
	}

	/**
	 * Removes the first occurrence of data in the linked list.
	 *
	 * @param data The value to be removed.
	 * @return {@code true} if and only if {@code data} was removed
	 */
	public boolean removeFirstOccurrenceOf(String data) {
		int num = this.find(data);

		if (num == -1) {
			return false;
		} else {
			this.removeAt(num);
			return true;
		}
	}

	/**
	 * Removes the all occurrence of {@code data} in the linked list.
	 *
	 * @param data The value to be removed.
	 * @return The number of times {@code data} was removed
	 */
	public int removeAllOccurrencesOf(String data) {
		Node nodePtr = head;
		int result = 0;

		for (int i = 0; i < this.size(); i++) {
			if (nodePtr.data.equals(data)) {
				this.removeAt(this.find(data));
				result++;
			}
			nodePtr = nodePtr.next;
		}
		return result;
	}

	/**
	 * Reverses the elements in the incoming linked list.
	 */
	public void reverse() {
		String[] result = this.toArray();
		int counter = 0;

		for (int i = this.size() - 1; i >= 0; i--) {
			this.insertAt(counter, result[i]);
			this.removeLast();
			counter++;
		}
	}

	/**
	 * Puts all the elements in the list to uppercase.
	 */
	public void toUpper() {
		Node nodePtr = head;

		for (int i = 0; i < this.size(); i++) {
			nodePtr.data = nodePtr.data.toUpperCase();
			nodePtr = nodePtr.next;
		}
	}

	/**
	 * Returns the concatenation of all strings, from left to right. No extra spaces
	 * are inserted.
	 *
	 * @return Concatenation of all string in the list
	 */
	public String getConcatenation() {
		String result = "";
		Node nodePtr = head;

		while (nodePtr != null) {
			result += nodePtr.data;
			nodePtr = nodePtr.next;
		}
		return result;
	}

	/**
	 * Returns the alphabetically last value in the list.
	 *
	 * @return The alphabetically last value in the list
	 * @throws NoSuchElementException list is empty
	 */
	public String getAlphabeticallyLast() {
		Node nodePtr = head;
		String result = "";
		
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}

		while (nodePtr != null) {
			if (nodePtr.data.compareToIgnoreCase(result) > 0) {
				result = nodePtr.data;
			}
			nodePtr = nodePtr.next;
		}
		return result;
	}

	/**
	 * Returns the index where the alphabetically last value value resides. If this
	 * value appears multiple times, the first occurrence is used.
	 *
	 * @return Index value of where maximum value resides
	 * @throws NoSuchElementException list is empty
	 */
	public int indexOfAlphabeticallyLast() {
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		return this.find(this.getAlphabeticallyLast());
	}

	/*
	 * Determines if the two list contain elements that have exactly the same value,
	 * with the same list sizes, but with the elements perhaps in different order.
	 * 
	 * @return true only if the two lists are permutations of one another.
	 */
	public boolean anagrams(LinkedAlgorithms other) {
		Node nodePtr = other.head;
		String[] result = this.toArray();
		int count = 0;

		if (this.size() != other.size()) {
			return false;
		} else {
			for (String s : result) {
				while (nodePtr != null) {
					if (nodePtr.data.equals(s)) {
						count++;
						nodePtr = other.head;
						break;
					}
					nodePtr = nodePtr.next;
				}
				nodePtr = other.head;
			}
		}
		if (count == this.size()) {
			return true;
		} else {
			return false;
		}
	}

//	public static void main(String[] args) {
//		String[] items = { "hello", "world" };
//		LinkedAlgorithms LL1 = new LinkedAlgorithms();
//		LinkedAlgorithms LL2 = new LinkedAlgorithms(items);
//		LinkedAlgorithms LL3 = new LinkedAlgorithms(LL1);
//		String[] items3 = { "Hello", "world", "my", "name", "is", "Zaza", "Sam", "how", "are", "you", "Hello" };
//
//		LinkedAlgorithms list = new LinkedAlgorithms(items3);
//
//		String[] items2 = { "you", "are", "how", "Hello", "Sam", "is", "Zaza", "name", "my", "world", "Hello" };
//
//		LinkedAlgorithms list2 = new LinkedAlgorithms(items2);
//		list.anagrams(list2);
//	}
}
