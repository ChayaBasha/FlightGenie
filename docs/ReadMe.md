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
    - Customer
        - confirm extending User fields too
    - Flight Method
        - equal based upon the same route/time/airline and flight number
        - availableSeats based upon whether any seats are not booked
        - airport code
        - airline code 
        
        

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. May need to change some things about the itineraries to make it possible to have more than one passenger (need to think what makes more sense)


