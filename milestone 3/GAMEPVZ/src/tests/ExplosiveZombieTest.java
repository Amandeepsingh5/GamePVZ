package tests;
import static org.junit.Assert.*;
import model.Actor;
import model.DefZombie;
import model.ExplosiveZombie;
import model.LevelData;
import model.Shooter;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests ExplosiveZombie class 
 * @author Abhinav Thukral
 *
 */
public class ExplosiveZombieTest {
	private ExplosiveZombie actor;
	private LevelData grid;

	@Before
	public void setUp() throws Exception{
		actor = new ExplosiveZombie(1);
		grid = new LevelData(1);
		grid.addActor(actor, grid.getMaxX() -1, 0);
	}
	/**
	 * Tests Act() in ExplosiveZombie and also private methods
	 * move() and attack()
	 */
	@Test
	public void testAct() {
		Actor plant = new SunFlower(1);
		grid.addActor(plant,grid.getMaxX() - 2, 0);
		assertTrue(2 == this.actor.act(grid));
		assertTrue(plant.getMaxHealth() > plant.getCurrHealth());
	}

	@Test
	public void testMove(){
		assertTrue(1 == actor.act(grid));
		actor.setXY(0, 0);
		assertTrue(-1 == actor.act(grid));

	}
	@Test
	public void testExplode(){
		Actor plant = new SunFlower(1);
		grid.addActor(plant,grid.getMaxX() - 2, 0);
		Actor anotherPlant = new Shooter(1);
		grid.addActor(anotherPlant, grid.getMaxX() - 2, 1);
		actor.takeDamage((int) (0.83 * actor.getMaxHealth()));
		assertTrue(2 == actor.act(grid));
		assertTrue(!actor.isAlive());
		assertTrue(!plant.isAlive());
		assertTrue(!anotherPlant.isAlive());
	}
}