/**
 * 
 */
package tests;


import static org.junit.Assert.*;

import model.GetPlant;
import model.PeaShooter;
import model.Plant;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class GetPlantTest {

	private GetPlant plant;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.plant = new GetPlant(1);
	}

	/**
	 * Test method for getPlant().
	 */
	@Test
	public void testGetPlant() {
		Plant actor = plant.getPlant("sunflower", 5);
		assertFalse(actor == null);
		assertTrue(actor instanceof SunFlower);
		
		actor = plant.getPlant("sunflower", -2);
		assertTrue(actor == null);
		
		actor = plant.getPlant("shooter", 6);
		assertFalse(actor == null);
		assertTrue(actor instanceof PeaShooter);
		
		actor = plant.getPlant("shooter", 0);
		assertTrue(actor == null);
	}

}
