package Logic;

import java.util.concurrent.ThreadLocalRandom;

public class Ogre extends Character {
	private boolean isOnKey = false;
	private int isStunned = 0;
	Cube cube;

	public Ogre(int pos_x, int pos_y) {	
		super(pos_x, pos_y);
		cube=new Cube(pos_x, pos_y);
	}
	
	public Cube getCube() {
		return cube;
	}

	public void gotStunned(){
		isStunned=2;
		cube.setPosXY(pos_x, pos_y);
	}

	public void move(OgreLevel ogreLevel) {

		if(isStunned!=0){
			isStunned--;
			atack(ogreLevel);
			return;
		}
		// gera num de 0 a 4
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

		boolean canMove = false;

		while (!canMove) {

			switch (randomNum) {
			case 0:
				if (ogreLevel.ogreCanMoveTo(getX(), getY() - 1)) {
					moveUp();
					canMove = true;
				}
				break;

			case 1:
				if (ogreLevel.ogreCanMoveTo(getX(), getY() + 1)) {
					moveDown();
					canMove = true;
				}
				break;

			case 2:
				if (ogreLevel.ogreCanMoveTo(getX() - 1, getY())) {
					moveLeft();
					canMove = true;
				}
				break;

			case 3:
				if (ogreLevel.ogreCanMoveTo(getX() + 1, getY())) {
					moveRight();
					canMove = true;
				}
				break;
			}

			if (!canMove) {
				randomNum++;
				if (randomNum > 3)
					randomNum = 0;

			}

		}
		atack(ogreLevel);
	}

	public void atack(OgreLevel ogreLevel) {
		// gera num de 0 a 4
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
		

		boolean canAtack = false;

		while (!canAtack) {

			switch (randomNum) {
			case 0:
				if (ogreLevel.ogreCanAtack(getX(), getY() - 1)) {
					cube.setPosXY(getX(), getY() - 1);
					canAtack = true;
				}
				break;

			case 1:
				if (ogreLevel.ogreCanAtack(getX(), getY() + 1)) {
					cube.setPosXY(getX(), getY() + 1);
					canAtack = true;
				}
				break;

			case 2:
				if (ogreLevel.ogreCanAtack(getX() - 1, getY())) {
					cube.setPosXY(getX() - 1, getY());
					canAtack = true;
				}
				break;

			case 3:
				if (ogreLevel.ogreCanAtack(getX() + 1, getY())) {
					cube.setPosXY(getX() + 1, getY());
					canAtack = true;
				}
				break;
			}

			if (!canAtack) {
				randomNum++;
				if (randomNum > 3)
					randomNum = 0;

			}

		}


		
	}
	
	public void stepedOnKey(){
		isOnKey = true;	
		
	}
	
	public boolean isStunned(){
		if (isStunned == 0)
			return false;
		else
			return true;
		
	}
	
	public boolean isOnKey(){
		return isOnKey;	
		
	}
	
	public void stopstepedOnKey(){
		isOnKey = false;	
		
	}
	
	@Override
	public String toString() {
		if(isOnKey)
			return "$";
		else if(isStunned())
			return "8";
		return "0";
	}

}
