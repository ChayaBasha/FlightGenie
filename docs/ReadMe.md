# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 2 
1. create domain classes for your most important use cases
    - Created classes for the customer to search for flights and make an itinerary
        - User
        - Customer
            - address
            -creditCard
               creditCardType
        - Itinerary
            - Flight
                Airport
                Airline
                Seats
            - Seat
                - seatType

2. create and implement unit tests that test the interesting behavior of the classes 
    - User Method
        isUnique
            - need to test same userName as existing file
        constructor
            - need to test if it will allow a null or " "
    - 

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)


