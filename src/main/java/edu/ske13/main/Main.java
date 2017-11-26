package edu.ske13.main;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;

import java.net.UnknownHostException;

public class Main {
    public static String HELLO = "hello world";
    
    public static String say_hello() {
        return HELLO;
    }
    
    public static void main(String[] args) throws UnknownHostException, IPException {
        // String google = "172.217.7.206";
        String raw = "192.168.123.123";
        
        IPAddress a = new IPAddress(raw);
        
        System.out.println(a.toBinaryLong());
    }
}