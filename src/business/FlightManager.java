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

			List<Flight> directFlights = flightSvc.getDirectFlights(customerCriteria.getDesiredDepartureCity(),
					customerCriteria.getDesiredArrivalCity());

			ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < directFlights.size(); i++) {

				if (directFlights.get(i).getArrivalTime().isBefore(customerCriteria.getDesiredArrivalTime())
						&& directFlights.get(i).getArrivalTime().isAfter(strictArrivalTimeRange)) {
					matchingFlights.add(directFlights.get(i));
				}

			}

			ArrayList<Flight> availableMatchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlights.size(); i++) {

				if (matchingFlights.get(i).availability(customerCriteria.getNumberPassengers())) {
					availableMatchingFlights.add(matchingFlights.get(i));
				} else
					throw new FlightException("no mathcing FLights Foung");

			}
			return availableMatchingFlights;
			/**
			 * This second option shows all direct flights as selected by the customer and
			 * allows for a time range of days because this wasn't selected as important by
			 * the customer
			 */
		} else if (customerCriteria.isDirectFlightsOnly()) {

			List<Flight> directFlights = flightSvc.getDirectFlights(customerCriteria.getDesiredDepartureCity(),
					customerCriteria.getDesiredArrivalCity());

			ArrayList<Flight> matchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < directFlights.size(); i++) {
				if (directFlights.get(i).getArrivalTime().isBefore(broadArrivalTimeRangeEnd)
						&& directFlights.get(i).getArrivalTime().isAfter(broadArrivalTimeRangeStart)) {
					matchingFlights.add(directFlights.get(i));
				}
			}

			ArrayList<Flight> availableMatchingFlights = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlights.size(); i++) {

				if (matchingFlights.get(i).availability(customerCriteria.getNumberPassengers())) {
					availableMatchingFlights.add(matchingFlights.get(i));
				} else
					throw new FlightException("no mathcing FLights Foung");

			}
			return availableMatchingFlights;
			/**
			 * This option returns all flights that meet a strict time frame, but that could be non-direct
			 */

		} else if (customerCriteria.isPriorityTimeArrival()) {
			List<Flight> matchingFlightTimes = flightSvc.getFlightByTimeFrame(strictArrivalTimeRange,
					customerCriteria.getDesiredArrivalTime());

			ArrayList<Flight> matchingDepartureRoutes = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlightTimes.size(); i++) {
				if (matchingFlightTimes.get(i).getDepartureCity().equals(customerCriteria.getDesiredDepartureCity())) {
					matchingDepartureRoutes.add(matchingFlightTimes.get(i));
				}
			}
			ArrayList<Flight> matchingArrivalRoutes = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlightTimes.size(); i++) {
				if (matchingFlightTimes.get(i).getArrivalCity().equals(customerCriteria.getDesiredArrivalCity())) {
					matchingArrivalRoutes.add(matchingFlightTimes.get(i));
				}
			}

			ArrayList<Flight> firstLegs = new ArrayList<Flight>();
			ArrayList<Flight> secondLegs = new ArrayList<Flight>();
			for (int i = 0; i < matchingDepartureRoutes.size(); i++) {
				for (int j = 0; j < matchingArrivalRoutes.size(); j++) {
					if (matchingDepartureRoutes.get(i).getArrivalCity()
							.equals(matchingArrivalRoutes.get(j).getDepartureCity())
							&& matchingDepartureRoutes.get(i).getArrivalTime()
									.isBefore(matchingArrivalRoutes.get(j).getDepartureTime())) {
						firstLegs.add(matchingDepartureRoutes.get(i));
						secondLegs.add(matchingArrivalRoutes.get(j));
					}

				}
			}

			ArrayList<Flight> availableNonDirectFlights = new ArrayList<Flight>();
			for (int i = 0; i < firstLegs.size(); i++) {
				if (firstLegs.get(i).availability(customerCriteria.getNumberPassengers())
						&& secondLegs.get(i).availability(customerCriteria.getNumberPassengers())) {
					availableNonDirectFlights.add(firstLegs.get(i));
					availableNonDirectFlights.add(secondLegs.get(i));
				} else
					throw new FlightException("no available flights match your search");
			}

			return availableNonDirectFlights;

		} else 
			/**
			 * This is if you care less about direct flights or strict time
			 */
		
		{
			List<Flight> matchingFlightTimes = flightSvc.getFlightByTimeFrame(strictArrivalTimeRange,
					customerCriteria.getDesiredArrivalTime());

			ArrayList<Flight> directFlights = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlightTimes.size(); i++) {
				if(matchingFlightTimes.get(i).getDepartureCity().equals(customerCriteria.getDesiredDepartureCity()) &&
						matchingFlightTimes.get(i).getArrivalCity().equals(customerCriteria.getDesiredArrivalCity())) {
					directFlights.add(matchingFlightTimes.get(i));
				}
			}
			
			ArrayList<Flight> availableDirectFlights = new ArrayList<Flight>();
			for(int i=0; i< directFlights.size(); i++) {
				if(directFlights.get(i).availability(customerCriteria.getNumberPassengers())) {
					availableDirectFlights.add(directFlights.get(i));
				}
			}
			ArrayList<Flight> matchingDepartureRoutes = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlightTimes.size(); i++) {
				if (matchingFlightTimes.get(i).getDepartureCity().equals(customerCriteria.getDesiredDepartureCity())) {
					matchingDepartureRoutes.add(matchingFlightTimes.get(i));
				}
			}
			ArrayList<Flight> matchingArrivalRoutes = new ArrayList<Flight>();
			for (int i = 0; i < matchingFlightTimes.size(); i++) {
				if (matchingFlightTimes.get(i).getArrivalCity().equals(customerCriteria.getDesiredArrivalCity())) {
					matchingArrivalRoutes.add(matchingFlightTimes.get(i));
				}
			}

			ArrayList<Flight> firstLegs = new ArrayList<Flight>();
			ArrayList<Flight> secondLegs = new ArrayList<Flight>();
			for (int i = 0; i < matchingDepartureRoutes.size(); i++) {
				for (int j = 0; j < matchingArrivalRoutes.size(); j++) {
					if (matchingDepartureRoutes.get(i).getArrivalCity()
							.equals(matchingArrivalRoutes.get(j).getDepartureCity())
							&& matchingDepartureRoutes.get(i).getArrivalTime()
									.isBefore(matchingArrivalRoutes.get(j).getDepartureTime())) {
						firstLegs.add(matchingDepartureRoutes.get(i));
						secondLegs.add(matchingArrivalRoutes.get(j));
					}

				}
			}

			ArrayList<Flight> availableNonDirectFlights = new ArrayList<Flight>();
			for (int i = 0; i < firstLegs.size(); i++) {
				if (firstLegs.get(i).availability(customerCriteria.getNumberPassengers())
						&& secondLegs.get(i).availability(customerCriteria.getNumberPassengers())) {
					availableNonDirectFlights.add(firstLegs.get(i));
					availableNonDirectFlights.add(secondLegs.get(i));
				} else
					throw new FlightException("no available flights match your search");
			}

			return availableNonDirectFlights;

		}

	}

	/**
	 * This is just a handy thing if someone just wants to browse flights
	 * 
	 * @return
	 * @throws ServiceLoadException
	 * @throws FlightException
	 */

	public List<Flight> browseFlights() throws ServiceLoadException, FlightException {
		IFlightSvc flightSvc = flightSvc();
		LocalDateTime timeFrameFromToday = LocalDateTime.now().minusDays(-90);
		List<Flight> browseFlights = flightSvc.getFlightByTimeFrame(LocalDateTime.now(), timeFrameFromToday);
		return browseFlights;
	}

}
