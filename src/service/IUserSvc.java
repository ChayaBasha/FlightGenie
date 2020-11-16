package service;

import domain.User;
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
	
	public boolean checkUserNameAvailable(String userName);
	public boolean autehnticateUser(User user);

}
