package GUI;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
	
	private Image Player1;
	private Image Player2;
	private Image Player3;
	private Image Player4;
	
	private Image tail1;
	private Image tail2;
	private Image tail3;
	private Image tail4;
	
	private Image backGroundGame;
	
	private boolean drawGame = false;
	
	int game[][]={{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0,0}
	};
	
	
	/**
	 * Create the panel.
	 */
	public GamePanel(Board board) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 95, 169, 86);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(53, 11, 46, 14);
		panel.add(lblStatus);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(panel);
				repaint();
			}
		});
		btnNewButton.setBounds(10, 52, 69, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(88, 52, 69, 23);
		panel.add(button);
		
		
		
		loadImages();


	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backGroundGame, 0, 0, getWidth(), getHeight(), null);
		displayGame(g);

		requestFocusInWindow();

	}
	
	

	private void loadImages() {
		Player1 = new ImageIcon("src/Images/p1.png").getImage();

		Player2 = new ImageIcon("src/Images/p2.png").getImage();

		tail1 = new ImageIcon("src/Images/tail1.png").getImage();
		
		backGroundGame = new ImageIcon("src/Images/backGame.png").getImage();

		
	}
	
	void displayGame(Graphics g) {

		int deltay = getHeight() /game.length;
		int deltax = getWidth() / game[0].length;

		for(int i = 0; i<game.length;i++)
			for(int j = 0; j<game[i].length;j++)
				if(game[i][j]==1)
			g.drawImage(tail1, deltax * j, deltay * i, deltax, deltay, null);
	}
}
