package service.implementationTests;

import org.junit.Before;
import org.junit.Test;

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

public class CustomerSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Customer customer1;
	
	@Before
	protected void setUp() throws Exception {
		
		serviceFactory = new ServiceFactory();
		Address  customer1Address = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customer1CreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555", "02/22", "453", customer1Address);
		customer1 = new Customer("Penny", "W00f!", "Penny Blumenthal", customer1Address,"penny@gmail.com", customer1CreditCard );
		
	}

	@Test
	public void testCreateCustomer() {
		
		ICustomerSvc customerService = serviceFactory.getCustomerService();
		customerService.createCustomer(customer1);
		System.out.println("testCreateCustomer PASSED");
		
		CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getCustomerService();
		customerServiceImpl.createCustomer(customer1);
		System.out.println("testCreateCustomer PASSED");
	}
	
	@Test
	public void getCustomerByUserName() {
		
		String userName = customer1.getUserName();
		
		ICustomerSvc customerService = serviceFactory.getCustomerService();
		assertTrue(customerService.getCustomerByUserName(userName)!= null);
		System.out.println("testGetCustomerByUserName PASSED");
		
		CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getCustomerService();
		assertTrue(customerServiceImpl.getCustomerByUserName(userName)!= null);
		System.out.println("testGetCustomerByUsername PASSED");
		
	}
	
	@Test
	public void testUpdateUser() {
	ICustomerSvc customerService = serviceFactory.getCustomerService();
	customerService.updateCustomer(customer1);
	System.out.println("testUpdateCustomer PASSED");
	
	CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getCustomerService();
	customerServiceImpl.updateCustomer(customer1);
	System.out.println("testUpdateCustomer PASSED");
	
	}
	
	@Test
	public void testDeleteCustomer() {
		
		String userName = customer1.getUserName();
		
		ICustomerSvc customerService = serviceFactory.getCustomerService();
		customerService.deleteCustomer(userName);
		System.out.println("testDeleteCustomer PASSED");
		
		CustomerSvcImpl customerServiceImpl = (CustomerSvcImpl) serviceFactory.getCustomerService();
		customerServiceImpl.deleteCustomer(userName);
		System.out.println("testDeleteCustomer PASSED");
	}

}
