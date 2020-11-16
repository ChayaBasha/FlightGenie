# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 3 Feedback

Met week 3 requirements
        
# Changes in Week3 
1.


# Week 4 Assignment
1. Implement exceptions for all services in your application.
    - Customer 
        - CustomerExceptions in all CRUD functions
    - FLight
        
2. Modify your service layer unit tests to catch exceptions.
3. Update your domain objects so that they can be serialized and deserialized.
        - Added implements serializable and serialVersionUID = 1L to (User, Customer, Flight, Itinerary, Seat)...I read that enums don't need to implement serializable
4. Update your service layer interfaces using a Marker Interface design pattern.
    - IService interface added
    - Each interface now implements IService
5. Refactor your service factory to decouple interfaces to your services from their implementations.
    - The Factory now has a singular method that can be used to get Each service implementation by looking it up in the serviceName.txt file 

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. I need to think about whether I need the isUnique on the user class


