package domain.customer;

import domain.User;

public class Customer extends User {

	private String name;
	private Address address;
	private String email;
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

	public Customer(String userName, String password, String name, Address address, String email, CreditCard creditCard) {
		super(userName, password);
		assert(name != null && address != null && email != null && creditCard != null);
		this.name=name;
		this.address=address;
		this.email=email;
		this.creditCard= creditCard;
		
	}
}
