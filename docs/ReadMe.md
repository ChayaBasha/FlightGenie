# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 5Feedback

Satisfied Requirements 
        
# Changes in Week5 


# Week 6 Assignment
## Visually draw out the user interface (UI) for your application.
1. See Word document with screen views made with Justinmind labeled ScreenViews in the doc file. 

## Determine what UI widgets you will need.

1. Welcome Screen
    -Jpanel for the banners 
    -JPanel for the oval in the middle (Some research suggests this will be a bit tricky, but doable)
    -JLabel for the static text
    -JRadioButton for the Leave By/ Arrive By
    -JList or JMenu for the arrival and departure cities 
    -JTextFields
    -JButton

## Create the UI class, add a data member for each widget, and create a skeleton constructor.

## Update the UI constructor to layout the widgets.

## Add the needed widgets and containers.

## Update your UI to have an anonymous inner class ActionListener that is registered with a button.

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
   


