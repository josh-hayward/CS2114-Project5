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

/**
 * This class creates a list using Nodes and a generic type.
 * 
 * @author Cameron Moore (cam1111)
 * @author Joshua Hayward (jhayward)
 * @author Anthony Farina (farinaa)
 * @version 2018.04.22
 * @param <T>
 *            The generic data type for this list.
 */
public class LinkedList<T> implements Iterable<T> {

    private int size;
    private Node<T> head;


    /**
     * The LinkedList constructor that initializes the size and head Node.
     */
    public LinkedList() {
        size = 0;
        head = null;
    }


    /**
     * Returns the current size of the list.
     * 
     * @return The current size of the list.
     */
    public int size() {
        return size;
    }


    /**
     * Removes all data in the list.
     */
    public void clear() {
        head = null;
        size = 0;
    }


    /**
     * Checks if the list is empty.
     * 
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds a Node to the end of the list.
     * 
     * @param data
     *            The data to put in the Node.
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
        }
        else {
            getNodeAt(size - 1).setNextNode(newNode);
        }
        size++;
    }


    /**
     * Removes a Node at the specified index.
     * 
     * @param index
     *            The index of the node to remove.
     * @return True if the removal was successful, false otherwise.
     */
    public T remove(int index) {
        Node<T> removedNode = getNodeAt(index);
        T removedData = removedNode.getData();

        if (removedNode == head) {
            head = removedNode.getNextNode();
        }
        else {
            Node<T> prevNode = getNodeAt(index - 1);
            prevNode.setNextNode(removedNode.getNextNode());
        }

        size--;
        return removedData;
    }


    /**
     * Adds a node at the specified index.
     * 
     * @param index
     *            The index to insert the new Node at.
     * @param data
     *            The data to add to the Node.
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
            beforeNode.setNextNode(newNode);
        }

        size++;
    }


    /**
     * Gets the Node at the specified index. The LinkedList starts at index 0.
     * 
     * @param index
     *            The index of the Node to return.
     * @return The Node at the specified index.
     * @throws IndexOutOfBoundsException
     *             Thrown when the index does not exist for this LinkedList.
     */
    public Node<T> getNodeAt(int index) {
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
     * Returns the LinkedList's data as a string.
     * 
     * @return The LinkedList's data as a string.
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");

        Node<T> curr = head;
        while (curr != null) {
            list.append(curr.getData().toString());
            if (curr.getNextNode() != null) {
                list.append(", ");
            }
            curr = curr.getNextNode();
        }

        return list.append("]").toString();
    }


    /**
     * Iterator method that creates an Iterator object for this LinkedList.
     *
     * @return A new Iterator object for this LinkedList.
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }


    /**
     * An Iterator class for the LinkedList that traverses the list from the
     * front to the back.
     * 
     * @author Anthony Farina (farinaa)
     * @version 2018.04.22
     * @param <E>
     *            The generic data type to use for this class.
     */
    private class LinkedListIterator<E> implements Iterator<T> {

        /**
         * Private variables needed to keep track of the next Node, the next
         * position, and if the next method was called.
         */
        private Node<T> nextNode;
        private int nextPos;
        private boolean nextCalled;


        /**
         * Creates a new LinkedListIterator object by initializing the next
         * Node, the next position integer, and the boolean to check if the next
         * method has been called.
         */
        public LinkedListIterator() {
            nextNode = head;
            nextPos = 0;
            nextCalled = false;
        }


        /**
         * Checks if there is a Node next in the LinkedList.
         *
         * @return True if there is Node next in the LinkedList, false
         *         otherwise.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }


        /**
         * Gets the next value in the LinkedList.
         *
         * @return The next value.
         * @throws NoSuchElementException
         *             Thrown when there isn't a Node next in the LinkedList
         *             (which means the end of the list has been reached).
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
         * Removes the last object returned from next() from the LinkedList.
         *
         * @throws IllegalStateException
         *             Thrown if next() has not been called yet and if the
         *             object has already been removed.
         */
        @Override
        public void remove() throws IllegalStateException {
            if (nextCalled) {

                if (nextPos >= 2) {
                    Node<T> prevNode = getNodeAt(nextPos - 2);
                    prevNode.setNextNode(nextNode);
                }
                else {
                    head = head.getNextNode();
                }

                nextPos--;
                size--;
                nextCalled = false;
            }
            else {
                throw new IllegalStateException("Illegal call to remove(): "
                    + "next() has not been called yet.");
            }
        }
    }
}
