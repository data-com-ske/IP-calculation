package edu.ske13.constants;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;

/**
 * @author kamontat
 * @version 1.0
 * @since Sat 25/Nov/2017 - 22:08
 */
public interface IPClassable {
    IPAddress getDefaultSubnetMask();
    
    boolean isPrivateClass();
    
    boolean isExtraClass();
    
    static <T extends IPClassable> T getIPClass(T t, IPAddress address) throws IPException {
        return t.getIPClassImp(address);
    }
    
    <T extends IPClassable> T getIPClassImp(IPAddress ipAddress) throws IPException;
}
