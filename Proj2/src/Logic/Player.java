package Logic;

public class Player {
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	
	boolean alive;
	int direction;  
	int x;
	int y;

	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player(){
		this.alive=true;
		
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
	
	public boolean isBot(){
		return false;
	}
	
	public void updatePos() {
		if (this.direction == Player.UP)
			this.y--;

		if (this.direction == Player.RIGHT)
			this.x++;

		if (this.direction == Player.DOWN)
			this.y++;

		if (this.direction == Player.LEFT)
			this.x--;
	}
	
	public int[]  nextPosInThisDir(int dir) {
		int newX=this.x, newY=this.y;
		
		if (dir == Player.UP)
			newY= this.y - 1;

		if (dir == Player.RIGHT)
			newX= this.x + 1;

		if (dir == Player.DOWN)
			newY= this.y + 1;

		if (dir == Player.LEFT)
			newX= this.x - 1;
		
		 return new int[] {newX, newY};

		
	}

	
}
