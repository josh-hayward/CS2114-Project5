// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

import java.util.Enumeration;
import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * The main graphics for the program. Contains all the buttons and their
 * functionalities. Also organizes all of the graphical elements on screen.
 * 
 * @author Josh Hayward
 * @version 2018.04.22
 */
public class GUIMusicWindow {

    private SongList songs;
    private LinkedList<Student> students;
    private Window window;
    private GUILegend legend;
    private int currentPage;
    private CategoryEnum currentCategory;
    private SortTypeEnum currentSort;
    // dimension 1: sort type
    // dimension 2: category
    // dimension 3: song
    // dimension 4: sub-category
    private double[][][] percentages;

    /**
     * The amount of additional whitespace in pixels to leave on the edges of
     * each shape. If SHAPE_BUFFER was 0, all the glyphs would be touching their
     * neighboring glyphs (and/or the legend).
     */
    public static final int SHAPE_BUFFER = 10;
    /**
     * The vertical space in pixels occupied by a line of text. If TEXT_HEIGHT
     * was 0, subsequent lines of text would appear in the same position,
     * overlapping and making them hard to read.
     */
    public static final int TEXT_HEIGHT = 16;
    /**
     * The vertical space in pixels to leave between certain lines of text. This
     * serves to differentiate some groups of text in the legend, i.e. separate
     * the legend title from the category names.
     */
    public static final int TEXT_SPACING = 5;
    /**
     * The width in pixels of the legend box.
     */
    public static final int LEGEND_WIDTH = 170;
    /**
     * The height in pixels of the legend box. It contains 8 lines of text, and
     * 4 text spacing buffers.
     */
    public static final int LEGEND_HEIGHT = 8 * TEXT_HEIGHT + 4 * TEXT_SPACING
        + 2 * SHAPE_BUFFER;


    /**
     * Constructor for GUIMusicWindow. creates buttons and displays the default
     * view of songs sorted by title, representing hobbies, page 1.
     * 
     * @param songs
     *            The SongList to display data from.
     * @param students
     *            The Student List to get data from.
     */
    public GUIMusicWindow(SongList songs, LinkedList<Student> students) {
        this.songs = songs;
        this.students = students;
        window = new Window("cam1111 jhayward farinaa");
        currentPage = 0;
        currentCategory = CategoryEnum.HOBBY;
        currentSort = SortTypeEnum.TITLE;
        percentages = generatePercentages();

        // create and add the Previous button (\u2190 is a unicode arrow)
        Button previousButton = new Button("\u2190 Previous");
        previousButton.onClick(this, "clickedPrevious");
        window.addButton(previousButton, WindowSide.NORTH);
        // create and add the Sort By Artist Button
        Button sortArtist = new Button("Sort By Artist Name");
        sortArtist.onClick(this, "clickedSortArtist");
        window.addButton(sortArtist, WindowSide.NORTH);
        // create and add the Sort By Genre button
        Button sortGenre = new Button("Sort By Genre");
        sortGenre.onClick(this, "clickedSortGenre");
        window.addButton(sortGenre, WindowSide.NORTH);
        // create and add the Sort By Title button
        Button sortTitle = new Button("Sort By Song Tilte");
        sortTitle.onClick(this, "clickedSortTitle");
        window.addButton(sortTitle, WindowSide.NORTH);
        // create and add the Sort By Year button
        Button sortYear = new Button("Sort By Release Year");
        sortYear.onClick(this, "clickedSortYear");
        window.addButton(sortYear, WindowSide.NORTH);
        // create and add the Next button (\u2192 is a unicode arrow)
        Button nextButton = new Button("Next \u2192");
        nextButton.onClick(this, "clickedNext");
        window.addButton(nextButton, WindowSide.NORTH);
        // create and add the Represent Hobby button
        Button representHobby = new Button("Represent Hobby");
        representHobby.onClick(this, "clickedRepresentHobby");
        window.addButton(representHobby, WindowSide.SOUTH);
        // create and add the Represent Major button
        Button representMajor = new Button("Represent Major");
        representMajor.onClick(this, "clickedRepresentMajor");
        window.addButton(representMajor, WindowSide.SOUTH);
        // create and add the Represent Region button
        Button representRegion = new Button("Represent Region");
        representRegion.onClick(this, "clickedRepresentRegion");
        window.addButton(representRegion, WindowSide.SOUTH);
        // create and add the Quit button
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        // create the legend
        legend = new GUILegend(window);
        legend.updateCategory(currentCategory);

        drawGlyphs();
    }


