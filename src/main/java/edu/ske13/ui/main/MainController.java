package edu.ske13.ui.main;

import edu.ske13.exception.NotImplementedException;

import java.awt.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 14/Nov/2017 - 20:44
 */
public class MainController {
    private MainView view;
    
    public MainController() {
        if (view == null) view = MainView.getView();
    }
    
    public void start(Point point) {
        handleInputIP();
        handleInputHost();
        handleEnterKey();
        
        MainView.run(point);
    }
    
    public void startCenter() {
        MainView.run();
    }
    
    public void stop() {
        MainView.end();
    }
    
    /**
     * Add {@link java.awt.event.KeyListener} too validate code
     */
    public void handleInputIP() {
        throw new NotImplementedException();
    }
    
    public void handleInputHost() {
        throw new NotImplementedException();
    }
    
    public void handleEnterKey() {
        throw new NotImplementedException();
    }
}
