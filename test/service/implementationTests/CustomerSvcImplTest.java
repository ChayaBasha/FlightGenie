package service.implementationTests;

import org.junit.Before;
import org.junit.Test;

import domain.UserCredentials;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import domain.customer.Address;
import domain.customer.CardType;
import domain.customer.CreditCard;
import domain.customer.Customer;
import junit.framework.TestCase;
import service.CustomerSvcImpl;
import service.ICustomerSvc;
import service.ServiceFactory;
import service.exception.CustomerException;
import service.exception.ServiceLoadException;

public class CustomerSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Customer customer1;

	@Before
	protected void setUp() throws Exception {

		serviceFactory = ServiceFactory.getInstance();
		UserCredentials customerCredentials = new UserCredentials("Penny", "W00f!");
		Address customer1Address = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customer1CreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555",
				"02/22", "453", customer1Address);
		customer1 = new Customer(customerCredentials, "Penny Blumenthal", customer1Address, "penny@gmail.com",
				customer1CreditCard);

	}

	@Test
	public void testCreateCustomer() {
		try {
			ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
			customerService.createCustomer(customer1);
			System.out.println("testCreateCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getService(ICustomerSvc.NAME);
			customerServiceImpl.createCustomer(customer1);
			System.out.println("testCreateCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void getCustomerByUserName() {

		String userName = customer1.getCustomerCredentials().getUserName();

		try {
			ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
			assertTrue(customerService.getCustomerByUserName(userName) != null);
			System.out.println("testGetCustomerByUserName PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

		try {
			CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getService(ICustomerSvc.NAME);
			assertTrue(customerServiceImpl.getCustomerByUserName(userName) != null);
			System.out.println("testGetCustomerByUsername PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void testUpdateCustomer() {
		try {
			ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
			customerService.createCustomer(customer1);
			customerService.updateCustomer(customer1);
			System.out.println("testUpdateCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		try {
			CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getService(ICustomerSvc.NAME);
			customerServiceImpl.updateCustomer(customer1);
			System.out.println("testUpdateCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}

	}

	@Test
	public void testDeleteCustomer() {

		String userName = customer1.getCustomerCredentials().getUserName();

		try {
			ICustomerSvc customerService = (ICustomerSvc) serviceFactory.getService(ICustomerSvc.NAME);
			customerService.createCustomer(customer1);
			customerService.deleteCustomer(userName);
			System.out.println("testDeleteCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		

		try {
			CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getService(ICustomerSvc.NAME);
			customerServiceImpl.createCustomer(customer1);
			customerServiceImpl.deleteCustomer(userName);
			System.out.println("testDeleteCustomer PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Service didn't load");
		} catch (CustomerException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}

}
