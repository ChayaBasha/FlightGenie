package business;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import domain.flights.FlightSearchCriteria;
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

		IFlightSvc flightSvc = flightManager.flightSvc();

		flightSvc.addFlight(flight1);
		flightSvc.addFlight(flight2);
		flightSvc.addFlight(flight3);
		flightSvc.addFlight(flight4);

		/**
		 * This search criteria should return only flight 2 because that is the only
		 * flight arriving before the desired arrival time that is a direct flight
		 */
		customerSearchCriteria1 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:00:00"), (short) 2, null,
				true, true);

		/**
		 * This search Criteria should return flight1 and flight2 because both are
		 * within the broader time frame and the correct route
		 */

		customerSearchCriteria2 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:30:00"), (short) 2, null,
				true, false);
		/**
		 * This one should return flight2, flight3 since they are both within the strict
		 * arrival time period
		 */
		customerSearchCriteria3 = new FlightSearchCriteria(Airport.ASPEN_CO, Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T12:00:00"), LocalDateTime.parse("2019-06-23T20:30:00"), (short) 2, null,
				false, true);
		/**
		 * This one should return no flights because none of the flights are occurring
		 * next week.
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
        assertTrue(resultFlights.stream().anyMatch(f -> f.equals(flight2)) && resultFlights.stream().anyMatch(f -> f.equals(flight3))); 		
		System.out.println("testSearchAvailableFlightsPriorityTime PASSED");

	}
	
	public void testSearchAvailableFlights() throws FlightException, ServiceLoadException{
        List<Flight> resultFlights = flightManager.searchAvailableFlights(customerSearchCriteria4);
        assertTrue(resultFlights.size() ==0); 		
		System.out.println("testSearchAvailableFlights PASSED");

	}

}
