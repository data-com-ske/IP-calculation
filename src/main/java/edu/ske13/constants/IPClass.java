package edu.ske13.constants;

import edu.ske13.objects.IPAddress;
import edu.ske13.utils.IPUtils;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:53
 */
public enum IPClass {
    ClassA(IPUtils.forceCreateIPAddress("255.0.0.0")),
    ClassB(IPUtils.forceCreateIPAddress("255.255.0.0")),
    ClassC(IPUtils.forceCreateIPAddress("255.255.255.0")),
    ClassD(null),
    ClassE(null),
    PrivateClassA(IPUtils.forceCreateIPAddress("255.0.0.0")),
    PrivateClassB(IPUtils.forceCreateIPAddress("255.240.0.0")),
    PrivateClassC(IPUtils.forceCreateIPAddress("255.255.0.0"));
    
    private IPAddress subnetMask;
    
    IPClass(IPAddress subnetMask) {
        this.subnetMask = subnetMask;
    }
    
    public IPAddress getDefaultSubnetMask() {
        return subnetMask;
    }
    
    public boolean isPrivate() {
        // return this.equals(PrivateClassA) || this.equals(PrivateClassB) || this.equals(PrivateClassC);
        return this.name().toLowerCase().contains("private");
    }
}
