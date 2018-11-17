package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ExplosiveZombie;
import model.Level;
import model.PeaShooter;
import model.SunFlower;


public class ExplosiveZombieTest {
	private ExplosiveZombie actor;
	private Level level;

	@Before
	public void setUp() throws Exception{
		actor = new ExplosiveZombie(1);
		level = new Level(1);
		level.addChar(actor, level.getMaxX() -1, 0);
	}
	/**
	 * Tests Act() in ExplosiveZombie and also private methods
	 * move() and attack()
	 */
	@Test
	public void testAct() {
		SunFlower plant = new SunFlower(1);
		level.addChar(plant,level.getMaxX() - 2, 0);
		assertTrue(2 == this.actor.action(level));
		assertTrue(plant.getMaxHealth() > plant.getCurrHealth());
	}

	@Test
	public void testMove(){
		assertTrue(1 == actor.action(level));
		actor.setXY(0, 0);
		assertTrue(-1 == actor.action(level));

	}
	@Test
	public void testExplode(){
		SunFlower plant = new SunFlower(1);
		level.addChar(plant,level.getMaxX() - 2, 0);
		PeaShooter anotherPlant = new PeaShooter(1);
		level.addChar(anotherPlant, level.getMaxX() - 2, 1);
		actor.takeDamage((int) (0.83 * actor.getMaxHealth()));
		assertTrue(2 == actor.action(level));
		assertTrue(!actor.isAlive());
		assertTrue(!plant.isAlive());
		assertTrue(!anotherPlant.isAlive());
	}
}