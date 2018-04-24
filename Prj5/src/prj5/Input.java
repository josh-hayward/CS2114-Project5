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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class runs the main method which collects the input data
 * 
 * @author Cameron Moore (cam1111)
 * @version 2018.04.01
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
        LinkedList<Student> studentList;
        SongList songList;
        if (args.length != 0)
        {
            studentList = scanSurvey(args[0]);
            songList = scanSongList(args[1]);
            songList.sortBy(SortTypeEnum.ARTIST);
        }
        else
        {
            studentList = scanSurvey("MusicSurveyData2018S.csv");
            songList = scanSongList("SongList2018S.csv");
            songList.sortBy(SortTypeEnum.ARTIST);
        }
        GUIMusicWindow window = new GUIMusicWindow(songList, studentList);
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
        LinkedList<double[]> percentages)
    {
        for (int i = 0; i < songList.size(); i++)
        {
            Song curr = songList.getNodeAt(i).getData();
            System.out.println(curr.toString());
            double[] currResponse = percentages.getNodeAt(i).getData();
            
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
            if (hobby != HobbyEnum.UNKNOWN && major != MajorEnum.UNKNOWN && 
                region != RegionEnum.UNKNOWN) {
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
    public static LinkedList<double[]> representHobbies(LinkedList<Student> 
        studentList, SongList songList)
    {     
        LinkedList<double[]> percentages = new LinkedList<double[]>();
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
                        
            double[] hobbyPercentages = {(heardReading/heardTotalReading),
                                        (likesReading/likesReadingTotal), 
                                        (heardArt/heardTotalArt), 
                                        (likesArt/likesArtTotal),
                                        (heardSports/heardTotalSports),
                                        (likesSports/likesSportsTotal),
                                        (heardMusic/heardTotalMusic),
                                        (likesMusic/likesMusicTotal)};
            percentages.add(hobbyPercentages);
        }
        return percentages;
    }
    
    /**
     * Makes a list of the responses to each song
     * as a percent. The order of the returned array
     * is CS, ENGE, MATH_CMDA, and OTHER with heard 
     * taking precedence over like for each one.
     * 
     * @param studentList The list of students 
     * @param songList The list of songs
     * @return The responses as a percent
     */
    public static LinkedList<double[]> representMajor(LinkedList<Student> 
        studentList, SongList songList)
    {     
        LinkedList<double[]> percentages = new LinkedList<double[]>();
        for (int i = 0; i < songList.size(); i++)
        {
            float heardCS = 0;
            float heardENGE = 0;
            float heardMATH_CMDA = 0;
            float heardOTHER = 0;
            float likesCS = 0;
            float likesENGE = 0;
            float likesMATH_CMDA = 0;
            float likesOTHER = 0;
            float heardTotalCS = 0;
            float heardTotalENGE = 0;
            float heardTotalMATH_CMDA = 0;
            float heardTotalOTHER = 0;
            float likesCSTotal = 0;
            float likesENGETotal = 0;
            float likesMATH_CMDATotal = 0;
            float likesOTHERTotal = 0;
            
            for (int j = 0; j < studentList.size(); j++)
            {
                LinkedList<String[]> responses = studentList.
                    getNodeAt(j).getData().getResponses();
                String[] data = responses.getNodeAt(songList.
                    getNodeAt(i).getData().getSongID()).getData();
                switch (studentList.getNodeAt(j).getData().getMajor())
                {
                    case CS:
                        if (data[0].equals("Yes"))
                        {
                            heardCS++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalCS++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesCS++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesCSTotal++;
                        }
                        break;
                    case ENGE:
                        if (data[0].equals("Yes"))
                        {
                            heardENGE++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalENGE++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesENGE++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesENGETotal++;
                        }
                        break;
                    case MATH_CMDA:
                        if (data[0].equals("Yes"))
                        {
                            heardMATH_CMDA++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalMATH_CMDA++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesMATH_CMDA++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesMATH_CMDATotal++;
                        }
                        break;
                    case OTHER:
                        if (data[0].equals("Yes"))
                        {
                            heardOTHER++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalOTHER++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesOTHER++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesOTHERTotal++;
                        }
                        break;
                    default:
                        break;
                }
            }
                        
            double[] majorPercentages = {(heardCS/heardTotalCS),
                                        (likesCS/likesCSTotal), 
                                        (heardENGE/heardTotalENGE), 
                                        (likesENGE/likesENGETotal),
                                        (heardMATH_CMDA/heardTotalMATH_CMDA),
                                        (likesMATH_CMDA/likesMATH_CMDATotal),
                                        (heardOTHER/heardTotalOTHER),
                                        (likesOTHER/likesOTHERTotal)};
            percentages.add(majorPercentages);
        }
        return percentages;
    }
    
    
    /**
     * Makes a list of the responses to each song
     * as a percent. The order of the returned array
     * is Northeast, Southeast, US, or Non_US with heard 
     * taking precedence over like for each one.
     * 
     * @param studentList The list of students 
     * @param songList The list of songs
     * @return The responses as a percent
     */
    public static LinkedList<double[]> representRegion(LinkedList<Student> 
        studentList, SongList songList)
    {     
        LinkedList<double[]> percentages = new LinkedList<double[]>();
        for (int i = 0; i < songList.size(); i++)
        {
            float heardNortheast = 0;
            float heardSoutheast = 0;
            float heardUS = 0;
            float heardNon_US = 0;
            float likesNortheast = 0;
            float likesSoutheast = 0;
            float likesUS = 0;
            float likesNon_US = 0;
            float heardTotalNortheast = 0;
            float heardTotalSoutheast = 0;
            float heardTotalUS = 0;
            float heardTotalNon_US = 0;
            float likesNortheastTotal = 0;
            float likesSoutheastTotal = 0;
            float likesUSTotal = 0;
            float likesNon_USTotal = 0;
            
            for (int j = 0; j < studentList.size(); j++)
            {
                LinkedList<String[]> responses = studentList.
                    getNodeAt(j).getData().getResponses();
                String[] data = responses.getNodeAt(songList.
                    getNodeAt(i).getData().getSongID()).getData();
                switch (studentList.getNodeAt(j).getData().getRegion())
                {
                    case NORTHEAST:
                        if (data[0].equals("Yes"))
                        {
                            heardNortheast++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalNortheast++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesNortheast++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesNortheastTotal++;
                        }
                        break;
                    case SOUTHEAST:
                        if (data[0].equals("Yes"))
                        {
                            heardSoutheast++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalSoutheast++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesSoutheast++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesSoutheastTotal++;
                        }
                        break;
                    case US:
                        if (data[0].equals("Yes"))
                        {
                            heardUS++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalUS++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesUS++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesUSTotal++;
                        }
                        break;
                    case NON_US:
                        if (data[0].equals("Yes"))
                        {
                            heardNon_US++;
                        }
                        if (!data[0].equals(""))
                        {
                            heardTotalNon_US++;
                        }
                        if (data[1].equals("Yes"))
                        {
                            likesNon_US++;
                        }
                        if (!data[1].equals(""))
                        {
                            likesNon_USTotal++;
                        }
                        break;
                    default:
                        break;
                }
            }
                        
            double[] majorPercentages = {(heardNortheast/heardTotalNortheast),
                                        (likesNortheast/likesNortheastTotal), 
                                        (heardSoutheast/heardTotalSoutheast), 
                                        (likesSoutheast/likesSoutheastTotal),
                                        (heardUS/heardTotalUS),
                                        (likesUS/likesUSTotal),
                                        (heardNon_US/heardTotalNon_US),
                                        (likesNon_US/likesNon_USTotal)};
            percentages.add(majorPercentages);
        }
        return percentages;
    }
    
}
