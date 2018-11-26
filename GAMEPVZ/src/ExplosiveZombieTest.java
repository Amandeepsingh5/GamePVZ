package tests;
import static org.junit.Assert.*;


import model.ExplosiveZombie;
import model.Level;

import model.PeaShooter;

import model.SunFlower;

import org.junit.Before;
import org.junit.Test;


public class ExplosiveZombieTest {
	private ExplosiveZombie explosiveZombie;
	private Level level;

	@Before
	public void setUp() throws Exception{
		explosiveZombie = new ExplosiveZombie(1);
		level = new Level(1);
		level.addChar(explosiveZombie, level.getMaxX() -1, 0);
	}
	/**
	 * Tests Action() in ExplosiveZombie
	 * and move() and attack()
	 */
	@Test
	public void testAction() {
		SunFlower plant = new SunFlower(1);
		level.addChar(plant,level.getMaxX() - 2, 0);
		assertTrue(2 == this.explosiveZombie.action(level));
		assertTrue(plant.getmaximumHealth() > plant.getcurrentHealth());
	}

	@Test
	public void testMove(){
		assertTrue(1 == explosiveZombie.action(level));
		explosiveZombie.setXY(0, 0);
		assertTrue(-1 == explosiveZombie.action(level));

	}
	@Test
	public void testExplode(){
		SunFlower plant = new SunFlower(1);
		level.addChar(plant,level.getMaxX() - 2, 0);
		PeaShooter anotherPlant = new PeaShooter(1);
		level.addChar(anotherPlant, level.getMaxX() - 2, 1);
		explosiveZombie.takeDamage((int) (0.83 * explosiveZombie.getmaximumHealth()));
		assertTrue(2 == explosiveZombie.action(level));
		assertTrue(!explosiveZombie.isAlive());
		assertTrue(!plant.isAlive());
		assertTrue(!anotherPlant.isAlive());
	}
}
