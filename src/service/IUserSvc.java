package service;

import domain.User;
import service.exception.UserException;
/**
 * interface for the user services 
 * @author johannablumenthal
 *
 */

public interface IUserSvc extends IService {
	
	public final String NAME = "IUserSvc";
	
	/**
	 * methods needed for register and login functionality
	 * @param userName
	 * @return
	 */
	
	public boolean checkUserNameAvailable(String userName) throws UserException;
	public boolean authenticateUser(User user) throws UserException;

}
