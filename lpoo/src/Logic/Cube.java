package Logic;

public class Cube extends Object{
	


	public Cube(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	public String toString() {
		return "*";
	
	}
	
	public void setPosXY(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}


}
