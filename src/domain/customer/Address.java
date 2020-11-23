package domain.customer;

import java.io.Serializable;

/**
 * Class used to store addresses for users and for billing
 * 
 * @author johannablumenthal
 * @version 0.1
 */
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Holds the street address including the number and street and type of street
	 * ex 1234 Bux way ex 34B 8th Ave. ex 375 Iris Ave Suite 2
	 */

	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if (street != null) {
			this.street = street;
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city != null) {
			this.city = city;
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (state != null) {
			this.state = state;
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (country != null) {
			this.country = country;
		}
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if (zipCode != null) {
			this.zipCode = zipCode;
		}
	}

	public Address(String street, String city, String state, String country, String zipCode) {
		assert (street != null && city != null && state != null && country != null && zipCode != null);
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	/**
	 * Equals method to compare customer addresses
	 * @param address
	 * @return
	 */

	public boolean equals(Address address) {
		if(address.getStreet().equals(this.getStreet()) &&
				address.getCity().equals(this.getCity()) &&
				address.getState().equals(this.getState()) &&
				address.getZipCode().equals(this.getZipCode())) {
			return true;
		} else 
			return false;
	}
}
