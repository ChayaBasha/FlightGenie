package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.customer.itinerary.BookingStatus;
import domain.customer.itinerary.Itinerary;
import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
/**
 * Implements the Itinerary Services 
 * 
 * @author johannablumenthal
 *
 */

public class ItinerarySvcImpl implements IItinerarySvc{

	@Override
	/**
	 * allows customer to save a new itinerary to the data store
	 */
	public void createItinerary(Itinerary itinerary) {
		System.out.println("Create Itinerary Method in Itinerary Service implementation was called");
		
	}

	@Override
	/**
	 * returns all of the customers itineraries 
	 */
	public List<Itinerary> getItineraryByCustomer(String userName) {
		System.out.println("Get Itinerary for Customer Method in Itinerary Service implementation was called");
		return new ArrayList<Itinerary>();
	}

	@Override
	/**
	 * gets a particular itinerary by ID...since behavior not implemented with data, I am using the concrete data for testing...will serve up data later
	 */
	public Itinerary getItineraryById(String itineraryId) {
		
		Flight flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		
		System.out.println("Get Itinerary By Id Method in Itinerary Service implementation was called");
		return new Itinerary("123456AFD", "FrogBomb", "Penny Blumenthal", flight1, "1C", BookingStatus.RESERVED);
	}

	@Override
	/**
	 * Allows the customer to change the itinerary
	 */
	public void updateItinerary(Itinerary itinerary) {
		System.out.println("Update Itinerary Method in Itinerary Service implementation was called");
		
	}

	@Override
	/**
	 * allows the customer to delete the itinerary from the data store
	 */
	public void deleteItinerary(String itineraryId) {
		System.out.println("Delete Itinerary Method in Itinerary Service implementation was called");
		
	}

}
