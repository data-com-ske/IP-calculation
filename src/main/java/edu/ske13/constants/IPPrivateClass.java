package edu.ske13.constants;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;
import edu.ske13.utils.IPUtils;

import static edu.ske13.exception.Error.IPClassNotFound;

/**
 * @author kamontat
 * @version 1.0
 * @since Sat 25/Nov/2017 - 22:10
 */
public enum IPPrivateClass implements IPClassable {
    PrivateClassA(IPUtils.newIPAddress("10.0.0.0", false), IPUtils.newIPAddress("10.255.255.255", false), IPUtils.newIPAddress("255.0.0.0", false)),
    PrivateClassB(IPUtils.newIPAddress("172.16.0.0", false), IPUtils.newIPAddress("172.31.255.255", false), IPUtils.newIPAddress("255.240.0.0", false)),
    PrivateClassC(IPUtils.newIPAddress("192.168.0.0", false), IPUtils.newIPAddress("192.168.255.255", false), IPUtils.newIPAddress("255.255.0.0", false));
    
    private IPAddress start, end;
    private IPAddress subnetMask;
    
    IPPrivateClass(IPAddress start, IPAddress end, IPAddress subnetMask) {
        this.start = start;
        this.end = end;
        this.subnetMask = subnetMask;
    }
    
    public IPAddress getDefaultSubnetMask() {
        return subnetMask;
    }
    
    public boolean isPrivateClass() {
        return true;
    }
    
    @Override
    public boolean isExtraClass() {
        return false;
    }
    
    @Override
    public IPPrivateClass getIPClassImp(IPAddress ipAddress) throws IPException {
        
        
        for (IPPrivateClass c : IPPrivateClass.values()) {
            if (ipAddress.getIPIndex(0).isBetween(c.start.getIPIndex(0), c.end.getIPIndex(0)))
                if (ipAddress.getIPIndex(1).isBetween(c.start.getIPIndex(1), c.end.getIPIndex(1)))
                    if (ipAddress.getIPIndex(2).isBetween(c.start.getIPIndex(2), c.end.getIPIndex(2)))
                        if (ipAddress.getIPIndex(3).isBetween(c.start.getIPIndex(3), c.end.getIPIndex(3))) return c;
        }
        throw new IPException(IPClassNotFound);
    }
}
