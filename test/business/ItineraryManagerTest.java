package business;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import domain.customer.itinerary.BookingStatus;
import domain.customer.itinerary.CustomerReservationPreferences;
import domain.customer.itinerary.Itinerary;
import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import domain.flights.Seat;
import domain.flights.SeatType;
import junit.framework.TestCase;
import service.IFlightSvc;
import service.IItinerarySvc;
import service.exception.FlightException;
import service.exception.ItineraryException;
import service.exception.ServiceLoadException;

public class ItineraryManagerTest extends TestCase {
	private FlightManager flightManager = new FlightManager();
	private ItineraryManager itineraryManager = new ItineraryManager();
	private CustomerReservationPreferences customerReservationPreferences;
	private Itinerary customerItinerary;
	private Flight flight;
	private ArrayList<Seat> seats2;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		/**
		 * We need to set up a flight to use for booking
		 */
		
		flight = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T20:38:00"), 79.00, 53.00);
		
		seats2 = new ArrayList<Seat> (); 
		seats2.add(new Seat("1A", SeatType.BUSINESS, true));
		seats2.add(new Seat("1B", SeatType.BUSINESS, true));
		seats2.add(new Seat("1C", SeatType.BUSINESS, true));
		seats2.add(new Seat("1D", SeatType.BUSINESS, true));
		seats2.add(new Seat("2A", SeatType.BUSINESS, true));
		seats2.add(new Seat("2B", SeatType.BUSINESS, true));
		seats2.add(new Seat("2C", SeatType.BUSINESS, true));
		seats2.add(new Seat("2D", SeatType.BUSINESS, true));
		seats2.add(new Seat("3A", SeatType.BUSINESS, true));
		seats2.add(new Seat("3B", SeatType.BUSINESS, true));
		seats2.add(new Seat("4A", SeatType.ECONOMY, true));
		seats2.add(new Seat("4B", SeatType.ECONOMY, true));
		seats2.add(new Seat("4C", SeatType.ECONOMY, true));
		seats2.add(new Seat("4D", SeatType.ECONOMY, true));
		seats2.add(new Seat("4E", SeatType.ECONOMY, true));
		seats2.add(new Seat("4F", SeatType.ECONOMY, true));
		seats2.add(new Seat("5A", SeatType.ECONOMY, true));
		seats2.add(new Seat("5B", SeatType.ECONOMY, true));
		seats2.add(new Seat("5C", SeatType.ECONOMY, true));
		seats2.add(new Seat("5D", SeatType.ECONOMY, true));
		seats2.add(new Seat("5E", SeatType.ECONOMY, true));
		seats2.add(new Seat("5F", SeatType.ECONOMY, true));
		seats2.add(new Seat("6A", SeatType.ECONOMY, true));
		seats2.add(new Seat("6B", SeatType.ECONOMY, true));
		seats2.add(new Seat("6C", SeatType.ECONOMY, true));
		seats2.add(new Seat("6D", SeatType.ECONOMY, true));
		seats2.add(new Seat("6E", SeatType.ECONOMY, true));
		seats2.add(new Seat("6F", SeatType.ECONOMY, true));
		seats2.add(new Seat("7A", SeatType.ECONOMY, true));
		seats2.add(new Seat("7B", SeatType.ECONOMY, true));
		seats2.add(new Seat("7C", SeatType.ECONOMY, true));
		seats2.add(new Seat("7D", SeatType.ECONOMY, true));
		seats2.add(new Seat("7E", SeatType.ECONOMY, true));
		seats2.add(new Seat("7F", SeatType.ECONOMY, true));
		seats2.add(new Seat("8A", SeatType.ECONOMY, true));
		seats2.add(new Seat("8B", SeatType.ECONOMY, true));
		seats2.add(new Seat("8C", SeatType.ECONOMY, true));
		seats2.add(new Seat("8D", SeatType.ECONOMY, true));
		seats2.add(new Seat("8E", SeatType.ECONOMY, true));
		seats2.add(new Seat("8F", SeatType.ECONOMY, false));
		
		flight.setSeats(seats2);
		
		IFlightSvc flightSvc = flightManager.flightSvc();
		
		flightSvc.addFlight(flight);
		
		/**
		 * WE need to add the customer's preferences 
		 */
		
		customerReservationPreferences = new CustomerReservationPreferences(flight, SeatType.ECONOMY);
		customerItinerary = new Itinerary("FrogBomb", "Penny Blumenthal", flight, "8F", BookingStatus.RESERVED);
		
		IItinerarySvc itinerarySvc = itineraryManager.itinerarySvc();

	}

	@Test
	public void testGetAvailableSeats() throws ItineraryException {
		flight.setSeats(seats2);
		ArrayList<Seat> resultSeats = itineraryManager.getAvailableSeats(customerReservationPreferences);
		assertTrue(resultSeats.stream().anyMatch(s -> s.equals(seats2.get(39))));
	}

	@Test
	public void testReserveFlight() throws ItineraryException, ServiceLoadException, FlightException {
		flight.setSeats(seats2);
		itineraryManager.reserveFlight(customerItinerary);
		System.out.println(customerItinerary.getFlight().allAvailableSeats());
		assertTrue(customerItinerary.getFlight().allAvailableSeats().size()==0);
	}
}
