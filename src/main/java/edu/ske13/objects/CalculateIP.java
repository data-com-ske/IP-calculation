package edu.ske13.objects;

public class CalculateIP {

    private String ip_binary;
    private int fbi[] = new int[32];
    private int lbi[] = new int[32];
    private Mask mask;
    private String first_ip;
    private String last_ip;

    private String calculate_first() {
        for (int i = 0; i < 32; i++)
            fbi[i] = (int) ip_binary.charAt(i) - 48;
        for (int i = 31; i > 31 - mask.getNetwork_number(); i--)
            fbi[i] &= 0;
        String ip[] = {"", "", "", ""};
        for (int i = 0; i < 32; i++)
            ip[i / 8] = new String(ip[i / 8] + fbi[i]);
        int fip = 0;
        for (int i = 0; i < 4; i++) {
            fip = Integer.parseInt(ip[i], 2);
            first_ip += fip;
            if (i != 3) {
                first_ip += ".";
            }
        }
        return first_ip;
    }

    private String calculate_last() {

        for (int i = 0; i < 32; i++) lbi[i] = (int) ip_binary.charAt(i) - 48;
        for (int i = 31; i > 31 - mask.getNetwork_number(); i--)
            lbi[i] |= 1;
        String lip[] = {"", "", "", ""};
        for (int i = 0; i < 32; i++)
            lip[i / 8] = new String(lip[i / 8] + lbi[i]);

        for (int i = 0; i < 4; i++) {
            last_ip += (Integer.parseInt(lip[i], 2));

            if (i != 3) {
                last_ip += ".";
            }
        }
        return last_ip;
    }
}
