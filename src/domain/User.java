package domain;

/**
 * * This super class represents the various users for the flight reservation
 * systen.
 * 
 * @author johannablumenthal
 * @version 0.1
 */
public class User {

	/**
	 * the key field that will identify the user information. Given the nature of
	 * the application. This will ideally be generated by the database that will
	 * store the date.
	 */
	protected String userId;
	/**
	 * Holds the unique userName for the user
	 */
	protected String userName;
	/**
	 * Holds the password for the userName
	 */
	protected String password;

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (userName != null) {
			this.userName = userName;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null) {
			this.password = password;
		}
	}

	public User(String userName, String password) {
//		 this.userId = userId;
		assert (userName != null && userName != "" && password != null && password != "");
		this.userName = userName;
		this.password = password;
	}

	/**
	 * compares the new user to existing users to make sure each user has a unique
	 * user name. Will be used during registering new user.
	 * 
	 * @param users
	 * @return whether unique or not
	 */
	public boolean isUniqueUser(User[] users) {
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			if (user.getUserName() == this.getUserName()) {
				return false;
			}
		}
		return true;
	};

}
