/**
 * 
 */
package tests;
import static org.junit.Assert.*;
import model.LevelData;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class SunFlowerTest {
	private SunFlower sunflower;
	private LevelData grid;
	

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
		assertTrue(sunflower.act(grid) == 5);
		assertTrue(sunflower.act(grid) == 0);
		assertTrue(sunflower.act(grid) == 0);
		assertTrue(sunflower.act(grid) == 5);
	}

}
