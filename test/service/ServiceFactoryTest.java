package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ServiceFactoryTest {
	
	ServiceFactory serviceFactory;

	@Before
	public void setUp() throws Exception {
		serviceFactory = new ServiceFactory();
	}
	@Test
	void testGetUserService() {
		IUserSvc userService = (IUserSvc)serviceFactory.getUserService();
		assertTrue(userService instanceof UserSvcImpl);
	}
	
	@Test
	void testGetCustomerService() {
		ICustomerSvc customerService = (ICustomerSvc)serviceFactory.getCustomerService();
		assertTrue(customerService instanceof CustomerSvcImpl);
	}
	
	@Test
	void testGetFlightService() {
		IFlightSvc flightService = (IFlightSvc)serviceFactory.getFlghtService();
		assertTrue(flightService instanceof FlightSvcImpl);
	}

	@Test
	void testGetItineraryService() {
		IItinerarySvc itineraryService = (IItinerarySvc)serviceFactory.getItineraryService();
		assertTrue(itineraryService instanceof ItinerarySvcImpl);
	}
}
