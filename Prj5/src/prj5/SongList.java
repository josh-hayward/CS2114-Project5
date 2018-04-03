// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Joshua Hayward (jhayward)

/*
 * TODO: sortArtist(): void
 * TODO: sortGenre(): void
 * TODO: sortTitle(): void
 * TODO: sortYear(): void
 * TODO: toString(): String - only implement if it's different from LinkedList
 */

package prj5;

/**
 * this class is an extension of LinkedList that only stores Songs. It has
 * several sort fuctions unique to Songs.
 * 
 * @author Josh Hayward
 * @version 04.02.2018
 */
public class SongList extends LinkedList<Song> {

    /**
     * the SongList constructor
     */
    public SongList() {
        super();
    }
    
    /**
     * uses a simple insertion sort to sort the list by artist name
     */
    public void sortBy() {
        for (int i = 0; i < size(); i++) {
            Song currentSong = getNodeAt(i).getData();
            remove(i);
            for (int j = 0; j < i; j++) {
                if (currentSong.getArtist().compareTo(getNodeAt(j).getData().getArtist()) < 0) {
                    add(j, currentSong);
                    break;
                }
            }
        }
    }
}
