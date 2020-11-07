package service;

import java.util.List;


import domain.customer.itinerary.Itinerary;
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
		return null;
	}

	@Override
	/**
	 * gets a particular itinerary
	 */
	public Itinerary getItineraryById(String itineraryId) {
		System.out.println("Get Itinerary By Id Method in Itinerary Service implementation was called");
		return null;
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
