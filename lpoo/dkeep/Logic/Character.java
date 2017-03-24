package Logic;

public abstract class Character {
	
	protected int pos_x;
	protected int pos_y;
	
	public Character(int x, int y){
		this.pos_x=x;
		this.pos_y=y;
	}


	public void setPosX(int pos_x) {
		this.pos_x = pos_x;
	}


	public void setPosY(int pos_y) {
		this.pos_y = pos_y;
	}


	public void moveUp() {
		pos_y--;
	}

	public void moveDown() {
		pos_y++;		
	}

	public void moveLeft() {
		pos_x--;		
	}

	public void moveRight() {
		pos_x++;		
	}
	
	public boolean positionIs(int x, int y){
		if(pos_x== x && pos_y==y)
			return true;
		else return false;		
	}
	
	public boolean samePosition(Object obj) {
		if ((getX() == obj.getX()) && (getY() == obj.getY()))				
			return true;
		else
			return false;
	}
	
	public int getX() {
		return pos_x;
	}
	
	public int getY() {
		return pos_y;
	}

}
