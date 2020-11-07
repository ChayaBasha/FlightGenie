package service;

import domain.User;
/**
 * User services implemented 
 * 
 * @author johannablumenthal
 *
 */

public class UserSvcImpl implements IUserSvc{

	@Override
	/**
	 * Compares username against existing usernames
	 */
	public boolean checkUserNameAvailable(String userName) {
		System.out.println("Check UserName Availability Method was called");
		return false;
	}

	@Override
	/**
	 * will compare username and password for login
	 */
	public boolean autehnticateUser(User user) {
		System.out.println("Authenticate Method was called");
		return false;
	}

}
