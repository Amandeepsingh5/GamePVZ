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
		Plant character = plant.getPlant("sunflower", 5);
		assertFalse(character == null);
		assertTrue(character instanceof SunFlower);
		
		character = plant.getPlant("sunflower", -2);
		assertTrue(character == null);
		
		character = plant.getPlant("shooter", 6);
		assertFalse(character == null);
		assertTrue(character instanceof PeaShooter);
		
		character = plant.getPlant("snowshooter", -7);
		assertTrue(character == null);
		
		
		character = plant.getPlant("WALNUT", -19);
		assertTrue(character == null);
		
	}

}

