package edu.ske13.constants;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;
import edu.ske13.objects.NumberBase;
import edu.ske13.utils.IPUtils;

import static edu.ske13.exception.Error.IPClassNotFound;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:53
 */
public enum IPClass implements IPClassable {
    ClassA(1, 126, IPUtils.newIPAddress("255.0.0.0", false)),
    ClassB(128, 191, IPUtils.newIPAddress("255.255.0.0", false)),
    ClassC(192, 223, IPUtils.newIPAddress("255.255.255.0", false)),
    ClassD(224, 239, null),
    ClassE(240, 254, null);
    
    private int start, end;
    private IPAddress subnetMask;
    
    IPClass(int start, int end, IPAddress subnetMask) {
        this.start = start;
        this.end = end;
        this.subnetMask = subnetMask;
    }
    
    public IPAddress getDefaultSubnetMask() {
        return subnetMask;
    }
    
    public boolean isPrivateClass() {
        return false;
    }
    
    @Override
    public boolean isExtraClass() {
        return false;
    }
    
    
    @Override
    public IPClass getIPClassImp(IPAddress ipAddress) throws IPException {
        NumberBase b = ipAddress.getIPIndex(0);
        for (IPClass c : IPClass.values()) {
            if (b.isBetween(NumberBase.Utils.toNumberBase(c.start), NumberBase.Utils.toNumberBase(c.end))) {
                return c;
            }
        }
        throw new IPException(IPClassNotFound);
    }
}
