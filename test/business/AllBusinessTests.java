package business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightManagerTest.class, ItineraryManagerTest.class, UserManagerTest.class })
public class AllBusinessTests {

}
