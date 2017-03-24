package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Logic.Game;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener {
	
	private Board win;

	private Image wall;
	//private Image floor;
	private Image stairs;
	private Image doorClosed;
	private Image keyHit;
	private Image keyNotHit;
	private Image leverActive;
	private Image leverInactive;
	private Image heroUnarmed;
	private Image heroArmed;
	private Image guardAsleep;
	private Image guardAwake;
	private Image ogre;
	private Image ogreCube;
	private Image ogreStunned;
	private Image backGround;

	private Game game;

	public Game getGame() {
		return game;
	}



	private boolean drawMap = false;
	
	public GamePanel(Board win) {
		this.win=win;
		addKeyListener(this);
		backGround =  new ImageIcon("dkeep/Images/BackGround.png").getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (drawMap) {
			displayGame(g);
		}
		else g.drawImage(backGround, 0, 0, getWidth(), getHeight(), null);
	
		
		requestFocusInWindow();
		

	}
	
	public void displayGame(Graphics g) {
		displayMap(g);
				
		if (game.levelIsOn() == 1) {			
			displayGuard(g);			
			displayLever(g);			
		} else {		
			displayOgres(g);			
			displayKey(g);

		}
		
		displayDoors(g);
		displayHero(g);
	}

	void displayHero(Graphics g) {

		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;
		
		if (game.levelIsOn() == 1) {			
			g.drawImage(heroUnarmed, deltax * game.getHero().getX(), deltay * game.getHero().getY(), deltax, deltay, null);			
		} else {		
			g.drawImage(heroArmed, deltax * game.getHero().getX(), deltay * game.getHero().getY(), deltax, deltay, null);

		}

	}

	void displayDoors(Graphics g) {
		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;

		for (int i = 0; i < game.getDoors().size(); i++)
			if (game.getDoors().get(i).isOpen())
				g.drawImage(stairs, deltax * game.getDoors().get(i).getX(), deltay * game.getDoors().get(i).getY(),
						deltax, deltay, null);
			else
				g.drawImage(doorClosed, deltax * game.getDoors().get(i).getX(), deltay * game.getDoors().get(i).getY(),
						deltax, deltay, null);
			
	}
	

	void displayGuard(Graphics g) {
		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;
		
		if (game.getGuard().isAsleep()) {			
			g.drawImage(guardAsleep, deltax * game.getGuard().getX(), deltay * game.getGuard().getY(), deltax, deltay, null);			
		} else {		
			g.drawImage(guardAwake, deltax * game.getGuard().getX(), deltay * game.getGuard().getY(), deltax, deltay, null);

		}

	}

	void displayLever(Graphics g) {
		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;

		if (game.getLever().isActivated()) {
			g.drawImage(leverActive, deltax * game.getLever().getX(), deltay * game.getLever().getY(), deltax, deltay,
					null);
		} else {
			g.drawImage(leverInactive, deltax * game.getLever().getX(), deltay * game.getLever().getY(), deltax, deltay,
					null);

		}
		for (int i = 0; i < game.getLever().getDoors().size(); i++)
			if (game.getLever().getDoors().get(i).isOpen())
				g.drawImage(stairs, deltax * game.getLever().getDoors().get(i).getX(),
						deltay * game.getLever().getDoors().get(i).getY(), deltax, deltay, null);
			else
				g.drawImage(doorClosed, deltax * game.getLever().getDoors().get(i).getX(),
						deltay * game.getLever().getDoors().get(i).getY(), deltax, deltay, null);

	}

	void displayOgres(Graphics g) {
		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;
		
		for (int i = 0; i < game.getEnemies().size(); i++) {
			g.drawImage(ogreCube, deltax * game.getEnemies().get(i).getCube().getX(),
					deltay * game.getEnemies().get(i).getCube().getY(), deltax, deltay, null);
			
			if (game.getEnemies().get(i).isStunned())
				g.drawImage(ogreStunned, deltax * game.getEnemies().get(i).getX(),
						deltay * game.getEnemies().get(i).getY(), deltax, deltay, null);
			else
				g.drawImage(ogre, deltax * game.getEnemies().get(i).getX(), deltay * game.getEnemies().get(i).getY(),
						deltax, deltay, null);

			

		}

	}

	void displayKey(Graphics g) {
		int deltay = getHeight() /  game.getMapArray().length;
		int deltax = getWidth() / game.getMapArray()[0].length;

		if (!game.getHero().hasKey())
			if (game.getKey().isHit()) {

				g.drawImage(keyHit, deltax * game.getKey().getX(), deltay * game.getKey().getY(), deltax, deltay, null);
			} else {
				g.drawImage(keyNotHit, deltax * game.getKey().getX(), deltay * game.getKey().getY(), deltax, deltay,
						null);

			}
		else
			return;
		
		for (int i = 0; i < game.getKey().getDoors().size(); i++)
			if (game.getKey().getDoors().get(i).isOpen())
				g.drawImage(stairs, deltax * game.getKey().getDoors().get(i).getX(),
						deltay * game.getKey().getDoors().get(i).getY(), deltax, deltay, null);
			else
				g.drawImage(doorClosed, deltax * game.getKey().getDoors().get(i).getX(),
						deltay * game.getKey().getDoors().get(i).getY(), deltax, deltay, null);

	}
	

	public void displayMap(Graphics g) {

		char map[][] = game.getMapArray();

		int deltay = getHeight() / map.length;
		int deltax = getWidth() / map[0].length;

		for (int y = 0; y < map.length; y++)
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] == 'X')
					g.drawImage(wall, deltax * x, deltay * y, deltax, deltay, null);

			}

	}

	public boolean heroMove(char dir) {
		boolean continueGame = game.updateGame(dir);
		repaint();
		
		return continueGame;
	 
	}
	
	void startGame(String guardPersonality, int numOgres) {
		loadImages();
		

		game = new Game(guardPersonality, numOgres);
		drawMap=true;
		repaint();
	}
	
	

	private void loadImages() {
		ImageIcon ii;

		ii = new ImageIcon("dkeep/Images/Wall.png");
		wall = ii.getImage();

		ii = new ImageIcon("dkeep/Images/BackGround.png");
		backGround = ii.getImage();

		ii = new ImageIcon("dkeep/Images/Stairs.png");
		stairs = ii.getImage();

		ii = new ImageIcon("dkeep/Images/DoorClosed.png");
		doorClosed = ii.getImage();

		ii = new ImageIcon("dkeep/Images/KeyHit.png");
		keyHit = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/KeyNotHit.png");
		keyNotHit = ii.getImage();

		ii = new ImageIcon("dkeep/Images/LeverActive.png");
		leverActive = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/LeverInactive.png");
		leverInactive = ii.getImage();

		ii = new ImageIcon("dkeep/Images/HeroUnarmed.png");
		heroUnarmed = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/HeroArmed.png");
		heroArmed = ii.getImage();

		ii = new ImageIcon("dkeep/Images/GuardAsleep.png");
		guardAsleep = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/GuardAwake.png");
		guardAwake = ii.getImage();

		ii = new ImageIcon("dkeep/Images/Ogre.png");
		ogre = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/OgreCube.png");
		ogreCube = ii.getImage();
		
		ii = new ImageIcon("dkeep/Images/OgreStunned.png");
		ogreStunned = ii.getImage();
		
		

	}
	
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!game.isGameOn())
			return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (!heroMove('a'))
				win.gameOver();
			break;
		case KeyEvent.VK_RIGHT:
			if (!heroMove('d'))
				win.gameOver();
			break;
		case KeyEvent.VK_UP:
			if (!heroMove('w'))
				win.gameOver();
			break;
		case KeyEvent.VK_DOWN:
			if (!heroMove('s'))
				win.gameOver();
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	

}

