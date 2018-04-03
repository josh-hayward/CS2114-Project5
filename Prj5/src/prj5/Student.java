// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
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
    private MajorEnum major;
    private RegionEnum region;
    private HobbyEnum hobby;
    private LinkedList<String[]> responses;
    
    /**
     * constructor for student
     * @param id studntID
     * @param time student's time of response
     * @param major student's major
     * @param region student's home region
     * @param hobby student's hobby
     * @param responses list of student's responses
     */
    public Student(int id, String time, MajorEnum major, RegionEnum region, HobbyEnum hobby, LinkedList<String[]> responses) {
        studentID = id;
        this.time = time;
        this.major = major;
        this.region = region;
        this.hobby = hobby;
        this.responses = responses;
    }

    /**
     * returns studentID
     * @return studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * returns time
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * returns major
     * @return major
     */
    public MajorEnum getMajor() {
        return major;
    }

    /**
     * returns region
     * @return region
     */
    public RegionEnum getRegion() {
        return region;
    }

    /**
     * returns hobby
     * @return hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }

    /**
     * returne responses
     * @return response
     */
    public LinkedList<String[]> getResponses() {
        return responses;
    }
}
