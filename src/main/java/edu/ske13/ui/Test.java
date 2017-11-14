package edu.ske13.ui;

import edu.ske13.ui.main.MainView;
import edu.ske13.utils.ui.Display;

public class Test {
    public static void main(String[] args) {
        //********* run main on top left corner *********//
        // MainView.run(Display.getDefaultPoint);
        
        //********* run main on center screen *********//
        MainView.run(Display.getCenterLocation(MainView.getPageSize()));
    }
}
