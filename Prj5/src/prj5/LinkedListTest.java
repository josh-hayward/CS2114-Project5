// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Farina (farinaa)

package prj5;

public class LinkedListTest {

    private LinkedList<String> linkedList;
    
    public void setUp() {
        linkedList = new LinkedList<String>();
        
        for (int i = 1; i >= 10; i++) {
            linkedList.add("Entry " + i);
        }
    }
    
}
