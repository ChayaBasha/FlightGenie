package business;

import domain.UserCredentials;
import domain.customer.Customer;
import service.ICustomerSvc;
import service.IUserSvc;
import service.exception.CustomerException;
import service.exception.ServiceLoadException;
import service.exception.UserException;

/**
 * This class controls the access to user services; implemented for customer users for now
 * @author johannablumenthal
 *
 */
public class UserManager extends ManagerSuperType {

	public static String ICUSTOMER_SVC_PROP = "ICustomerSvc";

	public static String IUSER_SVC_PROP = "IUserSvc";
	
	/**
	 * This is for you to manage who is logged in (This is needed for itineraries)
	 */
	public Customer loggedInCustomer;

	public IUserSvc userSvc() throws ServiceLoadException {
		return (IUserSvc) getService(IUSER_SVC_PROP);
	}

	public ICustomerSvc customerSvc() throws ServiceLoadException {
		return (ICustomerSvc) getService(ICUSTOMER_SVC_PROP);
	}

	/**
	 * the register checks if userName is available prior to creating new Customer
	 * 
	 * @param newCustomer
	 * @throws UserException
	 * @throws CustomerException
	 * @throws ServiceLoadException
	 */

	public void register(Customer newCustomer) throws UserException, CustomerException, ServiceLoadException {

		IUserSvc userSvc = userSvc();

		if (userSvc.checkUserNameAvailable(newCustomer.getCustomerCredentials().getUserName())) {

			ICustomerSvc customerSvc = customerSvc();

			customerSvc.createCustomer(newCustomer);
		} else
			throw new UserException("your userName must be unique");
	}

	/**
	 * login chcecks authentication and then returns the customer
	 * 
	 * @param currentUserCredentials
	 * @throws UserException
	 * @throws ServiceLoadException
	 */
	public Customer login(UserCredentials currentUserCredentials)
			throws UserException, CustomerException, ServiceLoadException {

		IUserSvc userSvc = userSvc();

		if (userSvc.authenticateUser(currentUserCredentials)) {

			ICustomerSvc customerSvc = customerSvc();

			this.loggedInCustomer = customerSvc.getCustomerByUserName(currentUserCredentials.getUserName());
			return this.loggedInCustomer;

		} else
			throw new CustomerException("No  user found with those credentials");

	}
	/**
	 * Logout function added
	 */
	public void logout() {
		this.loggedInCustomer = null;
	}

	public void deleteCustomer(String userName) throws ServiceLoadException, CustomerException {
		ICustomerSvc customerSvc = customerSvc();
		customerSvc.deleteCustomer(userName);
	}

}
