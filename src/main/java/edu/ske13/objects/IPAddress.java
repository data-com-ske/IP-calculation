package edu.ske13.objects;

import edu.ske13.constants.IPClass;
import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;

import java.util.regex.Pattern;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:46
 */
public class IPAddress {
    private String raw;
    private NumberBase first;
    private NumberBase second;
    private NumberBase third;
    private NumberBase fourth;

    public IPAddress(String raw) throws IPException {
        updateIP(raw);
    }

    public IPAddress(int first, int second, int third, int fourth) throws IPException {
        updateIP(first, second, third, fourth);
    }

    public IPAddress(String arg, String arg1, String arg2, String arg3) throws IPException {
        updateIP(arg, arg1, arg2, arg3);
    }

    public IPAddress updateIP(String raw) throws IPException {
        this.raw = raw;
        updateNumberBase();
        validateIP();
        return this;
    }

    public IPAddress updateIP(int first, int second, int third, int fourth) throws IPException {
        return this.updateIP(String.format("%d.%d.%d.%d", first, second, third, fourth));
    }

    public IPAddress updateIP(String arg, String arg1, String arg2, String arg3) throws IPException {
        return this.updateIP(String.format("%s.%s.%s.%s", arg, arg1, arg2, arg3));
    }

    public IPAddress getDefaultSubnetMask() {
        return getIPClass().getDefaultSubnetMask();
    }

    public boolean isCorrect() {
        try {
            validateIP();
            return true;
        } catch (IPException e) {
            // e.printStackTrace();
            return false;
        }
    }

    public boolean isSubnetMask() {
        int cf = 0;
        /* throw new NotImplementedException(); */
        String split[] = toString().split("\\.");
        for (int i = 0; i < 4; i++) {
            if (split[i].toString().equals("255") || split[i].toString().equals("0")) {
                cf = 0;
            } else {
                cf++;
            }
        }
        return cf == 0;
    }

    public boolean isPrivate() {
        String split[] = toString().split("\\.");
        int cfalse = 0;
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(split[i]) != 255 || Integer.parseInt(split[i]) != 0) {
                cfalse = 0;
            } else {
                cfalse++;
            }
        }
        return cfalse == 0;
    }


    public boolean isLoopback() {
        /* throw new NotImplementedException(); */
        return raw.equals("127.0.0.1");
    }

    public IPClass getIPClass() {
         /* throw new NotImplementedException(); */
        String split[] = toString().split("\\.");
        int firstip = Integer.parseInt(split[0]);
        if (firstip > 0 && firstip < 127) return IPClass.ClassA;
        else if (firstip > 126 && firstip < 192) return IPClass.ClassB;
        else if (firstip > 191 && firstip < 224) return IPClass.ClassC;
        else if (firstip > 223 && firstip < 240) return IPClass.ClassD;
        else if (firstip > 239 && firstip < 255) return IPClass.ClassE;
        throw new NotImplementedException();
    }

    private void updateNumberBase() {
        throw new NotImplementedException();
    }

    private void validateIP() throws IPException {
        Pattern PATTERN = Pattern.compile(
                "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        PATTERN.matcher(toString()).matches();
        /* throw new NotImplementedException(); */
    }

    @Override
    public String toString() {
        return raw;
    }

}