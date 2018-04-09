// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor
// will I accept the actions of those who do.
// -- Joshua Hayward (jhayward)

package prj5;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class GUILegend extends Shape {

    private TextShape title;
    private Shape background;
    private TextShape category1;
    private TextShape category2;
    private TextShape category3;
    private TextShape category4;
    private TextShape songTitle;
    private Shape axis;
    private TextShape heardText;
    private TextShape likedText;
    private Shape[] shapeArray = {title, background, category1, category2,
        category3, category4, songTitle, axis, heardText, likedText };
    
    /**
     * constructor for GUILegend.
     */
    public GUILegend(Window window) {
        super(window.getWidth() - GUIMusicWindow.LEGEND_WIDTH, 0);
        title = new TextShape(0, 0, "Title");
        window.addShape(title);
        background = new Shape(0, 0);
        window.addShape(background);
        for (int i = 0; i < shapeArray.length; i++) {
            window.addShape(shapeArray[i]);
        }
        System.out.println("!!!");
    }


    public void updateCategory(CategoryEnum cat) {
        moveTo(100, 100);
    }
}
