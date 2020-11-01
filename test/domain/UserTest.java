package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class UserTest {

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

		User proposedUser = new User("FrogBomb", "cro@k!");
		User proposedUser2 = new User("ForgBomb2", "ribb3t!");

		assertFalse(proposedUser.isUniqueUser(userArr), "Already existing user not found!");
		assertTrue(proposedUser2.isUniqueUser(userArr), "Already an exisitng user");

	}
	@Test
	public void testEmpties() {
		
		assertThrows(AssertionError.class, new Executable() {
			
			public void execute() throws Throwable {
				User proposedUser = new User("", "password");
			}
		});
		
	}

}
