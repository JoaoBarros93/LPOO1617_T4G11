package CLI;

import Logic.Logic.*;

public class CLI {
	Logic.Logic logic;
	
	static public void main()
	{
		CLI cli =new CLI();
		cli.printMap();
	}
	public CLI()
	{
		logic = new Logic.Logic();
	}
	public printMap()
	{
			
		for (int x = 0; x < map.length; x++)
		{
			for (int y = 0; y < map[x].length; y++) {
				System.out.print(map[x][y]);
				System.out.print(" ");
			}
			System.out.print("\n");

				
		}
	}

}
