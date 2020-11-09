package service.FactoryTest;

import static org.junit.Assert.assertTrue;


import org.junit.Before;

import org.junit.Test;

import service.CustomerSvcImpl;
import service.FlightSvcImpl;
import service.ICustomerSvc;
import service.IFlightSvc;
import service.IItinerarySvc;
import service.IUserSvc;
import service.ItinerarySvcImpl;
import service.ServiceFactory;
import service.UserSvcImpl;


public class ServiceFactoryTest {
	
	ServiceFactory serviceFactory;

	@Before
	public void setUp() throws Exception {
		serviceFactory = new ServiceFactory();
	}
	@Test
	public void testGetUserService() {
		IUserSvc userService = (IUserSvc)serviceFactory.getUserService();
		assertTrue(userService instanceof UserSvcImpl);
	}
	
	@Test
	public void testGetCustomerService() {
		ICustomerSvc customerService = (ICustomerSvc)serviceFactory.getCustomerService();
		assertTrue(customerService instanceof CustomerSvcImpl);
	}
	
	@Test
	public void testGetFlightService() {
		IFlightSvc flightService = (IFlightSvc)serviceFactory.getFlghtService();
		assertTrue(flightService instanceof FlightSvcImpl);
	}

	@Test
	public void testGetItineraryService() {
		IItinerarySvc itineraryService = (IItinerarySvc)serviceFactory.getItineraryService();
		assertTrue(itineraryService instanceof ItinerarySvcImpl);
	}
}
