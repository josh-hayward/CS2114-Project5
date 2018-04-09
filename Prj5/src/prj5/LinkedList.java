// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Cameron Moore (cam1111)

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates a list using nodes
 * and a generic type
 * 
 * @author Cameron Moore (cam1111)
 * @author Joshua Hayward (jhayward)
 * @version 2018.04.01
 * @param T
 *            A generic type
 */
public class LinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;


    /**
     * The LinkedList<T> constructor
     */
    public LinkedList() {
        size = 0;
        head = null;
    }


    /**
     * Returns the size of the list
     * 
     * @return int The size of the list
     */
    public int size() {
        return size;
    }


    /**
     * Clears the list
     */
    public void clear() {
        head = null;
        size = 0;
    }


    /**
     * Checks for emptiness
     * 
     * @return boolean True if empty
     */
    public boolean isEmpty() {
        return size == 0 && head == null;
    }


    /**
     * Adds a node to the end of the list
     * 
     * @param data
     *            The data to put in the node
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        else {
            Node<T> curr = head;
            while (curr.getNextNode() != null) {
                curr = curr.getNextNode();
            }
            curr.setNextNode(new Node<T>(data));
        }
        size++;
    }


    /**
     * Removes a Node at an index
     * 
     * @return boolean True if successful
     * @param index
     *            The index of the node
     */
    public boolean remove(int index) {
        Node<T> removedNode;
        try {
            removedNode = getNodeAt(index);
        }
        catch (Exception e) {
            return false;
        }
        if (removedNode == head) {
            head = removedNode.getNextNode();
        }
        else {
            Node<T> prevNode = getNodeAt(index - 1);
            prevNode.setNextNode(removedNode.getNextNode());
        }
        size--;
        return true;
    }


    /**
     * Adds a node at an index
     * 
     * @param index
     *            The index of the new node
     * @param data
     *            The data to add to the node
     */
    public void add(int index, T data) {
        Node<T> newNode = new Node<T>(data);
        if (index == 0) {
            newNode.setNextNode(head);
            head = newNode;
        }
        else {
            Node<T> beforeNode = getNodeAt(index - 1);
            newNode.setNextNode(beforeNode.getNextNode());
            beforeNode.setNextNode(beforeNode);
        }
        size++;
    }


    /**
     * Gets a node at a given index
     * List starts at 0
     * 
     * @param index
     *            The index of the node to find
     * @return Node<T> The node at the index
     */
    public Node<T> getNodeAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("No element exists at"
                + " the given index.");
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNextNode();
        }
        return curr;
    }


    /**
     * Converts the linked list to a string
     * 
     * @return String The list as a string
     */
    @Override
    public String toString() {
        String list = "[";
        Node<T> curr = head;
        while (curr != null) {

            list = list + curr.getData().toString();
            if (curr.getNextNode() != null) {
                list = list + ", ";
            }
            curr = curr.getNextNode();
        }
        return list + "]";
    }


    /**
     * Iterator method that creates an Iterator object for the LinkedList.
     *
     * @return A new Iterator object.
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }


    /**
     * An iterator for the LinkedList that traverses the list from the front to
     * the back.
     * 
     * @author Anthony Farina (farinaa)
     * @version 2018.04.09
     * @param <E>
     *            The generic data type to use for this class.
     */
    private class LinkedListIterator<E> implements Iterator<T> {

        /**
         * Private variables needed to keep track of the next Node, the next
         * position, and if next was called.
         */
        private Node<T> nextNode;
        private int nextPos;
        private boolean nextCalled;


        /**
         * Creates a new LinkedListIterator object.
         */
        public LinkedListIterator() {
            nextNode = head;
            nextPos = 0;
            nextCalled = false;
        }


        /**
         * Checks if there is a next node.
         *
         * @return True if there is a next node, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }


        /**
         * Gets the next value in the list.
         *
         * @return The next value.
         * @throws NoSuchElementException
         *             Thrown when there is no next Node (the end of the list
         *             has been reached).
         */
        @Override
        public T next() throws NoSuchElementException {
            if (hasNext()) {
                nextCalled = true;
                nextPos++;

                Node<T> returnNode = nextNode;
                nextNode = nextNode.getNextNode();
                return returnNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call to next(): "
                    + "end of list reached.");
            }
        }


        /**
         * Removes the last object returned with next() from the list.
         *
         * @throws IllegalStateException
         *             Thrown if next() has not been called yet
         *             and if the element has already been removed.
         */
        @Override
        public void remove() throws IllegalStateException {
            if (nextCalled) {

                if (nextPos >= 2) {
                    Node<T> prevNode = getNodeAt(nextPos - 2);
                    prevNode.setNextNode(nextNode);
                    size--;
                }
                else {
                    head = head.getNextNode();
                    size--;
                }
                nextCalled = false;

            }
            else {
                throw new IllegalStateException("Illegal call to remove(): "
                    + "next() has not been called yet.");
            }
        }

    }
}
