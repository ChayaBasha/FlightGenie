package service;

import java.util.List;

import domain.customer.itinerary.Itinerary;
import service.exception.ItineraryException;

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
	
	public void createItinerary(Itinerary itinerary) throws ItineraryException;
	public List<Itinerary> getAllItineraries() throws ItineraryException;
	public List<Itinerary> getItineraryByCustomer(String userName)throws ItineraryException;
	public Itinerary getItineraryById(String userName, String itineraryId) throws ItineraryException;
	public void updateItinerary(Itinerary itinerary) throws ItineraryException;
	public void deleteItinerary(Itinerary itinerary) throws ItineraryException;

}
