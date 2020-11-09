package service;

import domain.customer.Customer;

/**
 * interface for Customer Services
 * @author johannablumenthal
 *
 */

public interface ICustomerSvc {
	
	/** 
	 * Basic CRUD functions for the Customer
	 * @param customer
	 */
	
	public void createCustomer(Customer customer);
	public Customer getCustomerByUserName(String userName);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(String userName);
	

}
