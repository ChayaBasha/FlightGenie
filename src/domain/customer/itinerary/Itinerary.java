package domain.customer.itinerary;

import domain.flights.Flight;

import domain.flights.Seat;
import java.util.Date;
import java.util.List;

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
	private List<Flight> flights;
	/**
	 * Holds the specific seat on the plane that was reserved
	 */
	private Seat seat;
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

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
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

	public Itinerary(String owner, String passengerName, List<Flight> flights, Seat seat, BookingStatus bookingStatus) {
		assert (owner != null && passengerName != null && flights != null && seat != null && bookingStatus != null);
//		this.itineraryId = itineraryId;
		this.owner = owner;
		this.passengerName = passengerName;
		this.flights = flights;
		this.seat = seat;
		this.bookingStatus = bookingStatus;
	}

}
