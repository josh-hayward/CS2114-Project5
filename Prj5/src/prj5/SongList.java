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
     * uses a simple insertion sort to sort the list by the given song attribute
     */
    public void sortBy(SortType sortType) {
        for (int i = 0; i < size(); i++) {
            Song currentSong = getNodeAt(i).getData();
            remove(i);
            for (int j = 0; j < i; j++) {
                // case: sort by year
                if (sortType == SortType.YEAR) {
                    int curr = currentSong.getYear();
                    int other = getNodeAt(j).getData().getYear();
                    if (curr < other) {
                        add(j, currentSong);
                        break;
                    }
                }
                // case: sort by another attribute (all Strings, sort alphabetically)
                else {
                    String curr;
                    String other;
                    switch (sortType) {
                        case ARTIST:
                            curr = currentSong.getArtist();
                            other = getNodeAt(j).getData().getArtist();
                        case GENRE:
                            curr = currentSong.getGenre();
                            other = getNodeAt(j).getData().getGenre();
                        case TITLE:
                            curr = currentSong.getTitle();
                            other = getNodeAt(j).getData().getTitle();
                        default:
                            curr = currentSong.getArtist();
                            other = getNodeAt(j).getData().getArtist();
                    }
                    if (curr.compareTo(other) < 0) {
                        add(j, currentSong);
                        break;
                    }
                }
            }
        }
    }
}
