package Logic;

import java.util.Random;
import java.util.Vector;

public class OgreLevel implements IGameLogicLevel{
	
	
	private char wallChar = 'X';	
	private boolean isBeaten;
	
	
	private char map[][] = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } 
			};
	
	private Hero hero;
	private Vector<Ogre> enemies;
	private Key key;
	private Vector<Door> otherDoors;

	public OgreLevel(int numOgres) {
		hero=new Hero(1,7);
		enemies = new Vector<Ogre>();
		otherDoors = new Vector<Door>();
		key= new Key(7,1);
		key.addDoor(new Door(0,1));
		
		
		for(int i = 0; i < numOgres; i++)
		{
			Random ran = new Random();
			int x = ran.nextInt(6) + 1;
			int y = ran.nextInt(6) + 1;
			enemies.add(new Ogre(x, y));
		}

	}
	
	public OgreLevel(boolean ogreCanMove, char map[][]) {
		this.map=map;
		
		key = new Key(-1,-1);
		otherDoors= new Vector<Door>();
		enemies= new Vector<Ogre>();
		for(int y = 0; y < map.length; y++)
			for(int x = 0; x < map[y].length; x++){
				if(map[y][x]=='X'||map[y][x]==' ')
					continue;
				else if(map[y][x]=='k')
					key.setPosXY(x,y);
					else if(map[y][x]=='H')
						hero=new Hero(x,y);
					else if(map[y][x]=='I')
						key.addDoor(new Door(x,y));
					else if(map[y][x]=='0'){
						Ogre og = new Ogre(x,y);
						og.setCanMove(ogreCanMove);
						enemies.add(og);
					}
			}
		
	}

	public Hero getHero() {
		return hero;
	}

	public Vector<Ogre> getEnemies() {
		return enemies;
	}

	public Key getKey() {
		return key;
	}

	public boolean isBeaten(){
		return isBeaten;	
	}
	public void beaten(){
		isBeaten=true;	
	}
	

	@Override
	public boolean update(char direction) {
		
		//Special: open door
		for (Door i : key.getDoors())
			if (i.isNextTo(hero) && !i.isOpen() && hero.hasKey() && i.canBeOpenWith(hero, direction)){
				i.openDoor();
				for (Ogre j : enemies)
					j.move(this);
				return true;
			}

		if (!hero.move(direction, this))
			return true;
		
		// check is player is next to Ogre after moving hero
		for (Ogre j : enemies)
			if (hero.isNextTo(j)) {
				j.gotStunned();
			}
		
	
		for (Ogre j : enemies)
			j.move(this);
		
		// check is player is next to Ogre after moving ogres
		for (Ogre j : enemies)
			if (hero.isNextTo(j)) {
				j.gotStunned();
			}
		
		//check if player has key
		if (!hero.hasKey())
			if (hero.samePosition(key)) {
				hero.pickKey();				
		}

		// check is player is next to Ogre Cube
		for (Ogre j : enemies)
			if (j.getCube().isNextTo(hero)&&!j.isStunned()) {
				hero.wasKilled();
				return false;
			}
		
		// check is Ogre Cube hit key
		if (!hero.hasKey())
			for (Ogre j : enemies)
				if (j.getCube().samePosition(key)){
					key.keyWasHit();
					break;
				}
				else
					key.keyWasNotHit();
		
		

		// check is Ogre is on Key
		for (Ogre j : enemies)
			if (j.samePosition(key)) {
				j.stepedOnKey();
			} else
				j.stopstepedOnKey();
		
		
		for (Door i : key.getDoors())
			if (hero.samePosition(i)) {
				beaten();
				return false;
			}

	return true;		
		
	}
	
	
	@Override
	public String toString() {
		String ret = "\n\n\n";

		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				boolean wasAdded = false;
				if (hero.positionIs(x, y)) {
					ret += hero.toString();
					wasAdded = true;
				}
				if (!wasAdded)
					for (Ogre j : enemies)
						if (j.positionIs(x, y)) {
							ret += j.toString();
							wasAdded = true;
							break;
						}
				if (!wasAdded)
					if (key.positionIs(x, y) && !hero.hasKey()) {
						ret += key.toString();
						wasAdded = true;
					}
				if (!wasAdded)
					for (Object i : key.getDoors())
						if (i.positionIs(x, y)) {
							ret += i.toString();
							wasAdded = true;
							break;
						}
				if (!wasAdded)
					for (Object i : otherDoors)
						if (i.positionIs(x, y)) {
							ret += i.toString();
							wasAdded = true;
							break;
						}
				if (!wasAdded)
					for (Ogre j : enemies)
						if (j.getCube().positionIs(x, y)) {
							ret += j.getCube().toString();
							wasAdded = true;
							break;
						}
				if (!wasAdded)
					ret += map[y][x];
				ret += " ";
			}
			ret += " \n";

		}
		return ret;
	}

	
	
	// 0 hero can move
	// 1 cant move
	// 2 opens do

	public boolean heroCanMoveTo(int x, int y) {
		if (map[y][x]==wallChar) 				
				return false;
		
		for (Door i : otherDoors)
			if (i.positionIs(x, y) && !i.isOpen())
				return false;

		for (Door i : key.getDoors())
			if (i.positionIs(x, y) && !i.isOpen())
				return false;
		
		//hero cant move to Ogre position
		for (Ogre i : enemies)
			if (i.positionIs(x, y))
				return false;
		
			return true;
	}
	
	public boolean ogreCanMoveTo(int x, int y) {
		if (map[y][x]==wallChar) 				
				return false;
		
		for (Door i : otherDoors)
			if (i.positionIs(x, y) && !i.isOpen())
				return false;

		for (Door i : key.getDoors())
			if (i.positionIs(x, y) && !i.isOpen())
				return false;
		
			return true;
	}
	
	public boolean ogreCanAtack(int x, int y){
		if (map[y][x]==wallChar) 				
			return false;
		
		//check if try to attack a door
		for (Door i : otherDoors)
			if (i.positionIs(x, y))
				return false;

		for (Door i : key.getDoors())
			if (i.positionIs(x, y))
				return false;
		
		//check if he try to attack key
		if (key.positionIs(x, y))
			key.keyWasHit();
				
		
		//Ogres can attack themselves
		for (Ogre j : enemies)
			if (j.positionIs(x, y)) {
				j.gotStunned();
			}
		
			return true;		
	}



}
