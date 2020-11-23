package service.implementationTests;

import org.junit.Before;
import org.junit.Test;

import domain.UserCredentials;
import domain.customer.Address;
import domain.customer.CardType;
import domain.customer.CreditCard;
import domain.customer.Customer;
import junit.framework.TestCase;
import service.ICustomerSvc;
import service.IUserSvc;
import service.ServiceFactory;
import service.UserSvcImpl;
import service.exception.ServiceLoadException;
import service.exception.UserException;

public class UserSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Customer customer;

	@Before
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = ServiceFactory.getInstance();
		
		UserCredentials customerCredentials = new UserCredentials("FrogBomb", "r1bb3t!");
		Address customer1Address = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customer1CreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555",
				"02/22", "453", customer1Address);
		customer = new Customer(customerCredentials, "Frog Blumenthal", customer1Address, "frogbomb@gmail.com",
				customer1CreditCard);
		ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
		customerService.createCustomer(customer);

	}

	@Test
	public void testCheckUserNameAvailable() {

		String userName = customer.getCustomerCredentials().getUserName();

		try {
			IUserSvc userService = (IUserSvc) serviceFactory.getService(IUserSvc.NAME);
			assertFalse(userService.checkUserNameAvailable(userName));
			assertTrue(userService.checkUserNameAvailable("a little less crazy"));
			System.out.println("testCheckUserName PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (UserException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			UserSvcImpl userServiceImpl = (UserSvcImpl) serviceFactory.getService(IUserSvc.NAME);
			assertFalse(userServiceImpl.checkUserNameAvailable(userName));
			assertTrue(userServiceImpl.checkUserNameAvailable("a little less crazy"));
			System.out.println("testCheckUserName PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (UserException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

	}

	@Test
	public void testAuthenticateUser() {
		UserCredentials customerCredentials = customer.getCustomerCredentials();
		try {
			IUserSvc userService = (IUserSvc) serviceFactory.getService(IUserSvc.NAME);
			assertTrue(userService.authenticateUser(customerCredentials));
			System.out.println("testAuthenticateUser PASSED");

		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (UserException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {

			UserSvcImpl userServiceImpl = (UserSvcImpl) serviceFactory.getService(IUserSvc.NAME);
			assertTrue(userServiceImpl.authenticateUser(customerCredentials));
			System.out.println("testAuthenticateUserPASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (UserException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

	}
}
