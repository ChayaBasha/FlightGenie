package domain.flights;

import java.io.Serializable;

/**
 * class designed to track the bookings for each seat with the seat number
 * 
 * @author johannablumenthal
 * @version 0.1
 *
 */

public class Seat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/**
	 * Holds the unique seat number for the particular flight
	 */
	private String seatNumber;
	/**
	 * Holds the type either Business or Economy
	 */
	private SeatType seatType;

	/**
	 * Hold whether this has been booked by a customer
	 */
	private boolean booked;

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public Seat(String seatNumber, SeatType seatType, boolean booked) {
		assert (seatNumber != null && seatType != null);
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.booked = booked;
	}

}
