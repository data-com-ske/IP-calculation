package edu.ske13.main;

import java.net.UnknownHostException;

public class Main {
    public static String HELLO = "hello world";
    
    public static String say_hello() {
        return HELLO;
    }
    
    public static void main(String[] args) throws UnknownHostException {
        String google = "172.217.7.206";
        String raw = "123.123.123.123";
        
        // String raw = "127.1.256.255";
        // System.out.println(InetAddress.getByName(raw).isLoopbackAddress());
    }
}