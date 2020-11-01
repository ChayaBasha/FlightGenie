package domain.customer;

public class Address {

	private String city;
	private String state;
	private String country;
	private String zipCode;

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

	public Address(String city, String state, String country, String zipCode) {
		assert (city != null && state != null && country != null && zipCode != null);
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

}
