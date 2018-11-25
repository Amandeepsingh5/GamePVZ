package tests;
import java.util.Random;

import static org.junit.Assert.*;
import model.Actor;
import model.DefZombie;
import model.LevelData;
import model.SunFlower;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests DefZombie class and Actor class
 * @author Abhinav Thukral
 *
 */
public class ActorDefZombieTest {
	private DefZombie actor;
	private LevelData grid;

	@Before
	public void setUp() throws Exception{
		actor = new DefZombie(1);
		grid = new LevelData(1);
		grid.addActor(actor, grid.getMaxX(), 0);
	}
	/**
	 * Tests Act() in DefZombie and also private methods
	 * move() and attack()
	 */
	@Test
	public void testAct() {
		Actor plant = new SunFlower(1);
		grid.addActor(plant,grid.getMaxX() - 1, 0);
		assertTrue(2 == this.actor.act(grid));
		assertTrue(plant.getMaxHealth() > plant.getCurrHealth());
	}

	@Test
	public void testMove(){
		assertTrue(1 == actor.act(grid));
		actor.setXY(0, 0);
		assertTrue(-1 == actor.act(grid));

	}
	/**
	 * Testing takeDamage inherited from Actor
	 * Also tests private methods die() and isAlive()
	 */
	@Test 
	public void testTakeDamage() {
		//Also tests is alive
		assertTrue(actor.isAlive());
		// for random int damage
		Random r = new Random();
		int damage = r.nextInt(actor.getMaxHealth());
		assertTrue((actor.getMaxHealth() - damage) == actor.takeDamage(damage));
		//Also tests is alive
		assertTrue(actor.isAlive());
		assertTrue(actor.takeDamage(1000) == 0);
		//Also tests private method die()
		assertFalse(actor.isAlive());

	}
}
