package service.implementationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import domain.flights.Airport;
import domain.flights.Flight;
import junit.framework.TestCase;
import service.IFlightSvc;
import service.ServiceFactory;

class FlightSvcImplTest extends TestCase{
	
	private ServiceFactory serviceFactory;
	private Airport departureCity;
	private Airport arrivalCity;
	private LocalDateTime startDepartureTimeRange;
	private LocalDateTime endDepartureTimeRange;
	
	
	protected void SetUp() throws Exception{
		super.setUp();
		
		serviceFactory = new ServiceFactory();
		departureCity = Airport.DENVER_CO;
		arrivalCity = Airport.HARTFORD_CT;
		startDepartureTimeRange = LocalDateTime.parse("2019-06-23T00:00:00");
		endDepartureTimeRange = LocalDateTime.parse("2019-06-23T00:00:00");
		
		
	
	}

	@Test
	void testGetFlightsByRoute() {
		
		IFlightSvc flightService = serviceFactory.getFlghtService();
		assert(flightService.getFlightsByRoute(departureCity, arrivalCity)== "");
		
		
	}

}
