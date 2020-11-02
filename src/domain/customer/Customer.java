package domain.customer;

import domain.User;

/**
 * this subclass extends the user class as it is a type of user the Customer
 * 
 * @author johannablumenthal
 *
 */

public class Customer extends User {
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

	public Customer(String userName, String password, String name, Address address, String email,
			CreditCard creditCard) {
		super(userName, password);
		assert (name != null && address != null && email != null && creditCard != null);
		this.name = name;
		this.address = address;
		this.email = email;
		this.creditCard = creditCard;

	}
}
