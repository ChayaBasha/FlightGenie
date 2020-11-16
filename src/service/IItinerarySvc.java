package service;

import java.util.List;

import domain.customer.itinerary.Itinerary;

/**
 * Interface for the itinerary service
 * @author johannablumenthal
 *
 */

public interface IItinerarySvc extends IService{
	
	public final String NAME = "IItinerarySvc";
	
	/**
	 * CRUD functions for Itinerary
	 * @param itinerary
	 */
	
	public void createItinerary(Itinerary itinerary);
	public List<Itinerary> getItineraryByCustomer(String userName);
	public Itinerary getItineraryById(String itineraryId);
	public void updateItinerary(Itinerary itinerary);
	public void deleteItinerary(String itineraryId);

}
