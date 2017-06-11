package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {

	Board frame;

	/**
	 * Create the panel.
	 */
	public MainMenu(Board frame) {
		setLayout(null);

		this.frame = frame;

		JButton btnNewButton = new JButton("SinglePlayer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setpanel(frame.gamePanel);
				frame.gamePanel.remove(frame.gamePanel.gamePanelStatus);
				frame.gamePanel.repaint();
				try {
					frame.gamePanel.startGameSingle();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(329, 265, 142, 30);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("MultiPlayer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setpanel(frame.gamePanel);
				frame.gamePanel.remove(frame.gamePanel.gamePanelStatus);
				frame.gamePanel.repaint();
				try {
					frame.gamePanel.startGameMulti();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(329, 317, 142, 30);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Options");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setpanel(frame.optionsMenu);
			}
		});
		btnNewButton_2.setBounds(329, 367, 142, 30);
		add(btnNewButton_2);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(frame.backGroundMainMenu, 0, 0, getWidth(), getHeight(), null);

		requestFocusInWindow();

	}

}
