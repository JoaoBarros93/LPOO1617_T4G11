package Logic;

public class Map {

	private byte[][] map;

	public Map(int ARENA_WIDTH, int ARENA_HEIGHT) {
		map = new byte[ARENA_WIDTH][ARENA_HEIGHT];

	}

	byte getPosMap(int x, int y) {
		return map[y][x];
	}

	void setPosMap(int x, int y, byte value) {
		map[y][x] = value;
	}
	
	boolean isEmpty(int x, int y){
		if(map[y][x]!=0)
			return false;
		else return true;	
	}
	
	int getMaxXsize(){
		return map[0].length;
		
		
	}
	
	int getMaxY(){
		return map.length;
		
		
	}
	
	int[] getAdjacent(int x, int y){
		
		int[] adjs = new int[4];
		
		//if(y+1>=getMaxY)
		//adjs[0]=
		

		
		 return adjs;
		
		
	}
}
