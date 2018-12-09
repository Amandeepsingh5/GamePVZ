package tests;

import static org.junit.Assert.*;

import model.ExplosiveZombie;
import model.Level;
import model.PeaShooter;



import org.junit.Before;
import org.junit.Test;

public class LevelTest {
	ExplosiveZombie zombieA;
	ExplosiveZombie zombieB;
	ExplosiveZombie zombieC;
	PeaShooter peashooterA;
	PeaShooter peashooterB;
	Level end;
	
	@Before
	public void setUp() throws Exception {
		zombieA = new ExplosiveZombie(1);
		zombieB = new ExplosiveZombie(1);
		zombieC = new ExplosiveZombie(1);
		peashooterA = new PeaShooter(1);
		peashooterB = new PeaShooter(1);
		end = new Level(1);
	}

	@Test
	public void test() {
		assert(end.addChar(zombieA, 0, 0));
		assert(end.CharacterAt(0, 0));
		assert(!end.CharacterAt(1, 0));
		assert(end.loc_zombie(0, 0));
		assert(!end.loc_zombie(1, 0));
		assert(end.addChar(zombieB, 1, 0));
		assert(end.addChar(zombieC, 0, 0));
		assert(end.getCharacterAt(1, 0) == zombieB);
		assert(end.getCharactersAt(0, 0).contains(zombieA) && end.getCharactersAt(0, 0).contains(zombieC));
		assert(end.addChar(peashooterB, 0, 1));
		assert(end.plantAt(0, 1));
	}

	

}
