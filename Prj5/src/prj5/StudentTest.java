// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Farina (farinaa)

package prj5;

import student.TestCase;

/**
 * This class tests all the methods in the Student class to ensure they all
 * work as intended.
 * 
 * @author Anthony Farina (farinaa)
 * @version 2018.04.09
 */
public class StudentTest extends TestCase {

    /**
     * Declare the Student objects to be tested on.
     */
    private Student student1;
    private Student student2;


    /**
     * Initialize the Student objects for testing.
     */
    public void setUp() {
        LinkedList<String[]> responses1 = new LinkedList<String[]>();
        String[] strings1 = { "Yes", "No" };
        responses1.add(strings1);

        LinkedList<String[]> responses2 = new LinkedList<String[]>();
        String[] strings2 = { "No", "Yes" };
        responses2.add(strings2);

        student1 = new Student(1, "10:00PM", HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NON_US, responses1);
        student2 = new Student(2, "11:00PM", HobbyEnum.MUSIC, MajorEnum.ENGE,
            RegionEnum.SOUTHEAST, responses2);
    }


    /**
     * Tests the getStudentID method in the Student class to ensure it works as
     * intended.
     */
    public void testGetStudentID() {
        assertEquals(1, student1.getStudentID());

        assertEquals(2, student2.getStudentID());
    }


    /**
     * Tests the getTime method in the Student class to ensure it works as
     * intended.
     */
    public void testGetTime() {
        assertEquals("10:00PM", student1.getTime());

        assertEquals("11:00PM", student2.getTime());
    }


    /**
     * Tests the getHobby method in the Student class to ensure it works as
     * intended.
     */
    public void testGetHobby() {
        assertEquals(HobbyEnum.ART, student1.getHobby());

        assertEquals(HobbyEnum.MUSIC, student2.getHobby());
    }


    /**
     * Tests the getMajor method in the Student class to ensure it works as
     * intended.
     */
    public void testGetMajor() {
        assertEquals(MajorEnum.CS, student1.getMajor());

        assertEquals(MajorEnum.ENGE, student2.getMajor());
    }


    /**
     * Tests the getRegion method in the Student class to ensure it works as
     * intended.
     */
    public void testGetRegion() {
        assertEquals(RegionEnum.NON_US, student1.getRegion());

        assertEquals(RegionEnum.SOUTHEAST, student2.getRegion());
    }


    /**
     * Tests the getReponses method in the Student class to ensure it works as
     * intended.
     */
    public void testGetResponses() {
        String[] strings1Expected = { "Yes", "No" };
        String[] strings1Actual = { student1.getResponses().getNodeAt(0)
            .getData()[0], student1.getResponses().getNodeAt(0).getData()[1] };
        assertEquals(strings1Expected[0], strings1Actual[0]);
        assertEquals(strings1Expected[1], strings1Actual[1]);

        String[] strings2Expected = { "No", "Yes" };
        String[] strings2Actual = { student2.getResponses().getNodeAt(0)
            .getData()[0], student2.getResponses().getNodeAt(0).getData()[1] };
        assertEquals(strings2Expected[0], strings2Actual[0]);
        assertEquals(strings2Expected[1], strings2Actual[1]);
    }
}
