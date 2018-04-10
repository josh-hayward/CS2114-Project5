// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * This class tests all the methods in the LinkedList class to ensure they all
 * work as intended.
 * 
 * @author Anthony Farina (farinaa)
 * @version 2018.04.10
 */
public class LinkedListTest extends TestCase {

    /**
     * Declare the LinkedList objects to be tested on.
     */
    private LinkedList<String> linkedList;
    private LinkedList<String> emptyLinkedList;


    /**
     * Initialize the LinkedList objects for testing.
     */
    public void setUp() {
        linkedList = new LinkedList<String>();
        emptyLinkedList = new LinkedList<String>();

        for (int i = 1; i <= 10; i++) {
            linkedList.add("Entry " + i);
        }
    }


    /**
     * Tests the size method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testSize() {
        assertEquals(10, linkedList.size());

        assertEquals(0, emptyLinkedList.size());
    }


    /**
     * Tests the clear method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testClear() {
        assertEquals(10, linkedList.size());
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        linkedList.clear();
        assertEquals(0, linkedList.size());
        assertEquals("[]", linkedList.toString());

        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
        emptyLinkedList.clear();
        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
    }


    /**
     * Tests the isEmpty method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testIsEmpty() {
        assertFalse(linkedList.isEmpty());

        assertTrue(emptyLinkedList.isEmpty());
    }


    /**
     * Tests the add(T data) method in the LinkedList class to ensure it works
     * as intended.
     */
    public void testAddWithoutIndex() {
        assertEquals(10, linkedList.size());
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        linkedList.add("Entry 11");
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10, Entry 11]",
            linkedList.toString());
        assertEquals(11, linkedList.size());

        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
        emptyLinkedList.add("test");
        assertEquals("[test]", emptyLinkedList.toString());
        assertEquals(1, emptyLinkedList.size());
    }


    /**
     * Tests the remove method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testRemove() {
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        assertEquals(10, linkedList.size());
        assertEquals("Entry 1", linkedList.remove(0));
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        assertEquals(9, linkedList.size());
        assertEquals("Entry 7", linkedList.remove(5));
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 8, Entry 9, Entry 10]", linkedList.toString());
        assertEquals(8, linkedList.size());
        assertEquals("Entry 10", linkedList.remove(7));
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 8, Entry 9]", linkedList.toString());
        assertEquals(7, linkedList.size());

        Exception exception = null;
        try {
            linkedList.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(7, linkedList.size());
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 8, Entry 9]", linkedList.toString());

        exception = null;
        try {
            linkedList.remove(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(7, linkedList.size());
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 8, Entry 9]", linkedList.toString());

        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
        exception = null;
        try {
            emptyLinkedList.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
    }


    /**
     * Tests the add(int index, T data) method in the LinkedList class to
     * ensure it works as intended.
     */
    public void testAddWithIndex() {
        assertEquals(10, linkedList.size());
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        linkedList.add(0, "Entry 0");
        assertEquals("[Entry 0, Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());
        assertEquals(11, linkedList.size());

        linkedList.add(5, "New Entry 5");
        assertEquals("[Entry 0, Entry 1, Entry 2, Entry 3, Entry 4, "
            + "New Entry 5, Entry 5, Entry 6, Entry 7, Entry 8, Entry 9, "
            + "Entry 10]", linkedList.toString());
        assertEquals(12, linkedList.size());

        linkedList.add(12, "Entry 11");
        assertEquals("[Entry 0, Entry 1, Entry 2, Entry 3, Entry 4, "
            + "New Entry 5, Entry 5, Entry 6, Entry 7, Entry 8, Entry 9, "
            + "Entry 10, Entry 11]", linkedList.toString());
        assertEquals(13, linkedList.size());

        Exception exception = null;
        try {
            linkedList.add(-1, "negative index?");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(13, linkedList.size());
        assertEquals("[Entry 0, Entry 1, Entry 2, Entry 3, Entry 4, "
            + "New Entry 5, Entry 5, Entry 6, Entry 7, Entry 8, Entry 9, "
            + "Entry 10, Entry 11]", linkedList.toString());

        exception = null;
        try {
            linkedList.add(1000, "too high!");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(13, linkedList.size());
        assertEquals("[Entry 0, Entry 1, Entry 2, Entry 3, Entry 4, "
            + "New Entry 5, Entry 5, Entry 6, Entry 7, Entry 8, Entry 9, "
            + "Entry 10, Entry 11]", linkedList.toString());

        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());

        exception = null;
        try {
            emptyLinkedList.add(-1, "negative index?");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());

        exception = null;
        try {
            emptyLinkedList.add(1000, "too high!");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());

        emptyLinkedList.add(0, "test");
        assertEquals(1, emptyLinkedList.size());
        assertEquals("[test]", emptyLinkedList.toString());
    }


    /**
     * Tests the getNodeAt method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testGetNodeAt() {
        assertEquals("Entry 1", linkedList.getNodeAt(0).getData());
        assertEquals("Entry 6", linkedList.getNodeAt(5).getData());
        assertEquals("Entry 10", linkedList.getNodeAt(9).getData());

        Exception exception = null;
        try {
            linkedList.getNodeAt(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            linkedList.getNodeAt(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptyLinkedList.getNodeAt(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptyLinkedList.getNodeAt(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptyLinkedList.getNodeAt(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the toString method in the LinkedList class to ensure it works as
     * intended.
     */
    public void testToString() {
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());

        assertEquals("[]", emptyLinkedList.toString());
    }


    /**
     * Tests the hasNext method in the LinkedList's private class
     * LinkedListIterator to ensure it works as intended.
     */
    public void testIteratorHasNext() {
        Iterator<String> listIter = linkedList.iterator();
        assertTrue(listIter.hasNext());

        Iterator<String> emptyListIter = emptyLinkedList.iterator();
        assertFalse(emptyListIter.hasNext());
    }


    /**
     * Tests the next method in the LinkedList's private class
     * LinkedListIterator to ensure it works as intended.
     */
    public void testIteratorNext() {
        Iterator<String> listIter = linkedList.iterator();

        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 1");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 2");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 3");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 4");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 5");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 6");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 7");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 8");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 9");
        assertTrue(listIter.hasNext());
        assertEquals(listIter.next(), "Entry 10");
        assertFalse(listIter.hasNext());

        Exception exception = null;
        try {
            listIter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);

        Iterator<String> emptyListIter = emptyLinkedList.iterator();
        exception = null;
        try {
            emptyListIter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);
    }


    /**
     * Tests the remove method in the LinkedList's private class
     * LinkedListIterator to ensure it works as intended.
     */
    public void testIteratorRemove() {
        Iterator<String> listIter = linkedList.iterator();
        assertEquals(10, linkedList.size());
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());

        Exception exception = null;
        try {
            listIter.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        assertEquals(10, linkedList.size());
        assertEquals("[Entry 1, Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());

        assertEquals("Entry 1", listIter.next());
        listIter.remove();
        assertEquals(9, linkedList.size());
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 6, Entry 7, Entry 8, Entry 9, Entry 10]", linkedList
                .toString());

        for (int i = 1; i <= 5; i++) {
            assertEquals("Entry " + (i + 1), listIter.next());
        }

        listIter.remove();
        assertEquals(8, linkedList.size());
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 7, Entry 8, Entry 9, Entry 10]", linkedList.toString());

        for (int i = 6; i <= 9; i++) {
            assertEquals("Entry " + (i + 1), listIter.next());
        }
        listIter.remove();
        assertEquals(7, linkedList.size());
        assertEquals("[Entry 2, Entry 3, Entry 4, Entry 5, "
            + "Entry 7, Entry 8, Entry 9]", linkedList.toString());

        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
        Iterator<String> emptyListIter = emptyLinkedList.iterator();

        exception = null;
        try {
            emptyListIter.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        assertEquals(0, emptyLinkedList.size());
        assertEquals("[]", emptyLinkedList.toString());
    }
}
