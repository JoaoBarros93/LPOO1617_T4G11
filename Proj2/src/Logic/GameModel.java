package Logic;


import java.util.List;
import java.util.Vector;

import Logic.BotBehaviours.BotBehaviour;


/**
 * Controls the physics aspect of the game.
 */

public class GameModel {
    /**
     * The arena width in meters.
     */
    public static final int ARENA_WIDTH = 800;

    /**
     * The arena height in meters.
     */
    public static final int ARENA_HEIGHT = 480;
    
    
    /**
     * The arena. 
     */
    private Map map;
    
    
    /**
     * The players. 
     */
    Vector<Player> players;
    
    /**
     * The players. 
     */    
    Vector<Bot> bots;
    
    
  
    public GameModel(int NumHuman, int NumBots, BotBehaviour behaviour) {
    	map= new Map(ARENA_WIDTH,ARENA_HEIGHT);
    	players=new Vector<Player>();        
        bots =  new Vector<Bot>();
    	
    	for(int i = 0; i<NumHuman; i++)
    		players.add(new Player());
    	
    	for(int i = 0; i<NumBots; i++){
    		bots.add(new Bot());
    		bots.get(i).setBehaviour(behaviour);
    	}
    	
    	  	
    		
    	//falta coordenadas iniciais
    	
    	initialize();
    	
    	
    }
    
    
    public void  initialize() {
    	int InitialX[]={0,0,ARENA_WIDTH,ARENA_WIDTH};
    	int InitialY[]={0,ARENA_HEIGHT,0,ARENA_HEIGHT};
    	int InitialDir[]={6,8,2,4};
    	int num=0;
    	
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setDirection(InitialDir[num]);
			players.get(i).setX(InitialX[num]);
			players.get(i).setY(InitialY[num]);
			players.get(i).setId(num+1);
			num++;

		}

		for (int i = 0; i < bots.size(); i++) {
			bots.get(i).setDirection(InitialDir[num]);
			bots.get(i).setX(InitialX[num]);
			bots.get(i).setY(InitialY[num]);
			bots.get(i).setId(num+1);
			num++;

		}
    	
    	  	
    		
    	//falta cor?? 		
    		
    	
    	
    }

    /**
     * Calculates the next  step of duration delta (in seconds).
     *
     * @param delta The size of this physics step in seconds.
     */
    public void update(float delta) {
    	
    	//change if needed dir of bot
    	
    	for(int i = 0; i<bots.size(); i++)
    		bots.get(i).moveBot(map,bots.get(i));
    	
    	//Updates Position
    	
    	
    	for (int i = 0; i < players.size(); i++) {
			players.get(i).updatePos();

		}

		for (int i = 0; i < bots.size(); i++) {
			players.get(i).updatePos();
		}
		
		
		//check if they are alive
		//Warning!: Needs to be improved
		
		
		for(int i = 0; i<bots.size(); i++){
			if(0<bots.get(i).getX() || bots.get(i).getX()>ARENA_WIDTH)
				bots.get(i).setAlive(false);
			
			if(0<bots.get(i).getY() || bots.get(i).getX()>ARENA_HEIGHT)
			bots.get(i).setAlive(false);
			
			//if(map.getPosMap())
				
		}
    	
    	for (int i = 0; i < players.size(); i++) {
			players.get(i).updatePos();

		}
		
		
    	

        //float frameTime = Math.min(delta, 0.25f);    
    	
    
    
    }
    	
    	



}
