package service.implementationTests;

import java.time.LocalDateTime;

import org.junit.Test;

import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import junit.framework.TestCase;
import service.FlightSvcImpl;
import service.IFlightSvc;
import service.ServiceFactory;
import service.exception.FlightException;
import service.exception.ServiceLoadException;

public class FlightSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Airport departureCity;
	private Airport arrivalCity;
	private LocalDateTime startDepartureTimeRange;
	private LocalDateTime endDepartureTimeRange;
	private Flight flight1;
	private Flight flight2;
	private Flight flight3;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = ServiceFactory.getInstance();
		departureCity = Airport.ASPEN_CO;
		arrivalCity = Airport.BOSTON_MA;
		startDepartureTimeRange = LocalDateTime.parse("2019-06-23T11:00:00");
		endDepartureTimeRange = LocalDateTime.parse("2019-06-23T23:00:00");
		flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		flight2 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T10:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		flight3 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-24T12:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-24T18:38:00"), 79.00, 53.00);

	}

	@Test
	public void testAddFlight() {
		try {
			IFlightSvc flightService = (IFlightSvc) serviceFactory.getService(IFlightSvc.NAME);
			flightService.addFlight(flight1);
			System.out.println("testAddFlight PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			FlightSvcImpl flightServiceImpl = (FlightSvcImpl) serviceFactory.getService(IFlightSvc.NAME);
			flightServiceImpl.addFlight(flight2);
			System.out.println("testAddFlight PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testGetAllFlights() {
		try {
			IFlightSvc flightService = (IFlightSvc) serviceFactory.getService(IFlightSvc.NAME);
			flightService.getAllFlights();
			System.out.println("testGetFlights PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {

			FlightSvcImpl flightSvcImpl = (FlightSvcImpl) serviceFactory.getService(IFlightSvc.NAME);
			flightSvcImpl.getAllFlights();
			System.out.println("testGetAllFlights PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
			
		
	}

	@Test
	public void testGetFlightsByRoute() {

		try {
			IFlightSvc flightService = (IFlightSvc) serviceFactory.getService(IFlightSvc.NAME);
			assertTrue(flightService.getFlightsByRoute(departureCity, arrivalCity) != null);
			System.out.println("testGetFlightsByRoute PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {

			FlightSvcImpl flightSvcImpl = (FlightSvcImpl) serviceFactory.getService(IFlightSvc.NAME);
			assertTrue(flightSvcImpl.getFlightsByRoute(departureCity, arrivalCity) != null);
			System.out.println("testGetFlightsByRoute PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

	}

	@Test
	public void testGetFlightsByTimeFrame() {

		try {

			IFlightSvc flightService = (IFlightSvc) serviceFactory.getService(IFlightSvc.NAME);
			assertTrue(flightService.getFlightByTimeFrame(startDepartureTimeRange, endDepartureTimeRange) != null);
			System.out.println("testGetFlightsByTimeFrame PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			FlightSvcImpl flightSvcImpl = (FlightSvcImpl) serviceFactory.getService(IFlightSvc.NAME);
			assertTrue(flightSvcImpl.getFlightsByRoute(departureCity, arrivalCity) != null);
			System.out.println("testGetFlightsByTimeFrame PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (FlightException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

}
