package prj5;

import CS2114.Shape;
import CS2114.TextShape;

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
    
    /**
     * constructor for GUILegend.
     */
    public GUILegend() {
        super(0, 0);
    }
    
    public void updateCategory(CategoryEnum cat) {
        
    }
}
