package edu.ske13.ui.font;

import edu.ske13.main.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author kamontat
 * @version 1.0
 * @since Mon 27/Nov/2017 - 22:47
 */
public class Fontbook {
    private static InputStream getInputStreamFont(String folder, String name, String extension) {
        String f = "/font/" + folder + "/" + name + "." + extension;
        return Main.class.getResourceAsStream(f);
    }
    
    public static Font getShowInterFree(int fontType, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, getInputStreamFont("snowinter", "Snowinter-Free-For-Personal-Use", "ttf")).deriveFont(fontType, size);
        } catch (FontFormatException | IOException e) {
            String print = "cannot load font \n" + e.getMessage();
            JOptionPane.showMessageDialog(null, print, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    public static Font getAilerons(int fontType, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, getInputStreamFont("Ailerons", "Ailerons-Typeface", "otf")).deriveFont(fontType, size);
        } catch (FontFormatException | IOException e) {
            String print = "cannot load font \n" + e.getMessage();
            JOptionPane.showMessageDialog(null, print, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
    
    public static Font getSathu(int fontType, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, getInputStreamFont("sathu", "Sathu", "ttf")).deriveFont(fontType, size);
        } catch (FontFormatException | IOException e) {
            String print = "cannot load font \n" + e.getMessage();
            JOptionPane.showMessageDialog(null, print, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }
}
