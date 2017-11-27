package edu.ske13.main;

import edu.ske13.exception.IPException;
import edu.ske13.ui.main.MainController;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IPException {
        MainController v = new MainController();
        v.startCenter();
    }
}