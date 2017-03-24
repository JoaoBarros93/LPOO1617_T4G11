package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Options {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Options frame = new Options();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Options() {
		JFrame options = new JFrame();
		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		options.setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		options.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField tfNumOgres  = new JTextField();
		
		tfNumOgres .setBounds(144, 70, 86, 20);
		contentPane.add(tfNumOgres);
		tfNumOgres.setColumns(10);
		
		JLabel lblNumberOfOgres  = new JLabel("Number of Ogres");
		lblNumberOfOgres .setBounds(28, 73, 106, 14);
		contentPane.add(lblNumberOfOgres );
		
		JLabel lblGuardPersonality  = new JLabel("Guard Personality");
		lblGuardPersonality .setBounds(28, 112, 106, 14);
		contentPane.add(lblGuardPersonality );
		
		JComboBox<String> fldGuardPersona = new JComboBox<String>();
		fldGuardPersona.setBounds(144, 109, 86, 20);
		contentPane.add(fldGuardPersona);
		fldGuardPersona.addItem("Rookie");
		fldGuardPersona.addItem("Druken");
		fldGuardPersona.addItem("Suspicious");
		options.setVisible(true);
	}
}
