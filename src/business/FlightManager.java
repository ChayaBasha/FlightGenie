package business;

import java.util.List;

import domain.flights.Flight;
import domain.flights.FlightSearchCriteria;
import service.IFlightSvc;
import service.IService;

public class FlightManager extends ManagerSuperType {

	public static String IFLIGHT_SVC_PROP = "IFlightSvc";

	public List<Flight> searchAvailableFlights(FlightSearchCriteria customerCriteria) {
		
		IFlightSvc flightSvc = (IFlightSvc) getService(IFLIGHT_SVC_PROP);
		if(customerCriteria.isDirectFlightsOnly()) {
		flightSvc.getFlightsByRoute(customerCriteria.getDesiredDepartureCity(), customerCriteria.getDesiredArrivalCity());
		
	
		
	
    }
}
