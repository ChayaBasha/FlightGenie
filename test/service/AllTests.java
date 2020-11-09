package service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import service.FactoryTest.ServiceFactoryTest;
import service.implementationTests.CustomerSvcImplTest;
import service.implementationTests.FlightSvcImplTest;
import service.implementationTests.ItinerarySvcImplTest;
import service.implementationTests.UserSvcImplTest;

@RunWith(Suite.class)
@SuiteClasses({ServiceFactoryTest.class, CustomerSvcImplTest.class, FlightSvcImplTest.class, ItinerarySvcImplTest.class, UserSvcImplTest.class})

public class AllTests {

}
