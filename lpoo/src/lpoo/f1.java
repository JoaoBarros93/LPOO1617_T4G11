package lpoo;

public class f1 {

	public static void main(String[] args) {
		char map[][] = {
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		
		//level.add(new Wall(x, y));
		
		 for (int x = 0; x < map.length; x++) {
		        for (int y = 0; y < map[x].length; y++) {
				System.out.print(map[x][y]);
				System.out.print(" ");
			//	if (map[x].length == y)
			//		System.out.println("\n");

		  //          level.add(new Wall(y, x));
		            	
		            	
		        }
		        System.out.print("\n");
		        
		    }	
		 }
	
		//level.add(new Wall(x, y));

}
