package domain.flights;

import java.io.Serializable;
/**
 * This class holds the customers search criteria and preferences
 */
import java.time.LocalDateTime;

public class FlightSearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Airport desiredDepartureCity;
	private Airport desiredArrivalCity;
	private LocalDateTime desiredDepartureTime;
	private LocalDateTime desiredArrivalTime;
	private short numberPassengers;
	private SeatType desiredSeatType;
	private boolean directFlightsOnly;
	private boolean priorityTimeArrival;

	public Airport getDesiredDepartureCity() {
		return desiredDepartureCity;
	}

	public void setDesiredDepartureCity(Airport desiredDepartureCity) {
		this.desiredDepartureCity = desiredDepartureCity;
	}

	public Airport getDesiredArrivalCity() {
		return desiredArrivalCity;
	}

	public void setDesiredArrivalCity(Airport desiredArrivalCity) {
		this.desiredArrivalCity = desiredArrivalCity;
	}

	public LocalDateTime getDesiredDepartureTime() {
		return desiredDepartureTime;
	}

	public void setDesiredDepartureTime(LocalDateTime desiredDepartureTime) {
		this.desiredDepartureTime = desiredDepartureTime;
	}

	public LocalDateTime getDesiredArrivalTime() {
		return desiredArrivalTime;
	}

	public void setDesiredArrivalTime(LocalDateTime desiredArrivalTime) {
		this.desiredArrivalTime = desiredArrivalTime;
	}

	public short getNumberPassengers() {
		return numberPassengers;
	}

	public void setNumberPassengers(short numberPassenders) {
		this.numberPassengers = numberPassenders;
	}

	public SeatType getDesiredSeatType() {
		return desiredSeatType;
	}

	public void setDesiredSeatType(SeatType desiredSeatType) {
		this.desiredSeatType = desiredSeatType;
	}
	
	public boolean isDirectFlightsOnly() {
		return directFlightsOnly;
	}

	public void setDirectFlightsOnly(boolean directFlightsOnly) {
		this.directFlightsOnly = directFlightsOnly;
	}
	
	public boolean isPriorityTimeArrival() {
		return priorityTimeArrival;
	}

	public void setPriorityTimeArrival(boolean priorityTimeArrival) {
		this.priorityTimeArrival = priorityTimeArrival;
	}

	public FlightSearchCriteria(Airport desiredDepartureCity, Airport desiredArrivalCity, LocalDateTime desiredDepartureTime,
			LocalDateTime desiredArrivalTime, short numberPassengers, SeatType desiredSeatType, boolean directFlightsOnly, boolean priorityTimeArrival) {
		
		this.desiredDepartureCity = desiredDepartureCity;
		this.desiredArrivalCity = desiredArrivalCity;
		this.desiredDepartureTime = desiredDepartureTime;
		this.desiredArrivalTime = desiredArrivalTime;
		this.numberPassengers = numberPassengers;
		this.desiredSeatType = desiredSeatType;
		this.directFlightsOnly = directFlightsOnly;
		this.priorityTimeArrival = priorityTimeArrival;
	}



	
}


