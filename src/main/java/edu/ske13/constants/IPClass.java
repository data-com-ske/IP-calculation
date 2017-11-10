package edu.ske13.constants;

import edu.ske13.objects.IPAddress;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:53
 */
public enum IPClass {
    ClassA(new IPAddress("255.0.0.0")),
    ClassB(new IPAddress("255.255.0.0")),
    ClassC(new IPAddress("255.255.255.0")),
    ClassD(null),
    ClassE(null),
    PrivateClassA(new IPAddress("255.0.0.0")),
    PrivateClassB(new IPAddress("255.240.0.0")),
    PrivateClassC(new IPAddress("255.255.0.0"));
    
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
