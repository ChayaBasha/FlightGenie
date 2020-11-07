package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CustomerTest.class, FlightTest.class, UserTest.class})
public class AllDomainTests {


}
