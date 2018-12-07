package tests;
import static org.junit.Assert.*;

import model.Level;

import model.Plant;
import model.PoleZombie;

import model.SnowShooter;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class SnowShooterTest {
	private PoleZombie zombie;
	private SnowShooter shooter;
	private Level level;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		zombie = new PoleZombie(1);
		shooter = new SnowShooter(1);
		level = new Level(1);
		level.addChar(shooter, 0, 0);
	}

	/**
	 * Test method for checking no fire fire allowed
	 */
	@Test
	public void testNoFriendlykill() {
		assertTrue(shooter.action(level) == 0);
		Plant plant = new SunFlower(1);
		level.addChar(plant, 2,0);
		assertTrue(shooter.action(level) == 0);
	}
	
	@Test
	public void testAttack(){
		level.addChar(zombie, level.getMaxX() -1, 0);
		assertTrue(2 == shooter.action(level));
		assertTrue(zombie.Freeze());
		assertTrue(zombie.getcurrentHealth() < zombie.getmaximumHealth());
	}

}