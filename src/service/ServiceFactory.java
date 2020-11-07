package service;

/**
 * Factory to create the various services as needed
 * 
 * @author johannablumenthal
 *
 */

public class ServiceFactory {
	
	public IUserSvc getUserService() {
		return new UserSvcImpl();
	}
	
	public ICustomerSvc getCustomerService() {
		return new CustomerSvcImpl();
	}
	
	public IFlightSvc getFlghtService() {
		return new FlightSvcImpl();
	}
	
	public IItinerarySvc getItineraryService() {
		return new ItinerarySvcImpl();
	}

}
