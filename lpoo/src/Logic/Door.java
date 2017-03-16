package Logic;

public class Door extends Object {

	private boolean isOpen=false;
	

	
	public Door(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		// TODO Auto-generated constructor stub
	}

	
	
	public void openDoor(){
		isOpen=true;
	}
	
	public boolean isOpen(){
		return isOpen;
	}
	
	@Override
	public String toString() {
		if(isOpen)
			return "S";
		else return "I";
	}
	
	public String getType() {
		return "Door";
	}



	public boolean canBeOpenWith(Hero hero, char direction) {

		switch (direction) {
		case 'w':
			if (getX() == hero.getX() && getY() == hero.getY() - 1) {
				return true;
			}
			break;

		case 's':
			if (getX() == hero.getX() && getY() == hero.getY() + 1) {
				return true;
			}
			break;

		case 'a':
			if (getX() == hero.getX() - 1 && getY() == hero.getY()) {
				return true;
			}
			break;

		case 'd':
			if (getX() == hero.getX() + 1 && getY() == hero.getY()) {
				return true;
			}
			break;
			
		}
		return false;

	}
}