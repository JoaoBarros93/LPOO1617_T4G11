package Logic;

public class Hero extends Character{
	
	private boolean isAlive=true;
	private boolean hasKey=false;
	private boolean isArmed=false;

	public Hero(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	@Override
	public String toString() {
		if (hasKey)
			return "K";
		else if (isArmed)
			return "A";
		return "H";
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean hasKey(){
		return hasKey;	
	}
	
	public void pickKey(){
		hasKey=true;
		 
	}
	
	public boolean isArmed(){
		return hasKey;	
	}
	
	public void pickClub(){
		isArmed=true;		 
	}


	
	public boolean move(char dir, IGameLogicLevel level) {
		boolean validMove = false;

		switch (dir) {
		case 'w':
			if (level.heroCanMoveTo(getX(), getY() - 1)) {
				moveUp();
				validMove = true;
			}
			break;

		case 's':
			if (level.heroCanMoveTo(getX(), getY() + 1)) {
				moveDown();
				validMove = true;
			}
			break;

		case 'a':
			if (level.heroCanMoveTo(getX() - 1, getY())) {
				moveLeft();
				validMove = true;
			}
			break;

		case 'd':
			if (level.heroCanMoveTo(getX() + 1, getY())) {
				moveRight();
				validMove = true;
			}
			break;

		}
		return validMove;

	}

	public boolean isNextTo(Character character) {
		if (((Math.abs(getX() - character.getX()) <= 1) && (Math.abs(getY() - character.getY()) <= 0)) ||
				((Math.abs(getX() - character.getX()) <= 0) && (Math.abs(getY() - character.getY()) <= 1)))
			return true;
		else
			return false;
	}
}
