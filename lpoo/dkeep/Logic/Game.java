package Logic;

import java.util.Vector;

public class Game {
	private DungeonLevel level1;
	private OgreLevel level2;
	private boolean gameOn = true;
	

	public Game(int guardPersona, int numOgres) {
		level1=new DungeonLevel(guardPersona);
		level2=new OgreLevel(numOgres);
		
	}
	
	public Game(String guardPersonality, int numOgres) {
		if (guardPersonality == "Rookie")
			level1 = new DungeonLevel(1);
		else if (guardPersonality == "Druken")
			level1 = new DungeonLevel(2);
		else if (guardPersonality == "Suspicious")
			level1 = new DungeonLevel(3);

		level2 = new OgreLevel(numOgres);

	}
		
	
	public boolean updateGame(char direction) {
		if (!level1.isBeaten()) {
			gameOn = level1.update(direction);
			return gameOn;
		}

		else {
			gameOn = level2.update(direction);
			return gameOn;
		}

	}
	
	
	public boolean isGameOn() {
		return gameOn;
	}

	public String getMap(){
		if(!level1.isBeaten())
			return level1.toString();
		else return level2.toString();

	}
	
	public char[][] getMapArray(){
		if(!level1.isBeaten())
			return level1.getMap();
		else return level2.getMap();

	}
	
	
	//int = 0 - beaten
	//int = 1 - lost on level 1
	//int = 2 - lost on level 2
	public int results() {
		if(level2.isBeaten())
			return 0;
		
		if(level1.isBeaten())
			return 2;
		
		return 1;
		
		
	}
	
	public int levelIsOn() {
		if(!level1.isBeaten())
			return 1;
		else return 2;
		
	}
	
	
	
	public Hero getHero() {
		if (!level1.isBeaten())
			return level1.getHero();
		else
			return level2.getHero();
	}

	public Guard getGuard() {

		return level1.getGuard();
	}

	public Lever getLever() {

		return level1.getLever();

	}

	public Vector<Door> getDoors() {
		if (!level1.isBeaten()) {
			return level1.getOtherDoors();
		} else
			return level2.getOtherDoors();
	}

	public Vector<Ogre> getEnemies() {
		return level2.getEnemies();
	}

	public Key getKey() {
		return level2.getKey();
	}

}