package Test;

import static org.junit.Assert.*;

import org.junit.Test;


import Logic.*;
import Logic.BotBehaviours.*;

public class TestGame {

	@Test
	public void testMoveUserIntoFreeCell() {
		
		 Game game=new Game(1, 3,(BotBehaviour) new Random());
		 
		 assertEquals(game.getPlayers().get(0).getX(),1);
		 assertEquals(game.getPlayers().get(0).getY(),1);
		 
		 assertEquals(game.getPlayers().get(0).getDirection(),Player.RIGHT);
		 game.update();
		 assertTrue(game.getPlayers().get(0).getX()==2);
		 assertTrue(game.getPlayers().get(0).getY()==1);
	}
	
	/*
	
	@Test
	public void testMoveUserIntoAWall() {
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
	
	@Test
	public void testBeatsLevelRookieGuard() {
		DungeonLevel level1 = new DungeonLevel(1);
		char heroMoves[] = { 'd', 'd', 's', 's', 's', 's', 's', 's', 's', 'w', 'w', 'd', 'd', 'd', 'd', 'd', 's', 's',
				'a', 'd', 'w', 'w', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' };
		assertTrue(level1.getHero().positionIs(1, 1));
		assertTrue(level1.getLever().getDoors().size()==2);
		assertFalse(level1.isBeaten());
		
		for(char i: heroMoves){
			int pos_xGuard=level1.getGuard().getX();
			int pos_yGuard=level1.getGuard().getY();
			level1.update(i);
			assertFalse(pos_xGuard==level1.getGuard().getX()&&pos_yGuard==level1.getGuard().getY());
			
		}
		assertTrue(level1.isBeaten());
	}
	
	@Test
	public void testCompareTwoMaps() {
		DungeonLevel level1 = new DungeonLevel(0, map);
		assertTrue(level1.getHero().positionIs(1, 1));
		assertTrue(level1.getLever().getDoors().size()==2);
		assertTrue(level1.getOtherDoors().size()==0);
		
		String map1s = level1.toString();
		
		level1.update('s');		
		String map2s = level1.toString();
		
		assertFalse(map1s.equals(map2s));
		
		level1.update('w');		
		String map3s = level1.toString();
		
		assertTrue(map1s.equals(map3s));
	}
	*/

}