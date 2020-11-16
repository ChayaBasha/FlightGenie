package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import domain.User;
import service.exception.UserException;
/**
 * User services implemented 
 * 
 * @author johannablumenthal
 *
 */

public class UserSvcImpl implements IUserSvc{
	
	private File customerFolder = new File("customers");
	
	/**
	 * TODO would need to add Reservation Manager too
	 * @throws UserException 
	 */

	@Override
	/**
	 * Compares username against existing usernames
	 */
	public boolean checkUserNameAvailable(String userName) throws UserException {
		if (userName != null) {
			File existingUser = customerFolder.toPath().resolve(userName + ".customer.out").toFile();
				if(existingUser.exists()) {
			    	return false;
			    } else {
			    	return true;
			    }
			}
		throw new UserException("userName cannot be null");
	}
	

	@Override
	/**
	 * will compare username and password for login
	 */
	public boolean authenticateUser(User user) throws UserException {
		if (user != null) {
			String userName = user.getUserName();
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(
						customerFolder.toPath().resolve(userName + ".customer.out").toFile()));
				Object fileObject = input.readObject();
				input.close();
				if (fileObject instanceof User) {
					return ((User) fileObject).getPassword().equals(user.getPassword());
				} else
					throw new UserException(userName + " not associated with a  User");

			} catch (FileNotFoundException e) {
				throw new UserException("could not find User " + userName);
			} catch (IOException e) {
				throw new UserException("There was an I/O problem");
			} catch (ClassNotFoundException e) {
				throw new UserException("unkown object");
			}
		} else
			throw new UserException("null input");

	}

}
