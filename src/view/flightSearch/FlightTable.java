package view.flightSearch;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.flights.Flight;

public class FlightTable extends JPanel {
	
	public static final Color PALE_GREEN = new Color(153, 255, 204);
	public static final Color PALE_PURPLE = new Color(153, 153, 255);
	public static final Color CORNSILK = new Color(255, 254, 206);
	JTable flightTable;
	String[] columnNames = {"Ailrine", "Flight #", "Departure City", "Arrival City", "Departure Time", "Arrival Time", "Seat Availablity", "Business", "Economy"};
    ArrayList<String[]> flightFields = new ArrayList<String []>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   public FlightTable(List<Flight> flightResults) {
	   for(int i = 0; i < flightResults.size(); i++) {
		   String[] row = {flightResults.get(i).getAirline().getAirlineCode(),
				   Short.toString(flightResults.get(i).getFlightNumber()),
				   flightResults.get(i).getDepartureCity().getAirportCode(),
				   flightResults.get(i).getArrivalCity().getAirportCode(),
				   flightResults.get(i).getDepartureTime().toString(),
				   flightResults.get(i).getArrivalTime().toString(),
				   "not implemented",
				   Double.toString(flightResults.get(i).getBusinessPrice()),
				   Double.toString(flightResults.get(i).getEconomyPrice())};
		   flightFields.add(row);
	   }
	   String[][] flights = new String[flightFields.size()][columnNames.length];
	   flights = flightFields.toArray(flights);
	   
//	   String[][] data = {
//			   {
//				   "AA", "232", "DEN", "BOS", "23:00", "6:00", "not implemented", "23.00", "5.00"
//			   },
//			   {"CO", "252", "DEN", "BOS", "23:00", "6:00", "not implemented", "23.00", "5.00"
//			   
//			   }
//	   };
	   
	   flightTable = new JTable(flights, columnNames);
	   flightTable.setFillsViewportHeight(true);
	   flightTable.setForeground(CORNSILK);
	   flightTable.setBackground(PALE_PURPLE);
	   flightTable.setBounds(30, 40, 200, 300);
	   JScrollPane scrollPane = new JScrollPane(flightTable);
	   scrollPane.setBackground(PALE_PURPLE);
	   scrollPane.setForeground(PALE_PURPLE);
	   this.add(scrollPane);
	   this.setVisible(true);
	   this.setBackground(PALE_GREEN);
	   this.setSize(500, 200);
	   
   }
	

}
