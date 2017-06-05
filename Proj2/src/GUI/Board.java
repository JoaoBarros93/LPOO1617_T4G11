package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Board extends JFrame {
		
	private Image Player1;
	private Image Player2;
	private Image Player3;
	private Image Player4;
	
	
	private Image backGroundMainMenu;
	
	private Image backGroundGame;
	
	  JPanel cards;
	  JPanel mainMenu;
	  GamePanel gamePanel;
	  public JPanel optionsMenu;



	/**
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		mainMenu=new  MainMenu(this);
		optionsMenu=new  OptionsMenu(this);
		gamePanel=new  GamePanel(this);
		

		setpanel(gamePanel);
        setVisible(true); //Make JFrame visible
	}
	
	
	private void loadImages() {
		//wall = new ImageIcon("src/Images/Wall.png").getImage();

	}
	
	public void setpanel(JPanel panel)
	{
		JPanel contentPane = (JPanel) getContentPane();

		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate(); 
		contentPane.repaint();
	}



}

