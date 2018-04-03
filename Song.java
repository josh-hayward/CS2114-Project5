// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Joshua Hayward (jhayward)

package prj5;

public class Song {

    private String artist;
    private String genre;
    private String title;
    private int year;
    private int songID;
    
    public Song(String artist, String genre, String title, int year) {
        this.artist = artist;
        this.genre = genre;
        this.title = title;
        this.year = year;
    }

    /**
     * returns the artist of the song
     * @return artist the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * returns the genre of the song
     * @return genre the genre of the song
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returns the title of the song
     * @return title the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the year of the song
     * @return year the year of the song
     */
    public int getYear() {
        return year;
    }

    /**
     * returns the songID of the song
     * @return songID the genre of the songID
     */
    public int getSongID() {
        return songID;
    }
    
    /**
     * sets the songID for the song
     * @param id the songID for the song
     */
    public void setSongID(int id) {
        songID = id;
    }
}
