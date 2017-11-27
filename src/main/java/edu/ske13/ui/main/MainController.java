package edu.ske13.ui.main;

import edu.ske13.constants.Base;
import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;
import edu.ske13.objects.NumberBase;
import edu.ske13.objects.SHNumber;
import edu.ske13.utils.IPUtils;

import javax.swing.*;
import java.awt.*;
import java.util.*;

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
    
    private void handleEnterKey() {
        view.addEnterButtonListener(e -> {
            IPAddress ip;
            try {
                view.clearTable();
                
                ip = new IPAddress(view.getIP()).resetIP();
                MainView.InputType t = view.getInputType();
                int number = view.getHostOrSubnetNumber();
                
                int i;
                for (i = 0; i < 33; i++) {
                    if (Math.pow(2, i) - 2 > number) break;
                }
                
                SHNumber host, subnet;
                
                if (t.equals(MainView.InputType.HOST)) {
                    host = new SHNumber(MainView.InputType.HOST, i);
                    subnet = new SHNumber(MainView.InputType.SUBNET, ip.getIPClass().getClassBit() - i);
                } else {
                    host = new SHNumber(MainView.InputType.HOST, ip.getIPClass().getClassBit() - i);
                    subnet = new SHNumber(MainView.InputType.SUBNET, i);
                }
                
                ArrayList<ArrayList<String>> data = new ArrayList<>();
                
                
                NumberBase b = new NumberBase("1" + host.returnBinary(), Base.Binary);
                for (int j = 0; j < Math.pow(2, subnet.getNumber()); j++) {
                    NumberBase bb = new NumberBase(ip.toBinaryLong(), Base.Binary);
                    
                    NumberBase nextIPNumber = new NumberBase(bb.add(b).toString(), Base.Binary);
                    
                    String next = bb.add(NumberBase.Utils.toNumberBase(1)).toString();
                    
                    String last = nextIPNumber.minus(NumberBase.Utils.toNumberBase(2)).toString();
                    
                    String broadcast = nextIPNumber.minus(NumberBase.Utils.toNumberBase(1)).toString();
                    
                    view.appendTable(ip.toString(), IPUtils.toIPAddressBinary(next, false).toString(), IPUtils.toIPAddressBinary(last, false).toString(), IPUtils.toIPAddressBinary(broadcast, false).toString());
                    // next
                    ip = IPUtils.toIPAddressBinary(nextIPNumber.toString(), false);
                }
            } catch (IPException e1) {
                JOptionPane.showMessageDialog(null, e1.getErrorMessage(), "error code: " + e1.getErrorCode(), JOptionPane.ERROR_MESSAGE);
                // e1.printStackTrace();
            }
        });
    }
}
