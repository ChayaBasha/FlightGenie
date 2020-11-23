package business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.UserCredentials;
import domain.customer.Address;
import domain.customer.CardType;
import domain.customer.CreditCard;
import domain.customer.Customer;
import junit.framework.TestCase;
import service.ICustomerSvc;
import service.exception.CustomerException;
import service.exception.ServiceLoadException;
import service.exception.UserException;

public class UserManagerTest extends TestCase {

	private UserManager userManager = new UserManager();
	private Customer customer1;
	private Customer customer2;
	private Customer customer3;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		/**
		 * We want to make sure we have customers to compare to and test our methods
		 */

		Address customerAddress = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customerCreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555",
				"02/22", "453", customerAddress);

		/**
		 * The thing we care about is not making more than one user with the same
		 * userName We should not be able to register(Customer2), but we should be able
		 * to register customer3;
		 */

		UserCredentials customer1Credentials = new UserCredentials("FrogBomb", "r1bb3t!");
		customer1 = new Customer(customer1Credentials, "Frog Blumenthal", customerAddress, "frogbomb@gmail.com",
				customerCreditCard);

		UserCredentials customer2Credentials = new UserCredentials("FrogBomb", "cr0@k!");
		customer2 = new Customer(customer2Credentials, "Frog Blumenthal", customerAddress, "frogbomb@gmail.com",
				customerCreditCard);

		UserCredentials customer3Credentials = new UserCredentials("FrogKing", "cr0@k!");
		customer3 = new Customer(customer3Credentials, "Frog Higness", customerAddress, "frogbomb@gmail.com",
				customerCreditCard);

		ICustomerSvc customerSvc = userManager.customerSvc();

		customerSvc.createCustomer(customer1);
	}

	@Test
	public void testRegisterSameUserName() throws CustomerException, ServiceLoadException {
		boolean caught = false;
		try {
			userManager.register(customer2);
		} catch (UserException exception) {

			caught = true;

		}
		assertTrue(caught);

		System.out.println("TestRegisterSameUserName PASSED");
	}

	@Test
	public void testRegister() throws UserException, CustomerException, ServiceLoadException {
		userManager.register(customer3);
	}

	@Test
	public void testLogin() throws UserException, CustomerException, ServiceLoadException {

		assertTrue(userManager.login(customer1.getCustomerCredentials()).equals(customer1));
		System.out.println("testLogin PASSED");
	}

	@After
	public void tearDown() throws Exception {

		ICustomerSvc customerSvc = userManager.customerSvc();
		try {
			customerSvc.deleteCustomer(customer3.getCustomerCredentials().getUserName());
		} catch (CustomerException e) {
			;
		}
	}

	
}