    /**
     * Returns songs.
     * 
     * @return songs
     */
    public SongList getSongs() {
        return songs;
    }


    /**
     * Returns students.
     * 
     * 
     * @return students
     */
    public LinkedList<Student> getStudents() {
        return students;
    }


    /**
     * Returns window.
     * 
     * @return window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * Returns currentPage.
     * 
     * @return currentPage
     */
    public int getPage() {
        return currentPage;
    }


    /**
     * Displays the previous page of glyphs. If already displaying the first
     * page, do nothing.
     * 
     * @param button
     *            The Previous button.
     */
    public void clickedPrevious(Button button) {
        if (currentPage > 0) {
            currentPage--;
            drawGlyphs();
        }
    }


    /**
     * Sorts the songs by artist name and then displays the new first page.
     * 
     * @param button
     *            The Sort By Artist button.
     */
    public void clickedSortArtist(Button button) {
        currentSort = SortTypeEnum.ARTIST;
        songs.sortBy(currentSort);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * Sorts the songs by genre and then displays the new first page.
     * 
     * @param button
     *            The Sort By Genre button.
     */
    public void clickedSortGenre(Button button) {
        currentSort = SortTypeEnum.GENRE;
        songs.sortBy(currentSort);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * Sorts the songs by title and the displays the new first page.
     * 
     * @param button
     *            The Sort By Title button.
     */
    public void clickedSortTitle(Button button) {
        currentSort = SortTypeEnum.TITLE;
        songs.sortBy(currentSort);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * Sorts the songs by year and displays the new first page.
     * 
     * @param button
     *            The Sort By Year button.
     */
    public void clickedSortYear(Button button) {
        currentSort = SortTypeEnum.YEAR;
        songs.sortBy(currentSort);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * Displays the next page of glyphs. If already on the last page, does
     * nothing.
     * 
     * @param button
     *            The Next button.
     */
    public void clickedNext(Button button) {
        if (currentPage < songs.size() / 9) {
            currentPage++;
            drawGlyphs();
        }
    }


    /**
     * Redraws glyphs and legend for hobby data.
     * 
     * @param button
     *            The Represent Hobby button.
     */
    public void clickedRepresentHobby(Button button) {
        currentCategory = CategoryEnum.HOBBY;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * Redraws glyphs and legend for major data.
     * 
     * @param button
     *            The Represent Major button.
     */
    public void clickedRepresentMajor(Button button) {
        currentCategory = CategoryEnum.MAJOR;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * Redraws glyphs and legend for region data.
     * 
     * @param button
     *            The Represent Region button.
     */
    public void clickedRepresentRegion(Button button) {
        currentCategory = CategoryEnum.REGION;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * Exits the window.
     * 
     * @param button
     *            The Quit button.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Redraws all glyphs to fit the current window state.
     */
    public void drawGlyphs() {
        // clear the window
        window.removeAllShapes();
        // redraw the legend
        legend.draw();
        // index of the song in the sorted list
        int index;
        // coordinates of the center of the glyph
        int xcor;
        int ycor;
        // iterate through each row and column
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                // calculate the index of the appropriate song for this position
                index = currentPage * 9 + row * 3 + col;
                // if it's a valid index, create the glyph
                if (index < songs.size()) {
                    // calculate x coordinate using the column number
                    xcor = (2 * col + 1) * (window.getGraphPanelWidth()
                        - LEGEND_WIDTH) / 6;
                    // calculate y coordinate using the row number
                    ycor = (2 * row + 1) * window.getGraphPanelHeight() / 6;
                    GUIGlyph glyph = new GUIGlyph(window, xcor, ycor, songs
                        .getSong(index), getPercentages(songs.getSong(index)
                            .getSongID()));
                    glyph.draw();
                }
            }
        }
    }


    /**
     * Helper method for drawGlyph. Uses the sort type, category, and song to
     * retrieve the corresponding percentage values from the master list.
     * 
     * @return an array of 8 percentages corresponding to the song
     */
    private double[] getPercentages(int songID) {
        // get int representation of category
        int categoryNum;
        switch (currentCategory) {
            case HOBBY:
                categoryNum = 0;
                break;
            case MAJOR:
                categoryNum = 1;
                break;
            case REGION:
                categoryNum = 2;
                break;
            default:
                categoryNum = 0;
        }

        return percentages[categoryNum][songID];
    }


    /**
     * Helper method for the constructor. Stores heard/liked percentages in a 3D
     * array so they can be efficiently retrieved.
     * 
     * @return an array organized as so: [category (3x)][Song (?x)][percent
     *         (8x)]
     */
    private double[][][] generatePercentages() {

        // initialize the final array of percentages
        double[][][] allPercentages = new double[3][songs.size()][8];

        // one row for each category - Hobby, Major, Region
        for (int categoryNum = 0; categoryNum < 3; categoryNum++) {
            // one column for each song
            for (int songNum = 0; songNum < songs.size(); songNum++) {
                // initialize counters for heard/liked totals
                int[] heardCounter = new int[4];
                int[] likedCounter = new int[4];
                int[] heardTotal = new int[4];
                int[] likedTotal = new int[4];
                // iterate through each student to get heard/liked totals
                for (int studentNum = 0; studentNum < students
                    .size(); studentNum++) {
                    // store the current student
                    Student student = students.getNodeAt(studentNum).getData();

                    // store the student's sub-category number for the current
                    // category
                    int subCategoryNum = subCategoryNums(student)[categoryNum];
                    // if the student has a valid sub-category
                    if (subCategoryNum >= 0) {
                        // store the student's response to the current song
                        String[] songResponse = student.getResponses()
                            .getNodeAt(songNum).getData();
                        // if the 'heard' response isn't blank, increment
                        // heardTotal for the student's sub-category
                        if (!songResponse[0].equals("")) {
                            // if the 'heard' response is 'Yes', also increment
                            // heardCounter for the student's sub-category
                            if (songResponse[0].equals("Yes")) {
                                heardCounter[subCategoryNum]++;
                            }
                            heardTotal[subCategoryNum]++;
                        }
                        // if the 'liked' response isn't blank, increment
                        // likedTotal for the student's sub-category
                        if (!songResponse[1].equals("")) {
                            if (songResponse[1].equals("Yes")) {
                                // if the 'liked' response is 'Yes', also
                                // increment likedCounter for the student's
                                // sub-category
                                likedCounter[subCategoryNum]++;
                            }
                            likedTotal[subCategoryNum]++;
                        }
                    }
                }
                // calculate heard/liked percentages for each sub-category
                for (int subCategoryNum =
                    0; subCategoryNum < 4; subCategoryNum++) {
                    // avoid divide-by-zero errors
                    if (heardTotal[subCategoryNum] > 0) {
                        // heard percentages are the first 4 values
                        allPercentages[categoryNum][songNum][subCategoryNum] =
                            (double)heardCounter[subCategoryNum]
                                / heardTotal[subCategoryNum];
                    }
                    // avoid divide-by-zero errors
                    if (likedTotal[subCategoryNum] > 0) {
                        // and liked percentages are the last 4
                        allPercentages[categoryNum][songNum][subCategoryNum
                            + 4] = (double)likedCounter[subCategoryNum]
                                / likedTotal[subCategoryNum];
                    }
                }
            }
        }

        return allPercentages;
    }


    /**
     * helper method for getPercentages, returns an int representation of the
     * student's [hobby, major, region]
     * 
     * @param student
     *            the student to get the subCategories from
     * @return [hobbyNum, majorNum, regionNum], -1 for a value if the response
     *         is not recognized
     */
    private int[] subCategoryNums(Student student) {
        int hobbyNum;
        switch (student.getHobby()) {
            case READ:
                hobbyNum = 0;
                break;
            case ART:
                hobbyNum = 1;
                break;
            case SPORTS:
                hobbyNum = 2;
                break;
            case MUSIC:
                hobbyNum = 3;
                break;
            default:
                hobbyNum = -1;
        }
        int majorNum;
        switch (student.getMajor()) {
            case CS:
                majorNum = 0;
                break;
            case ENGE:
                majorNum = 1;
                break;
            case MATH_CMDA:
                majorNum = 2;
                break;
            case OTHER:
                majorNum = 3;
                break;
            default:
                majorNum = -1;
        }
        int regionNum;
        switch (student.getRegion()) {
            case NORTHEAST:
                regionNum = 0;
                break;
            case SOUTHEAST:
                regionNum = 1;
                break;
            case US:
                regionNum = 2;
                break;
            case NON_US:
                regionNum = 3;
                break;
            default:
                regionNum = -1;
        }

        int[] subCategories = { hobbyNum, majorNum, regionNum };
        return subCategories;
    }
}
