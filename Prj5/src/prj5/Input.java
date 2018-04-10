// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class runs the main method which collects the input data
 * 
 * @author Cameron Moore (cam1111)
 * @version 2018.04.10
 */
public class Input {
    /**
     * The Input() constructor
     * It is not used, but the
     * main method within the class
     * is.
     */
    public Input() {
        // Empty on purpose
    }


    /**
     * Starts the program and creates
     * a list of students and songs
     * 
     * @throws FileNotFoundException
     *             If file isn't present
     * @param args
     *            Command line arguments that should be
     *            be the files to scan
     * @precondition args are the list of students and
     *               the list of songs and other info
     *               in CSV format
     */
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Student> studentList = scanSurvey(args[0]);
        SongList songList = scanSongList(args[1]);
        songList.sortBy(SortTypeEnum.GENRE);
        LinkedList<int[]> percentages = representHobbies(studentList, songList);
        outputPercentages(songList, percentages);
        
        songList.sortBy(SortTypeEnum.TITLE);
        percentages = representHobbies(studentList, songList);
        outputPercentages(songList, representHobbies(studentList, songList));
    }

    /**
     * Outputs the song information and the
     * percentages to the console
     * @param songList The list of songs in 
     *                 any order
     * @param percentages The percentages for 
     *                    this song order
     */
    public static void outputPercentages(SongList songList, 
        LinkedList<int[]> percentages)
    {
        for (int i = 0; i < songList.size(); i++)
        {
            Song curr = songList.getNodeAt(i).getData();
            System.out.println(curr.toString());
            int[] currResponse = percentages.getNodeAt(i).getData();
            
            System.out.println("Heard");
            System.out.println("reading:" + currResponse[0]
                + " art:" + currResponse[2] + " sports:" +
                currResponse[4] + " music:" + currResponse[6]);
            System.out.println("Likes");
            System.out.println("reading:" + currResponse[1]
                + " art:" + currResponse[3] + " sports:" +
                currResponse[5] + " music:" + currResponse[7] + "\n");
        }
    }
    
    /**
     * Scans a list of songs for
     * the artist, title, year, and genre
     * and creates a SongList of them
     * 
     * @param file
     *            The name of the file
     * @throws FileNotFoundException
     *             If file name given is
     *             not present
     * @return SongList A list of songs from the file
     * @precondition All song info is filled in completely
     *               within the file
     */
    public static SongList scanSongList(String file)
        throws FileNotFoundException {
        SongList songList = new SongList();
        Scanner songListScanner = new Scanner(new File(file));

        songListScanner.nextLine();

        int songID = 0;
        while (songListScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(songListScanner.nextLine());
            lineScanner.useDelimiter(",");

            String title = lineScanner.next();
            String artist = lineScanner.next();
            int year = Integer.parseInt(lineScanner.next());
            String genre = lineScanner.next();

            lineScanner.close();

            songList.add(new Song(artist, genre, title, year, songID));
            songID++;
        }

        songListScanner.close();

        return songList;
    }


    /**
     * Scans the survey file
     * 
     * @throws FileNotFoundException
     *             If file is not present
     * @return LinkedList<Student> The list of students and their
     *         information
     * @param file
     *            The file's pathname
     */
    public static LinkedList<Student> scanSurvey(String file)
        throws FileNotFoundException {
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

        while (survey.hasNextLine()) {
            Scanner lineScanner = new Scanner(survey.nextLine());
            lineScanner.useDelimiter(",");
            int studentID = Integer.parseInt(lineScanner.next());
            String time = lineScanner.next();
            MajorEnum major;
            RegionEnum region;
            HobbyEnum hobby;
            LinkedList<String[]> responses = new LinkedList<String[]>();

            switch (lineScanner.next()) {
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

            switch (lineScanner.next()) {
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

            switch (lineScanner.next()) {
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

            while (lineScanner.hasNext()) {
                String heard = lineScanner.next();
                String liked = "";
                if (lineScanner.hasNext()) {
                    liked = lineScanner.next();
                }
                String[] response = { heard, liked };
                responses.add(response);
            }
            lineScanner.close();
            if (hobby != null && major != null && region != null) {
                studentList.add(new Student(studentID, time, hobby, major, region,
                    responses));
            }
        }
        survey.close();
        return studentList;
    }
    
    
    /**
     * Makes a list of the responses to each song
     * as a percent. The order of the returned array
     * is reading, art, sports, and music with heard 
     * taking precedence over like for each one.
     * 
     * @param studentList The list of students 
     * @param songList The list of songs
     * @return The responses as a percent
     */
    public static LinkedList<int[]> representHobbies(LinkedList<Student> 
        studentList, SongList songList)
    {     
        LinkedList<int[]> percentages = new LinkedList<int[]>();
        for (int i = 0; i < songList.size(); i++)
        {
            float heardReading = 0;
            float heardArt = 0;
            float heardSports = 0;
            float heardMusic = 0;
            float likesReading = 0;
            float likesArt = 0;
            float likesSports = 0;
            float likesMusic = 0;
            float heardTotalReading = 0;
            float heardTotalArt = 0;
            float heardTotalSports = 0;
            float heardTotalMusic = 0;
            float likesReadingTotal = 0;
            float likesArtTotal = 0;
            float likesSportsTotal = 0;
            float likesMusicTotal = 0;
            
            for (int j = 0; j < studentList.size(); j++)
            {
                LinkedList<String[]> responses = studentList.
                    getNodeAt(j).getData().getResponses();
                String[] data = responses.getNodeAt(songList.
                    getNodeAt(i).getData().getSongID()).getData();
                switch (studentList.getNodeAt(j).getData().getHobby())
                {
                    case READ:
                        if (data[0].equals("Yes"))
                        {
                            heardReading++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalReading++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesReading++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesReadingTotal++;
                        }
                        break;
                    case ART:
                        if (data[0].equals("Yes"))
                        {
                            heardArt++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalArt++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesArt++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesArtTotal++;
                        }
                        break;
                    case SPORTS:
                        if (data[0].equals("Yes"))
                        {
                            heardSports++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalSports++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesSports++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesSportsTotal++;
                        }
                        break;
                    case MUSIC:
                        if (data[0].equals("Yes"))
                        {
                            heardMusic++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalMusic++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesMusic++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesMusicTotal++;
                        }
                        break;
                    default:
                        break;
                }
            }
                        
            int[] hobbyPercentages = {(int)(heardReading/heardTotalReading * 100),
                                        (int)(likesReading/likesReadingTotal * 100), 
                                        (int)(heardArt/heardTotalArt * 100), 
                                        (int)(likesArt/likesArtTotal * 100),
                                        (int)(heardSports/heardTotalSports * 100),
                                        (int)(likesSports/likesSportsTotal * 100),
                                        (int)(heardMusic/heardTotalMusic * 100),
                                        (int)(likesMusic/likesMusicTotal * 100)};
            percentages.add(hobbyPercentages);
        }
        return percentages;
    }
}
