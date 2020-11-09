package service.implementationTests;


import java.time.LocalDateTime;

import org.junit.Test;


import domain.flights.Airport;
import junit.framework.TestCase;
import service.FlightSvcImpl;
import service.IFlightSvc;
import service.ServiceFactory;

public class FlightSvcImplTest extends TestCase{
	
	private ServiceFactory serviceFactory;
	private Airport departureCity;
	private Airport arrivalCity;
	private LocalDateTime startDepartureTimeRange;
	private LocalDateTime endDepartureTimeRange;
	
	@Override 
	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("hi");
		
		serviceFactory = new ServiceFactory();
		departureCity = Airport.DENVER_CO;
		arrivalCity = Airport.HARTFORD_CT;
		startDepartureTimeRange = LocalDateTime.parse("2019-06-23T00:00:00");
		endDepartureTimeRange = LocalDateTime.parse("2019-06-23T00:00:00");
		
		
	
	}

	@Test
	public void testGetFlightsByRoute() {
		

		System.out.println("there");
		IFlightSvc flightService = serviceFactory.getFlghtService();
		assertTrue(flightService.getFlightsByRoute(departureCity, arrivalCity)!= null);
		System.out.println("testGetFlightsByRoute PASSED");
		
		FlightSvcImpl flightSvcImpl = (FlightSvcImpl) serviceFactory.getFlghtService();
		assertTrue(flightSvcImpl.getFlightsByRoute(departureCity, arrivalCity)!=null);
		
	}
	
	@Test
	public void testGetFlightsByTimeFrame() {
		
		IFlightSvc flightService = serviceFactory.getFlghtService();
		assertTrue(flightService.getFlightByTimeFrame(startDepartureTimeRange, endDepartureTimeRange)!=null);
		System.out.println("testGetFlightsByTimeFrame PASSED");
		
		FlightSvcImpl flightSvcImpl = (FlightSvcImpl) serviceFactory.getFlghtService();
		assertTrue(flightSvcImpl.getFlightsByRoute(departureCity, arrivalCity) != null);
		
	}

}
