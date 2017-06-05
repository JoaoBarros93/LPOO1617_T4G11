package Logic;

import Logic.BotBehaviours.BotBehaviour;

public class Bot extends Player {
	
	private BotBehaviour behaviour;
	
	public boolean isBot(){
		return false;
	}
	
	public void setBehaviour(BotBehaviour behaviour) {
		this.behaviour = behaviour;
		
		}
	
	public void moveBot(Map map, Player player) {
		this.behaviour.moveBot(map, player);
		
		
		} 
	

}
