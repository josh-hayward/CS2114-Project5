// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

/**
 * This class creates a song with
 * a title, year, genre, and artist attached
 * 
 * @author Joshua Hayward (jhayward)
 * @version 2018.04.10
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
        return new StringBuilder("Song Title: ").append(title).append(
            "\nSong Artist: ").append(artist).append("\nSong Genre: ").append(
                genre).append("\nSong Year: ").append(year).toString();
    }


    /**
     * Checks whether the given object is a Song and checks if it has the same
     * artist, genre, title, and year as this Song.
     * 
     * @return True if the other Song is the same as this Song, false
     *         otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass().equals(obj.getClass())) {
            Song otherSong = (Song)obj;
            if (otherSong.getArtist().equals(this.getArtist()) && otherSong
                .getGenre().equals(this.getGenre()) && otherSong.getTitle()
                    .equals(this.getTitle()) && otherSong.getYear() == this
                        .getYear()) {
                return true;
            }
        }

        return false;
    }
}
