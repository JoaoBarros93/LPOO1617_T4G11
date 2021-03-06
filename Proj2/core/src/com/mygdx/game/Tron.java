package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tron extends Game {
	private SpriteBatch batch;
	private AssetManager assetManager;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();

        startGame();
	}
	
	/**
     * Starts the game.
     */
    private void startGame() {
        GameModel model = new GameModel(GameController.ARENA_WIDTH / 2, GameController.ARENA_HEIGHT / 2, 100);

        setScreen(new GameView(this, model, new GameController(model)));
    }

	
	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}
	
	
	 /**
     * Returns the asset manager used to load all textures and sounds.
     *
     * @return the asset manager
     */
	public AssetManager getAssetManager() {
		return assetManager;
	}

    /**
     * Returns the sprite batch used to improve drawing performance.
     *
     * @return the sprite batch
     */
	public SpriteBatch getBatch() {
		return batch;
	}
	
}
