package edu.ske13.objects;

import edu.ske13.constants.IPClass;
import edu.ske13.exception.NotImplementedException;

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
    
    public IPAddress(String raw) {
        this.raw = raw;
        updateNumberBase();
    }
    
    public IPAddress(int first, int second, int third, int fourth) {
        this(String.format("%d.%d.%d.%d", first, second, third, fourth));
    }
    
    public IPAddress(String arg, String arg1, String arg2, String arg3) {
        this(String.format("%s.%s.%s.%s", arg, arg1, arg2, arg3));
    }
    
    public IPAddress getDefaultSubnetMask() {
        return getIPClass().getDefaultSubnetMask();
    }
    
    public boolean isCorrect() {
        throw new NotImplementedException();
    }
    
    public boolean isSubnetMask() {
        throw new NotImplementedException();
    }
    
    public boolean isPrivate() {
        return getIPClass().isPrivate();
    }
    
    public boolean isLoopback() {
        throw new NotImplementedException();
    }
    
    public IPClass getIPClass() {
        throw new NotImplementedException();
    }
    
    private void updateNumberBase() {
        throw new NotImplementedException();
    }
    
    @Override
    public String toString() {
        return raw;
    }
}
