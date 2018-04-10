// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
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
 * @version 04.09.2018
 */
public class GUIGlyph {

    private Window window;
    private TextShape title;
    private TextShape artist;
    private Shape L1;
    private Shape L2;
    private Shape L3;
    private Shape L4;
    private Shape R1;
    private Shape R2;
    private Shape R3;
    private Shape R4;
    private Shape axis;
    // top-center of the glyph
    private int x0;
    private int y0;
    private int width;
    private int height;
    private int barHeight;
    private int barFullWidth;


    /**
     * constructor for GUIGlyph
     * 
     * @param window
     *            the main window
     * @param x
     *            x coordinate of the center of the glyph
     * @param y
     *            y coordinate of the center of the glyph
     * @param song
     *            song to be represented by the glyph
     * @param percentages
     *            the numbers representing the length of each bar
     */
    public GUIGlyph(
        Window window,
        int x,
        int y,
        Song song,
        double[] percentages) {
        this.window = window;
        width = (int)((window.getGraphPanelWidth()
            - GUIMusicWindow.LEGEND_WIDTH) / 3 - 2
                * GUIMusicWindow.SHAPE_BUFFER);
        height = (int)(window.getGraphPanelHeight() / 3 - 2
            * GUIMusicWindow.SHAPE_BUFFER);
        x0 = x;
        y0 = (int)(y - height / 2);
        barHeight = (int)((height - 2 * GUIMusicWindow.TEXT_HEIGHT - 3
            * GUIMusicWindow.TEXT_SPACING) / 4);

        title = new TextShape(0, 0, song.getTitle());
        title.setBackgroundColor(Color.WHITE);
        artist = new TextShape(0, 0, song.getArtist());
        artist.setBackgroundColor(Color.WHITE);
        axis = new Shape(0, 0, barHeight / 2, 4 * barHeight, Color.BLACK);

        barFullWidth = (int)((width - axis.getWidth()) / 2);
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
     * draws every shape in the glyph
     */
    public void draw() {
        window.addShape(title);
        title.moveTo((int)(x0 - title.getWidth() / 2), y0
            + GUIMusicWindow.TEXT_SPACING);
        window.addShape(artist);
        artist.moveTo((int)(x0 - artist.getWidth() / 2), y0
            + GUIMusicWindow.TEXT_HEIGHT + GUIMusicWindow.TEXT_SPACING);
        window.addShape(L1);
        L1.moveTo((int)(x0 - axis.getWidth() / 2 - L1.getWidth()), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING);
        window.addShape(L2);
        L2.moveTo((int)(x0 - axis.getWidth() / 2 - L2.getWidth()), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING
            + barHeight);
        window.addShape(L3);
        L3.moveTo((int)(x0 - axis.getWidth() / 2 - L3.getWidth()), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING + 2
                * barHeight);
        window.addShape(L4);
        L4.moveTo((int)(x0 - axis.getWidth() / 2 - L4.getWidth()), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING + 3
                * barHeight);
        window.addShape(R1);
        R1.moveTo((int)(x0 + axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING);
        window.addShape(R2);
        R2.moveTo((int)(x0 + axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING
            + barHeight);
        window.addShape(R3);
        R3.moveTo((int)(x0 + axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING + 2
                * barHeight);
        window.addShape(R4);
        R4.moveTo((int)(x0 + axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING + 3
                * barHeight);
        window.addShape(axis);
        axis.moveTo((int)(x0 - axis.getWidth() / 2), y0 + 2
            * GUIMusicWindow.TEXT_HEIGHT + 2 * GUIMusicWindow.TEXT_SPACING);
    }
}
