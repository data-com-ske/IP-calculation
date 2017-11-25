package edu.ske13.ui.main;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;

import javax.swing.*;
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
        handleEnterKey();
        MainView.run();
    }
    
    public void stop() {
        MainView.end();
    }
    
    public void handleEnterKey() {
        view.addEnterButtonListener(e -> {
            IPAddress ip;
            try {
                view.clearTable();
                
                ip = new IPAddress(view.getIP());
                MainView.InputType t = view.getInputType();
                int number = view.getHostOrSubnetNumber();
                
                System.out.println(ip);
                System.out.println(ip.resetIP());
                
                // TODO: add calculation logic
                // use append method to add to table
                // view.appendTable();
                
                
            } catch (IPException e1) {
                JOptionPane.showMessageDialog(null, e1.getErrorMessage(), "error code: " + e1.getErrorCode(), JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        });
    }
}
