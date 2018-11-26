/**
 * 
 */
package tests;
import static org.junit.Assert.*;

import model.ExplosiveZombie;
import model.Level;
import model.PeaShooter;
import model.Plant;

import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class PeaShooterTest {
	private ExplosiveZombie zombie;
	private PeaShooter shooter;
	private Level level;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		zombie = new ExplosiveZombie(1);
		shooter = new PeaShooter(1);
		level = new Level(1);
		level.addChar(shooter, 0, 0);
	}

	
	
	@Test
	public void testNoShooting() {
		assertTrue(shooter.action(level) == 0);
		Plant plant = new SunFlower(1);
		level.addChar(plant, 2,0);
		assertTrue(shooter.action(level) == 0);
	}
	
	@Test
	public void testAttack(){
		level.addChar(zombie, 2, 0);
		assertTrue(2 == shooter.action(level));
		assertTrue(zombie.getcurrentHealth() < zombie.getmaximumHealth());
	}

}
