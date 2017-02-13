package lpoo;

//import java.io.BufferedReader;

//import java.io.InputStreamReader;

/*
import java.util.Scanner;
public class f1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("What is your favorite color? ");
    String name = scanner.next();
    System.out.println("Your favorite color is: " + name);
  }
}

*/
import java.util.Scanner;

public class f1 {

	public static void main(String[] args) {
		int hero_x = 1;
		int hero_y = 1;

		char map[][] = { { 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				System.out.print(map[x][y]);
				System.out.print(" ");
			}
			System.out.print("\n");

		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("What direction do you want your character to move? ");
		char direction = scanner.next().charAt(0);

		// System.out.println(map[hero_x][hero_y-1]);

		switch (direction) {
		case 'w':
			if (map[hero_x - 1][hero_y] != 'X') {
				map[hero_x][hero_y] = ' ';
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

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				System.out.print(map[x][y]);
				System.out.print(" ");
			}
			System.out.print("\n");

		}

		/*
		 * function Update() { if (Input.GetKeyDown(KeyCode.W)) pos.y +=
		 * spacing; if (Input.GetKeyDown(KeyCode.S)) pos.y -= spacing; if
		 * (Input.GetKeyDown(KeyCode.A)) pos.x -= spacing; if
		 * (Input.GetKeyDown(KeyCode.D)) pos.x += spacing;
		 * 
		 */

		// System.out.print("Enter something:");
		// String input = System.console().readLine();
		/*
		 * 
		 * switch (month) { case 1: monthString = "January"; break; case 2:
		 * monthString = "February"; break; case 3: monthString = "March";
		 * break; case 4: monthString = "April"; break; case 5: monthString =
		 * "May"; break; case 6: monthString = "June"; break; case 7:
		 * monthString = "July"; break;
		 * 
		 * 
		 */
	}

}
