# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 4 Feedback

Met week 4 requirements met
Add more comments to code
   -Added additional comments 
        
# Changes in Week4 
## Domain Layer
1. I changed the User class to be more descriptive to what is intended UserCredenitals
2. I similarly changed the Customer class to have a filed for customerCredentials which is of the type UserCredentials (This seems better than extending the user class)
3. I added a class for FlightSearchCriteria in order to be able to store flight searches (I though I might need this in the future to add additional use cases or additional priorities for filtering flights based on  customer selected options such as only show direct flights or only show flights during this time frame)
4. I added an equals method to the address and customer classes so that I can use the equals methods in my tests 

## Service Layer
1. I did some refactoring in the ServiceFactory

## Other Changes
I renamed some of my classes and the .txt to .properties 

# Week 4 Assignment
##Create a business layer manager that provides the logic for executing your highest priority use cases that makes use of the service layer factory and services, and makes use of domain objects.

Use CAse 001, 002 and 003 implemented

1. I added several business logic items to the FlightManager to control different types of searches
2. I added several  business logic to the UserManager which controls customers 

##Implement a unit test that tests the functionality of the business layer façade.
1. Tests added for UserManager 
2. Tests added for FlightManager

##Implement a test suite for aggregating the business layer tests.
1. See AllBusinessTests

##Create a manager supertype that provides the behavior for getting services.
See ManagerSuperType.java
##Refactor your manager facades to extend the manager supertype and use the getting services method.
See FlightManager
See UserManager
##Implement a test suite that aggregates the entire application.
1. See ApplicationTestSuite

# TODO
1. I'd like to have the system generate the Ids (I have used the database to do this in the past)
2. I need to think about whether I need the isUnique on the user class
3. I need to add logic to Flight Manager to filter the flights further for available seats...may need additional methods or refactoring of availableSeats method to accommodate more than just one available. 
4. I need to add the logic for the itineraries

# Thoughts
Should I add a new domain class to store criteria? 
What controls do I need?
   unique userNames
   get flights based on criteria within range of criteria
   aggregate itineraries for a customer
   


