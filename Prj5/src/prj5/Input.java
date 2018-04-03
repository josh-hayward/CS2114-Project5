// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with 
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor 
// will I accept the actions of those who do.
// -- Cameron Moore (cam1111)
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class 
 * @author Cameron Moore (cam1111)
 * @version 2018.04.01
 */
public class Input 
{
    private SongList songList = new SongList();
    private LinkedList<Student> studentList = new LinkedList<Student>();
    
    public Input()
    {
        
    }
    
    public static final void main(String[] args) throws FileNotFoundException
    {
        Scanner survey = new Scanner(new File(args[0]));
        survey.useDelimiter(",");
        Scanner songList = new Scanner(new File(args[1]));
        songList.useDelimiter(",");
        
        
        String final CS = "Computer Science";
        String final ENGE = "Other Engineering";
        String final MATH_CMDA = "Math or CMDA";
        String final OTHER = "Other";
        String final NORTHEAST = "Northeast";
        String final SOUTHEAST = "Southeast";
        String final US = "United States (other than Southeast or Northwest)";
        String final NON_US = "Outside of United States";
        String final READ = "reading";
        String final ART = "art";
        String final MUSIC = "music";
        String final SPORTS = "sports";
        
        studentID = 0;
        while (survey.hasNext())
        {
            if (survey.next() == studentID + 1)
            {
                studentID++;
                String time = survey.next();
                MajorEnum major;
                RegionEnum region;
                HobbyEnum hobby;
                LinkedList<String[]> responses = new LinkedList<String[]>();
                switch (survey.next()): 
                {
                    case CS: 
                        major = MajorEnum.CS;
                        break;
                    case ENGE:
                        major = MajorEnum.ENGE;
                        break;
                    case MATH_CMDA:
                        major = MajorEnum.MATH_CMDA;
                        break;
                    case OTHER:
                        major = MajorEnum.OTHER;
                        break;
                    default:
                        major = MajorEnum.UNKNOWN;
                }
                
                switch (survey.next()): 
                {
                    case NORTHEAST: 
                        region = RegionEnum.NORTHEAST;
                        break;
                    case SOUTHEAST:
                        region = RegionEnum.SOUTHEAST;
                        break;
                    case US:
                        region = RegionEnum.US;
                        break;
                    case NON_US:
                        region = RegionEnum.NON_US;
                        break;
                    default:
                        region = RegionEnum.UNKNOWN;
                }
                
                switch (survey.next()): 
                {
                    case READ: 
                        region = HobbyEnum.READ;
                        break;
                    case ART:
                        region = HobbyEnum.ART;
                        break;
                    case MUSIC:
                        region = HobbyEnum.MUSIC;
                        break;
                    case SPORTS:
                        region = HobbyEnum.SPORTS;
                        break;
                    default:
                        region = HobbyEnum.UNKNOWN;
                }
                
                while (survey.hasNext())
                {
                    String firstResponse = survey.next();
                    if (firstResponse == studentID + 1)
                    {
                        break;
                    }
                    String secondResponse = survey.next();
                }
                
                studentList.add(new Student(StudentID, time, major, region, hobby, responses));
            }
        }
    }
}
