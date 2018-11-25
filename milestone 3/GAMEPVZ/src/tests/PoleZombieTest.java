package tests;

import static org.junit.Assert.*;
import model.DefZombie;
import model.LevelData;
import model.Plant;
import model.PoleZombie;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the working of the poleZombie
 * @author Abhinav Thukral
 *
 */
public class PoleZombieTest {
	
	private PoleZombie zombie;
	private LevelData grid;
	private int maxX;
	@Before
	public void setUp() throws Exception {
		zombie = new PoleZombie(1);
		grid = new LevelData(1);
		maxX = grid.getMaxX();
		grid.addActor(zombie, maxX, 0);
		
	}

	@Test
	public void testMove() {
		assertTrue(1 == zombie.act(grid));
		assertTrue(zombie.getX() == maxX - 2);
	}

	@Test
	public void FrozenJump() {
		zombie.setFrozen(true);
		assertTrue(1 == zombie.act(grid));
		assertTrue(zombie.getX() == maxX - 1);
	}

	@Test
	public void testjumpAttack() {
		Plant plant = new SunFlower(1);
		grid.addActor(plant, maxX - 1, 0);
		assertTrue(zombie.act(grid) == 1);
		assertTrue(zombie.getX() == maxX - 2);
		Plant anotherPlant = new SunFlower(1);
		grid.addActor(anotherPlant, maxX -3, 0);
		//Testing attack on this plant also tests if 
		assertTrue(zombie.act(grid) == 2);
		assertTrue(anotherPlant.getMaxHealth() > anotherPlant.getCurrHealth());
		
	}

}
