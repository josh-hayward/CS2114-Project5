// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Farina (farinaa)

package prj5;

import student.TestCase;

/**
 * This class tests all the methods in the Song class to ensure they all work
 * as intended.
 * 
 * @author Anthony Farina (farinaa)
 * @version 2018.04.09
 */
public class SongTest extends TestCase {

    /**
     * Declare the Song objects to be tested on.
     */
    private Song song1;
    private Song song2;
    private Song nullSong;


    /**
     * Initialize the Song objects for testing.
     */
    public void setUp() {
        song1 = new Song("Tyler, The Creator", "Hip Hop", "Boredom", 2017, 1);
        song2 = new Song("Mr. Bungle", "Indie", "Retrovertigo", 1999, 2);
    }


    /**
     * Tests the getArtist method in the Song class to ensure it works as
     * intended.
     */
    public void testGetArtist() {
        assertEquals("Tyler, The Creator", song1.getArtist());

        assertEquals("Mr. Bungle", song2.getArtist());
    }


    /**
     * Tests the getGenre method in the Song class to ensure it works as
     * intended.
     */
    public void testGetGenre() {
        assertEquals("Hip Hop", song1.getGenre());

        assertEquals("Indie", song2.getGenre());
    }


    /**
     * Tests the getTitle method in the Song class to ensure it works as
     * intended.
     */
    public void testGetTitle() {
        assertEquals("Boredom", song1.getTitle());

        assertEquals("Retrovertigo", song2.getTitle());
    }


    /**
     * Tests the getYear method in the Song class to ensure it works as
     * intended.
     */
    public void testGetYear() {
        assertEquals(2017, song1.getYear());

        assertEquals(1999, song2.getYear());
    }


    /**
     * Tests the getSongID method in the Song class to ensure it works as
     * intended.
     */
    public void testGetSongID() {
        assertEquals(1, song1.getSongID());

        assertEquals(2, song2.getSongID());
    }


    /**
     * Tests the toString method in the Song class to ensure it works as
     * intended.
     */
    public void testToString() {
        assertEquals("Song Title: Boredom\nSong Artist: Tyler, The Creator\n"
            + "Song Genre: Hip Hop\nSong Year: 2017", song1.toString());

        assertEquals("Song Title: Retrovertigo\nSong Artist: Mr. Bungle\n"
            + "Song Genre: Indie\nSong Year: 1999", song2.toString());
    }
    
    /**
     * tests the equals method in the Song class to ensure it works as intended
     */
    public void testEquals() {
        assertFalse(song1.equals(nullSong));
        assertTrue(song1.equals(song1));
        assertFalse(song1.equals(1));
        assertFalse(song1.equals(song2));
        assertFalse(song1.equals(new Song("Tony, "
            + "The Creator", "Hip Hop", "Boredom", 2017, 3)));
        assertFalse(song1.equals(new Song("Tyler, "
            + "The Creator", "Classical", "Boredom", 2017, 3)));
        assertFalse(song1.equals(new Song("Tyler, "
            + "The Creator", "Hip Hop", "Death of a Bachelor", 2017, 3)));
        assertFalse(song1.equals(new Song("Tyler, "
            + "The Creator", "Hip Hop", "Boredom", 1999, 3)));
        assertTrue(song1.equals(new Song("Tyler, "
            + "The Creator", "Hip Hop", "Boredom", 2017, 3)));
    }
}
