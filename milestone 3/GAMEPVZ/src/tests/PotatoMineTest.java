package tests;

import static org.junit.Assert.*;
import model.DefZombie;
import model.LevelData;
import model.PotatoMine;

import org.junit.Before;
import org.junit.Test;

/**
 * This class has tests for potato mine
 * @author Abhinav Thukral
 *
 */
public class PotatoMineTest {
	private LevelData grid;
	private PotatoMine mine;
	private DefZombie zombie;
	
	@Before
	public void setUp() throws Exception {
		grid = new LevelData(1);
		mine = new PotatoMine(1);
		zombie = new DefZombie(1);
		grid.addActor(mine, 0, 0);
		grid.addActor(zombie, 2, 0);
	}

	@Test
	public void testAct() {
		assertTrue(0 == mine.act(grid));
		assertTrue(0 == mine.act(grid));
		assertTrue(0 == mine.act(grid));
		assertTrue(0 == mine.act(grid));
		zombie.act(grid);
		assertTrue(2 == mine.act(grid));
		
	}

	

}
