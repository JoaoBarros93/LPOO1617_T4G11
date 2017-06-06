package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanelStatus extends JPanel {
	
	
	

	/**
	 * Create the panel.
	 */
	public GamePanelStatus(GamePanel panel) {
		
		setBounds(141, 95, 252, 166);		
		setLayout(null);
		
		JLabel lblStatus = new JLabel("Game Status");
		lblStatus.setBounds(52, 27, 138, 14);
		add(lblStatus);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.remove(panel.gamePanelStatus);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(30, 89, 69, 23);
		add(btnNewButton);
		
		JButton button = new JButton("Back");
		button.setBounds(145, 89, 69, 23);
		add(button);
		

	}

}
