package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GamePanelStatus extends JPanel {

	public JLabel lblStatus;

	/**
	 * Create the panel.
	 */
	public GamePanelStatus(GamePanel panel) {

		setBounds(286, 217, 252, 166);
		setLayout(null);

		lblStatus = new JLabel("Game Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(85, 30, 92, 14);
		add(lblStatus);

		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.remove(panel.gamePanelStatus);
				panel.repaint();
				try {
					if (panel.gameType == 0)
						panel.startGameSingle();
					else
						panel.startGameMulti();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(30, 89, 79, 23);
		add(btnNewButton);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.board.setpanel(panel.board.mainMenu);
			}
		});
		button.setBounds(145, 89, 79, 23);
		add(button);

	}

}
