package Logic;

public class Map {

	private byte[][] map;

	public Map(int ARENA_WIDTH, int ARENA_HEIGHT) {
		map = new byte[ARENA_HEIGHT][ARENA_WIDTH];

	}

	public byte getPosMap(int x, int y) {
		return map[y][x];
	}

	public void setPosMap(int x, int y, byte value) {
		map[y][x] = value;
	}
	
	public boolean isEmpty(int x, int y){
		if(map[y][x]!=0)
			return false;
		else return true;	
	}
	
	public int getMaxXsize(){
		return map[0].length;
		
		
	}
	
	public int getMaxY(){
		return map.length;
		
		
	}
	
	public boolean getAdjacent(int x, int y) {

		if (y + 1 < getMaxY() && getPosMap(x, y + 1) != 0)
			return true;

		if (y - 1 >= 0 && getPosMap(x, y - 1) != 0)
			return true;

		if (x + 1 < getMaxXsize() && getPosMap(x + 1, y) != 0)
			return true;

		if (x - 1 >= 0 && getPosMap(x - 1, y) != 0)
			return true;

		return false;

	}
	
	public boolean validCoord(int x, int y) {

		if (y < 0 || y >= getMaxY())
			return false;
		
		if (x < 0 || x >= getMaxXsize())
			return false;

		return true;

	}
	
	
}
