// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Cameron Moore (cam1111)
// -- Anthony Farina (farinaa)
// -- Joshua Hayward (jhayward)

package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * Creates and organizes the Shapes in each glyph. Defaults and constants stored
 * in GUIMusicWindow
 * 
 * @author Josh Hayward
 * @version 2018.04.10
 */
public class GUIGlyph {

    // the window the glyph is in
    private Window window;
    // text shapes at the top of the glyph
    private TextShape title;
    private TextShape artist;
    // shapes representing the 8 data bars in a glyph
    private Shape L1;
    private Shape L2;
    private Shape L3;
    private Shape L4;
    private Shape R1;
    private Shape R2;
    private Shape R3;
    private Shape R4;
    // black bar in the center of the glyph
    private Shape axis;
    // coordinates of the top-center of the glyph
    private int x0;
    private int y0;
    // dimensions of the entire glyph shape
    private int width;
    private int height;
    // dimensions of the data bars in the glyph (the actual width of each will
    // be some fraction of the full width, determined by the data being
    // represented)
    private int barHeight;
    private int barFullWidth;


    /**
     * Constructor for GUIGlyph.
     * 
     * @param window
     *            The main window.
     * @param x
     *            X coordinate of the center of the glyph.
     * @param y
     *            Y coordinate of the center of the glyph.
     * @param song
     *            Song to be represented by the glyph.
     * @param percentages
     *            The numbers representing the length of each bar.
     */
    public GUIGlyph(
        Window window,
        int x,
        int y,
        Song song,
        double[] percentages) {

        this.window = window;
        // width is 1/3 of the window width, not including the legend
        width = (int)((window.getGraphPanelWidth()
            - GUIMusicWindow.LEGEND_WIDTH) / 3 - 2
                * GUIMusicWindow.SHAPE_BUFFER);
        // height is 1/3 of the window height
        height = (int)(window.getGraphPanelHeight() / 3 - 2
            * GUIMusicWindow.SHAPE_BUFFER);
        // (x0, y0) are the top-center coordinates, but the constructor inputs
        // (x, y) are the middle-center
        x0 = x;
        y0 = (int)(y - height / 2);
        // bar height is 1/4 of the glyph height, not including the space the
        // text occupies
        barHeight = (int)((height - 2 * GUIMusicWindow.TEXT_HEIGHT - 3
            * GUIMusicWindow.TEXT_SPACING) / 4);

        // create title and artist text shapes, and the axis shape, they will be
        // moved into place by the draw method
        title = new TextShape(0, 0, song.getTitle());
        title.setBackgroundColor(Color.WHITE);
        artist = new TextShape(0, 0, song.getArtist());
        artist.setBackgroundColor(Color.WHITE);
        axis = new Shape(0, 0, barHeight / 2, 4 * barHeight, Color.BLACK);

        // full bar width is 1/2 of the glyph width, not including the space
        // occupied by the axis
        barFullWidth = (int)((width - axis.getWidth()) / 2);
        // each bar's width is determined by the given list of percentages
        L1 = new Shape(0, 0, (int)(percentages[0] * barFullWidth), barHeight,
            Color.MAGENTA);
        L2 = new Shape(0, 0, (int)(percentages[1] * barFullWidth), barHeight,
            Color.BLUE);
        L3 = new Shape(0, 0, (int)(percentages[2] * barFullWidth), barHeight,
            Color.ORANGE);
        L4 = new Shape(0, 0, (int)(percentages[3] * barFullWidth), barHeight,
            Color.GREEN);
        R1 = new Shape(0, 0, (int)(percentages[4] * barFullWidth), barHeight,
            Color.MAGENTA);
        R2 = new Shape(0, 0, (int)(percentages[5] * barFullWidth), barHeight,
            Color.BLUE);
        R3 = new Shape(0, 0, (int)(percentages[6] * barFullWidth), barHeight,
            Color.ORANGE);
        R4 = new Shape(0, 0, (int)(percentages[7] * barFullWidth), barHeight,
            Color.GREEN);

        draw();
    }


    /**
     * Draws every shape in the glyph.
     */
    public void draw() {
        // draw the title at the top center of the glyph
        window.addShape(title);
        title.moveTo((int)(x0 - title.getWidth() / 2), y0
            + GUIMusicWindow.TEXT_SPACING);
        // draw the artist name at the top center, below the title
        window.addShape(artist);
        artist.moveTo((int)(x0 - artist.getWidth() / 2), y0
            + GUIMusicWindow.TEXT_HEIGHT + GUIMusicWindow.TEXT_SPACING);
        // draw the left shapes on the left side of the bar
        Shape[] leftShapes = { L1, L2, L3, L4 };
        for (int i = 0; i < 4; i++) {
            Shape shape = leftShapes[i];
            window.addShape(shape);
            shape.moveTo((int)(x0 - axis.getWidth() / 2 - shape.getWidth()), y0
                + 2 * GUIMusicWindow.TEXT_HEIGHT + 2
                    * GUIMusicWindow.TEXT_SPACING + i * barHeight);
        }
        // draw the right shapes on the right side of the bar
        Shape[] rightShapes = { R1, R2, R3, R4 };
        for (int i = 0; i < 4; i++) {
            Shape shape = rightShapes[i];
            window.addShape(shape);
            shape.moveTo((int)(x0 + axis.getWidth() / 2), y0 + 2
                * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING
                + i * barHeight);
        }
        // draw the axis in the center
        window.addShape(axis);
        axis.moveTo((int)(x0 - axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING);
    }
}
