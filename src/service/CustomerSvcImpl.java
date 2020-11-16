package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This is an implementation of the interface CustomerSvc
 * 
 * @author Johanna Blumenthal
 */

import domain.customer.Customer;
import service.exception.CustomerConstructorException;
import service.exception.CustomerException;

public class CustomerSvcImpl implements ICustomerSvc {

	/**
	 * Below are the beginnings of the CRUD functions for the Customers. Right now
	 * it doesn't do anything.
	 */

	@Override
	public void createCustomer(Customer customer) throws CustomerException {

		if (customer != null) {
			try {
				ObjectOutputStream output = new ObjectOutputStream(
						new FileOutputStream(customer.getUserName() + ".customer.out"));

				output.writeObject(customer);
				output.flush();
				output.close();
			} catch (IOException e) {
				throw new CustomerException("Cannot save customer");

			}
		} else
			throw new CustomerException("Cannot save customer that is null");
	}

	/**
	 * Because I am checking that my fields are not null in the constructor, I
	 * cannot return a new Customer without giving it data; when we built ou the
	 * data source it will come from the data source.
	 */
	@Override
	public Customer getCustomerByUserName(String userName) throws CustomerException {
		if (userName != null) {
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(userName + ".customer.out"));
				Object fileObject = input.readObject();
				input.close();
				if (fileObject instanceof Customer) {
					return (Customer) fileObject;
				} else
					throw new CustomerConstructorException(userName + " not associated with a  Customer");

			} catch (FileNotFoundException e) {
				throw new CustomerException("could not find Customer" + userName);
			} catch (IOException e) {
				throw new CustomerException("There was an I/O problem");
			} catch (ClassNotFoundException e) {
				throw new CustomerException("unkown object");
			}
		} else
			throw new CustomerException("null input");

	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer = this.getCustomerByUserName(customer.getUserName());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setCreditCard(customer.getCreditCard());

		this.createCustomer(existingCustomer);
	}


	@Override
	public void deleteCustomer(String userName) throws CustomerException {
		if(userName != null) {
			
				File existingUser = new File(userName + ".customer.out");
				if(existingUser.exists()) {
					existingUser.delete();
				} else throw new CustomerException ("could not deleted " + userName);
			
		} else 
			throw new CustomerException (" null input");

	}

}
