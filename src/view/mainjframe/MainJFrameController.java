package view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import domain.flights.Flight;

import business.FlightManager;
import service.exception.FlightException;
import service.exception.ServiceLoadException;

public class MainJFrameController {
	
	private MainJFrame welcomeJFrame;
	
	private FlightManager flightManager = new FlightManager();
	
	public MainJFrameController() {
		
	}
	
	public MainJFrameController(MainJFrame welcomeJFrame) {
		this.welcomeJFrame = welcomeJFrame;
		
		welcomeJFrame.addSearchFlightsActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					showFlights(flightManager.searchAvailableFlights(welcomeJFrame.getSelectedData()));
				} catch (ServiceLoadException e) {
					welcomeJFrame.showErrorDialog(e);
				} catch (FlightException e) {
					welcomeJFrame.showErrorDialog(e);
				}
			}
		});
	}

	public void showFlights(List<Flight> flights) {
		System.out.println("you got some flights");
		flights.forEach(flight -> System.out.println(flight.createFlightId()));
	}
}
