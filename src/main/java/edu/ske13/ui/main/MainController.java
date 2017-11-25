package edu.ske13.ui.main;

import edu.ske13.objects.IPAddress;
import edu.ske13.utils.IPUtils;

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
        handleEnterKey();
        
        MainView.run(point);
    }
    
    public void startCenter() {
        MainView.run();
    }
    
    public void stop() {
        MainView.end();
    }
    
    public void handleEnterKey() {
        view.addButtonListener(e -> {
            IPAddress ip = IPUtils.newIPAddress(view.getIP(), true);
            MainView.InputType t = view.getInputType();
            int number = view.getHostOrSubnetNumber();
            
            // view.appendTable();
        });
    }
}
