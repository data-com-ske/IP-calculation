package edu.ske13.ui;

import edu.ske13.ui.main.MainController;

public class Test {
    public static void main(String[] args) {
        MainController controller = new MainController();
        
        controller.start(null); /* default point 0,0 */
        
        // controller.start(new Point(15, 155)); /* fix point 15,155 */
        
        // controller.startCenter(); /* center of screen */
    }
}
