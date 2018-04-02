// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Cameron Moore (cam1111)

/*
 * LinkedList:
 * TODO remove(T data): boolean
 * TODO equals(LinkedList<T>): boolean if needed
 * TODO toString(): String
 * 
 * Node:
 * TODO equals(Node<T>): boolean
 * TODO toString(): String
 */

package prj5;

/**
 * This class creates a list using nodes
 * and a generic type
 * 
 * @author Cameron Moore (cam1111)
 * @version 2018.04.01
 * @param T
 *            A generic type
 */
public class LinkedList<T> {
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
     * Adds a node to the edge of the list
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
            Node<T> prevNode = getNodeAt(index-1);
            prevNode.setNextNode(removedNode.getNextNode());
        }
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
     * This class creates nodes that store some
     * type of data
     * 
     * @author Cameron Moore (cam1111)
     * @version 2018.04.01
     * @param T
     *            A generic type
     */
    private class Node<T> {
        private Node<T> next;
        private T data;


        /**
         * Initializes next as null
         * and sets the data within the node
         * 
         * @param data
         *            The data to store in the node
         */
        private Node(T data) {
            next = null;
            this.data = data;
        }


        /**
         * Sets the nextNode of a node
         * 
         * @param newNode
         *            The next node in the list
         */
        private void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }


        /**
         * Sets the data of a node
         * 
         * @param data
         *            The data to be stored in the node
         */
        private void setData(T data) {
            this.data = data;
        }


        /**
         * Returns the data stored in the node
         * 
         * @return data The data in the node
         */
        private T getData() {
            return data;
        }


        /**
         * Gets the next node
         */
        private Node<T> getNextNode() {
            return next;
        }
    }
}
