package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.flights.Airport;
import domain.flights.Flight;
import service.exception.FlightException;

/**
 * Implementation of the Flight Services interface
 * 
 * @author johannablumenthal
 *
 */

public class FlightSvcImpl implements IFlightSvc {

	private File flightFolder = new File("flights");

	/**
	 * For flights we need to be able to search all the flights and find the ones we
	 * need Each flight will be created in its own file with a unique path that is
	 * different only by the end which is the file name, assigned to be the
	 * createFlightId, which I hope was created to be unique for each flight
	 */

	public void addFlight(Flight flight) throws FlightException {

		if (flight != null) {
			try {
				flightFolder.mkdirs();
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(
						flightFolder.toPath().resolve((flight.createFlightId() + ".flight.out")).toFile()));

				output.writeObject(flight);
				output.flush();
				output.close();
			} catch (IOException e) {
				throw new FlightException("Cannot save flight");

			}
		} else
			throw new FlightException("Cannot save flight that is null");
	}

	@Override
	/**
	 * Should be able to read each file that represents a flight by reading the
	 * files in the folder/directory specified (which is flightFolder)
	 */
	public List<Flight> getAllFlights() throws FlightException {

		if (this.flightFolder.isDirectory()) {
			ArrayList<Flight> flights = new ArrayList<Flight>();
			for (File file : this.flightFolder.listFiles()) {
				if (file.isFile()) {
					try {
						ObjectInputStream readFlights = new ObjectInputStream(new FileInputStream(file));
						Object fileContents = readFlights.readObject();
						readFlights.close();
						if (fileContents instanceof Flight) {
							flights.add((Flight) fileContents);
						} else
							throw new FlightException("file contents are not a flight " + file.getAbsolutePath());
					} catch (IOException e) {
						throw new FlightException("IO problems " + file.getAbsolutePath());
					} catch (ClassNotFoundException e) {
						throw new FlightException("class not found");
					}
				} else
					throw new FlightException("not a file :-( " + file.getAbsolutePath());
			}
		} else
			throw new FlightException("can't find directory flightFolder " + this.flightFolder.getAbsolutePath());
		return null;
	}

	@Override
	/**
	 * This service returns all the Flights that match the route as defined by the
	 * departure and arrival locations
	 */
	public List<Flight> getFlightsByRoute(Airport departureCity, Airport arrivalCity) throws FlightException {
		ArrayList<Flight> matchingRoutes = new ArrayList<Flight>();
		List<Flight> flights = getAllFlights();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getDepartureCity() == departureCity && flights.get(i).getArrivalCity() == arrivalCity) {
				matchingRoutes.add(flights.get(i));
			}
		}
		
		return matchingRoutes;

	}

	@Override
	/**
	 * This service returns all the flights within a certain time frame that will be
	 * defined by the business logic
	 */
	public List<Flight> getFlightByTimeFrame(LocalDateTime startDepartureTimeRange,
			LocalDateTime endDepartureTimeRange) throws FlightException {
		ArrayList<Flight> matchingRoutes = new ArrayList<Flight>();
		List<Flight> flights = getAllFlights();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getDepartureTime().isAfter(startDepartureTimeRange) && flights.get(i).getDepartureTime().isBefore(endDepartureTimeRange)) {
				matchingRoutes.add(flights.get(i));
			}
		}
		
		return matchingRoutes;

	}
}
