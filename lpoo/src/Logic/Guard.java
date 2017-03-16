package Logic;

public class Guard extends Character {
	

	public char moves[] = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 
							'd', 'd', 'd', 'd', 'd', 'd', 'd', 'w', 'w', 'w', 'w', 'w' };
	
	int nextMove = 0;
	boolean isMovingFront= true;
	boolean isAsleep= false;
	
	//0-not moving
	//1-rookie
	//2-Druken
	//3-Suspicious
	int guardPersona;

	public Guard(int pos_x, int pos_y, int guardPersona) {
		super(pos_x, pos_y);
		this.guardPersona= guardPersona;
	}
	
	

	@Override
	public String toString() {
		return "G";
	}
	
	public void move(){
		
		switch(guardPersona)
		{
		case 0: return;
		
		case 1:  movefront();

			break;
		case 2: //Drunken 

			break;
		case 3: //Suspicious 
		break;
		}
		
		if(guardPersona==0)
			return;
		
	}
	
	public void movefront() {

		char dir = moves[nextMove];
		if (nextMove == 23)
			nextMove = 0;
		else
			nextMove++;

		switch (dir) {
		case 'w':
			moveUp();
			break;
			
		case 's':
			moveDown();
			break;

		case 'a':
			moveLeft();
			break;

		case 'd':
			moveRight();
			break;
		}
	}
	
	public void moveback() {

		char dir = moves[nextMove];
		if (nextMove == 0)
			nextMove = 23;
		else
			nextMove--;

		switch (dir) {
		case 'w':
			moveUp();
			break;
			
		case 's':
			moveDown();
			break;

		case 'a':
			moveLeft();
			break;

		case 'd':
			moveRight();
			break;
		}
	}


}
