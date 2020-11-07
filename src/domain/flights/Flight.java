package domain.flights;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * this class will create flight instances for each new flight that the user can
 * search for
 * 
 * @author johannablumenthal
 * @version 0.1
 *
 */

public class Flight {
	/**
	 * Holds the airline from the enumerated list of airlines/codes for the flight
	 */
	private Airline airline;

	/**
	 * holds the three digit flight number
	 */
	private short flightNumber;

	/**
	 * Holds the airport from the enumerated list and ariport/codes for departure
	 */
	private Airport departureCity;
	/**
	 * Holds the year/month/day/time of departure
	 */
	private LocalDateTime departureTime;
	/**
	 * Holds the airport from the enumerated list and ariport/codes for arrival
	 */
	private Airport arrivalCity;
	/**
	 * Holds the year/month/day/time of departure
	 */
	private LocalDateTime arrivalTime;
	/**
	 * Holds the price per ticket for business class
	 */
	private double businessPrice;
	/**
	 * Holds the price per ticker for economy class
	 */
	private double economyPrice;
	/**
	 * Holds the seats for each flight to track bookings...right now all flights
	 * have same model for seats, but this could be changed in the future
	 */
	private ArrayList<Seat> seats = new ArrayList<Seat>();

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		if (airline != null) {
			this.airline = airline;
		}
	}

	public short getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(short flightNumber) {
		if (flightNumber != 0) {
			this.flightNumber = flightNumber;
		}
	}

	public Airport getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(Airport departureCity) {
		if (departureCity != null) {
			this.departureCity = departureCity;
		}
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		if (departureTime != null) {
			this.departureTime = departureTime;
		}
	}

	public Airport getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(Airport arrivalCity) {
		if (arrivalCity != null) {
			this.arrivalCity = arrivalCity;
		}
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		if (arrivalTime != null) {
			this.arrivalTime = arrivalTime;
		}
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		if (businessPrice != 0) {
			this.businessPrice = businessPrice;
		}
	}

	public double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(double economyPrice) {
		if (economyPrice != 0) {
			this.economyPrice = economyPrice;
		}
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {

		this.seats = seats;
	}

	public Flight(Airline airline, short flightNumber, Airport departureCity, LocalDateTime departureTime,
			Airport arrivalCity, LocalDateTime arrivalTime, double businessPice, double economyPrice) {
		assert (airline != null && flightNumber != 0 && departureCity != null && departureTime != null
				&& arrivalCity != null && arrivalTime != null && businessPice != 0 && economyPrice != 0);
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.departureTime = departureTime;
		this.arrivalCity = arrivalCity;
		this.arrivalTime = arrivalTime;
		this.businessPrice = businessPice;
		this.economyPrice = economyPrice;
		/**
		 * The constructor is set to initiate the seats with the 10 Business class and
		 * 30 Economy class seats specified in the project specification
		 */
		this.seats.add(new Seat("1A", SeatType.BUSINESS, false));
		this.seats.add(new Seat("1B", SeatType.BUSINESS, false));
		this.seats.add(new Seat("1C", SeatType.BUSINESS, false));
		this.seats.add(new Seat("1D", SeatType.BUSINESS, false));
		this.seats.add(new Seat("2A", SeatType.BUSINESS, false));
		this.seats.add(new Seat("2B", SeatType.BUSINESS, false));
		this.seats.add(new Seat("2C", SeatType.BUSINESS, false));
		this.seats.add(new Seat("2D", SeatType.BUSINESS, false));
		this.seats.add(new Seat("3A", SeatType.BUSINESS, false));
		this.seats.add(new Seat("3B", SeatType.BUSINESS, false));
		this.seats.add(new Seat("4A", SeatType.ECONOMY, false));
		this.seats.add(new Seat("4B", SeatType.ECONOMY, false));
		this.seats.add(new Seat("4C", SeatType.ECONOMY, false));
		this.seats.add(new Seat("4D", SeatType.ECONOMY, false));
		this.seats.add(new Seat("4E", SeatType.ECONOMY, false));
		this.seats.add(new Seat("4F", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5A", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5B", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5C", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5D", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5E", SeatType.ECONOMY, false));
		this.seats.add(new Seat("5F", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6A", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6B", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6C", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6D", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6E", SeatType.ECONOMY, false));
		this.seats.add(new Seat("6F", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7A", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7B", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7C", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7D", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7E", SeatType.ECONOMY, false));
		this.seats.add(new Seat("7F", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8A", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8B", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8C", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8D", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8E", SeatType.ECONOMY, false));
		this.seats.add(new Seat("8F", SeatType.ECONOMY, false));

	}

	/**
	 * compares two flights based upon the fields we consider to be a different
	 * flight. For example, many routes run multiple times per day. The same route,
	 * same airline would distinguish the flights by the times.
	 * 
	 * @param flight to compare with the newly created flight
	 * @return whether the same flight on the important parameters
	 */

	public boolean equals(Flight flight) {
		if (flight.getAirline() == this.getAirline() && flight.getFlightNumber() == this.getFlightNumber()
				&& flight.getDepartureCity() == this.getDepartureCity()
				&& flight.getDepartureTime().isEqual(this.getDepartureTime())
				&& flight.getArrivalCity() == this.getArrivalCity()
				&& flight.getArrivalTime().isEqual(this.getArrivalTime())) {
			return true;
		} else
			return false;
	};

	/**
	 * checks whether there are any seats available on a particular flight. This
	 * could be extended to show how many seats, etc.
	 * 
	 * @return whether seats are available
	 */
	public boolean availability() {
		for (int i = 0; i < this.seats.size(); i++) {
			if (this.seats.get(i).isBooked() == false) {
				return true;
			}
		}
		return false;
	}
};
