package tests;

import static org.junit.Assert.*;

import java.util.Random;
import model.BasicZombie;

import model.Level;

import model.SunFlower;

import org.junit.Before;
import org.junit.Test;


public class basicZombieTest {
	private BasicZombie basicZombie;
	private Level level;

	@Before
	public void setUp() throws Exception{
		basicZombie = new BasicZombie(1);
		level = new Level(1);
		level.addChar(basicZombie, level.getMaxX(), 0);
	}
	/**
	 * Tests Action() in BasicZombie 
	 * with Move() and Attack()
	 */
	@Test
	public void testAction() {
		SunFlower plant = new SunFlower(1);
		level.addChar(plant,level.getMaxX() - 1, 0);
		assertTrue(2 == this.basicZombie.action(level));
		assertTrue(plant.getmaximumHealth() > plant.getcurrentHealth());
	}

	@Test
	public void testMove(){
		assertTrue(1 == basicZombie.action(level));
		basicZombie.setXY(0, 0);
		assertTrue(-1 == basicZombie.action(level));

	}
	/**
	 * Testing takeDamage inherited from Character
	 * with die() and isAlive()
	 */
	@Test 
	public void testTakeDamage() {
		//Also tests is alive
		assertTrue(basicZombie.isAlive());
		// for random int damage
		Random r = new Random();
		int damage = r.nextInt(basicZombie.getmaximumHealth());
		assertTrue((basicZombie.getmaximumHealth() - damage) == basicZombie.takeDamage(damage));
		//Also tests is alive
		assertTrue(basicZombie.isAlive());
		assertTrue(basicZombie.takeDamage(1000) == 0);
		//Also tests private method die()
		assertFalse(basicZombie.isAlive());

	}
}
