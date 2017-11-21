package edu.ske13.main;

import edu.ske13.exception.IPException;
import edu.ske13.objects.IPAddress;

public class Main {
	public static String HELLO = "hello world";
	
	public static String say_hello() {
		return HELLO;
	}
	
	public static void main(String[] args) {
		System.out.println(Main.say_hello());

	}
}