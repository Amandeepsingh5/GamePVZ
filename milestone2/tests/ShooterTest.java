/**
 * 
 */
package tests;
import static org.junit.Assert.*;
import model.DefZombie;
import model.LevelData;
import model.Plant;
import model.Shooter;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

import controller.*;


public class ShooterTest {
	private DefZombie zombie;
	private Shooter shooter;
	private LevelData grid;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		zombie = new DefZombie(1);
		shooter = new Shooter(1);
		grid = new LevelData(1);
		grid.addActor(shooter, 0, 0);
	}

	/**
	 * Test method for {@link model.Shooter#act()}.
	 */
	@Test
	public void testNoShooting() {
		assertTrue(shooter.act(grid) == 0);
		Plant plant = new SunFlower(1);
		grid.addActor(plant, 2,0);
		assertTrue(shooter.act(grid) == 0);
	}
	
	@Test
	public void testAttack(){
		grid.addActor(zombie, 2, 0);
		assertTrue(2 == shooter.act(grid));
		assertTrue(zombie.getCurrHealth() < zombie.getMaxHealth());
	}

}