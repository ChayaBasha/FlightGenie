package view.mainjframe;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.Color;
import javax.swing.SwingConstants;

import domain.flights.Airport;
import domain.flights.FlightSearchCriteria;
import view.OvalPane;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Color PALE_GREEN = new Color(153, 255, 204);
	public static final Color PALE_PURPLE = new Color(153, 153, 255);
	public static final Color CORNSILK = new Color(255, 254, 206);
	public static final Color GREY = new Color(180, 180, 180);
	
	/**
	 * The widgets that will be used to create the welcome screen
	 */

	JPanel welcomePanel = new JPanel();
	JLabel heading = new JLabel();
	JLabel browseFlights = new JLabel();
	JLabel loginRegister = new JLabel();
	JLabel subHeading = new JLabel();
	/**
	 * I created a new JPanel type to make an oval
	 */
	OvalPane bubblePanel = new OvalPane();
	JLabel searchFlightForm = new JLabel();
	JCheckBox directFlights = new JCheckBox();
	JCheckBox prioritizeArrival = new JCheckBox();
	JTextField departureCity = new JTextField();
	JTextField arrivalCity = new JTextField();
	JTextField day1 = new JTextField();
	JTextField month1 = new JTextField();
	JTextField year1 = new JTextField();
	JTextField hour1 = new JTextField();
	JTextField minute1 = new JTextField();
	JTextField day2 = new JTextField();
	JTextField month2 = new JTextField();
	JTextField year2 = new JTextField();
	JTextField hour2 = new JTextField();
	JTextField minute2 = new JTextField();
	JButton searchFlights = new JButton();
	
	JPanel footerPanel =new JPanel();
	JLabel footer = new JLabel();

	public MainJFrame() {

		initComponents();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO: Make dynamic
		this.setSize(800, 1000);
//		 setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	private void initComponents() {

		/**
		 * Using the GridBag Layout to set the layout of the widgets on the screen
		 */

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 };

		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };

		getContentPane().setLayout(gridBagLayout);

		

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
		 * Add Layout for the oval itself
		 */
		
		GridBagLayout gridBagLayoutOval = new GridBagLayout();
		gridBagLayoutOval.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayoutOval.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayoutOval.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutOval.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		bubblePanel.setLayout(gridBagLayoutOval);
		/**
		 * Add the oval Panel 
		 */
		GridBagConstraints cBubblePanel = new GridBagConstraints();
		bubblePanel.setBackground(PALE_PURPLE);
		cBubblePanel.fill = GridBagConstraints.HORIZONTAL;
		cBubblePanel.gridx = 1;
		cBubblePanel.gridy = 3;
		getContentPane().add(bubblePanel, cBubblePanel);
		
		GridBagConstraints cSearchFlightLabel = new GridBagConstraints();
		searchFlightForm.setText("I wish I could go to . . . ");
		searchFlightForm.setForeground(CORNSILK);
		searchFlightForm.setFont(new Font("arial", Font.PLAIN, 20));
		cSearchFlightLabel.gridx = 0;
		cSearchFlightLabel.gridy = 1;
		cSearchFlightLabel.gridwidth = GridBagConstraints.REMAINDER;
		bubblePanel.add(searchFlightForm, cSearchFlightLabel);
		
		GridBagConstraints cDepartureCity = new GridBagConstraints();
		departureCity.setText("DEPARTURECITY_ST");
		departureCity.setForeground(GREY);
		departureCity.setFont(new Font("arial", Font.PLAIN, 18));
		cDepartureCity.gridx = 1;
		cDepartureCity.gridy = 2;
		cDepartureCity.gridwidth = 2;
		bubblePanel.add(departureCity, cDepartureCity);
		
		GridBagConstraints cArrivalCity = new GridBagConstraints();
		cArrivalCity.anchor = GridBagConstraints.WEST;
		arrivalCity.setText("ARRIVALCITY_ST");
		arrivalCity.setForeground(GREY);
		arrivalCity.setFont(new Font("arial", Font.PLAIN, 18));
		cArrivalCity.gridx = 3;
		cArrivalCity.gridy = 2;
		cArrivalCity.gridwidth = 2;
		bubblePanel.add(arrivalCity, cArrivalCity);
		
		GridBagConstraints cDirectFlights = new GridBagConstraints();
		directFlights.setText("Direct Flights");
		directFlights.setForeground(CORNSILK);
		directFlights.setFont(new Font("arial", Font.PLAIN, 18));
		cDirectFlights.gridx = 0;
		cDirectFlights.gridy = 3;
		cDirectFlights.gridwidth =2;
		bubblePanel.add(directFlights, cDirectFlights);
		
		GridBagConstraints cPrioritizeArrival = new GridBagConstraints();
		prioritizeArrival.setText("Prioritize Arrival");
		prioritizeArrival.setForeground(CORNSILK);
		prioritizeArrival.setFont(new Font("arial", Font.PLAIN, 18));
		cPrioritizeArrival.gridx = 0;
		cPrioritizeArrival.gridy = 4;
		cPrioritizeArrival.gridwidth = 2;
		bubblePanel.add(prioritizeArrival, cPrioritizeArrival);
		
		GridBagConstraints cDay1 = new GridBagConstraints();
		day1.setHorizontalAlignment(SwingConstants.LEFT);
		day1.setText("DD");
		day1.setForeground(GREY);
		day1.setFont(new Font("arial", Font.PLAIN, 18));
		cDay1.gridx = 2;
		cDay1.gridy = 3;
		bubblePanel.add(day1, cDay1);
		
		GridBagConstraints cMonth1 = new GridBagConstraints();
		month1.setText("MM");
		month1.setForeground(GREY);
		month1.setFont(new Font("arial", Font.PLAIN, 18));
		cMonth1.gridx = 3;
		cMonth1.gridy = 3;
		bubblePanel.add(month1, cMonth1);
		
		GridBagConstraints cYear1 = new GridBagConstraints();
		year1.setText("YYYY");
		year1.setForeground(GREY);
		year1.setFont(new Font("arial", Font.PLAIN, 18));
		cYear1.gridx = 4;
		cYear1.gridy = 3;
		bubblePanel.add(year1, cYear1);
		
		GridBagConstraints cHour1 = new GridBagConstraints();
		hour1.setText("HH");
		hour1.setForeground(GREY);
		hour1.setFont(new Font("arial", Font.PLAIN, 18));
		cHour1.gridx = 5;
		cHour1.gridy = 3;
		bubblePanel.add(hour1, cHour1);
		
		GridBagConstraints cMinute1 = new GridBagConstraints();
		minute1.setText("MM");
		minute1.setForeground(GREY);
		minute1.setFont(new Font("arial", Font.PLAIN, 18));
		cMinute1.anchor = GridBagConstraints.WEST;
		cMinute1.gridx = 6;
		cMinute1.gridy = 3;
		bubblePanel.add(minute1, cMinute1);
		
		GridBagConstraints cDay2 = new GridBagConstraints();
		day2.setText("DD");
		day2.setForeground(GREY);
		day2.setFont(new Font("arial", Font.PLAIN, 18));
		cDay2.gridx = 2;
		cDay2.gridy = 4;
		bubblePanel.add(day2, cDay2);
		
		GridBagConstraints cMonth2 = new GridBagConstraints();
		month2.setText("MM");
		month2.setForeground(GREY);
		month2.setFont(new Font("arial", Font.PLAIN, 18));
		cMonth2.gridx = 3;
		cMonth2.gridy = 4;
		bubblePanel.add(month2, cMonth2);
		
		GridBagConstraints cYear2 = new GridBagConstraints();
		year2.setText("YYYY");
		year2.setForeground(GREY);
		year2.setFont(new Font("arial", Font.PLAIN, 18));
		cYear2.gridx = 4;
		cYear2.gridy = 4;
		bubblePanel.add(year2, cYear2);
		
		GridBagConstraints cHour2 = new GridBagConstraints();
		hour2.setText("HH");
		hour2.setForeground(GREY);
		hour2.setFont(new Font("arial", Font.PLAIN, 18));
		cHour2.gridx = 5;
		cHour2.gridy = 4;
		bubblePanel.add(hour2, cHour2);
		
		GridBagConstraints cMinute2 = new GridBagConstraints();
		minute2.setText("MM");
		minute2.setForeground(GREY);
		minute2.setFont(new Font("arial", Font.PLAIN, 18));
		cMinute2.anchor = GridBagConstraints.WEST;
		cMinute2.gridx = 6;
		cMinute2.gridy = 4;
		bubblePanel.add(minute2, cMinute2);
		
		GridBagConstraints cSearchFlights = new GridBagConstraints();
		searchFlights.setText("Search Flights");
		searchFlights.setForeground(PALE_PURPLE);
		searchFlights.setFont(new Font("arial", Font.PLAIN, 18));
		cSearchFlights.gridx = 0;
		cSearchFlights.gridy = 5;
		cSearchFlights.gridwidth = GridBagConstraints.REMAINDER;
		cSearchFlights.gridheight =1;
		bubblePanel.add(searchFlights, cSearchFlights);

		
		GridBagConstraints cFooterPanel = new GridBagConstraints();
		footerPanel.setBackground(PALE_PURPLE);
		cFooterPanel.fill = GridBagConstraints.HORIZONTAL;
		cFooterPanel.gridx = 0;
		cFooterPanel.gridheight = 1;
		cFooterPanel.gridy = 4;
		cFooterPanel.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(footerPanel, cFooterPanel);
		
		footerPanel.add(footer);
		footer.setFont(new Font("Arial", Font.PLAIN, 18));
		footer.setText("Created By Johanna Blumenthal 2020");
		footer.setForeground(CORNSILK);
	}
	
	/**
	 * Method to add the listener to the button; the ActionListener is in the 
	 * @param listener
	 */
	
	public void addSearchFlightsActionListener(ActionListener listener) {
		searchFlights.addActionListener(listener);
	}
	
	public FlightSearchCriteria getSelectedData() {
		//TODO: 
		FlightSearchCriteria customerCriteria = new FlightSearchCriteria(
				Airport.valueOf(departureCity.getText()),
				Airport.valueOf(arrivalCity.getText()),
				LocalDateTime.of(Integer.parseInt(year1.getText()), 
						Integer.parseInt(month1.getText()),
						Integer.parseInt(day1.getText()),
						Integer.parseInt(hour1.getText()),
						Integer.parseInt(minute1.getText())),
				LocalDateTime.of(Integer.parseInt(year2.getText()), 
						Integer.parseInt(month2.getText()),
						Integer.parseInt(day2.getText()),
						Integer.parseInt(hour2.getText()),
						Integer.parseInt(minute2.getText())),
				(short) 0, 
				null,
				directFlights.isSelected(),
				prioritizeArrival.isSelected());
		
		return customerCriteria;
		
	}
	
	public void showErrorDialog(Exception e) {
		// TODO: 
		System.out.println(e);
	}


	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainJFrame welcomeJFrame = new MainJFrame();

			}
		});
	}
}
