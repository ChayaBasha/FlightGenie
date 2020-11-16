# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 3 Feedback

Met week 3 requirements
        
# Changes in Week3 
1.Mostly below with homework related 


# Week 4 Assignment
## Implement exceptions for all services in your application.
 - Customer (CRUD Functions all working)
 - Flights (Flight add and read methods working)
 - User (authenticate and unique ueser working)
 - Itinerary (CRUD functions working) 
        
## Modify your service layer unit tests to catch exceptions.
- All Test Running

## Update your domain objects so that they can be serialized and deserialized.
       - Added implements serializable and serialVersionUID = 1L to (User, Customer, Flight, Itinerary, Seat)...I read that enums don't need to implement serializable

## Update your service layer interfaces using a Marker Interface design pattern.
    - IService interface added
    - Each interface now implements IService

## Refactor your service factory to decouple interfaces to your services from their implementations.
    - The Factory now has a singular method that can be used to get Each service implementation by looking it up in the serviceName.txt file 

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. I need to think about whether I need the isUnique on the user class


