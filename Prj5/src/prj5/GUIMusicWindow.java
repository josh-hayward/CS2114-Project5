// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

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
        songs.sortBy(SortTypeEnum.ARTIST);
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
        songs.sortBy(SortTypeEnum.GENRE);
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
        songs.sortBy(SortTypeEnum.TITLE);
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
        songs.sortBy(SortTypeEnum.YEAR);
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
        window.removeAllShapes();
        legend.draw();
        int index;
        int xcor;
        int ycor;
        double[] percentages = { 0.5, 0.7, 0.6, 1, 0.4, 0.7, 0.2, 1 };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                index = currentPage * 9 + i * 3 + j;
                if (index < songs.size()) {
                    xcor = (2 * i + 1) * (window.getGraphPanelWidth()
                        - LEGEND_WIDTH) / 6;
                    ycor = (2 * j + 1) * window.getGraphPanelHeight() / 6;
                    // fake percentages for now, get actual data later [heard1,
                    // heard2, heard3, heard4, liked1, liked2, liked3, liked4]
                    // (remember to use currentCategory for this)
                    GUIGlyph glyph = new GUIGlyph(window, xcor, ycor, songs
                        .getSong(index), percentages);
                    glyph.draw();
                }
            }
        }
    }
}
