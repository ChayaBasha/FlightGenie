package service;

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
 * Because I am checking that my fields are not null in the constructor, I cannot return a new Customer without it actually pulling the data 
 */
	@Override
	public Customer getCustomerByUserName(String userName) {
		System.out.println("Retrieve Method for Customer Implementation Working");
		return null;
	}

	@Override
	public void upateCustomer(Customer customer) {
		System.out.println("Update Method for Customer Impementation is Working");
		
	}

	@Override
	public void deleteCustomer(String userName) {
		System.out.println("Delete Method for Customer Imlementation is Working");
		
	}

	
	
}
