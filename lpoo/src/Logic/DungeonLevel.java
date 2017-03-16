package Logic;

import java.util.Vector;

public class DungeonLevel implements IGameLogicLevel {
	
	private char wallChar = 'X';
	
	private char map[][] = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } 
			};
	
	private Hero hero;
	private Guard guard;
	private Lever lever;
	private Vector<Door> otherDoors;

	private boolean isBeaten;
	
	public DungeonLevel(int guardPersona, char map[][]) {
		this.map=map;
		
		lever = new Lever(-1,-1);
		otherDoors= new Vector<Door>();
		for(int y = 0; y < map.length; y++)
			for(int x = 0; x < map.length; x++){
				if(map[y][x]=='X'||map[y][x]==' ')
					continue;
				else if(map[y][x]=='k')
					lever=new Lever(x,y);
					else if(map[y][x]=='H')
						hero=new Hero(x,y);
					else if(map[y][x]=='I')
						lever.addDoor(new Door(x,y));
					else if(map[y][x]=='G')
						guard= new Guard(x,y,guardPersona);
			}
		
	}
	
	public Hero getHero() {
		return hero;
	}

	public Guard getGuard() {
		return guard;
	}

	public Lever getLever() {
		return lever;
	}

	public DungeonLevel(int guardPersona) {
		hero=new Hero(1,1);
		guard=new Guard(8,1, guardPersona);
		lever=new Lever(7,8);
		lever.addDoor(new Door(0,5));
		lever.addDoor(new Door(0,6));
		
		otherDoors= new Vector<Door>();
		otherDoors.add(new Door(4,1));
		otherDoors.add(new Door(2,3));
		otherDoors.add(new Door(4,3));	
		otherDoors.add(new Door(2,8));
		otherDoors.add(new Door(4,8));
		
	}


	public boolean isBeaten(){
		return isBeaten;	
	}
	public void beaten(){
		isBeaten=true;	
	}
	
	public boolean isLeverActivated(){
		return lever.isActivated();	
	}
	
	public void activateLever(){
		lever.activateLever();		 
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
				} else if (guard.positionIs(x, y)) {
					ret += guard.toString();
					wasAdded = true;
				} else if (lever.positionIs(x, y)){
					ret += lever.toString();
					wasAdded = true;					
				}
				for (Door i : lever.getDoors())
					if (i.positionIs(x, y)) {
						ret += i.toString();
						wasAdded = true;
					}

				for (Door i : otherDoors)
					if (i.positionIs(x, y)) {
						ret += i.toString();
						wasAdded = true;
						}
				if (!wasAdded)
					ret += map[y][x];
				ret += " ";
			}
			ret += " \n";

		}
		return ret;
	}
	
	
	public boolean update(char direction){
		
		
		if(!hero.move(direction, this))
			return true;
		guard.move();
		
		//check if player has pushed the lever
		if (!isLeverActivated())
			if (hero.samePosition(lever)) {
				activateLever();
		}
			
		
		
		// check is player is next to Guard
		if (hero.isNextTo(guard)&&!guard.isAsleep()) {
			return false;
		}
		

		// check if player is on Exit Door
		if (isLeverActivated()) {
			for (Door i : lever.getDoors())
				if (hero.samePosition(i)) {
					beaten();

				}
		}
		return true;
	}

	
	public boolean heroCanMoveTo(int x, int y) {
		if (map[y][x]==wallChar) 				
				return false;

		for (Door i : otherDoors)
			if (i.positionIs(x, y) && !i.isOpen())
				return false;

		for (Door i : lever.getDoors())
			if (i.positionIs(x, y) && !i.isOpen())
				return false;
		
		if (guard.positionIs(x, y))
			return false;

		return true;
	}
}

