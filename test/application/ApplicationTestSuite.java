package application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import business.AllBusinessTests;
import domain.AllDomainTests;
import service.AllServiceTests;



@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllServiceTests.class, AllDomainTests.class})

public class ApplicationTestSuite {

}