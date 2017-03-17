package Logic;

public abstract class Object {

	protected int pos_x;
	protected int pos_y;
	
	public Object(int pos_x,	int pos_y){
		this.pos_x=pos_x;
		this.pos_y=pos_y;
	}
	
	public int getX() {
		return pos_x;
	}
	
	public int getY() {
		return pos_y;
	}
	
	

	public void setPosXY(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	
	public boolean positionIs(int x, int y){
		if(pos_x== x && pos_y==y)
			return true;
		else return false;		
	}

	public String getType() {
		return null;
	}
	
	public boolean isNextTo(Character character) {
		if (((Math.abs(getX() - character.getX()) <= 1) && (Math.abs(getY() - character.getY()) <= 0)) ||
				((Math.abs(getX() - character.getX()) <= 0) && (Math.abs(getY() - character.getY()) <= 1)))
			return true;
		else
			return false;
	}
	
	public boolean samePosition(Object obj) {
		if ((getX() == obj.getX()) && (getY() == obj.getY()))				
			return true;
		else
			return false;
	}
	
	
	

	

}
