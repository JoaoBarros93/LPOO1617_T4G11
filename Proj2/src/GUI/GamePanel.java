package GUI;

import javax.swing.JPanel;
import javax.swing.Timer;

import Logic.Game;
import Logic.Map;
import Logic.Player;
import Logic.BotBehaviours.*;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements ActionListener {
	
	  private final int DELAY = 25;
	  private Timer timer;
	
	Board board;
	
	private Image Player1;
	private Image Player2;
	private Image Player3;
	private Image Player4;
	
	private Image tail1;
	private Image tail2;
	private Image tail3;
	private Image tail4;
	
	
	
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
		game = new Game(1, board.optionsMenu.getAISelected(),
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
		Player1 = new ImageIcon("src/Images/p1.png").getImage();
		Player2 = new ImageIcon("src/Images/p2.png").getImage();
		Player3 = new ImageIcon("src/Images/p3.png").getImage();
		Player4 = new ImageIcon("src/Images/p4.png").getImage();

		tail1 = new ImageIcon("src/Images/tail1.png").getImage();
		tail2 = new ImageIcon("src/Images/tail2.png").getImage();
		tail3 = new ImageIcon("src/Images/tail3.png").getImage();
		tail4 = new ImageIcon("src/Images/tail4.png").getImage();
		
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

		int deltay = getHeight() /map.getMaxY();
		int deltax = getWidth() / map.getMaxXsize();
		
		

		for (int y = 0; y < game.getMap().getMaxY(); y++)
			for (int x = 0; x < map.getMaxXsize(); x++)
				if (map.getPosMap(x, y) != 0)
					g.drawImage(tail1, deltax * x, deltay * y, deltax, deltay, null);
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
