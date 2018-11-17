/**
 * 
 */
package tests;
import static org.junit.Assert.*;

import model.Level;

import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class SunFlowerTest {
	private SunFlower sunflower;
	private Level level;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sunflower = new SunFlower(1);
		
	}

	/**
	 * Test method for {@link model.SunFlower#act()}.
	 */
	@Test
	public void testAct() {
		assertTrue(sunflower.action(level) == 5);
		assertTrue(sunflower.action(level) == 0);
		assertTrue(sunflower.action(level) == 0);
	}

}
