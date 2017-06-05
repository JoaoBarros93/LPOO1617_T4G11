package GUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

public class OptionsMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public OptionsMenu(Board frame) {
		
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 109, 68, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(180, 152, 68, 20);
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setpanel(frame.mainMenu);
			}
		});
		btnNewButton.setBounds(381, 266, 59, 23);
		add(btnNewButton);
		


	}
}
