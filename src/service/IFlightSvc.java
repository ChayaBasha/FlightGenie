package service;

import java.time.LocalDateTime;
import java.util.List;

import domain.flights.Airport;
import domain.flights.Flight;

/**
 * Interface for the Flight services
 * @author johannablumenthal
 *
 */

public interface IFlightSvc {
	
	/**
	 * Functions needed for the useCases for the Customer to search for flights
	 * @param departureCity
	 * @param arrivalCity
	 * @return
	 */
	
	public List<Flight> getFlightsByRoute(Airport departureCity, Airport arrivalCity);
	public List<Flight> getFlightByTimeFrame(LocalDateTime startDepartureTimeRange, LocalDateTime endDepartureTimeRange);

}
