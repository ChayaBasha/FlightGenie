package domain.customer;

public class CreditCard {

	private String nameOnCard;
	private CardType cardType;
	private long cardNumber;
	private String expiration;
	private String securityCode;
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

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		if (cardNumber != 0L) {
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

	public CreditCard(String nameOnCard, CardType cardType, long cardNumber, String expiration, String securityCode,
			Address billingAddress) {
		assert(nameOnCard != null && cardType != null && cardNumber != 0L && expiration != null && securityCode != null && billingAddress != null);
		this.nameOnCard = nameOnCard;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expiration = expiration;
		this.securityCode = securityCode;
		this.billingAddress = billingAddress;
	}
	
	

}
