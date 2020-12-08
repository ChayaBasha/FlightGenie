package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import domain.customer.itinerary.Itinerary;
import service.exception.ItineraryException;

/**
 * Implements the Itinerary Services
 * 
 * @author johannablumenthal
 *
 */

public class ItinerarySvcImpl implements IItinerarySvc {

	private File itineraryFolder = new File("itineraries");

	@Override
	/**
	 * allows customer to save a new itinerary to the data store
	 */
	public void createItinerary(Itinerary itinerary) throws ItineraryException {
		if (itinerary != null) {
			try {
				itineraryFolder.mkdirs();
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(
						itineraryFolder.toPath().resolve((itinerary.createItineraryID() + ".itinerary.out")).toFile()));

				output.writeObject(itinerary);
				output.flush();
				output.close();
			} catch (IOException e) {
				throw new ItineraryException("Cannot save itinerary");

			}
		} else
			throw new ItineraryException("Cannot save itinerary that is null");
	}

	public List<Itinerary> getAllItineraries() throws ItineraryException {
		ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
		if (this.itineraryFolder.isDirectory()) {
			for (File file : this.itineraryFolder.listFiles()) {
				if (file.isFile()) {
					try {
						ObjectInputStream readItineraries = new ObjectInputStream(new FileInputStream(file));
						Object fileContents = readItineraries.readObject();
						readItineraries.close();
						if (fileContents instanceof Itinerary) {
							itineraries.add((Itinerary) fileContents);
						} else
							throw new ItineraryException(
									"file contents are not an itinerary " + file.getAbsolutePath());
					} catch (IOException e) {
						throw new ItineraryException("IO problems " + file.getAbsolutePath());
					} catch (ClassNotFoundException e) {
						throw new ItineraryException("class not found");
					}
				} else
					throw new ItineraryException("not a file :-( " + file.getAbsolutePath());
			}
		} else
			throw new ItineraryException(
					"can't find directory itineraryFolder " + this.itineraryFolder.getAbsolutePath());
		return itineraries;
	}

	@Override
	/**
	 * returns all of the customers itineraries
	 */
	public List<Itinerary> getItineraryByCustomer(String userName) throws ItineraryException {
		List<Itinerary> ownerItineraries = new ArrayList<Itinerary>();
		if (this.itineraryFolder.isDirectory()) {
			for (File file : this.itineraryFolder.listFiles()) {
				if (file.isFile()) {
					String[] itineraryFields = file.getName().replace(".itinerary.out", "").split("_");
					if (itineraryFields[2].equals(userName)) {
						try {
							ObjectInputStream readItineraries = new ObjectInputStream(new FileInputStream(file));
							Object fileContents = readItineraries.readObject();
							readItineraries.close();
							if (fileContents instanceof Itinerary) {
								ownerItineraries.add((Itinerary) fileContents);
							} else
								throw new ItineraryException(
										"File contents are not itinerary" + file.getAbsolutePath());
						} catch (IOException e) {
							throw new ItineraryException("IO problems" + file.getAbsolutePath());
						} catch (ClassNotFoundException e) {
							throw new ItineraryException("class not found");
						}
					}
				} else
					throw new ItineraryException("not a file " + file.getAbsolutePath());
			}
		} else
			throw new ItineraryException(
					"can't find directory ItineraryFolder" + this.itineraryFolder.getAbsolutePath());

		return ownerItineraries;

	}

	@Override
	/**
	 * gets a particular itinerary by ID...since behavior not implemented with data,
	 * I am using the concrete data for testing...will serve up data later
	 */
	public Itinerary getItineraryById(String userName, String itineraryId) throws ItineraryException {
		Itinerary itinerary = null;
		List<Itinerary> ownerItineraries = getItineraryByCustomer(userName);
		
		for (int i = 0; i < ownerItineraries.size(); i++) {
			
			if (ownerItineraries.get(i).createItineraryID().equals(itineraryId)) {
				itinerary = ownerItineraries.get(i);
			}

		}

		if (itinerary == null) {
			throw new ItineraryException("no itinerary for user " + userName + " with Id " + itineraryId);
		} else
			return itinerary;
	}

	@Override
	/**
	 * Allows the customer to change the itinerary
	 */
	public void updateItinerary(Itinerary itinerary) throws ItineraryException {
		Itinerary existingItinerary = this.getItineraryById(itinerary.getOwner(), itinerary.createItineraryID());
		if (existingItinerary != null) {

			existingItinerary.setBookingStatus(itinerary.getBookingStatus());
			existingItinerary.setPassengerName(itinerary.getPassengerName());
			existingItinerary.setSeat(itinerary.getSeatNumber());

			this.createItinerary(existingItinerary);
		}
	}

	@Override
	/**
	 * allows the customer to delete the itinerary from the data store
	 */
	public void deleteItinerary(Itinerary itinerary) throws ItineraryException {
		if (itinerary != null) {

			File existingItinerary = itineraryFolder.toPath().resolve(itinerary.createItineraryID() + ".itinerary.out")
					.toFile();
			if (existingItinerary.exists()) {
				existingItinerary.delete();
			} else
				throw new ItineraryException(
						"could not delete " + itinerary.createItineraryID() + " for user " + itinerary.getOwner());

		} else
			throw new ItineraryException(" null input");

	}

}
