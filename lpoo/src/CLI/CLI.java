package CLI;

import Logic.Logic.*;
import Logic.Map.*;

public class CLI {
	public Logic.Logic logic2;
	public Logic.Map map;
	public Logic.Hero hero;
	
	
	
	
	
	public static void main(String[] args) {
		CLI cli =new CLI();
		cli.map.Draw(); 
		cli.hero.Update();
	}
	
	
	public CLI(){
		logic = new Logic.Logic();
		map = new Logic.Map();
	}
	


}
