package view.mainjframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Color PALE_GREEN = new Color(153, 255, 204);
	public static final Color PALE_PURPLE = new Color(153, 153, 255);
	public static final Color CORNSILK = new Color(255, 254, 206);

	public MainJFrame() {

		initComponents();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: Make dynamic
		this.setSize(800, 800);
//		 setResizable(false);
//		this.pack();
		this.setVisible(true);
	}

	private void initComponents() {

		/**
		 * Using the GridBag Layout to set the layout of the widgets on the screen
		 */

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };

		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };

		getContentPane().setLayout(gridBagLayout);

		/**
		 * The widgets that will be used to create the welcome screen
		 */

		JPanel welcomePanel = new JPanel();
		JLabel heading = new JLabel();
		JLabel browseFlights = new JLabel();
		JLabel loginRegister = new JLabel();
		JLabel subHeading = new JLabel();
		JPanel bubblePanel = new JPanel();
		JLabel searchFlightForm = new JLabel();
		JRadioButton radioButton = new JRadioButton();
		JMenu departureCity = new JMenu();
		JMenu arrivalCity = new JMenu();
		JTextField day = new JTextField();
		JTextField month = new JTextField();
		JTextField year = new JTextField();
		JTextField hour = new JTextField();
		JTextField minute = new JTextField();
		JButton searchFlights = new JButton();

		getContentPane().setBackground(PALE_GREEN);

		/**
		 * The styling and layout for the Welcome Panel
		 */
		GridBagConstraints cWelcomePanel = new GridBagConstraints();
		welcomePanel.setBackground(PALE_PURPLE);
		cWelcomePanel.fill = GridBagConstraints.HORIZONTAL;
		cWelcomePanel.gridx = 0;
		cWelcomePanel.gridheight = 1;
		cWelcomePanel.gridy = 0;
		cWelcomePanel.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(welcomePanel, cWelcomePanel);

		/**
		 * Add Heading Label to the Welcome Panel
		 */

		welcomePanel.add(heading);
		heading.setFont(new Font("American Typewriter", Font.PLAIN, 28));
		heading.setText("Welcome to Flight Genie");
		heading.setForeground(CORNSILK);

		/**
		 * Add Labels to create a navigation
		 */
		GridBagConstraints cbrowseFlights = new GridBagConstraints();
		browseFlights.setText("Browse Flights");
		browseFlights.setFont(new Font("arial", Font.PLAIN, 16));
		browseFlights.setForeground(PALE_PURPLE);
		browseFlights.setHorizontalAlignment(SwingConstants.CENTER);
		cbrowseFlights.fill = GridBagConstraints.HORIZONTAL;
		cbrowseFlights.gridx = 0;
		cbrowseFlights.gridy = 1;
		cbrowseFlights.ipadx = 15;
		cbrowseFlights.ipady = 15;
		getContentPane().add(browseFlights, cbrowseFlights);

		GridBagConstraints cLoginRegister = new GridBagConstraints();
		loginRegister.setText("Login | Register");
		loginRegister.setFont(new Font("arial", Font.PLAIN, 16));
		loginRegister.setForeground(PALE_PURPLE);
		loginRegister.setHorizontalAlignment(SwingConstants.CENTER);
		cLoginRegister.fill = GridBagConstraints.HORIZONTAL;
		cLoginRegister.gridx = 2;
		cLoginRegister.gridy = 1;
		cLoginRegister.ipadx = 15;
		cLoginRegister.ipady = 15;
		getContentPane().add(loginRegister, cLoginRegister);

		/**
		 * Add SubHeading to Content
		 */

		GridBagConstraints cSubHeading = new GridBagConstraints();
		subHeading.setText("Where your destination is our command");
		subHeading.setFont(new Font("arial", Font.PLAIN, 20));
		subHeading.setForeground(PALE_PURPLE);
		subHeading.setHorizontalAlignment(SwingConstants.CENTER);
		cSubHeading.fill = GridBagConstraints.HORIZONTAL;
		cSubHeading.gridx = 1;
		cSubHeading.gridy = 2;
		getContentPane().add(subHeading, cSubHeading);

		
		/**
		 * Add the oval Panel 
		 */
		GridBagConstraints cBubblePanel = new GridBagConstraints();
		bubblePanel.setBackground(PALE_PURPLE);
		
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainJFrame welcomeJFrame = new MainJFrame();

			}
		});
	}
}
