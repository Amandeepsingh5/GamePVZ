package tests;
import static org.junit.Assert.*;
import model.DefZombie;
import model.LevelData;
import model.Plant;
import model.PoleZombie;
import model.Shooter;
import model.SnowShooter;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;

/**
 * This class tests SnowShooter class
 * @author Abhinav Thukral
 *
 */
public class SnowShooterTest {
	private PoleZombie zombie;
	private SnowShooter shooter;
	private LevelData grid;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		zombie = new PoleZombie(1);
		shooter = new SnowShooter(1);
		grid = new LevelData(1);
		grid.addActor(shooter, 0, 0);
	}

	/**
	 * Test method for checking no shooting against friendlies
	 */
	@Test
	public void testNoShooting() {
		assertTrue(shooter.act(grid) == 0);
		Plant plant = new SunFlower(1);
		grid.addActor(plant, 2,0);
		assertTrue(shooter.act(grid) == 0);
	}
	
	@Test
	public void testAttackFrozen(){
		grid.addActor(zombie, grid.getMaxX() -1, 0);
		assertTrue(2 == shooter.act(grid));
		assertTrue(zombie.isFrozen());
		assertTrue(zombie.getCurrHealth() < zombie.getMaxHealth());
	}

}