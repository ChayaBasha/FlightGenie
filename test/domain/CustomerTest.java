package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.customer.Address;
import domain.customer.CardType;
import domain.customer.CreditCard;
import domain.customer.Customer;

class CustomerTest {
	
	@Test
	void createCustomerAllFields() {
		
		Address  customer1Address = new Address(" 1234 Privet Dr.", "Longmont", "CO", "United States", "80503");
		CreditCard customer1CreditCard = new CreditCard("Johanna Blumenthal", CardType.VISA, "5555 5555 5555 5555", "02/22", "453", customer1Address);
		Customer customer1 = new Customer("Penny", "W00f!", "Penny Blumenthal", customer1Address,"penny@gmail.com", customer1CreditCard );

		assertFalse(customer1.getUserName().equals("Penny Blumenthal"));
		assertTrue(customer1.getUserName().equals("Penny"));
	}

}
