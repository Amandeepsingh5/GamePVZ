/**
 * 
 */
package tests;


import static org.junit.Assert.*;
import model.Actor;
import model.SeedPacket;
import model.Shooter;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class SeedPacketTest {

	private SeedPacket seed;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.seed = new SeedPacket(1);
	}

	/**
	 * Test method for getPlant().
	 */
	@Test
	public void testGetPlant() {
		Actor actor = seed.getPlant("sunflower", 7);
		assertFalse(actor == null);
		assertTrue(actor instanceof SunFlower);
		
		actor = seed.getPlant("sunflower", -1);
		assertTrue(actor == null);
		
		actor = seed.getPlant("sdfad", 7);
		assertTrue(actor == null);
		
		actor = seed.getPlant("shooter", 7);
		assertFalse(actor == null);
		assertTrue(actor instanceof Shooter);
		
		actor = seed.getPlant("shooter", 0);
		assertTrue(actor == null);
	}

}
