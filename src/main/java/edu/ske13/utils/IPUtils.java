package edu.ske13.utils;

import edu.ske13.constants.Base;
import edu.ske13.exception.NotImplementedException;
import edu.ske13.objects.IPAddress;
import edu.ske13.objects.NumberBase;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:54
 */
public class IPUtils {
    public static IPAddress getIPAddress(String ipAddress) {
        return new IPAddress(ipAddress);
    }
    
    public static IPAddress getIPAddress(int first, int second, int third, int fourth) {
        return new IPAddress(first, second, third, fourth);
    }
    
    public static IPAddress getIPAddress(String arg, String arg1, String arg2, String arg3) {
        return new IPAddress(arg, arg1, arg2, arg3);
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
