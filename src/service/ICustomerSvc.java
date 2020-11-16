package service;

import domain.customer.Customer;
import service.exception.CustomerException;

/**
 * interface for Customer Services
 * @author johannablumenthal
 *
 */

public interface ICustomerSvc extends IService {
	
	/**
	 * Key to look up the implementations for customerService
	 */
	
	public final String NAME = "ICustomerSvc";
	
	/** 
	 * Basic CRUD functions for the Customer
	 * @param customer
	 */
	
	public void createCustomer(Customer customer) throws CustomerException;
	public Customer getCustomerByUserName(String userName)throws CustomerException;
	public void updateCustomer(Customer customer) throws CustomerException;
	public void deleteCustomer(String userName) throws CustomerException;
	

}
