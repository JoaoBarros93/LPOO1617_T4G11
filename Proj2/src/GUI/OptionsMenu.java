package GUI;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class OptionsMenu extends JPanel {
	
	Board frame;
	
	public JComboBox<String> comboBoxAI;
	public JComboBox<String> comboBoxNumBots;



	/**
	 * Create the panel.
	 */
	public OptionsMenu(Board frame) {
		
		setLayout(null);
		
		this.frame=frame;
		
		comboBoxAI = new JComboBox<String>();
		comboBoxAI.setBounds(300, 221, 219, 20);
		add(comboBoxAI);
		initAISelector();
		
		comboBoxNumBots = new JComboBox<String>();
		comboBoxNumBots.setBounds(300, 288, 219, 20);
		add(comboBoxNumBots);
		initNumBotsSelector();
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setpanel(frame.mainMenu);
			}
		});
		btnNewButton.setBounds(677, 527, 79, 23);
		add(btnNewButton);
		


	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(frame.backGroundMainMenu, 0, 0, getWidth(), getHeight(), null);
	
		//requestFocusInWindow();

	}
	

	public void initAISelector() {
		

		comboBoxAI.addItem("Random");
		comboBoxAI.addItem("Wall-hugging");
		comboBoxAI.addItem("Enemy Avoidance");
		comboBoxAI.addItem("Most Open Destination");

	}
	
	public void initNumBotsSelector() {
		
		comboBoxNumBots.addItem("1");
		comboBoxNumBots.addItem("2");
		comboBoxNumBots.addItem("3");

	}
	
	public int getNumBotsSelected(){
		return Integer.parseInt(comboBoxNumBots.getSelectedItem().toString());		
		
	}
	
	public int getBotBehaviourSelected(){
		int i =comboBoxAI.getSelectedIndex();
		
		return comboBoxAI.getSelectedIndex();
		
		
	}
	
}
