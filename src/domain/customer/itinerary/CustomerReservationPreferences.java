package domain.customer.itinerary;

import domain.flights.Flight;
import domain.flights.SeatType;

public class CustomerReservationPreferences {
	
	private Flight selectedFlight;
	private SeatType seatPreference;
	

	public Flight getSelectedFlight() {
		return selectedFlight;
	}
	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}
	public SeatType getSeatPreference() {
		return seatPreference;
	}
	public void setSeatPreference(SeatType seatPreference) {
		this.seatPreference = seatPreference;
	}
	
	public CustomerReservationPreferences(Flight selectedFlight, SeatType seatPreference ) {
		this.setSelectedFlight(selectedFlight);
		this.setSeatPreference(seatPreference);
	}

}
