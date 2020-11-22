package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.flights.Flight;
import domain.flights.FlightSearchCriteria;
import service.IFlightSvc;
import service.IService;

public class FlightManager extends ManagerSuperType {

	public static String IFLIGHT_SVC_PROP = "IFlightSvc";

	public List<Flight> searchAvailableFlights(FlightSearchCriteria customerCriteria) {

		LocalDateTime strictArrivalTimeRange = customerCriteria.getDesiredArrivalTime().minusHours(12);
		LocalDateTime broadArrivalTimeRange = customerCriteria.getDesiredArrivalTime().minusDays(3);

		IFlightSvc flightSvc = (IFlightSvc) getService(IFLIGHT_SVC_PROP);
		if (customerCriteria.isDirectFlightsOnly() && customerCriteria.isPriorityTimeArrival()) {
			List<Flight> directFlights = flightSvc.getFlightsByRoute(customerCriteria.getDesiredDepartureCity(),
					customerCriteria.getDesiredArrivalCity());

			ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < directFlights.size(); i++) {
				if (directFlights.get(i).getArrivalTime().isBefore(customerCriteria.getDesiredArrivalTime())
						&& directFlights.get(i).getArrivalTime().isAfter(strictArrivalTimeRange)) {
					matchingFlights.add(directFlights.get(i));
				}
				
			}
		} else if(customerCriteria.isDirectFlightsOnly())

	}
}
