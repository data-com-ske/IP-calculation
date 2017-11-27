package edu.ske13.objects;

import edu.ske13.ui.main.MainView;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 26/Nov/2017 - 16:20
 */
public class SHNumber {
    private MainView.InputType type;
    private int number;
    
    public SHNumber(MainView.InputType type, int number) {
        this.type = type;
        this.number = number;
    }
    
    public MainView.InputType getType() {
        return type;
    }
    
    public int getNumber() {
        return number;
    }
    
    public String returnBinary() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < number; j++) {
            if (type.equals(MainView.InputType.HOST)) sb.append(0);
            else sb.append(1);
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "SHNumber{" + "type=" + type + ", number=" + number + '}';
    }
}
