package edu.ske13.constants;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;

import static edu.ske13.exception.Error.IPClassNotFound;

/**
 * @author kamontat
 * @version 1.0
 * @since Sat 25/Nov/2017 - 23:33
 */
public enum IPExtraClass implements IPClassable {
    Mask(255),
    Loopback(127),
    NonRoutable(0);
    
    private int start;
    
    IPExtraClass(int start) {
        this.start = start;
    }
    
    @Override
    public IPAddress getDefaultSubnetMask() {
        return null;
    }
    
    @Override
    public boolean isPrivateClass() {
        return false;
    }
    
    @Override
    public boolean isExtraClass() {
        return true;
    }
    
    @Override
    public int getClassBit() {
        return 0;
    }
    
    
    @Override
    public IPExtraClass getIPClassImp(IPAddress ipAddress) throws IPException {
        for (IPExtraClass c : IPExtraClass.values()) {
            if (ipAddress.getIPIndex(0).intValue() == c.start) return c;
        }
        throw new IPException(IPClassNotFound);
    }
}
