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
    /**
     * The Input() constructor
     * It is not used, but the 
     * main method within the class 
     * is.
     */
    public Input()
    {
        // Empty on purpose
    }
    
    /**
     * Starts the program and creates
     * a list of students and songs
     * @throws FileNotFoundException If file isn't present
     * @param args Command line arguments that should be 
     *             be the files to scan
     * @precondition args are the list of students and 
     *               the list of songs and other info
     *               in CSV format
     */
    public static void main(String[] args) 
        throws FileNotFoundException
    {
        LinkedList<Student> studentList = scanSurvey(args[0]);
        SongList songList = scanSongList(args[1]);
    }
    
    /**
     * Scans a list of songs for
     * the artist, title, year, and genre
     * and creates a SongList of them
     * @param file The name of the file
     * @throws FileNotFoundException If file name given is
     *         not present
     * @return SongList A list of songs from the file
     * @precondition All song info is filled in completely
     *               within the file
     */
    public static SongList scanSongList(String file) 
        throws FileNotFoundException
    {
        SongList songList = new SongList();
        Scanner songListScanner = new Scanner(new File(file));
        
        songListScanner.nextLine();
        
        while (songListScanner.hasNextLine())
        {
            Scanner lineScanner = new Scanner(songListScanner.nextLine());
            lineScanner.useDelimiter(",");
            
            String title = lineScanner.next();
            String artist = lineScanner.next();
            int year = Integer.parseInt(lineScanner.next());
            String genre = lineScanner.next();
            
            lineScanner.close();
            
            songList.add(new Song(artist, genre, title, year));
        }
        
        return songList;
    }
    
    /**
     * Scans the survey file
     * @throws FileNotFoundException If file is not present
     * @return LinkedList<Student> The list of students and their
     *                             information
     * @param file The file's pathname
     */
    public static LinkedList<Student> scanSurvey(String file)
        throws FileNotFoundException
    {
        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner survey = new Scanner(new File(file));
        survey.nextLine();
        
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
            lineScanner.close();
            if (hobby != null && major != null && region != null)
            {
                studentList.add(new Student(studentID, time, major,
                    region, hobby, responses));
            }  
        }
        survey.close();
        return studentList;
    }
}
