package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	UserCredentials proposedUser = new UserCredentials("FrogBomb", "cro@k!");
	UserCredentials proposedUser2 = new UserCredentials("ForgBomb2", "ribb3t!");
	UserCredentials returningUser = new UserCredentials("FrogBomb", "cro@k!");


	@Test(expected = AssertionError.class)
	public void testEmpties() {
		
		@SuppressWarnings("unused")
		UserCredentials proposedUser3 = new UserCredentials("", "password");

		
	}
	@Test
	public void testEquals() {
		assertFalse( "not authorized", proposedUser.equals(proposedUser2));
		assertTrue("authorized", proposedUser.equals(returningUser) );
	}

}
