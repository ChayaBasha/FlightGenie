# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 6 Feedback

Satisfied Requirements 
        
# Changes from Week 6 

## For UC Search Flights

### Domain Layer
1. I changed the Flight class availability method to search for the availability based on number of passengers requested (changed corresponding test as well)

### Business Layer
1. I added the available flights loop in the FlightManager method for searchAvailableFlights
2. I added in the non-direct flights logic as well (Shows a lay over) Tested as well 

### Presentation Layer
1. Refactored the MainJFrame/Welcome Screen to pull out the FlightSearchForm and its oval 
2. added field for mainContnet so that this can be reset for the different screens 

## For UC Manage itineraries

### Domain Layer
1. I changed the logic of the ItineraryIDs to generate them with the intinerary information
2. I added a new method to the flight class called allAailableSeats in order to get the seats that are free (this is needed to allow for booking) and tested

### Service Layer
1. I updated the service layer to get the correct Itineraries by reading the creatId files to get the right one and updated tests

### Business Layer
1. I added a getAvailableSeats Method in the ItineraryManager class to get all available seats on a flight of the user selected type of seat (and tested it)
2. I added a reserveFlight method in the ItineraryManager class to set the seat to booked and to create the itinerary in one step (and tested)
3. I added a view itineraries that gets upcoming itineraries 


# Week 6 Assignment
## UC Priority 1: Search Flights
Status: Working start to finish to get flights 
Missing: number of passengers inPut box on UI; need to fix the availability of flights UI in table 

## UC Priority 2: Manage itinerary
Status:

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
   


