package com.mygdx.controller;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Bot;
import com.mygdx.game.Map;
import com.mygdx.game.Player;

import java.util.List;
import java.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Controls the physics aspect of the game.
 */

public class GameController {
    /**
     * The arena width in meters.
     */
    public static final int ARENA_WIDTH = 100;

    /**
     * The arena height in meters.
     */
    public static final int ARENA_HEIGHT = 50;
    
    //private final int NUM_PLAYERS=4;
    
    /**
     * The arena. 
     */
    private Map map;
    
    
    /**
     * The players. 
     */
    Vector<Player> players;
    
    Vector<Bot> bots;
    
    
  
    public GameController(int NumHuman, int NumBots) {
    	map= new Map(ARENA_WIDTH,ARENA_HEIGHT);
    	players=new Vector<Player>();        
        bots =  new Vector<Bot>();
    	
    	for(int i = 0; i<NumHuman; i++)
    		players.add(new Player());
    	
    	for(int i = 0; i<NumBots; i++)
    		bots.add(new Bot());
    	
    	
    	//falta coordenadas iniciais
    	
    	
    }

    /**
     * Calculates the next physics step of duration delta (in seconds).
     *
     * @param delta The size of this physics step in seconds.
     */
    public void update(float delta) {
    	
        //float frameTime = Math.min(delta, 0.25f);    }



}
