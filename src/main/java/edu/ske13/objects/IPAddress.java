package edu.ske13.objects;

import edu.ske13.constants.IPClass;
import edu.ske13.constants.IPClassable;
import edu.ske13.constants.IPExtraClass;
import edu.ske13.constants.IPPrivateClass;
import edu.ske13.exception.IPException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import static edu.ske13.exception.Error.InvalidIPException;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:46
 */
public class IPAddress {
    private String raw;
    private List<NumberBase> numbers = new ArrayList<>(4);
    
    private IPClassable ipClass;
    
    public IPAddress(String raw) throws IPException {
        updateIP(raw);
        setIpClass();
    }
    
    public IPAddress(int first, int second, int third, int fourth) throws IPException {
        updateIP(first, second, third, fourth);
        setIpClass();
    }
    
    public IPAddress(String arg, String arg1, String arg2, String arg3) throws IPException {
        updateIP(arg, arg1, arg2, arg3);
        setIpClass();
    }
    
    public IPAddress(String raw, boolean initialClass) throws IPException {
        updateIP(raw, initialClass);
    }
    
    public IPAddress updateIP(String raw) throws IPException {
        this.raw = raw;
        updateNumberBase();
        setIpClass();
        return this;
    }
    
    public IPAddress updateIP(String raw, boolean initialClass) throws IPException {
        this.raw = raw;
        updateNumberBase();
        if (initialClass) setIpClass();
        return this;
    }
    
    public IPAddress updateIP(int first, int second, int third, int fourth) throws IPException {
        return this.updateIP(String.format("%d.%d.%d.%d", first, second, third, fourth));
    }
    
    public IPAddress updateIP(String arg, String arg1, String arg2, String arg3) throws IPException {
        return this.updateIP(String.format("%s.%s.%s.%s", arg, arg1, arg2, arg3));
    }
    
    public IPAddress getDefaultSubnetMask() throws IPException {
        if (Objects.isNull(getIPClass())) return null;
        return getIPClass().getDefaultSubnetMask();
    }
    
    public NumberBase getIPIndex(int index) {
        return numbers.get(index);
    }
    
    public NumberBase[] getIPs() {
        return numbers.toArray(new NumberBase[4]);
    }
    
    public boolean isSubnetMask() {
        return !Objects.isNull(getIPClass()) && getIPClass().equals(IPExtraClass.Mask);
    }
    
    public boolean isPrivate() {
        return !Objects.isNull(getIPClass()) && getIPClass().getClass().equals(IPPrivateClass.class);
    }
    
    public boolean isLoopback() {
        return !Objects.isNull(getIPClass()) && getIPClass().equals(IPExtraClass.Loopback);
    }
    
    private void setIpClass() throws IPException {
        try {
            ipClass = IPClassable.getIPClass(IPPrivateClass.PrivateClassA, this);
        } catch (IPException e) {
            try {
                ipClass = IPClassable.getIPClass(IPExtraClass.Loopback, this);
            } catch (IPException e1) {
                ipClass = IPClassable.getIPClass(IPClass.ClassA, this);
            }
        }
    }
    
    public IPClassable getIPClass() {
        return ipClass;
    }
    
    private void updateNumberBase() throws IPException {
        try {
            numbers.clear();
            byte[] ip = InetAddress.getByName(raw).getAddress();
            for (byte i : ip) {
                numbers.add(new NumberBase(i & 0xFF)); // change to unsigned byte
            }
        } catch (UnknownHostException e) {
            throw new IPException(InvalidIPException, e);
        }
        
        if (getIPIndex(0).intValue() == 0 && (getIPIndex(1).intValue() != 0 || getIPIndex(2).intValue() != 0 || getIPIndex(3).intValue() != 0))
            throw new IPException(InvalidIPException);
        
        this.raw = toString();
    }
    
    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", getIPIndex(0).intValue(), getIPIndex(1).intValue(), getIPIndex(2).intValue(), getIPIndex(3).intValue());
    }
}