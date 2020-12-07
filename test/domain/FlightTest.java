package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;
import domain.flights.Seat;
import domain.flights.SeatType;

public class FlightTest {
	
	Flight flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
	Flight flight2 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);
    Flight flight3 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-24T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-24T18:38:00"), 79.00, 53.00);


	@Test
	public void testSameFlight() {
		
	    assertFalse(flight1.equals(flight3));
	    assertTrue(flight1.equals(flight2));
		
	}
	
	@Test
	public void testFlightAvailability() {
				
		ArrayList<Seat> seats2 = new ArrayList<Seat> (); 
		seats2.add(new Seat("1A", SeatType.BUSINESS, true));
		seats2.add(new Seat("1B", SeatType.BUSINESS, true));
		seats2.add(new Seat("1C", SeatType.BUSINESS, true));
		seats2.add(new Seat("1D", SeatType.BUSINESS, true));
		seats2.add(new Seat("2A", SeatType.BUSINESS, true));
		seats2.add(new Seat("2B", SeatType.BUSINESS, true));
		seats2.add(new Seat("2C", SeatType.BUSINESS, true));
		seats2.add(new Seat("2D", SeatType.BUSINESS, true));
		seats2.add(new Seat("3A", SeatType.BUSINESS, true));
		seats2.add(new Seat("3B", SeatType.BUSINESS, true));
		seats2.add(new Seat("4A", SeatType.ECONOMY, true));
		seats2.add(new Seat("4B", SeatType.ECONOMY, true));
		seats2.add(new Seat("4C", SeatType.ECONOMY, true));
		seats2.add(new Seat("4D", SeatType.ECONOMY, true));
		seats2.add(new Seat("4E", SeatType.ECONOMY, true));
		seats2.add(new Seat("4F", SeatType.ECONOMY, true));
		seats2.add(new Seat("5A", SeatType.ECONOMY, true));
		seats2.add(new Seat("5B", SeatType.ECONOMY, true));
		seats2.add(new Seat("5C", SeatType.ECONOMY, true));
		seats2.add(new Seat("5D", SeatType.ECONOMY, true));
		seats2.add(new Seat("5E", SeatType.ECONOMY, true));
		seats2.add(new Seat("5F", SeatType.ECONOMY, true));
		seats2.add(new Seat("6A", SeatType.ECONOMY, true));
		seats2.add(new Seat("6B", SeatType.ECONOMY, true));
		seats2.add(new Seat("6C", SeatType.ECONOMY, true));
		seats2.add(new Seat("6D", SeatType.ECONOMY, true));
		seats2.add(new Seat("6E", SeatType.ECONOMY, true));
		seats2.add(new Seat("6F", SeatType.ECONOMY, true));
		seats2.add(new Seat("7A", SeatType.ECONOMY, true));
		seats2.add(new Seat("7B", SeatType.ECONOMY, true));
		seats2.add(new Seat("7C", SeatType.ECONOMY, true));
		seats2.add(new Seat("7D", SeatType.ECONOMY, true));
		seats2.add(new Seat("7E", SeatType.ECONOMY, true));
		seats2.add(new Seat("7F", SeatType.ECONOMY, true));
		seats2.add(new Seat("8A", SeatType.ECONOMY, true));
		seats2.add(new Seat("8B", SeatType.ECONOMY, true));
		seats2.add(new Seat("8C", SeatType.ECONOMY, true));
		seats2.add(new Seat("8D", SeatType.ECONOMY, true));
		seats2.add(new Seat("8E", SeatType.ECONOMY, true));
		seats2.add(new Seat("8F", SeatType.ECONOMY, false));
		
		flight2.setSeats(seats2);
		
		assertFalse(flight2.availability((short) 2));
		assertTrue(flight1.availability((short) 2));
	}
	
	@Test
	public void testAllAvailableSeats() {
		
		ArrayList<Seat> seats2 = new ArrayList<Seat> (); 
		seats2.add(new Seat("1A", SeatType.BUSINESS, true));
		seats2.add(new Seat("1B", SeatType.BUSINESS, true));
		seats2.add(new Seat("1C", SeatType.BUSINESS, true));
		seats2.add(new Seat("1D", SeatType.BUSINESS, true));
		seats2.add(new Seat("2A", SeatType.BUSINESS, true));
		seats2.add(new Seat("2B", SeatType.BUSINESS, true));
		seats2.add(new Seat("2C", SeatType.BUSINESS, true));
		seats2.add(new Seat("2D", SeatType.BUSINESS, true));
		seats2.add(new Seat("3A", SeatType.BUSINESS, true));
		seats2.add(new Seat("3B", SeatType.BUSINESS, true));
		seats2.add(new Seat("4A", SeatType.ECONOMY, true));
		seats2.add(new Seat("4B", SeatType.ECONOMY, true));
		seats2.add(new Seat("4C", SeatType.ECONOMY, true));
		seats2.add(new Seat("4D", SeatType.ECONOMY, true));
		seats2.add(new Seat("4E", SeatType.ECONOMY, true));
		seats2.add(new Seat("4F", SeatType.ECONOMY, true));
		seats2.add(new Seat("5A", SeatType.ECONOMY, true));
		seats2.add(new Seat("5B", SeatType.ECONOMY, true));
		seats2.add(new Seat("5C", SeatType.ECONOMY, true));
		seats2.add(new Seat("5D", SeatType.ECONOMY, true));
		seats2.add(new Seat("5E", SeatType.ECONOMY, true));
		seats2.add(new Seat("5F", SeatType.ECONOMY, true));
		seats2.add(new Seat("6A", SeatType.ECONOMY, true));
		seats2.add(new Seat("6B", SeatType.ECONOMY, true));
		seats2.add(new Seat("6C", SeatType.ECONOMY, true));
		seats2.add(new Seat("6D", SeatType.ECONOMY, true));
		seats2.add(new Seat("6E", SeatType.ECONOMY, true));
		seats2.add(new Seat("6F", SeatType.ECONOMY, true));
		seats2.add(new Seat("7A", SeatType.ECONOMY, true));
		seats2.add(new Seat("7B", SeatType.ECONOMY, true));
		seats2.add(new Seat("7C", SeatType.ECONOMY, true));
		seats2.add(new Seat("7D", SeatType.ECONOMY, true));
		seats2.add(new Seat("7E", SeatType.ECONOMY, true));
		seats2.add(new Seat("7F", SeatType.ECONOMY, true));
		seats2.add(new Seat("8A", SeatType.ECONOMY, true));
		seats2.add(new Seat("8B", SeatType.ECONOMY, true));
		seats2.add(new Seat("8C", SeatType.ECONOMY, true));
		seats2.add(new Seat("8D", SeatType.ECONOMY, true));
		seats2.add(new Seat("8E", SeatType.ECONOMY, true));
		seats2.add(new Seat("8F", SeatType.ECONOMY, false));
		
		flight2.setSeats(seats2);
		
		assertTrue(flight2.allAvailableSeats().size()==1);
	}
	
	@Test
	public void testGetAirlineCode() {
		
		assertFalse(flight1.getAirline().getAirlineCode() == "FL");
		assertTrue(flight1.getAirline().getAirlineCode() == "CO");
		
	}
	
	@Test
	public void testAirportCode() {
		assertFalse(flight1.getArrivalCity().getAirportCode() == "BMS");
		assertTrue(flight1.getArrivalCity().getAirportCode() == "BOS");
	}


}
