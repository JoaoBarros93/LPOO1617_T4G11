package GUI;

import java.awt.*;
import javax.swing.*;

import Logic.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 370);
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
		fldGuardPersona.addItem("Select");
		fldGuardPersona.addItem("Rookie");
		fldGuardPersona.addItem("Druken");
		fldGuardPersona.addItem("Suspicious");

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setBounds(553, 240, 100, 23);
		frame.getContentPane().add(btnExitGame);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(26, 101, 285, 110);
		frame.getContentPane().add(textArea);
		

		JLabel lblNewLabel = new JLabel("You can start a new game.");
		lblNewLabel.setBounds(28, 244, 283, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton btnUpButton = new JButton("UP");
		btnUpButton.setEnabled(false);
		btnUpButton.setBounds(553, 90, 89, 23);
		frame.getContentPane().add(btnUpButton);

		JButton btnDownButton = new JButton("DOWN");
		btnDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.updateGame('s');

			}
		});
		btnDownButton.setEnabled(false);
		btnDownButton.setBounds(553, 160, 89, 23);
		frame.getContentPane().add(btnDownButton);

		JButton btnLeftButton = new JButton("LEFT");
		btnLeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnLeftButton.setEnabled(false);
		btnLeftButton.setBounds(487, 124, 89, 23);
		frame.getContentPane().add(btnLeftButton);

		JButton btnRightButton = new JButton("RIGHT");
		btnRightButton.setEnabled(false);
		btnRightButton.setBounds(605, 124, 89, 23);
		frame.getContentPane().add(btnRightButton);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numOgres;
				String guardPersonality;

				numOgres = Integer.parseInt(fldNumOgres.getText());
				guardPersonality = fldGuardPersona.getSelectedItem().toString();

				game = new Game(guardPersonality, numOgres);
				
				textArea.append(game.getMap());
				
				btnRightButton.setEnabled(true);
				btnLeftButton.setEnabled(true);
				btnUpButton.setEnabled(true);
				btnDownButton.setEnabled(true);
				
				lblNewLabel.setText("You can play now.");
				
			}
		});

		btnNewGame.setBounds(553, 7, 100, 23);
		frame.getContentPane().add(btnNewGame);

	}

}
