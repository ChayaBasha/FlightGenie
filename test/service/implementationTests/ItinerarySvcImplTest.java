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

public class ItinerarySvcImplTest extends TestCase {
	
	private ServiceFactory serviceFactory;
	private Itinerary itinerary;

	@Before
	protected void setUp() throws Exception {
		
		serviceFactory = new ServiceFactory();
		Flight flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
		itinerary = new Itinerary("123456AFD", "FrogBomb", "Penny Blumenthal", flight1, "1C", BookingStatus.RESERVED);
	}

	@Test
	public void testCreateItinerary() {
		
		IItinerarySvc itineraryService = serviceFactory.getItineraryService();
		itineraryService.createItinerary(itinerary);
		System.out.println("testCreateItinerary PASSED");
		
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getItineraryService();
		itineraryServiceImpl.createItinerary(itinerary);
		System.out.println("testCreateItinerary PASSED");
	}
	
	@Test
	public void testGetItineraryByCustomer() {
		
		String userName = "Penny";
		
		IItinerarySvc itineraryService = serviceFactory.getItineraryService();
		assertTrue(itineraryService.getItineraryByCustomer(userName)!= null);
		System.out.println("testGetItineraryByCustomer PASSED");
		
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getItineraryService();
		assertTrue(itineraryServiceImpl.getItineraryByCustomer(userName)!=null);
		System.out.println("testGetItineraryByCustomer PASSED");
	}
	
	@Test
	public void testGetItineraryById() {
		
		String itineraryId = itinerary.getItineraryId();
		
		IItinerarySvc itineraryService = serviceFactory.getItineraryService();
		assertTrue(itineraryService.getItineraryById(itineraryId)!= null);
		System.out.println("testGetItineraryById PASSED");
		
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getItineraryService();
		assertTrue(itineraryServiceImpl.getItineraryById(itineraryId)!=null);
		System.out.println("testGetItineraryById PASSED");
	}
	
	@Test
	public void testUpdateItinerary() {
		
		IItinerarySvc itineraryService = serviceFactory.getItineraryService();
		itineraryService.updateItinerary(itinerary);
		System.out.println("testUpdateItinerary PASSED");
		
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getItineraryService();
		itineraryServiceImpl.updateItinerary(itinerary);
		System.out.println("testUpdateItinerary PASSED");
	}
	
	@Test
	public void testDeleteItinerary() {
		
		String itineraryId = itinerary.getItineraryId();
		
		IItinerarySvc itineraryService = serviceFactory.getItineraryService();
		itineraryService.deleteItinerary(itineraryId);
		System.out.println("testDeleteItinerary PASSED");
		
		ItinerarySvcImpl itineraryServiceImpl = (ItinerarySvcImpl) serviceFactory.getItineraryService();
		itineraryServiceImpl.deleteItinerary(itineraryId);
		System.out.println("testDeleteItinerary PASSED");
	}

}
