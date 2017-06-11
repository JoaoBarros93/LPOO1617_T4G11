package Logic.BotBehaviours;

import java.util.concurrent.ThreadLocalRandom;

import Logic.Map;
import Logic.Player;
import Logic.Util;

public class Random implements BotBehaviour {
	

	int[] dirs = { Player.UP, Player.DOWN, Player.LEFT, Player.RIGHT };

	@Override
	public void moveBot(Map map, Player player) {

		Util.shuffleArray(dirs);
		
		for(int i = 0; i < dirs.length; i++){
			int newDir=dirs[i];
			int[] newPos=player.nextPosInThisDir(newDir);
			if(!map.validCoord(newPos[0], newPos[1])||map.getPosMap(newPos[0], newPos[1])!=0)
				continue;
			else {
				player.setDirection(dirs[i]);
				return;
			}
		}
		player.setDirection(dirs[0]);

	}

}
