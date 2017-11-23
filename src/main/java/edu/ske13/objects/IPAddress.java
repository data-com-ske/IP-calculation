package edu.ske13.objects;

import edu.ske13.constants.IPClass;
import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import static edu.ske13.exception.Error.InvalidIPException;

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
            if (!(split[i].equals("255") || split[i].equals("0"))) {
                cf++;
            }
        }
        return cf == 0;
    }
    
    public boolean isPrivate() {
        return !isSubnetMask();
    }
    
    public boolean isLoopback() throws IPException {
        try {
            return InetAddress.getByName(raw).isLoopbackAddress();
        } catch (UnknownHostException e) {
            throw new IPException(InvalidIPException, e);
        }
    }
    
    public IPClass getIPClass() {
         /* throw new NotImplementedException(); */
        String split[] = toString().split("\\.");
        int firstIp = Integer.parseInt(split[0]);
        if (firstIp > 0 && firstIp < 127) return IPClass.ClassA;
        else if (firstIp > 126 && firstIp < 192) return IPClass.ClassB;
        else if (firstIp > 191 && firstIp < 224) return IPClass.ClassC;
        else if (firstIp > 223 && firstIp < 240) return IPClass.ClassD;
        else if (firstIp > 239 && firstIp < 255) return IPClass.ClassE;
        throw new NotImplementedException();
    }
    
    private void updateNumberBase() throws IPException {
        try {
            byte[] ip = InetAddress.getByName(raw).getAddress();
            first = new NumberBase(ip[0]);
            second = new NumberBase(ip[1]);
            third = new NumberBase(ip[2]);
            fourth = new NumberBase(ip[3]);
        } catch (UnknownHostException e) {
            throw new IPException(InvalidIPException, e);
        }
    }
    
    private void validateIP() throws IPException {
        Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        if (!PATTERN.matcher(toString()).matches()) throw new IPException(InvalidIPException);
    }
    
    @Override
    public String toString() {
        return raw;
    }
}