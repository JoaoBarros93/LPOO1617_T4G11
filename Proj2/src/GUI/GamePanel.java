package GUI;

import javax.swing.JPanel;
import javax.swing.Timer;

import Logic.Game;
import Logic.Map;
import Logic.Player;
import Logic.BotBehaviours.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements ActionListener {
	
	  private final int DELAY = 25*4;
	  private Timer timer;
	
	Board board;
	
	Image[] PlayersH;
	Image[] PlayersV;
	
	private Image tail1;
	private Image tail2;
	private Image tail3;
	private Image tail4;
	
	private Image wall;
	
	
	
	private BotBehaviour[] botBehaviours = new BotBehaviour[4];
	
	public Image backGroundGame;
	
	private boolean drawGame=false;
	boolean gameOver=true;
	boolean showPanel=false;
	
	private int playerWhoWon;
		
	GamePanelStatus gamePanelStatus;
	
	
	
	Game game;
	
	/**
	 * Create the panel.
	 */
	public GamePanel(Board board) {
		setLayout(null);
		//setBounds(100, 100, 800, 600);
		this.board=board;
		addKeyListener(new TAdapter());
		
		gamePanelStatus= new GamePanelStatus(this);		
		
		botBehaviours[0]=new Random();
		botBehaviours[1]=new WallHugging();
		botBehaviours[2]=new EnemyAvoidance();
		botBehaviours[3]=new MostOpenDestination();
		
		//game=new Game (1, 1,botBehaviours[0]);
		
		loadImages();
		
		 timer = new Timer(DELAY, this);
		 timer.start();	

		
		


	}
	
	public void startGameSingle() throws InterruptedException{
		game = new Game(1, board.optionsMenu.getNumBotsSelected(),
				botBehaviours[board.optionsMenu.getBotBehaviourSelected()]);
		//game = new Game(1, 1,botBehaviours[0]);
		drawGame = true;
		gameOver=false;
		showPanel=false;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backGroundGame, 0, 0, getWidth(), getHeight(), null);
		
		if(drawGame)
		displayGame(g);

		requestFocusInWindow();

	}
	
	

	private void loadImages() {
		
		Image Player1H = new ImageIcon("src/Images/p1H.png").getImage();
		Image Player2H = new ImageIcon("src/Images/p2H.png").getImage();
		Image Player3H = new ImageIcon("src/Images/p3H.png").getImage();
		Image Player4H = new ImageIcon("src/Images/p4H.png").getImage();
		PlayersH=new Image[]{Player1H,Player2H,Player3H,Player4H};
		
		Image Player1V = new ImageIcon("src/Images/p1V.png").getImage();
		Image Player2V = new ImageIcon("src/Images/p2V.png").getImage();
		Image Player3V = new ImageIcon("src/Images/p3V.png").getImage();
		Image Player4V = new ImageIcon("src/Images/p4V.png").getImage();
		PlayersV=new Image[]{Player1V,Player2V,Player3V,Player4V};

		tail1 = new ImageIcon("src/Images/tail1.png").getImage();
		tail2 = new ImageIcon("src/Images/tail2.png").getImage();
		tail3 = new ImageIcon("src/Images/tail3.png").getImage();
		tail4 = new ImageIcon("src/Images/tail4.png").getImage();
		
		wall = new ImageIcon("src/Images/Wall.png").getImage();
		
		backGroundGame = new ImageIcon("src/Images/backGame.png").getImage();

		
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {


		if (!gameOver) {
			gameOver = game.update();
			showPanel = gameOver;
			playerWhoWon=game.getPlayerwhoWon();
		}

		if (showPanel && gameOver) {
			if (game.getPlayerwhoWon() != -1)
				gamePanelStatus.lblStatus.setText("You Won!");
			else
				gamePanelStatus.lblStatus.setText("You Lose!");

			add(gamePanelStatus);

		}

		repaint();
	}
	
	void displayGame(Graphics g) {
		
		Map map= game.getMap();
		
		int gh=getHeight();
		int gmy=map.getMaxY();
		int gw=getWidth();
		int gmx=map.getMaxXsize();
		
		

		int deltay = getHeight() /map.getMaxY();
		int deltax = getWidth() / map.getMaxXsize();
		
		

		for (int y = 0; y < game.getMap().getMaxY(); y++)
			for (int x = 0; x < map.getMaxXsize(); x++)
				switch(map.getPosMap(x, y)){
				case -1:
					g.drawImage(wall, deltax * x, deltay * y, deltax, deltay, null);
					break;
				case 1:
					g.drawImage(tail1, deltax * x, deltay * y, deltax, deltay, null);
					break;
				case 2:
					g.drawImage(tail2, deltax * x, deltay * y, deltax, deltay, null);
					break;
				case 3:
					g.drawImage(tail3, deltax * x, deltay * y, deltax, deltay, null);
					break;
				case 4:
					g.drawImage(tail4, deltax * x, deltay * y, deltax, deltay, null);
					break;
				
				}
	
		for (int i = 0; i < game.getPlayers().size(); i++) {
			if(game.getPlayers().get(i).isAlive())
				switch(game.getPlayers().get(i).getDirection()){
				case Player.UP:
					g.drawImage(PlayersV[game.getPlayers().get(i).getId()-1], deltax * game.getPlayers().get(i).getX()-3, deltay * game.getPlayers().get(i).getY(), deltax*2, deltay*4, null);
					break;
				case Player.RIGHT:
					g.drawImage(PlayersH[game.getPlayers().get(i).getId()-1], deltax * game.getPlayers().get(i).getX()-deltax*3, deltay * game.getPlayers().get(i).getY()-3, deltax*4, deltay*2, null);
					break;
				case Player.DOWN:
					g.drawImage(PlayersV[game.getPlayers().get(i).getId()-1], deltax * game.getPlayers().get(i).getX()-3, deltay * game.getPlayers().get(i).getY()-deltax*3, deltax*2, deltay*4, null);
					break;
				case Player.LEFT:
					g.drawImage(PlayersH[game.getPlayers().get(i).getId()-1], deltax * game.getPlayers().get(i).getX(), deltay * game.getPlayers().get(i).getY()-3, deltax*4, deltay*2, null);
					break;
				
				}
			}
			
			for (int i = 0; i < game.getBots().size(); i++) {
				if(game.getBots().get(i).isAlive())
					switch(game.getBots().get(i).getDirection()){
					case Player.UP:
						g.drawImage(PlayersV[game.getBots().get(i).getId()-1], deltax * game.getBots().get(i).getX()-3, deltay * game.getBots().get(i).getY(), deltax*2, deltay*4, null);
						break;
					case Player.RIGHT:
						g.drawImage(PlayersH[game.getBots().get(i).getId()-1], deltax * game.getBots().get(i).getX()-deltax*3, deltay * game.getBots().get(i).getY()-3, deltax*4, deltay*2, null);
						break;
					case Player.DOWN:
						g.drawImage(PlayersV[game.getBots().get(i).getId()-1], deltax * game.getBots().get(i).getX()-3, deltay * game.getBots().get(i).getY()-deltax*3, deltax*2, deltay*4, null);
						break;
					case Player.LEFT:
						g.drawImage(PlayersH[game.getBots().get(i).getId()-1], deltax * game.getBots().get(i).getX(), deltay * game.getBots().get(i).getY()-3, deltax*4, deltay*2, null);
						break;
					
					}
			}
				
				


		/*
		for (int i = 0; i < game.getBots().size(); i++) {
			if(game.getBots().get(i).isAlive())
				g.drawImage(Players[game.getBots().get(i).getId()], deltax * game.getBots().get(i).getX(), deltay * game.getBots().get(i).getY(), deltax, deltay, null);


		}*/

	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && !game.isDirPlayer(0,Player.RIGHT)) {
            	game.setDirPlayer(0, Player.LEFT);
            }

            if ((key == KeyEvent.VK_RIGHT) && !game.isDirPlayer(0,Player.LEFT)) {
            	game.setDirPlayer(0, Player.RIGHT);
            }

            if ((key == KeyEvent.VK_UP) && !game.isDirPlayer(0,Player.DOWN)) {
            	game.setDirPlayer(0, Player.UP);
            }

            if ((key == KeyEvent.VK_DOWN) && !game.isDirPlayer(0,Player.UP)) {
            	game.setDirPlayer(0, Player.DOWN);
            }
        }
    }
	
}
