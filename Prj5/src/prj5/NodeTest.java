// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

import student.TestCase;

/**
 * This class tests all the methods in the Node class to ensure they all work as
 * intended.
 * 
 * @author Anthony Farina (farinaa)
 * @version 2018.04.22
 */
public class NodeTest extends TestCase {

    /**
     * Declare the Node object(s) to be tested on.
     */
    private Node<String> testNode;


    /**
     * Initialize the Node object(s) for testing.
     */
    public void setUp() {
        testNode = new Node<String>("test");
    }


    /**
     * Tests the getData method in the Node class to ensure it returns the
     * correct data of this Node.
     */
    public void testGetData() {
        assertEquals("test", testNode.getData());
    }


    /**
     * Tests the setData method in the Node class to ensure it changes the data
     * in this Node to the given data.
     */
    public void testSetData() {
        assertEquals("test", testNode.getData());
        testNode.setData("new test");
        assertEquals("new test", testNode.getData());
    }


    /**
     * Tests the getNextNode method in the Node class to ensure it returns the
     * correct Node that this Node points to.
     */
    public void testGetNextNode() {
        assertNull(testNode.getNextNode());
    }


    /**
     * Tests the setNextNode method in the Node class to ensure it updates the
     * next Node this Node points to properly.
     */
    public void testSetNextNode() {
        assertNull(testNode.getNextNode());

        Node<String> next = new Node<String>("next");
        testNode.setNextNode(next);
        assertEquals(testNode.getNextNode(), next);
    }
}
