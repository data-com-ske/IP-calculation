package edu.ske13.main;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 02/Nov/2017 - 21:30
 */
public class MainTest {
	
	@RepeatedTest(10)
	void firstTest() {
		assertEquals(Main.HELLO, Main.say_hello());
	}
	
	@Test
	void failTest() {
		assertEquals("HELO", Main.say_hello());
	}
}
