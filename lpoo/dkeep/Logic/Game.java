package Logic;


public class Game {
	private DungeonLevel level1;
	private OgreLevel level2;
	

	public Game(int guardPersona, int numOgres) {
		level1=new DungeonLevel(guardPersona);
		level2=new OgreLevel(numOgres);
		
	}
		
	
	public boolean updateGame(char direction) {
		if(!level1.isBeaten())
			return level1.update(direction);
		else return level2.update(direction);			
		
	
	}

	
	
	public String getMap(){
		if(!level1.isBeaten())
			return level1.toString();
		else return level2.toString();

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
	
}