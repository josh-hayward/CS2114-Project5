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
 * This class creates a song with
 * a title, year, genre, and artist attached
 * 
 * @author Joshua Hayward (jhayward)
 * @version 04.02.2018
 */
public class Song {

    private String artist;
    private String genre;
    private String title;
    private int year;
    private int songID;


    /**
     * constructor for Song
     * 
     * @param artist
     *            the artist of the song
     * @param genre
     *            the genre of the song
     * @param title
     *            the title of the song
     * @param year
     *            the release year of the song
     * @param songID
     *            the index the song was found in the input list, and the index
     *            to look for it in the student responses
     */
    public Song(
        String artist,
        String genre,
        String title,
        int year,
        int songID) {
        this.artist = artist;
        this.genre = genre;
        this.title = title;
        this.year = year;
        this.songID = songID;
    }


    /**
     * returns the artist of the song
     * 
     * @return artist the artist of the song
     */
    public String getArtist() {
        return artist;
    }


    /**
     * returns the genre of the song
     * 
     * @return genre the genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * returns the title of the song
     * 
     * @return title the title of the song
     */
    public String getTitle() {
        return title;
    }


    /**
     * returns the year of the song
     * 
     * @return year the year of the song
     */
    public int getYear() {
        return year;
    }


    /**
     * returns the songID of the song
     * 
     * @return songID the genre of the songID
     */
    public int getSongID() {
        return songID;
    }


    /**
     * toString method returns the song information
     * 
     * @return song information
     */
    @Override
    public String toString() {
        StringBuilder song = new StringBuilder();
        song.append("Song Title: ");
        song.append(title);
        song.append("\n");
        song.append("Song Artist: ");
        song.append(artist);
        song.append("\n");
        song.append("Song Genre: ");
        song.append(genre);
        song.append("\n");
        song.append("Song Year: ");
        song.append(year);
        return song.toString();
    }
}
