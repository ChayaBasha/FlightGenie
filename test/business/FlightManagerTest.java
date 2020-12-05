package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import domain.flights.FlightSearchCriteria;
import domain.flights.Seat;
import domain.flights.SeatType;
import junit.framework.TestCase;
import service.IFlightSvc;
import service.exception.FlightException;
import service.exception.ServiceLoadException;

public class FlightManagerTest extends TestCase {

	private FlightManager flightManager = new FlightManager();
	private FlightSearchCriteria customerSearchCriteria1;
	private FlightSearchCriteria customerSearchCriteria2;
	private FlightSearchCriteria customerSearchCriteria3;
	private FlightSearchCriteria customerSearchCriteria4;
	private Flight flight1;
	private Flight flight2;
	private Flight flight3;
	private Flight flight4;
	private Flight flight5;
	private Flight flight6;
	private Flight flight7;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		/**
		 * We will want to make sure we have added some flights for the flight searches
		 * to search through so we know they are finding the flights that we think they
		 * should
		 */
		flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T20:38:00"), 79.00, 53.00);
		flight2 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T10:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		flight3 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.DENVER_CO,
				LocalDateTime.parse("2019-06-23T10:30:00"), Airport.NEWORLEANS_LA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 53.00, 33.00);
		flight4 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.NEWORLEANS_LA,
				LocalDateTime.parse("2019-08-23T14:30:00"), Airport.DENVER_CO,
				LocalDateTime.parse("2019-08-23T20:22:00"), 53.00, 33.00);
		flight5 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T10:30:00"), Airport.NEWORLEANS_LA,
				LocalDateTime.parse("2019-06-23T13:38:00"), 53.00, 33.00);
		flight6= new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.NEWORLEANS_LA,
				LocalDateTime.parse("2019-06-23T15:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 53.00, 33.00);
		flight7= new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.NEWORLEANS_LA,
				LocalDateTime.parse("2019-06-23T14:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 53.00, 33.00);
		/**
		 * We need to test that it is checking properly for availability
		 */
		ArrayList<Seat> seats2 = new ArrayList<Seat> (); 
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
		
	
		flight3.setSeats(seats2);
		flight7.setSeats(seats2);

		IFlightSvc flightSvc = flightManager.flightSvc();

		flightSvc.addFlight(flight1);
		flightSvc.addFlight(flight2);
		flightSvc.addFlight(flight3);
		flightSvc.addFlight(flight4);
		flightSvc.addFlight(flight5);
		flightSvc.addFlight(flight6);
		flightSvc.addFlight(flight7);

		/**
		 * This search criteria should return only flight 2 because that is the only
		 * flight arriving before the desired arrival time that is a direct flight
		 */
		customerSearchCriteria1 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:00:00"), (short) 2, null,
				true, true);

		/**
		 * This search Criteria should return flight1 and flight2 because both are
		 * within the broader time frame and the direct flight
		 */

		customerSearchCriteria2 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:30:00"), (short) 2, null,
				true, false);
		/**
		 * This one should return flight2, flight5, flight6 since they are both within the strict
		 * arrival time period
		 */
		customerSearchCriteria3 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:30:00"), (short) 2, null,
				false, true);
		/**
		 * This one should return flight1, flight2, flight5 and flight 6
		 */

		customerSearchCriteria4 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:30:00"), (short) 2, null,
				false, false);

	}

	@Test
	public void testSearchAvailableFlightsDirectAndStrict() throws FlightException, ServiceLoadException{

		assertTrue(flightManager.searchAvailableFlights(customerSearchCriteria1).get(0).equals(flight2));
		System.out.println("testSearchAvailableFlightsWhenDirectFlightAndStrictTime PASSED");

	}
	
	@Test
	public void testSearchAvailableFlightsDirect() throws FlightException, ServiceLoadException{
         List<Flight> resultFlights = flightManager.searchAvailableFlights(customerSearchCriteria2);
		assertTrue(resultFlights.stream().anyMatch(f -> f.equals(flight1)) && resultFlights.stream().anyMatch(f -> f.equals(flight2))); 		
		System.out.println("testSearchAvailableFlightsWhenDirectFlight PASSED");

	}
	
	public void testSearchAvailableFlightsPriorityTime() throws FlightException, ServiceLoadException{
        List<Flight> resultFlights = flightManager.searchAvailableFlights(customerSearchCriteria3);
        assertTrue(resultFlights.stream().anyMatch(f -> f.equals(flight2)) &&
        		resultFlights.stream().anyMatch(f -> f.equals(flight5)) && resultFlights.stream().anyMatch(f -> f.equals(flight6))); 		
		System.out.println("testSearchAvailableFlightsPriorityTime PASSED");

	}
	
	public void testSearchAvailableFlights() throws FlightException, ServiceLoadException{
        List<Flight> resultFlights = flightManager.searchAvailableFlights(customerSearchCriteria4);
        assertTrue(resultFlights.stream().anyMatch(f -> f.equals(flight1)) && resultFlights.stream().anyMatch(f -> f.equals(flight2)) &&
        		resultFlights.stream().anyMatch(f -> f.equals(flight5)) && resultFlights.stream().anyMatch(f -> f.equals(flight6))); 		
		System.out.println("testSearchAvailableFlights PASSED");

	}

}
