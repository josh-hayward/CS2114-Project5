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

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * height: 155
 * each line of text is 15, and there is a buffer of 5 between each area
 * @author Josh Hayward
 *
 */
public class GUILegend {

    private Window window;
    private TextShape title;
    private TextShape category1;
    private TextShape category2;
    private TextShape category3;
    private TextShape category4;
    private TextShape songTitle;
    private Shape axis;
    private TextShape heardLikedText;
    private Shape background;
    private Shape outline;
    // top-left corner of the legend
    int x0;
    int y0;
    
    /**
     * constructor for GUILegend.
     */
    public GUILegend(Window window) {
        this.window = window;
        title = new TextShape(0, 0, "Title");
        title.setBackgroundColor(Color.WHITE);
        category1 = new TextShape(0, 0, "Cat 1", Color.MAGENTA);
        category1.setBackgroundColor(Color.WHITE);
        category2 = new TextShape(0, 0, "Cat 2", Color.BLUE);
        category2.setBackgroundColor(Color.WHITE);
        category3 = new TextShape(0, 0, "Cat 3", Color.ORANGE);
        category3.setBackgroundColor(Color.WHITE);
        category4 = new TextShape(0, 0, "Cat 4", Color.GREEN);
        category4.setBackgroundColor(Color.WHITE);
        songTitle = new TextShape(0, 0, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        axis = new Shape(0, 0, 5, (int) (1.9 * GUIMusicWindow.LEGEND_TEXT_HEIGHT), Color.BLACK);
        heardLikedText = new TextShape(0, 0, "Heard      Likes  "); //trailing spaces intentional
        heardLikedText.setBackgroundColor(Color.WHITE);
        background = new Shape(0, 0, GUIMusicWindow.LEGEND_WIDTH - 2 * GUIMusicWindow.SHAPE_BUFFER - 4, GUIMusicWindow.LEGEND_HEIGHT - 2 * GUIMusicWindow.SHAPE_BUFFER - 4, Color.WHITE);
        outline = new Shape(0, 0, GUIMusicWindow.LEGEND_WIDTH - 2 * GUIMusicWindow.SHAPE_BUFFER, GUIMusicWindow.LEGEND_HEIGHT - 2 * GUIMusicWindow.SHAPE_BUFFER, Color.BLACK);
        updateCategory(CategoryEnum.HOBBY);
        draw();
    }

    public void draw() {
        x0 = window.getWidth() - GUIMusicWindow.LEGEND_WIDTH - GUIMusicWindow.SHAPE_BUFFER;
        y0 = window.getHeight() - GUIMusicWindow.LEGEND_HEIGHT - GUIMusicWindow.SHAPE_BUFFER - 100; //note the bottom menu bar is 100 pixels tall
        
        window.addShape(title);
        moveShape(title, true, 0, 1);
        window.addShape(category1);
        moveShape(category1, false, 1, 2);
        window.addShape(category2);
        moveShape(category2, false, 2, 2);
        window.addShape(category3);
        moveShape(category3, false, 3, 2);
        window.addShape(category4);
        moveShape(category4, false, 4, 2);
        window.addShape(songTitle);
        moveShape(songTitle, true, 5, 3);
        window.addShape(axis);
        moveShape(axis, true, 6, 3);
        window.addShape(heardLikedText);
        moveShape(heardLikedText, true, 6.4, 3);
        window.addShape(background);
        background.moveTo(x0 + 2, y0 + 2);
        window.addShape(outline);
        outline.moveTo(x0,  y0);
    }
    
    private void moveShape(Shape shape, boolean isCentered, double aboveText, int aboveSpacing) {
        int x;
        int y;
        if (isCentered) {
            x = (int) (x0 + GUIMusicWindow.LEGEND_WIDTH / 2 - shape.getWidth() / 2 - GUIMusicWindow.SHAPE_BUFFER);
        }
        else {
            x = x0 + GUIMusicWindow.LEGEND_TEXT_SPACING;
        }
        y = (int) (y0 + aboveText * GUIMusicWindow.LEGEND_TEXT_HEIGHT + aboveSpacing * GUIMusicWindow.LEGEND_TEXT_SPACING);
        shape.moveTo(x, y);
    }

    public void updateCategory(CategoryEnum category) {
        switch (category) {
            case HOBBY:
                title.setText("Hobby Legend");
                category1.setText("Read");
                category2.setText("Art");
                category3.setText("Sports");
                category4.setText("Music");
            case MAJOR:
                title.setText("Major Legend");
                category1.setText("Computer Science");
                category2.setText("Engineering");
                category3.setText("Math/CMDA");
                category4.setText("Other");
            case REGION:
                title.setText("Region Legend");
                category1.setText("Northeast US");
                category2.setText("Southeast US");
                category3.setText("US (other)");
                category4.setText("Outside of US");
            default:
                title.setText("Hobby Legend");
                category1.setText("Read");
                category2.setText("Art");
                category3.setText("Sports");
                category4.setText("Music");
        }
    }
}
