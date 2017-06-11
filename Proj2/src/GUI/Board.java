package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JFrame {

	public Image backGroundMainMenu;

	public Image backGroundGame;

	MainMenu mainMenu;
	GamePanel gamePanel;
	public OptionsMenu optionsMenu;

	/**
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 806, 629);
		setResizable(false);

		backGroundMainMenu = new ImageIcon("src/Images/BackGround.png").getImage();

		mainMenu = new MainMenu(this);
		optionsMenu = new OptionsMenu(this);
		gamePanel = new GamePanel(this);

		setpanel(mainMenu);
		setVisible(true);
	}

	public void setpanel(JPanel panel) {
		JPanel contentPane = (JPanel) getContentPane();

		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate();
		contentPane.repaint();
	}

}
