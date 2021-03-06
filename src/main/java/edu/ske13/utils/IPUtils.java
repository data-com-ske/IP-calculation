package edu.ske13.utils;

import edu.ske13.constants.Base;
import edu.ske13.exception.IPException;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import edu.ske13.objects.NumberBase;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:54
 */
public class IPUtils {
    private static IPAddress address;
    
    static {
        try {
            address = new IPAddress("1.0.0.0", false);
        } catch (IPException e) {
            // e.printStackTrace();
        }
    }
    
    public static IPAddress forceCreateIPAddress(String ipAddress) {
        try {
            return getIPAddress(ipAddress);
        } catch (IPException e) {
            return null;
        }
    }
    
    public static IPAddress forceCreateIPAddress(int first, int second, int third, int fourth) {
        try {
            return getIPAddress(first, second, third, fourth);
        } catch (IPException e) {
            return null;
        }
    }
    
    public static IPAddress forceCreateIPAddress(String arg, String arg1, String arg2, String arg3) {
        try {
            return getIPAddress(arg, arg1, arg2, arg3);
        } catch (IPException e) {
            return null;
        }
    }
    
    public static IPAddress getIPAddress(String ipAddress) throws IPException {
        return address.updateIP(ipAddress, true);
    }
    
    public static IPAddress getIPAddress(String ipAddress, boolean initialClass) throws IPException {
        return address.updateIP(ipAddress, initialClass);
    }
    
    public static IPAddress getIPAddress(int first, int second, int third, int fourth) throws IPException {
        return address.updateIP(first, second, third, fourth);
    }
    
    public static IPAddress getIPAddress(String arg, String arg1, String arg2, String arg3) throws IPException {
        return address.updateIP(arg, arg1, arg2, arg3);
    }
    
    public static IPAddress newIPAddress(String ipAddress, boolean initialClass) {
        
        try {
            return new IPAddress(ipAddress, initialClass);
        } catch (IPException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static IPAddress newIPAddress(int first, int second, int third, int fourth) {
        try {
            return new IPAddress(first, second, third, fourth);
        } catch (IPException e) {
            return null;
        }
    }
    
    public static IPAddress toIPAddressBinary(String ip, boolean dot) throws IPException {
        if (dot) {
            String[] s = ip.split("\\.");
            return new IPAddress(new NumberBase(s[0], Base.Binary).intValue(), new NumberBase(s[1], Base.Binary).intValue(), new NumberBase(s[2], Base.Binary).intValue(), new NumberBase(s[3], Base.Binary).intValue());
        } else {
            if (ip.length() < 32) {
                StringBuilder ipBuilder = new StringBuilder(ip);
                for (int i = 0; i < 32 - ipBuilder.length(); i++) {
                    ipBuilder.insert(0, "0");
                }
                ip = ipBuilder.toString();
            }
            String s = String.format("%s.%s.%s.%s", ip.substring(0, 8), ip.substring(8, 16), ip.substring(16, 24), ip.substring(24, 32));
            return toIPAddressBinary(s, true);
        }
    }
    
    public static IPAddress newIPAddress(String arg, String arg1, String arg2, String arg3) {
        try {
            return new IPAddress(arg, arg1, arg2, arg3);
        } catch (IPException e) {
            return null;
        }
    }
    
    public static boolean checkIPAddress(String ipAddress) {
        try {
            getIPAddress(ipAddress);
            return true;
        } catch (IPException e) {
            return false;
        }
    }
    
    public static boolean checkIPAddress(int first, int second, int third, int fourth) {
        try {
            getIPAddress(first, second, third, fourth);
            return true;
        } catch (IPException e) {
            return false;
        }
    }
    
    public static boolean checkIPAddress(String arg, String arg1, String arg2, String arg3) {
        try {
            getIPAddress(arg, arg1, arg2, arg3);
            return true;
        } catch (IPException e) {
            return false;
        }
    }
    
    public static NumberBase getIPBase(IPAddress address, Base b) {
        throw new NotImplementedException();
    }
    
    /**
     * input number cannot exceed 255, allow 1-255
     *
     * @param b
     *         input number
     * @return true, if input number between 1-255
     */
    public static boolean isIPExceed(NumberBase b) {
        return b.intValue() <= 255 && b.intValue() > 0;
    }
    
    public static boolean isIPExceed(IPAddress ip) {
        throw new NotImplementedException();
    }
}
