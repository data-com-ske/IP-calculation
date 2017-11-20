package edu.ske13.objects;

public class Mask {

    private int network_number;

    public Mask() {
        network_number = 0;
    }

    private int calculate_mask(int network_number) {
        int bits = (int) Math.ceil(Math.log(network_number) / Math.log(2));
        return 32 - bits;
    }

    public int getNetwork_number() {
        return network_number;
    }
}
