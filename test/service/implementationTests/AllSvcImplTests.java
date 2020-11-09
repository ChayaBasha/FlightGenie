package service.implementationTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerSvcImplTest.class, FlightSvcImplTest.class, ItinerarySvcImplTest.class, UserSvcImplTest.class })
public class AllSvcImplTests {

}
