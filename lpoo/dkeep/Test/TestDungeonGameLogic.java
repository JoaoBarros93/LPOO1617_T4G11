package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Logic.Door;
import Logic.DungeonLevel;

public class TestDungeonGameLogic {
	private char[][] map = 	{ 
				{ 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'H', ' ', 'G', 'X' }, 
				{ 'I', ' ', ' ', ' ', 'X' },
				{ 'I', 'k', ' ', ' ', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X' }};

	@Test
	public void testMoveHeroIntoToFreeCell() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('s');
		assertTrue(level1.getHero().positionIs(1, 2));
	}
	
	@Test
	public void testMoveHeroIntoAWall() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('w');
		assertTrue(level1.getHero().positionIs(1, 1));

	}

	@Test
	public void testMoveHeroNextToGuard() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('d');
		level1.update('d');
		assertFalse(level1.getHero().isAlive());

		

	}

	@Test
	public void testMoveHeroIntoTheDoorClosed() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('s');
		assertTrue(level1.getHero().positionIs(1, 2));
		level1.update('a');
		assertTrue(level1.getHero().positionIs(1, 2));

	}

	@Test
	public void testTheDoorOpen() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('s');
		level1.update('s');
		for(Door i : level1.getLever().getDoors())
			assertTrue(i.isOpen());

	}

	@Test
	public void testHeroBeatsLevel() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		level1.update('s');
		level1.update('s');
		assertFalse(level1.isBeaten());
		level1.update('a');
		assertTrue(level1.isBeaten());

	}

}