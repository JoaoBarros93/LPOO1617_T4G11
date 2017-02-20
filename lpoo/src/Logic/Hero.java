package Logic;

import java.util.Scanner;
import Logic.Map;
import Logic.Logic;

public class Hero {
	int x = 1;
	int y = 1;
	
	Logic logic;
	
	Hero(Logic l){
		logic = l;
	}
	
	public void Update(){
		
		//Scanner scanner = new Scanner(System.in);
		//System.out.print("What direction do you want your character to move? ");
		//char direction = scanner.next().charAt(0);
		char direction = 'w';

		Map map = logic.getMap();
		
		switch (direction) {
		case 'w':
			if (logic.getMap().getMap()[x - 1][ y] != 'X') 
			{
				logic.getMap().getMap()[x][y] = ' ';
				x--;
				logic.getMap().getMap()[x][y] = 'H';

			}
			break;
		case 'a':
			if (logic.getMap().getMap()[x][y - 1] != 'X') {
				logic.getMap().getMap()[x][y] = ' ';
				y--;
	
				logic.getMap().getMap()[x][y] = 'H';
			}
			break;
		case 'd':
			if (logic.getMap().getMap()[x][y + 1] != 'X') {
				logic.getMap().getMap()[x][y] = ' ';
				y++;
				logic.getMap().getMap()[x][y] = 'H';
			}
			break;
		case 's':
			if (logic.getMap().getMap()[x + 1][y] != 'X') {
				logic.getMap().getMap()[x][y] = ' ';
				x++;
				logic.getMap().getMap()[x][y] = 'H';
			}
			break;
		}
		}
		

}


