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
	 * in order to create a directory for all of the customers
	 */
	private File customerFolder = new File("customers");

	/**
	 * CRUD Functions for Customers. This reads and writes to the file system with each customer creating its own file in th ecustomers folder
	 */

	@Override
	public void createCustomer(Customer customer) throws CustomerException {

		if (customer != null) {
			try {
				customerFolder.mkdirs();
				ObjectOutputStream output = new ObjectOutputStream(
						new FileOutputStream(customerFolder.toPath().resolve((customer.getCustomerCredentials().getUserName() +".customer.out")).toFile()));

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
	 * The function will now check the existing UserNames to find the customer
	 */
	@Override
	public Customer getCustomerByUserName(String userName) throws CustomerException {
		if (userName != null) {
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(
						customerFolder.toPath().resolve(userName + ".customer.out").toFile()));
				Object fileObject = input.readObject();
				input.close();
				if (fileObject instanceof Customer) {
					return (Customer) fileObject;
				} else
					throw new CustomerConstructorException(userName + " not associated with a  Customer");

			} catch (FileNotFoundException e) {
				throw new CustomerException("could not find Customer " + userName);
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
		Customer existingCustomer = this.getCustomerByUserName(customer.getCustomerCredentials().getUserName());
		existingCustomer.getCustomerCredentials().setPassword(customer.getCustomerCredentials().getPassword());
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setCreditCard(customer.getCreditCard());

		this.createCustomer(existingCustomer);
	}


	@Override
	public void deleteCustomer(String userName) throws CustomerException {
		if(userName != null) {
			
				File existingUser = customerFolder.toPath().resolve(userName + ".customer.out").toFile();
				if(existingUser.exists()) {
					existingUser.delete();
				} else throw new CustomerException ("could not delete " + userName);
			
		} else 
			throw new CustomerException (" null input");

	}

}
