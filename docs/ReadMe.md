# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 5Feedback

Satisfied Requirements 
        
# Changes from Week 6 

## For UC Search Flights

### Domain Layer
1. I changed the Flight class availability method to search for the availability based on number of passengers requested (changed corresponding test as well)

### Business Layer
1. I added the available flights loop in the FlightManager method for searchAvailableFlights
2. I added in the non-direct flights logic as well (Shows a lay over) Tested as well 


# Week 6 Assignment
## UC Priority 1: Search Flights
Status: 

## UC Priority 2: Manage itinerary
Status;

## UC Priority 3: Register Customer
Status:

## UC Priority 4: Login
Status

# TODO
 - I'd like to have the system generate the Ids (I have used the database to do this in the past)
- I need to add logic to Flight Manager to filter the flights further for available seats...may need additional methods or refactoring of availableSeats method to accommodate more than just one available. 
- I need to add the logic for the itineraries
-I need to add the number of passengers
- Add input validation to form

# Thoughts
Should I have the other views pop up in a new window or create a method on the main frame to hide and show certain elements
   


