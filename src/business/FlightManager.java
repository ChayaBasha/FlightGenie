package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.flights.Flight;
import domain.flights.FlightSearchCriteria;
import service.IFlightSvc;
import service.exception.FlightException;
import service.exception.ServiceLoadException;

/**
 * This class contains the business logic for searching for flights
 * 
 * @author johannablumenthal
 *
 */

public class FlightManager extends ManagerSuperType {

	public static String IFLIGHT_SVC_PROP = "IFlightSvc";
	
	public IFlightSvc flightSvc() throws ServiceLoadException {
		return (IFlightSvc) getService(IFLIGHT_SVC_PROP);
	}

	public List<Flight> searchAvailableFlights(FlightSearchCriteria customerCriteria)
			throws FlightException, ServiceLoadException {

		LocalDateTime strictArrivalTimeRange = customerCriteria.getDesiredArrivalTime().minusHours(12);
		LocalDateTime broadArrivalTimeRangeStart = customerCriteria.getDesiredArrivalTime().minusDays(3);
		LocalDateTime broadArrivalTimeRangeEnd = customerCriteria.getDesiredArrivalTime().minusHours(-12);
		/**
		 * Calling the flight Service to get flights
		 */

		IFlightSvc flightSvc = flightSvc();
		/**
		 * The first option will return only direct flights that meet the stricter
		 * timeframe as selected by the customer
		 */
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
			return matchingFlights;
			/**
			 * This second option shows all direct flights as selected by the customer and
			 * allows for a time range of days because this wasn't selected as important by
			 * the customer
			 */
		} else if (customerCriteria.isDirectFlightsOnly()) {
			
			List<Flight> directFlights = flightSvc.getFlightsByRoute(customerCriteria.getDesiredDepartureCity(),
					customerCriteria.getDesiredArrivalCity());

			ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < directFlights.size(); i++) {
				if (directFlights.get(i).getArrivalTime().isBefore(broadArrivalTimeRangeEnd)
						&& directFlights.get(i).getArrivalTime().isAfter(broadArrivalTimeRangeStart)) {
					matchingFlights.add(directFlights.get(i));
				}
			}
			return matchingFlights;
			/**
			 * This option returns all flights that meet a strict time frame....
			 */

		} else if (customerCriteria.isPriorityTimeArrival()) {
			List<Flight> matchingFlights = flightSvc.getFlightByTimeFrame(strictArrivalTimeRange,
					customerCriteria.getDesiredArrivalTime());
			return matchingFlights;

		} else { 
			LocalDateTime timeFrameFromToday =  LocalDateTime.now().minusDays(-30);
			List<Flight> browseFlights = flightSvc.getFlightByTimeFrame(LocalDateTime.now(), timeFrameFromToday);
			
			return browseFlights;
		}
		/**
		 * TODO implement additional logic for searching flights...for example
		 * non-Direct flights. I have an idea for this, but am not sure I have the time
		 * to implement this now
		 */
	}
}
