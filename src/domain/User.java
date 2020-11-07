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
	 * Holds the unique userName for the user, This field will be used as the
	 * identifier in the DataStore
	 */
	protected String userName;
	/**
	 * Holds the password for the userName
	 */
	protected String password;

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
	/**
	 * compares whether two users are the same in order to be used in authentication
	 * @param user
	 * @return
	 */

	public boolean equals(User user) {
		if (user.getUserName() == this.getUserName() && user.getPassword() == this.getPassword()) {
			return true;
		} else
			return false;
	};
};
