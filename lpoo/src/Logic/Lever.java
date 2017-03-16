package Logic;

import java.util.Vector;

public class Lever extends Object {
	
	public Lever(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		doors= new Vector<Door>();
	}

	private boolean isActivated=false;
	Vector<Door> doors;
	
	public void activateLever(){
		isActivated=true;
		for(Door i: doors)
			i.openDoor();
	}
	
	public Vector<Door> getDoors() {
		return doors;
	}

	public boolean isActivated(){
		return isActivated;
	}
	
	public void addDoor(Door door){
		doors.add(door);
	}

	@Override
	public String toString() {
		return "k";
	}
	
	public String getType() {
		return "Lever";
	}


}
