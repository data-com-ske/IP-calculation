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
            address = new IPAddress("1.0.0.0");
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
        return address.updateIP(ipAddress);
    }
    
    public static IPAddress getIPAddress(int first, int second, int third, int fourth) throws IPException {
        return address.updateIP(first, second, third, fourth);
    }
    
    public static IPAddress getIPAddress(String arg, String arg1, String arg2, String arg3) throws IPException {
        return address.updateIP(arg, arg1, arg2, arg3);
    }
    
    public static boolean checkIPAddress(String ipAddress) {
        try {
            return getIPAddress(ipAddress).isCorrect();
        } catch (IPException e) {
            return false;
        }
    }
    
    public static boolean checkIPAddress(int first, int second, int third, int fourth) {
        try {
            return getIPAddress(first, second, third, fourth).isCorrect();
        } catch (IPException e) {
            return false;
        }
    }
    
    public static boolean checkIPAddress(String arg, String arg1, String arg2, String arg3) {
        try {
            return getIPAddress(arg, arg1, arg2, arg3).isCorrect();
        } catch (IPException e) {
            return false;
        }
    }
    
    public static boolean checkIPAddress(IPAddress address) {
        return address.isCorrect();
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
