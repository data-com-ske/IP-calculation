package edu.ske13.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 02/Nov/2017 - 21:30
 */
@RunWith(JUnit4.class)
public class MainTest {
	
	@Test()
	public void firstTest() {
		assertEquals(Main.HELLO, Main.say_hello());
	}
	
	@Test()
	public void fail() {
		assertEquals("asdf", "asdf");
	}
}
