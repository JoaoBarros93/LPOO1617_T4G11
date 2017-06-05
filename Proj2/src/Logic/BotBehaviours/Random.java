package Logic.BotBehaviours;

import java.util.concurrent.ThreadLocalRandom;

import Logic.Map;
import Logic.Player;

public class Random implements BotBehaviour {

	@Override
	public void moveBot(Map map, Player player) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
		player.setDirection(randomNum);
		
	}



}
