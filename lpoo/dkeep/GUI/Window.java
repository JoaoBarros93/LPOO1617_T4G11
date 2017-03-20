package GUI;

import java.awt.*;
import javax.swing.*;

import Logic.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;
	JLabel lblNewLabel;
	JTextArea textArea;
	JButton btnUpButton;
	JButton btnDownButton;
	JButton btnLeftButton;
	JButton btnRightButton;
	
	Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}
	
	public void heroMove(char dir) {
		boolean continueGame = game.updateGame(dir);
		textArea.setText(game.getMap());
		
		//if true, continue playing
		 if(continueGame)
			 return;
		 else gameOver();
	 
	}
	
	public void gameOver() {
		disableButtons();
		int result = game.results();

		switch (result) {
		case 0:
			lblNewLabel.setText("You Won the Game!");
			break;
		case 1:
			lblNewLabel.setText("Game Over! The Guard has caught you!");
			break;
		case 2:
			lblNewLabel.setText("Game Over! A Ogre has killed you!");
			break;

		}

	}
	
	public void disableButtons(){
		btnRightButton.setEnabled(false);
		btnLeftButton.setEnabled(false);
		btnUpButton.setEnabled(false);
		btnDownButton.setEnabled(false);
		
		
	}


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNumberOfOgres = new JLabel("Number of Ogres:");
		lblNumberOfOgres.setBounds(10, 11, 117, 14);
		frame.getContentPane().add(lblNumberOfOgres);

		JTextPane fldNumOgres = new JTextPane();
		fldNumOgres.setBounds(116, 11, 39, 20);
		frame.getContentPane().add(fldNumOgres);

		JLabel lblGuardPersonality = new JLabel("Guard Personality:");
		lblGuardPersonality.setBounds(10, 64, 136, 14);
		frame.getContentPane().add(lblGuardPersonality);

		JComboBox fldGuardPersona = new JComboBox();
		fldGuardPersona.setBounds(116, 61, 80, 20);
		frame.getContentPane().add(fldGuardPersona);
		fldGuardPersona.addItem("Rookie");
		fldGuardPersona.addItem("Druken");
		fldGuardPersona.addItem("Suspicious");

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(450, 236, 100, 23);
		frame.getContentPane().add(btnExitGame);

		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(26, 101, 285, 218);
		frame.getContentPane().add(textArea);
		
		lblNewLabel = new JLabel("You can start a new game.");
		lblNewLabel.setBounds(26, 359, 283, 14);
		frame.getContentPane().add(lblNewLabel);

		btnUpButton = new JButton("UP");
		btnUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroMove('w');	
				
			}
		});
		btnUpButton.setEnabled(false);
		btnUpButton.setBounds(450, 90, 89, 23);
		frame.getContentPane().add(btnUpButton);

		btnDownButton = new JButton("DOWN");
		btnDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroMove('s');	

			}
		});
		btnDownButton.setEnabled(false);
		btnDownButton.setBounds(450, 158, 89, 23);
		frame.getContentPane().add(btnDownButton);

		btnLeftButton = new JButton("LEFT");
		btnLeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroMove('a');	

			}
		});
		btnLeftButton.setEnabled(false);
		btnLeftButton.setBounds(387, 124, 89, 23);
		frame.getContentPane().add(btnLeftButton);

		btnRightButton = new JButton("RIGHT");
		btnRightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroMove('d');	
			}
		});
		btnRightButton.setEnabled(false);
		btnRightButton.setBounds(514, 124, 89, 23);
		frame.getContentPane().add(btnRightButton);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numOgres;
				String guardPersonality;

				numOgres = Integer.parseInt(fldNumOgres.getText());
				guardPersonality = fldGuardPersona.getSelectedItem().toString();
				
				if(numOgres<0 || numOgres>5){
					lblNewLabel.setText("Invalid number of Ogres.");
					return;
					
				}

				game = new Game(guardPersonality, numOgres);
				
				textArea.setText(game.getMap());
				
				btnRightButton.setEnabled(true);
				btnLeftButton.setEnabled(true);
				btnUpButton.setEnabled(true);
				btnDownButton.setEnabled(true);
				
				lblNewLabel.setText("You can play now.");
				
			}
		});
		
		

		btnNewGame.setBounds(450, 36, 100, 23);
		frame.getContentPane().add(btnNewGame);

	}

}
