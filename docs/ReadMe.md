# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 2 Feedback

1. Validate and Equals MEethod --Missing from most domain classes, see slide 70 for details
2.HWExecution File under Doc folder – Missing
3. HWUnitTestExecution file under Doc folder – please use the naming convention: HWUnitTestExecution.doc
        
# Changes in Week3 
1. Added an equals method to the User class
2. Added a test for the new method


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
Factory to get service  -instanitated in the setup method
Test method sfor each service  

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. May need to change some things about the itineraries to make it possible to have more than one passenger (need to think what makes more sense)
3. I need to fix the test for User...maybe start over. 
4. I need to think about whether I need the isUnique on the user class


