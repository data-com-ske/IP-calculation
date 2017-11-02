package edu.ske13.models;

import edu.ske13.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 03/Nov/2017 - 00:42
 */
@RunWith(JUnit4.class)
public class ModelTest {
	
	@Test()
	public void secondTest() {
		assertEquals(Main.HELLO, Main.say_hello());
	}
	
	@Test()
	public void fail2() {
		assertEquals("asdf", "asdf");
	}
}