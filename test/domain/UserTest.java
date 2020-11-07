package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class UserTest {
	
	User proposedUser = new User("FrogBomb", "cro@k!");
	User proposedUser2 = new User("ForgBomb2", "ribb3t!");
	User returningUser = new User("FrogBomb", "cro@k!");

	ArrayList<User> users = new ArrayList<User>();

	void createUsers() {
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

		assertFalse(proposedUser.isUniqueUser(userArr), "Already existing user not found!");
		assertTrue(proposedUser2.isUniqueUser(userArr), "Already an exisitng user");

	}
	@Test
	public void testEmpties() {
		
		assertThrows(AssertionError.class, new Executable() {
			
			public void execute() throws Throwable {
				@SuppressWarnings("unused")
				User proposedUser3 = new User("", "password");
			}
		});
		
	}
	@Test
	public void testEquals() {
		assertFalse(proposedUser.equals(proposedUser2), "not authorized");
		assertTrue(proposedUser.equals(returningUser), "authorized");
	}

}
