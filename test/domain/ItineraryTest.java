package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;


import domain.customer.itinerary.BookingStatus;
import domain.customer.itinerary.Itinerary;
import domain.flights.Airline;
import domain.flights.Airport;
import domain.flights.Flight;

public class ItineraryTest {
	
	Flight flight1 = new Flight(Airline.CONTINENTAL_AIRLINES, (short) 235, Airport.ASPEN_CO, LocalDateTime.parse("2019-06-23T12:30:00"), Airport.BOSTON_MA, LocalDateTime.parse("2019-06-23T18:38:00"), 79.00, 53.00);

	Itinerary itinerary1 = new Itinerary("123456AFD", "FrogBomb", "Penny Blumenthal", flight1, "1C", BookingStatus.RESERVED);
	Itinerary itinerary2 = new Itinerary("123456FGB", "Penny", "Penny Blumenthal", flight1, "3F", BookingStatus.RESERVED);
	Itinerary itinerary3 = new Itinerary("123432ABC", "Penny", "John Doe", flight1, "3F", BookingStatus.RESERVED);
	
	@Test
	public void testSameItinerary() {
		assertTrue(itinerary1.equals(itinerary2));
		assertFalse(itinerary2.equals(itinerary3));
	}

}
