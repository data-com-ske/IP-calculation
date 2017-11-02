package edu.ske13.main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 02/Nov/2017 - 21:30
 */
@DisplayName("Main Test")
class MainTest {
	
	@RepeatedTest(10)
	void firstTest() {
		assertEquals(Main.HELLO, Main.say_hello());
	}
}
