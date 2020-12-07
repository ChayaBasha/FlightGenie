package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.customer.itinerary.CustomerReservationPreferences;
import domain.customer.itinerary.Itinerary;
import domain.flights.Flight;
import domain.flights.Seat;
import service.IFlightSvc;
import service.IItinerarySvc;
import service.exception.FlightException;
import service.exception.ItineraryException;
import service.exception.ServiceLoadException;

/**
 * Not yet implemented
 * 
 * @author johannablumenthal
 *
 */

public class ItineraryManager extends ManagerSuperType {

	public static String IFLIGHT_SVC_PROP = "IFlightSvc";

	public IFlightSvc flightSvc() throws ServiceLoadException {
		return (IFlightSvc) getService(IFLIGHT_SVC_PROP);
	}

	public static String IITINERARY_SVC_PROP = "IItinerarySvc";

	public IItinerarySvc itinerarySvc() throws ServiceLoadException {
		return (IItinerarySvc) getService(IITINERARY_SVC_PROP);
	}

	/**
	 * This allows the user to start selecting the Seat they are looking for
	 * 
	 * @param customerReservationPreferences
	 * @return
	 * @throws ItineraryException
	 */

	public ArrayList<Seat> getAvailableSeats(CustomerReservationPreferences customerReservationPreferences)
			throws ItineraryException {

		ArrayList<Seat> availableSeats = customerReservationPreferences.getSelectedFlight().allAvailableSeats();
		ArrayList<Seat> availableMatchingSeatTypes = new ArrayList<Seat>();
		for (int i = 0; i < availableSeats.size(); i++) {
			if (availableSeats.get(i).getSeatType().equals(customerReservationPreferences.getSeatPreference())) {
				availableMatchingSeatTypes.add(availableSeats.get(i));
			}

		}
		if (availableMatchingSeatTypes.size() != 0) {
			return availableMatchingSeatTypes;
		} else
			throw new ItineraryException("no mathcing seat Types on this flight");

	}

	/**
	 * books the seat on the selected flight and then creates the new itinerary
	 * 
	 * @param customerItinerary
	 * @throws ItineraryException
	 * @throws ServiceLoadException
	 * @throws FlightException
	 */
	public void reserveFlight(Itinerary customerItinerary)
			throws ItineraryException, ServiceLoadException, FlightException {

		IItinerarySvc itinerarySvc = itinerarySvc();

		IFlightSvc flightSvc = flightSvc();
		ArrayList<Seat> flightSeats = customerItinerary.getFlight().getSeats();

		boolean seatSet = false;
		for (int i = 0; i < flightSeats.size(); i++) {

			if (flightSeats.get(i).getSeatNumber().equals(customerItinerary.getSeatNumber())) {
				seatSet = true;
				flightSeats.get(i).setBooked(true);
				customerItinerary.getFlight().setSeats(flightSeats);
				flightSvc.addFlight(customerItinerary.getFlight());
			}

			itinerarySvc.createItinerary(customerItinerary);
		}

		if (!seatSet) {
			throw new ItineraryException("cannot book this seat");
		}
	}

	public List<Itinerary> viewItineraries(String userName) throws ServiceLoadException, ItineraryException {
		IItinerarySvc itinerarySvc = itinerarySvc();
		List<Itinerary> customerItineraries = itinerarySvc.getItineraryByCustomer(userName);
		List<Itinerary> upcomingCustomerItineraries = new ArrayList<Itinerary>();
		LocalDateTime todaysDate = LocalDateTime.now();
		if (customerItineraries.size() != 0) {
			for (int i = 0; i < customerItineraries.size(); i++) {
				if (customerItineraries.get(i).getFlight().getDepartureTime().isAfter(todaysDate)) {
					upcomingCustomerItineraries.add(customerItineraries.get(i));
				}
				return upcomingCustomerItineraries;

			} 
				throw new ItineraryException("no upcoming itineraries");

		} else
			throw new ItineraryException("no itineraries mathicng");
	}
}
