package view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

import domain.flights.Flight;

import business.FlightManager;
import service.exception.FlightException;
import service.exception.ServiceLoadException;
import view.flightSearch.FlightSearchForm;
import view.flightSearch.FlightTable;

public class MainJFrameController {
	
	private MainJFrame welcomeJFrame;
	
	private FlightManager flightManager = new FlightManager();
	
	public MainJFrameController() {
		
	}
	
	public MainJFrameController(MainJFrame welcomeJFrame) {
		this.welcomeJFrame = welcomeJFrame;
		FlightSearchForm flightSearchForm = welcomeJFrame.initialSearchForm;
		
		flightSearchForm.addSearchFlightsActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					
					showFlights(flightManager.searchAvailableFlights(flightSearchForm.getSelectedData()));
				} catch (ServiceLoadException e) {
					flightSearchForm.showErrorDialog(e);
				} catch (FlightException e) {
					flightSearchForm.showErrorDialog(e);
				}
			}
		});
	}

	public void showFlights(List<Flight> flights) {
		System.out.println("you got some flights");
		System.out.println(flights.size());
		flights.forEach(flight -> System.out.println(flight.createFlightId()));
		this.welcomeJFrame.setMainContent(new FlightTable(flights));
	}
}
