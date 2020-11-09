package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class UserTest {
	
	User proposedUser = new User("FrogBomb", "cro@k!");
	User proposedUser2 = new User("ForgBomb2", "ribb3t!");
	User returningUser = new User("FrogBomb", "cro@k!");

	ArrayList<User> users = new ArrayList<User>();

	public void createUsers() {
		users.add(new User("FrogBomb", "ribb3t!"));
		users.add(new User("Penny", "w00f!"));
		users.add(new User("JMonkey", "ooh@hh"));
		users.add(new User("Giraffe", "mmmhumm"));
	};

	@Test
	public void testIsUnique() {

		this.createUsers();
		User[] userArr = new User[this.users.size()];
		users.toArray(userArr);

		assertFalse("Already existing user not found!", proposedUser.isUniqueUser(userArr));
		assertTrue("Already an exisitng user", proposedUser2.isUniqueUser(userArr));

	}
	@Test(expected = AssertionError.class)
	public void testEmpties() {
		
		@SuppressWarnings("unused")
		User proposedUser3 = new User("", "password");

		
	}
	@Test
	public void testEquals() {
		assertFalse( "not authorized", proposedUser.equals(proposedUser2));
		assertTrue("authorized", proposedUser.equals(returningUser) );
	}

}
