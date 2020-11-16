package service.FactoryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import service.exception.ServiceLoadException;

public class ServiceFactoryTest {

	ServiceFactory serviceFactory;

	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
	}

	@Test
	public void testGetUserService() {
		try {
			IUserSvc userService = (IUserSvc) serviceFactory.getService(IUserSvc.NAME);
			assertTrue(userService instanceof UserSvcImpl);
			System.out.println("test GetUserService Passed");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("service didn't load");
		}
	}

	@Test
	public void testGetCustomerService() {
		try {
			ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
			assertTrue(customerService instanceof CustomerSvcImpl);
			System.out.println("test GetCustomerService PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("service didn't load");
		}
	}

	@Test
	public void testGetFlightService() {
		try {
			IFlightSvc flightService = (IFlightSvc) serviceFactory.getService(IFlightSvc.NAME);
			System.out.println("test Get Flight Service PASSED");
			assertTrue(flightService instanceof FlightSvcImpl);
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("service didn't load");
		}
	}

	@Test
	public void testGetItineraryService() {
		try {
			IItinerarySvc itineraryService = (IItinerarySvc) serviceFactory.getService(IItinerarySvc.NAME);
			assertTrue(itineraryService instanceof ItinerarySvcImpl);
			System.out.println("test GEtItinerary Service PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("service didn't load");
		}
	}
}
