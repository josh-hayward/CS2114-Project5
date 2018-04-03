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
    public Input()
    {
        // Empty on purpose
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        SongList songList = new SongList();
        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner survey = new Scanner(new File(args[0]));
        survey.nextLine();
        
        Scanner songListScanner = new Scanner(new File(args[1]));        
        
        final String CS = "Computer Science";
        final String ENGE = "Other Engineering";
        final String MATH_CMDA = "Math or CMDA";
        final String OTHER = "Other";
        final String NORTHEAST = "Northeast";
        final String SOUTHEAST = "Southeast";
        final String US = "United States (other than Southeast or Northwest)";
        final String NON_US = "Outside of United States";
        final String READ = "reading";
        final String ART = "art";
        final String MUSIC = "music";
        final String SPORTS = "sports";
        
        while (survey.hasNextLine())
        {
            Scanner lineScanner = new Scanner(survey.nextLine());
            lineScanner.useDelimiter(",");
            int studentID = Integer.parseInt(lineScanner.next());
            String time = lineScanner.next();
            MajorEnum major = null;
            RegionEnum region = null;
            HobbyEnum hobby = null;
            LinkedList<String[]> responses = new LinkedList<String[]>();
            
            switch (lineScanner.next()) 
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
                    break;
            }
            
            switch (lineScanner.next())
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
                    break;
            }
            
            switch (lineScanner.next())
            {
                case READ: 
                    hobby = HobbyEnum.READ;
                    break;
                case ART:
                    hobby = HobbyEnum.ART;
                    break;
                case MUSIC:
                    hobby = HobbyEnum.MUSIC;
                    break;
                case SPORTS:
                    hobby = HobbyEnum.SPORTS;
                    break;
                default:
                    hobby = HobbyEnum.UNKNOWN;
                    break;
            }

            while (lineScanner.hasNext())
            {
                String heard = lineScanner.next();
                String liked = "";
                if (lineScanner.hasNext())
                {
                    liked = lineScanner.next();
                }
                String[] response = {heard, liked};
                responses.add(response);
                }
            if (hobby != null && major != null && region != null)
            {
                studentList.add(new Student(studentID, time, major, region, hobby, responses));
            }  
        }
    }
}
