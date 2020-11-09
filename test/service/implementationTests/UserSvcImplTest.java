package service.implementationTests;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import junit.framework.TestCase;
import service.IUserSvc;
import service.ServiceFactory;
import service.UserSvcImpl;

public class UserSvcImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private User user;

	@Before
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = new ServiceFactory();
		user = new User("FrogBomb", "r1bb3t!");

	}

	@Test
	public void testCheckUserNameAvailable() {

		String userName = user.getUserName();

		IUserSvc userService = serviceFactory.getUserService();
		assertTrue(userService.checkUserNameAvailable(userName));
		System.out.println("testCheckUserName PASSED");

		UserSvcImpl userServiceImpl = (UserSvcImpl) serviceFactory.getUserService();
		assertTrue(userServiceImpl.checkUserNameAvailable(userName));
		System.out.println("testCheckUserName PASSED");

	}

	@Test
	public void testAuthenticateUser() {

		IUserSvc userService = serviceFactory.getUserService();
		assertTrue(userService.autehnticateUser(user));
		System.out.println("testAuthenticateUSer PASSED");

		UserSvcImpl userServiceImpl = (UserSvcImpl) serviceFactory.getUserService();
		assertTrue(userServiceImpl.autehnticateUser(user));
		System.out.println("testAuthenticateUserPASSED");

	}
}
