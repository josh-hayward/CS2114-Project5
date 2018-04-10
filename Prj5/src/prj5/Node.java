// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)
package prj5;

/**
 * This class creates nodes that store some
 * type of data
 * 
 * @author Cameron Moore (cam1111)
 * @author Joshua Hayward (jhayward)
 * @version 2018.04.01
 * @param <T> A generic type
 */
public class Node<T> {

    private Node<T> next;
    private T data;


    /**
     * Initializes next as null
     * and sets the data within the node
     * 
     * @param data
     *            The data to store in the node
     */
    public Node(T data) {
        next = null;
        this.data = data;
    }


    /**
     * Sets the nextNode of a node
     * 
     * @param nextNode The next node in the list
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }


    /**
     * Sets the data of a node
     * 
     * @param data
     *            The data to be stored in the node
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Returns the data stored in the node
     * 
     * @return data The data in the node
     */
    public T getData() {
        return data;
    }


    /**
     * Gets the next node
     * 
     * @return next The next node
     */
    public Node<T> getNextNode() {
        return next;
    }
}
