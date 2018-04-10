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
 * class which represents individual students: each line in the .csv is one
 * student
 * responses is a list of the yes's and no's - each entry in responses is a
 * two-element array representing heard/liked for a song
 * 
 * @author Josh Hayward
 * @version 04.02.2018
 */
public class Student {

    private int studentID;
    private String time; // time of response - this is in the csv but we likely
                         // won't need it
    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private LinkedList<String[]> responses;


    /**
     * constructor for student
     * 
     * @param id
     *            studntID
     * @param time
     *            student's time of response
     * @param major
     *            student's major
     * @param region
     *            student's home region
     * @param hobby
     *            student's hobby
     * @param responses
     *            list of student's responses
     */
    public Student(
        int id,
        String time,
        HobbyEnum hobby,
        MajorEnum major,
        RegionEnum region,
        LinkedList<String[]> responses) {
        studentID = id;
        this.time = time;
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        this.responses = responses;
    }


    /**
     * returns studentID
     * 
     * @return studentID
     */
    public int getStudentID() {
        return studentID;
    }


    /**
     * returns time
     * 
     * @return time
     */
    public String getTime() {
        return time;
    }


    /**
     * returns hobby
     * 
     * @return hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * returns major
     * 
     * @return major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * returns region
     * 
     * @return region
     */
    public RegionEnum getRegion() {
        return region;
    }


    /**
     * returne responses
     * 
     * @return response
     */
    public LinkedList<String[]> getResponses() {
        return responses;
    }
}
