package Logic;

import java.util.Scanner;

public class Hero {
	int x = 1;
	int y = 1;
	
	
	public void update(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("What direction do you want your character to move? ");
		char direction = scanner.next().charAt(0);

		// System.out.println(map[hero_x][hero_y-1]);

		switch (direction) {
		case 'w':
			if (map[x - 1][ y] != 'X') {
				map[x][y] = ' ';
				hero_x--;
				// System.out.print(hero_y);
				map[hero_x][hero_y] = 'H';

			}
			break;
		case 'a':
			if (map[hero_x][hero_y - 1] != 'X') {
				map[hero_x][hero_y] = ' ';
				hero_y--;
				// System.out.print(hero_y);
				map[hero_x][hero_y] = 'H';
			}
			break;
		case 'd':
			if (map[hero_x][hero_y + 1] != 'X') {
				map[hero_x][hero_y] = ' ';
				hero_y++;
				// System.out.print(hero_y);
				map[hero_x][hero_y] = 'H';
			}
			break;
		case 's':
			if (map[hero_x + 1][hero_y] != 'X') {
				map[hero_x][hero_y] = ' ';
				hero_x++;
				// System.out.print(hero_y);
				map[hero_x][hero_y] = 'H';
			}
			break;
		}
		
		
		
		
		
		
	}
}


