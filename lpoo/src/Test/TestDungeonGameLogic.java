package Test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		level1.getHero().move('s', level1);
		assertTrue(level1.getHero().positionIs(1, 2));
	}

}