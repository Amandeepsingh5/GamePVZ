package tests;

import static org.junit.Assert.*;

import model.Level;

import model.Plant;
import model.PoleZombie;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;


public class PoleZombieTest {
	
	private PoleZombie zombie;
	private Level level;
	private int maxX;
	@Before
	public void setUp() throws Exception {
		zombie = new PoleZombie(1);
		level = new Level(1);
		maxX = level.getMaxX();
		level.addChar(zombie, maxX, 0);
		
	}

	@Test
	public void testMove() {
		assertTrue(1 == zombie.action(level));
		assertTrue(zombie.getX() == maxX - 2);
	}

	@Test
	public void FrozenJump() {
		zombie.setFrozen(true);
		assertTrue(1 == zombie.action(level));
		assertTrue(zombie.getX() == maxX - 1);
	}

	@Test
	public void testjump() {
		Plant plant = new SunFlower(1);
		level.addChar(plant, maxX - 1, 0);
		assertTrue(zombie.action(level) == 1);
		assertTrue(zombie.getX() == maxX - 2);
		Plant anotherPlant = new SunFlower(1);
		level.addChar(anotherPlant, maxX -3, 0);
		//Testing attack on this plant also tests if 
		assertTrue(zombie.action(level) == 2);
		assertTrue(anotherPlant.getmaximumHealth() > anotherPlant.getcurrentHealth());
		
	}

}
