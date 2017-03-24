package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Board extends JFrame {

	private JPanel mainPanel;

	JPanel panelSettings;
	JButton btnNewGame;
	JButton btnOptions;
	JButton btnExit;

	JPanel Controls;
	JButton btnDown;
	JButton btnUp;
	JButton btnLeft;
	JButton btnRight;

	JLabel lblGameStatus;

	String NumOfOgres = "1";
	String GuardPersonality = "Rookie";

	GamePanel gamePanel;

	/**
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(mainPanel);

		panelSettings = new JPanel();
		mainPanel.add(panelSettings, BorderLayout.NORTH);
		panelSettings.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		initUI();
		pack();

	}

	public void initUI() {

		initNewGameButton();

		initOptions();

		initExitButton();

		initGameArea();

		initGameStatusLabel();

		initDirectionButtons();

	}

	private void createOptionsFrame() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame options = new JFrame();
				// options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				options.setBounds(100, 100, 450, 300);
				JPanel contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				options.setContentPane(contentPane);
				contentPane.setLayout(null);

				JTextField tfNumOgres = new JTextField();
				tfNumOgres.setText(NumOfOgres);
				tfNumOgres.setBounds(144, 70, 86, 20);
				contentPane.add(tfNumOgres);
				tfNumOgres.setColumns(10);

				JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
				lblNumberOfOgres.setBounds(28, 73, 106, 14);
				contentPane.add(lblNumberOfOgres);

				JLabel lblGuardPersonality = new JLabel("Guard Personality");
				lblGuardPersonality.setBounds(28, 112, 106, 14);
				contentPane.add(lblGuardPersonality);

				JComboBox<String> fldGuardPersona = new JComboBox<String>();
				fldGuardPersona.setBounds(144, 109, 86, 20);
				contentPane.add(fldGuardPersona);
				fldGuardPersona.addItem("Rookie");
				fldGuardPersona.addItem("Druken");
				fldGuardPersona.addItem("Suspicious");
				if (GuardPersonality == "Rookie")
					fldGuardPersona.setSelectedIndex(0);
				else if (GuardPersonality == "Druken")
					fldGuardPersona.setSelectedIndex(1);
				else if (GuardPersonality == "Suspicious")
					fldGuardPersona.setSelectedIndex(2);
				options.setVisible(true);

				WindowListener exitListener = new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						GuardPersonality = fldGuardPersona.getSelectedItem().toString();
						NumOfOgres = tfNumOgres.getText();

					}
				};
				options.addWindowListener(exitListener);

			}
		});

	}

	public void initOptions() {
		btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOptionsFrame();

			}

		});
		panelSettings.add(btnOptions);

	}

	public void initExitButton() {

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelSettings.add(btnExit);

	}

	public void initGameArea() {
		gamePanel = new GamePanel();
		gamePanel.setPreferredSize(new Dimension(500, 500));
		gamePanel.setBackground(Color.BLACK);
		mainPanel.add(gamePanel, BorderLayout.CENTER);

	}

	public void initGameStatusLabel() {

		lblGameStatus = new JLabel("You can start a new game.");
		mainPanel.add(lblGameStatus, BorderLayout.SOUTH);

	}

	public void initDirectionButtons() {
		Controls = new JPanel();
		mainPanel.add(Controls, BorderLayout.EAST);
		Controls.setLayout(new MigLayout("", "[64.00px][64.00px][64px]", "[23px][][][23px][][][]"));

		btnUp = new JButton("   Up   ");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gamePanel.heroMove('w'))
					gameOver();

			}
		});
		btnUp.setEnabled(false);
		Controls.add(btnUp, "cell 1 1,alignx center,aligny top");

		btnDown = new JButton(" Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gamePanel.heroMove('s'))
					gameOver();
			}
		});
		btnDown.setEnabled(false);
		Controls.add(btnDown, "cell 1 2,alignx center,aligny top");

		btnLeft = new JButton("  Left ");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gamePanel.heroMove('a'))
					gameOver();
			}
		});
		btnLeft.setEnabled(false);
		Controls.add(btnLeft, "cell 0 2,alignx right,aligny top");

		btnRight = new JButton("Right ");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gamePanel.heroMove('d'))
					gameOver();
			}
		});
		btnRight.setEnabled(false);
		Controls.add(btnRight, "cell 2 2,alignx left,aligny top");

	}

	public void initNewGameButton() {

		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				if (!NumOfOgres.matches("[0-9]+") || NumOfOgres.length() != 1) {
					lblGameStatus.setText("Invalid number of Ogres.");
					return;
				}
				int numOgres = Integer.parseInt(NumOfOgres);
				if (numOgres < 1 || numOgres > 5) {
					lblGameStatus.setText("Invalid number of Ogres.");
					return;
				}

				gamePanel.startGame(GuardPersonality, numOgres);

				lblGameStatus.setText("You can play now.");
				enableButtons();

			}
		});
		panelSettings.add(btnNewGame);

	}

	public void gameOver() {
		disableButtons();
		int result = gamePanel.getGame().results();

		switch (result) {
		case 0:
			lblGameStatus.setText("You Won the Game!");
			break;
		case 1:
			lblGameStatus.setText("Game Over! The Guard has caught you!");
			break;
		case 2:
			lblGameStatus.setText("Game Over! A Ogre has killed you!");
			break;

		}

	}

	public void disableButtons() {
		btnRight.setEnabled(false);
		btnLeft.setEnabled(false);
		btnUp.setEnabled(false);
		btnDown.setEnabled(false);

	}

	public void enableButtons() {
		btnRight.setEnabled(true);
		btnLeft.setEnabled(true);
		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
	}

}
