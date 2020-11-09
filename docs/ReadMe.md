# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 2 Feedback

1. Validate and Equals MEethod --Missing from most domain classes, see slide 70 for details
2.HWExecution File under Doc folder – Missing
3. HWUnitTestExecution file under Doc folder – please use the naming convention: HWUnitTestExecution.doc
        
# Changes in Week3 
1. Added an equals method to the User class
2. Added a test for the new method
3. Added an equals method to the Itinerary Class
4. Tested the new added equals method
5. I also changed the seat in the itinerary to just be the seatNumber


# Week 3 Assignment
1. Create an interface for the Service(s) needed by your course project(separated interface design pattern)
    - ICustomerSvc
    -IUserSvc
    -IFlightScv
    -IItinerarySvc
2. create in implementation of the interface( a plugin design pattern) with just stub  
    -CustomerSvcImpl
    -UserSvcImpl
    -FlightSvcImpl
    -ItinerarySvcImpl    
3. Create a Service Factory that returns the interface; instantiates and returns the corresponding implementation
    - ServiceFactory
    -Creates New UserSvcImpl, new CustoerSvcImpl, new FlightSvcImpl, new ItinerarySvcImpl
    
4. Create a JUnit test suite that should test:
Factory to get service  -instantiated in the setup method
    - ServiceFactoryTest in test.service
Test methods for each service  
    -CustomerSvcImpTest
    - FlightSvcImplTest
    - UserSvcImplTest
    - ItineraryScvImplTest
5. Create Test Suite
    -I couldn't get this working in Junit 5 so I reverted back to Junit 4 and changed all of my tests...even then I was having an error that eventually was resolved by exporting the test packages into the module-info.java file

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. I need to think about whether I need the isUnique on the user class


