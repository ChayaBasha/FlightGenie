package service.implementationTests;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import domain.customer.itinerary.BookingStatus;
import domain.customer.itinerary.Itinerary;
import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import junit.framework.TestCase;
import service.IItinerarySvc;
import service.ItinerarySvcImpl;
import service.ServiceFactory;
import service.exception.ItineraryException;
import service.exception.ServiceLoadException;

public class ItinerarySvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Itinerary itinerary;
	private Itinerary itinerary2;

	@Before
	protected void setUp() throws Exception {

		serviceFactory = ServiceFactory.getInstance();
		Flight flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO,
				LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA,
				LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		itinerary = new Itinerary("FrogBomb", "Penny Blumenthal", flight1, "1C", BookingStatus.RESERVED);
	}

	@Test
	public void testCreateItinerary() {

		try {

			IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
			itineraryService.createItinerary(itinerary);
			System.out.println("testCreateItinerary PASSED");

		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getService(IItinerarySvc.NAME);
			itineraryServiceImpl.createItinerary(itinerary);
			System.out.println("testCreateItinerary PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testGetItineraryByCustomer() {

		String userName = "FrogBomb";
		

		try {

			IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
			assertTrue(itineraryService.getItineraryByCustomer(userName).size() != 0);
			System.out.println("testGetItineraryByCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {

			ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getService(IItinerarySvc.NAME);
			assertTrue(itineraryServiceImpl.getItineraryByCustomer(userName) != null);
			System.out.println("testGetItineraryByCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testGetItineraryById() {

		String itineraryId = itinerary.createItineraryID();
		String itineraryOwner = itinerary.getOwner();

		try {
			IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
			itineraryService.createItinerary(itinerary);
			assertTrue(itineraryService.getItineraryById(itineraryOwner, itineraryId) != null);
			System.out.println("testGetItineraryById PASSED");

		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getService(IItinerarySvc.NAME);
			assertTrue(itineraryServiceImpl.getItineraryById(itineraryOwner, itineraryId) != null);
			System.out.println("testGetItineraryById PASSED");

		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testUpdateItinerary() {
		
		try {

		IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
		itineraryService.createItinerary(itinerary);
		itineraryService.updateItinerary(itinerary);
		System.out.println("testUpdateItinerary PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getService(IItinerarySvc.NAME);
		itineraryServiceImpl.createItinerary(itinerary);
		itineraryServiceImpl.updateItinerary(itinerary);
		System.out.println("testUpdateItinerary PASSED");
		
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (ItineraryException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

//	@Test
//	public void testDeleteItinerary() {
//
//		try {
//			IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
//			itineraryService.createItinerary(itinerary);
//			itineraryService.deleteItinerary(itinerary);
//			System.out.println("testDeleteItinerary PASSED");
//
//		} catch (ServiceLoadException e) {
//			e.printStackTrace();
//			fail("Service didn't load");
//		} catch (ItineraryException e) {
//			e.printStackTrace();
//			fail(e.getLocalizedMessage());
//		}
//
//		try {
//
//			ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getService(IItinerarySvc.NAME);
//			itineraryServiceImpl.createItinerary(itinerary);
//			itineraryServiceImpl.deleteItinerary(itinerary);
//			System.out.println("testDeleteItinerary PASSED");
//
//		} catch (ServiceLoadException e) {
//			e.printStackTrace();
//			fail("Service didn't load");
//		} catch (ItineraryException e) {
//			e.printStackTrace();
//			fail(e.getLocalizedMessage());
//		}
//	}

}
