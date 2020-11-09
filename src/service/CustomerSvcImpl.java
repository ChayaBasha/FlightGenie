package service;

import domain.customer.Address;
import domain.customer.CardType;
import domain.customer.CreditCard;

/**
 * This is an implementation of the interface CustomerSvc
 * 
 * @author Johanna Blumenthal
 */

import domain.customer.Customer;

public class CustomerSvcImpl implements ICustomerSvc{
	
	
	
	
	/**
	 * Below are the beginnings of the CRUD functions for the Customers. Right now it doesn't do anything.
	 */

	@Override
	public void createCustomer(Customer customer) {
		System.out.println("Create Method for Customer Implimentation Working");
		
	}
/**
 * Because I am checking that my fields are not null in the constructor, I cannot return a new Customer without giving it data; when we built ou the data source it will come from the data source. 
 */
	@Override
	public Customer getCustomerByUserName(String userName) {
		Address  customer1Address = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customer1CreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555", "02/22", "453", customer1Address);
		System.out.println("Retrieve Method for Customer Implementation Working");
		
		return new Customer("Penny", "W00f!", "Penny Blumenthal", customer1Address,"penny@gmail.com", customer1CreditCard );
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Update Method for Customer Impementation is Working");
		
	}

	@Override
	public void deleteCustomer(String userName) {
		System.out.println("Delete Method for Customer Imlementation is Working");
		
	}

	
	
}
