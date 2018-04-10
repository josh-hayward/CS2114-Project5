// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Anthony Farina (farinaa)

package prj5;

import student.TestCase;

/**
 * This class tests all the methods in the SongList class to ensure they all
 * work as intended.
 * 
 * @author Anthony Farina (farinaa)
 * @version 2018.04.09
 */
public class SongListTest extends TestCase {

    /**
     * Declare the SongList objects to be tested on.
     */
    private SongList songList;
    private SongList emptySongList;


    /**
     * Initialize the LinkedList objects for testing.
     */
    public void setUp() {
        songList = new SongList();
        emptySongList = new SongList();

        songList.add(new Song("G", "C", "Z", 4000, 1));
        songList.add(new Song("K", "W", "F", 2000, 2));
        songList.add(new Song("A", "A", "A", 18000, 3));
    }


    /**
     * Tests the getSong method in the SongList class to ensure it works as
     * intended.
     */
    public void testGetSong() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        Exception exception = null;
        try {
            songList.getSong(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            songList.getSong(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptySongList.getSong(1000);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the sortArtist method in the SongList class to ensure it works as
     * intended.
     */
    public void testSortArtist() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        songList.sortArtist();

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(1));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(2));
    }


    /**
     * Tests the sortGenre method in the SongList class to ensure it works as
     * intended.
     */
    public void testSortGenre() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        songList.sortGenre();

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(0));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(1));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(2));
    }


    /**
     * Tests the sortTitle method in the SongList class to ensure it works as
     * intended.
     */
    public void testSortTitle() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        songList.sortTitle();

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(2));
    }


    /**
     * Tests the sortYear method in the SongList class to ensure it works as
     * intended.
     */
    public void testSortYear() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        songList.sortYear();

        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(0));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));
    }


    /**
     * Tests the sortBy method in the SongList class to ensure it works as
     * intended.
     */
    public void testSortBy() {
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));

        songList.sortBy(SortTypeEnum.ARTIST);

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(1));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(2));

        songList.sortBy(SortTypeEnum.GENRE);

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(0));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(1));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(2));

        songList.sortBy(SortTypeEnum.TITLE);

        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(0));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(1));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(2));

        songList.sortBy(SortTypeEnum.YEAR);

        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(0));
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(1));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(2));
        
        songList.sortBy(SortTypeEnum.UNKNOWN);
        
        assertEquals(new Song("G", "C", "Z", 4000, 1), songList.getSong(0));
        assertEquals(new Song("A", "A", "A", 18000, 3), songList.getSong(1));
        assertEquals(new Song("K", "W", "F", 2000, 2), songList.getSong(2));
    }
}
