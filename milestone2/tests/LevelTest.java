package tests;

import static org.junit.Assert.*;
import model.Actor;
import model.DefZombie;
import model.LevelData;
import model.Shooter;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {
	Actor dummy;
	Actor mannekin;
	Actor raggamuffin;
	Actor bellsprout;
	Actor saproling;
	LevelData finalDestination;
	
	@Before
	public void setUp() throws Exception {
		dummy = new DefZombie(1);
		mannekin = new DefZombie(1);
		raggamuffin = new DefZombie(1);
		bellsprout = new Shooter(1);
		saproling = new Shooter(1);
		finalDestination = new LevelData(1);
	}

	@Test
	public void test() {
		assert(finalDestination.addActor(dummy, 0, 0));
		assert(finalDestination.actorAt(0, 0));
		assert(!finalDestination.actorAt(1, 0));
		assert(finalDestination.zombieAt(0, 0));
		assert(!finalDestination.zombieAt(1, 0));
		assert(finalDestination.addActor(mannekin, 1, 0));
		assert(finalDestination.addActor(raggamuffin, 0, 0));
		assert(finalDestination.getActorAt(1, 0) == mannekin);
		assert(finalDestination.getActorsAt(0, 0).contains(dummy) && finalDestination.getActorsAt(0, 0).contains(raggamuffin));
		assert(finalDestination.addActor(saproling, 0, 1));
		assert(finalDestination.plantAt(0, 1));
	}

	

}
