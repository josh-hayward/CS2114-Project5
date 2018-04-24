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
     * is used
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
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException {
        
        LinkedList<Student> studentList;
        SongList songList;
        
        if (args.length == 2) {
            studentList = scanSurvey(args[0]);
            songList = scanSongList(args[1]);
        }
        else {
            studentList = scanSurvey("MusicSurveyData2018S.csv");
            songList = scanSongList("SongList2018S.csv");
        }
        songList.sortBy(SortTypeEnum.ARTIST);
        GUIMusicWindow window = new GUIMusicWindow(songList, studentList);
    }


    /**
     * Outputs the song information and the
     * percentages to the console
     * 
     * @param songList
     *            The list of songs in
     *            any order
     * @param percentages
     *            The percentages for
     *            this song order
     */
    public static void outputPercentages(
        SongList songList,
        LinkedList<int[]> percentages) {
        for (int i = 0; i < songList.size(); i++) {
            Song curr = songList.getNodeAt(i).getData();
            System.out.println(curr.toString());
            int[] currResponse = percentages.getNodeAt(i).getData();

            System.out.println("Heard");
            System.out.println("reading:" + currResponse[0] + " art:"
                + currResponse[2] + " sports:" + currResponse[4] + " music:"
                + currResponse[6]);
            System.out.println("Likes");
            System.out.println("reading:" + currResponse[1] + " art:"
                + currResponse[3] + " sports:" + currResponse[5] + " music:"
                + currResponse[7] + "\n");
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

        // Scans through the given file
        // and creates songs with
        // titles, artists, years, and
        // genres
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
        // Creates an empty list and starts scanning through the provided
        // file
        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner survey = new Scanner(new File(file));
        survey.nextLine();

        // Creates strings to search through the file for
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

        // Scans through each line of the provided file
        while (survey.hasNextLine()) {
            // Sets up a scanner for the provided line
            Scanner lineScanner = new Scanner(survey.nextLine());
            lineScanner.useDelimiter(",");
            int studentID = Integer.parseInt(lineScanner.next());
            String time = lineScanner.next();
            MajorEnum major;
            RegionEnum region;
            HobbyEnum hobby;
            LinkedList<String[]> responses = new LinkedList<String[]>();

            // Checks the major of the person
            // and sets the major variable accordingly
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

            // Checks the region of the person
            // and sets the region variable accordingly
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

            // Checks the hobby of the person
            // and updates the hobby variable
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

            // Continues looking at each person's responses
            // to whether they've heard the songs or liked them
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

            // Discards the person's information if they
            // do not have a correct major, hobby, or region
            if (hobby != HobbyEnum.UNKNOWN && major != MajorEnum.UNKNOWN
                && region != RegionEnum.UNKNOWN) {
                studentList.add(new Student(studentID, time, hobby, major,
                    region, responses));
            }
        }
        survey.close();
        return studentList;
    }
}
