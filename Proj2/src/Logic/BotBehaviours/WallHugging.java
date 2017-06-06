package Logic.BotBehaviours;

import GUI.Util;
import Logic.Map;
import Logic.Player;

public class WallHugging implements BotBehaviour {
	
	int[] dirs={Player.UP, Player.DOWN, Player.LEFT, Player.RIGHT};

	@Override
	public void moveBot(Map map, Player player) {
		
		Util.shuffleArray(dirs);
		
		for(int i = 0; i < dirs.length; i++){
			int newDir=dirs[i];
			int[] newPos=player.nextXPosInThisDir(newDir);
			if(map.getPosMap(newPos[0], newPos[1])!=0)
				continue;
			
			if(map.getAdjacent(newPos[0], newPos[1])){
				player.setDirection(dirs[i]);
				break;
			}
		}
		
		//int dfs=32;

	}


}
