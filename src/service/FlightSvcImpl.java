package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.flights.Airport;
import domain.flights.Flight;

/**
 * Implementation of the Flight Services interface
 * @author johannablumenthal
 *
 */

public class FlightSvcImpl implements IFlightSvc {
	

	@Override
	/**
	 * This service returns all the Flights that match the route as defined by the departure and arrival locations
	 */
	public List<Flight> getFlightsByRoute(Airport departureCity, Airport arrivalCity) {
		
		System.out.println("get FLight by Route Method for Flight Service Implementation was called");
		
		return new ArrayList<Flight>();
	}

	@Override
	/**
	 * This service returns all  the flights within a certain time frame that will be defined by the business logic
	 */
	public List<Flight> getFlightByTimeFrame(LocalDateTime startDepartureTimeRange, LocalDateTime endDepartureTimeRange) {

		System.out.println("get FLight by Time Frame for Flight Service Implementation was called");
		
		return new ArrayList<Flight>();
	}

	

}
