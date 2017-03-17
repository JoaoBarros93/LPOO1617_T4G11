package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Logic.OgreLevel;

public class TestOgreMovingLevel {
	private char[][] map = 	{ 
			{ 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', 'H', ' ', '0', 'X' }, 
			{ 'I', ' ', ' ', 'k', 'X' },
			{ 'I', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' }};

	@Test
	public void testMoveHeroNextToOgre() {
		OgreLevel level2 = new OgreLevel(true, map);
		assertTrue(level2.getHero().positionIs(1, 1));
		level2.update('d');
		assertTrue(level2.getHero().positionIs(2, 1));
		assertTrue(level2.getHero().isNextTo(level2.getEnemies().get(0)));
		assertTrue(level2.getEnemies().get(0).isStunned());
	}

	@Test
	public void testHeroGetsHitByClub() {
		
		

	}

	@Test
	public void testKeyGetsHitByClub() {
	

	}

	@Test
	public void testOgreOnTopOfKey() {
	

	}

	@Test
	public void testHeroBeatsLevel() {



	}


}
