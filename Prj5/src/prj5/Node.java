// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

/**
 * This class creates a Node that stores a generic data type and points to
 * another Node.
 * 
 * @author Cameron Moore (cam1111)
 * @author Joshua Hayward (jhayward)
 * @version 2018.04.22
 * @param <T>
 *            The generic data type for this class.
 */
public class Node<T> {

    /**
     * Declare the Node's data field and pointer to the next Node.
     */
    private Node<T> next;
    private T data;


    /**
     * Initializes the next Node as null and sets the data within the node to
     * the given data.
     * 
     * @param data
     *            The data to store in this Node.
     */
    public Node(T data) {
        next = null;
        this.data = data;
    }


    /**
     * Sets the next Node of this Node.
     * 
     * @param nextNode
     *            The next Node to point at.
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }


    /**
     * Sets the data of this Node.
     * 
     * @param data
     *            The data to be stored in the this Node.
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Returns the data stored in this Node.
     * 
     * @return The data in this Node.
     */
    public T getData() {
        return data;
    }


    /**
     * Gets the next Node.
     * 
     * @return The next Node.
     */
    public Node<T> getNextNode() {
        return next;
    }
}
