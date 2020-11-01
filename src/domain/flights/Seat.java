package domain.flights;

public class Seat {

	private String seatNumber;
	private SeatType seatType;
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
		assert(seatNumber != null && seatType != null);
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.booked = booked;
	}


}
