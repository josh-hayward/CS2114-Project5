package prj5;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

public class GUITestClass {

    public static void main(String[] args) {
        
        Song testSong = new Song("artist", "genre", "title", 2018, 0);
        SongList testSongList = new SongList();
        for (int i = 0; i < 10; i++) {
            testSongList.add(testSong);
        }
        LinkedList<Student> testStudentList = new LinkedList<Student>();
        LinkedList<String[]> testResponses = new LinkedList<String[]>();
        String[] testResponse = {"yes", "yes"};
        testResponses.add(testResponse);
        testStudentList.add(new Student(0, "time", HobbyEnum.ART, MajorEnum.CS, RegionEnum.NON_US, testResponses));
        GUIMusicWindow testWindow = new GUIMusicWindow(testSongList, testStudentList);
        
        
        /**
        Window window = new Window();
        Button button = new Button();
        Button button2 = new Button();
        window.addButton(button, WindowSide.NORTH);
        window.addButton(button2, WindowSide.SOUTH);
        Shape shape = new Shape(window.getGraphPanelWidth() - 100, window.getGraphPanelHeight() - 50, 100, 50);
        window.addShape(shape);
        */
    }
}
