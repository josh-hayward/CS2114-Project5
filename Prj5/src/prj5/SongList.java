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
 * this class is an extension of LinkedList that only stores Songs. It has
 * several sort functions unique to Songs.
 * 
 * @author Josh Hayward
 * @author Cameron Moore (cam1111)
 * @author Anthony Farina (farinaa)
 * @version 2018.04.22
 */
public class SongList extends LinkedList<Song> {

    /**
     * the SongList constructor
     */
    public SongList() {
        super();
    }


    /**
     * returns song at given index
     * 
     * @return song at given index
     * @param index
     *            The index of the song to get
     */
    public Song getSong(int index) {
        return getNodeAt(index).getData();
    }


    /**
     * Sorts by artist
     */
    public void sortArtist() {
        sortBy(SortTypeEnum.ARTIST);
    }


    /**
     * Sorts by genre
     */
    public void sortGenre() {
        sortBy(SortTypeEnum.GENRE);
    }


    /**
     * Sorts by title
     */
    public void sortTitle() {
        sortBy(SortTypeEnum.TITLE);
    }


    /**
     * Sorts by year
     */
    public void sortYear() {
        sortBy(SortTypeEnum.YEAR);
    }


    /**
     * Creates a string representation of all the Songs and their data in the
     * list.
     * 
     * @return A string of the data for each Song in the list.
     */
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        Node<Song> curr;

        if (isEmpty()) {
            curr = null;
        }
        else {
            curr = getNodeAt(0);
        }

        while (curr != null) {
            list.append(curr.getData().toString());
            if (curr.getNextNode() != null) {
                list.append(", ");
            }
            curr = curr.getNextNode();
        }
        return list.append("]").toString();
    }


    /**
     * uses a simple insertion sort to sort the list by the given song
     * attribute, defaults to sort by artist
     * 
     * @param sortType
     *            The type to sort by, including
     *            artist, genre, title, and year
     */
    public void sortBy(SortTypeEnum sortType) {
        for (int i = 1; i < size(); ++i) {

            Song currentSong = getNodeAt(i).getData();

            int j = i - 1;

            switch (sortType) {
                case ARTIST:
                    while (j >= 0 && getNodeAt(j).getData().getArtist()
                        .toLowerCase().compareTo(currentSong.getArtist()
                            .toLowerCase()) > 0) {
                        getNodeAt(j + 1).setData(getNodeAt(j).getData());
                        j = j - 1;
                    }
                    getNodeAt(j + 1).setData(currentSong);
                    break;
                case GENRE:
                    while (j >= 0 && getNodeAt(j).getData().getGenre()
                        .compareTo(currentSong.getGenre()) > 0) {
                        getNodeAt(j + 1).setData(getNodeAt(j).getData());
                        j = j - 1;
                    }
                    getNodeAt(j + 1).setData(currentSong);
                    break;
                case TITLE:
                    while (j >= 0 && getNodeAt(j).getData().getTitle()
                        .toLowerCase().compareTo(currentSong.getTitle()
                            .toLowerCase()) > 0) {
                        getNodeAt(j + 1).setData(getNodeAt(j).getData());
                        j = j - 1;
                    }
                    getNodeAt(j + 1).setData(currentSong);
                    break;
                case YEAR:
                    while (j >= 0 && getNodeAt(j).getData()
                        .getYear() > currentSong.getYear()) {
                        getNodeAt(j + 1).setData(getNodeAt(j).getData());
                        j = j - 1;
                    }
                    getNodeAt(j + 1).setData(currentSong);
                    break;
                default:
                    sortBy(SortTypeEnum.ARTIST);
            }
        }
    }
}
