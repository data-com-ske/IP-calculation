package edu.ske13.objects;

/* calculate subnet class */

public class NumberClass {


    public char address_class;

    public NumberClass() {
        address_class = 'A';
    }

    public char check_class(String ip) {
        String split_ip[] = ip.split("\\.");
        int subnet_class = Integer.parseInt(split_ip[0]);
        if (subnet_class > 1 && subnet_class < 127) {
            return address_class = 'A';
        } else if (subnet_class > 126 && subnet_class < 192) {
            return address_class = 'B';
        } else if (subnet_class > 191 && subnet_class < 225) {
            return address_class = 'C';
        } else if (subnet_class > 223 && subnet_class < 240) {
            return address_class = 'D';
        }
        return address_class = 'E';
    }
}
