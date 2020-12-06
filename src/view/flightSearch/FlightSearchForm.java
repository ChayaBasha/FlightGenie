package view.flightSearch;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import domain.flights.Airport;
import domain.flights.FlightSearchCriteria;
import view.OvalPane;

public class FlightSearchForm extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Color PALE_GREEN = new Color(153, 255, 204);
	public static final Color PALE_PURPLE = new Color(153, 153, 255);
	public static final Color CORNSILK = new Color(255, 254, 206);
	public static final Color GREY = new Color(180, 180, 180);
	
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
	
	public FlightSearchForm() {
		initOvalComponents();
	}
	/**
	 * Add Layout for the oval itself
	 */
	
	public void initOvalComponents() {
	
	GridBagLayout gridBagLayoutOval = new GridBagLayout();
	gridBagLayoutOval.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
	gridBagLayoutOval.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
	gridBagLayoutOval.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayoutOval.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	bubblePanel.setLayout(gridBagLayoutOval);
	bubblePanel.setBackground(PALE_PURPLE);
	this.setBackground(PALE_GREEN);
	this.add(bubblePanel);
	/**
	 * Add the oval Panel 
	 */
	
	
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
	}
	
	/**
	 * Method to add the listener to the button; the ActionListener is in the 
	 * @param listener
	 */
	
	public void addSearchFlightsActionListener(ActionListener listener) {
		searchFlights.addActionListener(listener);
	}

	public FlightSearchCriteria getSelectedData() {
		
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
				(short) 1, 
				null,
				directFlights.isSelected(),
				prioritizeArrival.isSelected());
		
		return customerCriteria;
		
	}
	
	public void showErrorDialog(Exception e) {
		// TODO: 
		System.out.println(e);
	}


}
