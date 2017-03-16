package Logic;

import java.util.Vector;

public class Key extends Object {
	
	boolean isHit=false;
	Vector<Door> doors;
	
	public void keyWasHit(){
		isHit=true;
	}
	public void keyWasNotHit(){
		isHit=false;
	}
	
	public boolean isHit(){
		return isHit;
	}
	

	public Key(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		doors = new Vector<Door>();
	}
	
	public void addDoor(Door door){
		doors.add(door);
	}
	
	public Vector<Door> getDoors() {
		return doors;
	}
	
	public String toString() {
		if(isHit)
			return "$";
		return "k";
	
	}
	
	public String getType() {
		return "Key";
	}


}
