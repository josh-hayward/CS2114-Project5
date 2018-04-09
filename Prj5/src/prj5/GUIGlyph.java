package prj5;

import CS2114.Shape;
import CS2114.TextShape;

public class GUIGlyph extends Shape {

    private Song song;
    private TextShape title;
    private Shape axis;
    private Shape L1;
    private Shape L2;
    private Shape L3;
    private Shape L4;
    private Shape R1;
    private Shape R2;
    private Shape R3;
    private Shape R4;
    
    /**
     * constructor for GUIGlyph
     * @param x x coordinate of the center of the glyph
     * @param y y coordinate of the center of the glyph
     * @param song song to be represented by the glyph
     * @param category how to represent the data
     */
    public GUIGlyph(int x, int y, Song song, CategoryEnum category) {
        super(0, 0);
    }
}
