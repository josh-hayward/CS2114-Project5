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

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * The main graphics for the program. Contains all the buttons and their
 * functionalities. Also organizes all of the graphical elements on screen.
 * 
 * @author Josh Hayward
 * @version 04.09.2018
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
     * constructor for GUIMusicWindow. creates buttons and displays the default
     * view of songs sorted by title, representing hobbies, page 1
     * 
     * @param songs
     *            the SongList to display data from
     * @param students
     *            the Student List to get data from
     */
    public GUIMusicWindow(SongList songs, LinkedList<Student> students) {
        this.songs = songs;
        this.students = students;
        window = new Window("cam1111 jhayward farinaa");
        currentPage = 0;
        currentCategory = CategoryEnum.HOBBY;

        Button previousButton = new Button("\u2190 Previous");
        previousButton.onClick(this, "clickedPrevious");
        window.addButton(previousButton, WindowSide.NORTH);
        Button sortArtist = new Button("Sort By Artist Name");
        sortArtist.onClick(this, "clickedSortArtist");
        window.addButton(sortArtist, WindowSide.NORTH);
        Button sortGenre = new Button("Sort By Genre");
        sortGenre.onClick(this, "clickedSortGenre");
        window.addButton(sortGenre, WindowSide.NORTH);
        Button sortTitle = new Button("Sort By Song Tilte");
        sortTitle.onClick(this, "clickedSortTitle");
        window.addButton(sortTitle, WindowSide.NORTH);
        Button sortYear = new Button("Sort By Release Year");
        sortYear.onClick(this, "clickedSortYear");
        window.addButton(sortYear, WindowSide.NORTH);
        Button nextButton = new Button("Next \u2192");
        nextButton.onClick(this, "clickedNext");
        window.addButton(nextButton, WindowSide.NORTH);
        Button representHobby = new Button("Represent Hobby");
        representHobby.onClick(this, "clickedRepresentHobby");
        window.addButton(representHobby, WindowSide.SOUTH);
        Button representMajor = new Button("Represent Major");
        representMajor.onClick(this, "clickedRepresentMajor");
        window.addButton(representMajor, WindowSide.SOUTH);
        Button representRegion = new Button("Represent Region");
        representRegion.onClick(this, "clickedRepresentRegion");
        window.addButton(representRegion, WindowSide.SOUTH);
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        legend = new GUILegend(window);
        legend.updateCategory(currentCategory);

        drawGlyphs();
    }


    /**
     * returns songs
     * 
     * @return songs
     */
    public SongList getSongs() {
        return songs;
    }


    /**
     * returns students
     * 
     * @return
     * 
     * @return students
     */
    public LinkedList<Student> getStudents() {
        return students;
    }


    /**
     * returns window
     * 
     * @return
     * 
     * @return window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * returns currentPage
     * 
     * @return
     * 
     * @return currentPage
     */
    public int getPage() {
        return currentPage;
    }


    /**
     * displays the previous page of glyphs. If already displaying the first
     * page, do nothing.
     * 
     * @param button
     *            the Previous button
     */
    public void clickedPrevious(Button button) {
        if (currentPage > 0) {
            currentPage--;
            drawGlyphs();
        }
    }


    /**
     * sorts the songs by artist name and then displays the new first page
     * 
     * @param button
     *            the Sort By Artist button
     */
    public void clickedSortArtist(Button button) {
        songs.sortBy(SortTypeEnum.ARTIST);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * sorts the songs by genre and then displays the new first page
     * 
     * @param button
     *            the Sort By Genre button
     */
    public void clickedSortGenre(Button button) {
        songs.sortBy(SortTypeEnum.GENRE);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * sorts the songs by title and the displays the new first page
     * 
     * @param button
     *            the Sort By Title button
     */
    public void clickedSortTitle(Button button) {
        songs.sortBy(SortTypeEnum.TITLE);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * sorts the songs by year and displays the new first page
     * 
     * @param button
     *            the Sort By Year button
     */
    public void clickedSortYear(Button button) {
        songs.sortBy(SortTypeEnum.YEAR);
        currentPage = 0;
        drawGlyphs();
    }


    /**
     * displays the next page of glyphs. If already on the last page, does
     * nothing.
     * 
     * @param button
     *            the Next button
     */
    public void clickedNext(Button button) {
        if (currentPage < songs.size() / 9) {
            currentPage++;
            drawGlyphs();
        }
    }


    /**
     * redraws glyphs and legend for hobby data
     * 
     * @param button
     *            the Represent Hobby button
     */
    public void clickedRepresentHobby(Button button) {
        currentCategory = CategoryEnum.HOBBY;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * redraws glyphs and legend for major data
     * 
     * @param button
     *            the Represent Major button
     */
    public void clickedRepresentMajor(Button button) {
        currentCategory = CategoryEnum.MAJOR;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * redraws glyphs and legend for region data
     * 
     * @param button
     *            the Represent Region button
     */
    public void clickedRepresentRegion(Button button) {
        currentCategory = CategoryEnum.REGION;
        legend.updateCategory(currentCategory);
        drawGlyphs();
    }


    /**
     * exits the window
     * 
     * @param button
     *            the Quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * redraws all glyphs to fit the current window state
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
