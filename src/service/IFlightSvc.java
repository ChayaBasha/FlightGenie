package service;

import java.time.LocalDateTime;
import java.util.List;

import domain.flights.Airport;
import domain.flights.Flight;
import service.exception.FlightException;

/**
 * Interface for the Flight services
 * @author johannablumenthal
 *
 */

public interface IFlightSvc extends IService{
	
	public final String NAME = "IFlightSvc";
	
	/**
	 * Functions needed for the useCases for the Customer to search for flights
	 * @param departureCity
	 * @param arrivalCity
	 * @return
	 */
	
	public void addFlight(Flight flight) throws FlightException;
	public List<Flight> getAllFlights() throws FlightException;
	public List<Flight> getFlightsByRoute(Airport departureCity, Airport arrivalCity) throws FlightException;
	public List<Flight> getFlightByTimeFrame(LocalDateTime startDepartureTimeRange, LocalDateTime endDepartureTimeRange) throws FlightException;

}
