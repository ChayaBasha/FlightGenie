package domain.customer;

import java.io.Serializable;

import domain.UserCredentials;
import service.exception.CustomerConstructorException;

/**
 * The Customer class is one of the main users of the system
 * 
 * @author johannablumenthal
 *
 */

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserCredentials customerCredentials;

	/**
	 * Holds the name of the customer
	 */
	private String name;

	/**
	 * Holds the customers address as specified in the address class
	 */
	private Address address;
	/**
	 * Holds the customer email
	 */
	private String email;
	/**
	 * Holds the customers credit card as specified in the CreditCard class
	 */
	private CreditCard creditCard;

	public UserCredentials getCustomerCredentials() {
		return customerCredentials;
	}

	public void setCustomerCredentials(UserCredentials customerCredentials) {
		this.customerCredentials = customerCredentials;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if (address != null) {
			this.address = address;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email;
		}
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		if (creditCard != null) {
			this.creditCard = creditCard;
		}
	}

	public Customer(UserCredentials customerCredentials, String name, Address address, String email, CreditCard creditCard)
			throws CustomerConstructorException {
		
		if (customerCredentials != null && name != null && address != null && creditCard != null) {

			this.customerCredentials = customerCredentials;
			this.name = name;
			this.address = address;
			this.email = email;
			this.creditCard = creditCard;

		} else
		throw new CustomerConstructorException("Customer Fields cannot be null");
	}

	
}
