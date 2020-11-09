package domain.customer.itinerary;

import domain.flights.Flight;

import java.util.Date;


/**
 * class that holds the particular flights that a customer has booked for
 * passengers
 * 
 * @author johannablumenthal
 *
 */
public class Itinerary {

	private String itineraryId;
	/**
	 * Holds the customer ID who made the itinerary
	 */
	private String owner;
	/**
	 * Holds passenger name, which could be different than the customer
	 */
	private String passengerName;
	private Flight flight;
	/**
	 * Holds the specific seat on the plane that was reserved
	 */
	private String seatNumber;
	/**
	 * Holds an enumeration of whether reserved, booked or canceled as specified in
	 * the project
	 */
	private BookingStatus bookingStatus;
	private Date bookingDate = new Date();

	public String getItineraryId() {
		return itineraryId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String currentUserId) {
		if (currentUserId != null) {
			this.owner = currentUserId;
		}
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		if (passengerName != null) {
			this.passengerName = passengerName;
		}
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeat(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		if (bookingStatus != null) {
			this.bookingStatus = bookingStatus;
		}
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		if (bookingDate != null) {
			this.bookingDate = bookingDate;
		} else {
			Date todaysDate = new Date();
			this.bookingDate = todaysDate;
		}
	}

	public Itinerary(String itineraryId, String owner, String passengerName, Flight flight, String seatNumber, BookingStatus bookingStatus) {
		assert (itineraryId != null && owner != null && passengerName != null && flight != null && seatNumber != null && bookingStatus != null);
		this.itineraryId = itineraryId;
		this.owner = owner;
		this.passengerName = passengerName;
		this.flight = flight;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
	}

	/**
	 * This method tests whether there the same passenger has been booked more than once on the same exact flight; the system should prevent this as one person cannot be in more than one seat at a time
	 * @param itinerary
	 * @return
	 */
	
	public boolean equals(Itinerary itinerary) {
		if(itinerary.getPassengerName() == this.getPassengerName() 
				&& itinerary.getFlight() == this.getFlight()) {
			return true;
		} else
			return false;
			
	}
}

