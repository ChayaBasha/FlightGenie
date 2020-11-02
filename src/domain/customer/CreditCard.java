package domain.customer;

/**
 * class used to hold the creditCard information for a customer
 * 
 * @author johannablumenthal
 *
 */

public class CreditCard {
	/**
	 * Holds the name on the credit/debit card, which could be different from the
	 * customer
	 */
	private String nameOnCard;

	/**
	 * Hold the enumerated creditCard types
	 */
	private CardType cardType;
	/**
	 * Holds the 16 digit credit card number as a string
	 */
	private String cardNumber;
	/**
	 * Holds the mm/yy expiration date
	 */
	private String expiration;
	/**
	 * Holds the CSC, CVV2, CVC2
	 */
	private String securityCode;
	/**
	 * Holds the billing address associated with the card, which could be different
	 * than the customer's address
	 */
	private Address billingAddress;

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		if (nameOnCard != null) {
			this.nameOnCard = nameOnCard;
		}
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		if (cardType != null) {
			this.cardType = cardType;
		}
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		if (cardNumber != null) {
			this.cardNumber = cardNumber;
		}
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		if (expiration != null) {
			this.expiration = expiration;
		}
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		if (securityCode != null) {
			this.securityCode = securityCode;
		}
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		if (billingAddress != null) {
			this.billingAddress = billingAddress;
		}
	}

	public CreditCard(String nameOnCard, CardType cardType, String cardNumber, String expiration, String securityCode,
			Address billingAddress) {
		assert (nameOnCard != null && cardType != null && cardNumber != null && expiration != null
				&& securityCode != null && billingAddress != null);
		this.nameOnCard = nameOnCard;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiration = expiration;
		this.securityCode = securityCode;
		this.billingAddress = billingAddress;
	}

}
