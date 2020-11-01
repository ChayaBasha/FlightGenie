package domain;

public class User {

	protected String userId;

	protected String userName;
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
