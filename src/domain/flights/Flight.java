package domain.flights;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {

	private Airline airline;
	private short flightNumber;
	private Airport departureCity;
	private Date departureTime;
	private Airport arrivalCity;
	private Date arrivalTime;
	private float businessPrice;
	private float economyPrice;
	private List<Seat> seats = new ArrayList<Seat>();

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

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		if (departureTime != null) {
			this.departureTime = departureTime;
		}
	}

	public Airport getArrivalCiry() {
		return arrivalCity;
	}

	public void setArrivalCiry(Airport arrivalCity) {
		if (arrivalCity != null) {
			this.arrivalCity = arrivalCity;
		}
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		if (arrivalTime != null) {
			this.arrivalTime = arrivalTime;
		}
	}

	public float getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(float businessPrice) {
		if (businessPrice != 0) {
			this.businessPrice = businessPrice;
		}
	}

	public float getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(float economyPrice) {
		if (economyPrice != 0) {
			this.economyPrice = economyPrice;
		}
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {

		this.seats = seats;
	}

	public Flight(Airline airline, short flightNumber, Airport departureCity, Date departureTime, Airport arrivalCity,
			Date arrivalTime, float businessPrice, float economyPrice) {
		assert (airline != null && flightNumber != 0 && departureCity != null && departureTime != null
				&& arrivalCity != null && arrivalTime != null && businessPrice != 0 && economyPrice != 0);
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.departureTime = departureTime;
		this.arrivalCity = arrivalCity;
		this.arrivalTime = arrivalTime;
		this.businessPrice = businessPrice;
		this.economyPrice = economyPrice;
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
};
