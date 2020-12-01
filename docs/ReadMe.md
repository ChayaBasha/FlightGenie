# Flight Reservation System
The FLight Reservation System is an application that allows customers to book airline flights.

# Week 5Feedback

Satisfied Requirements 
        
# Changes in Week5 
-Added the View layer
    - OvalPane
    -ViewDriver
    

# Week 6 Assignment
## Visually draw out the user interface (UI) for your application.
1. See Word document with screen views made with Justinmind labeled ScreenViews in the doc file. 

## Determine what UI widgets you will need.

    -Jpanel for the banners 
    -JPanel for the oval in the middle (Some research suggests this will be a bit tricky, but doable)
    -JLabel for the static text
    -JCheckBox for the Leave By/ Arrive By 
    -JTextFields
    -JButton
    -JTable for the flights

## Create the UI class, add a data member for each widget, and create a skeleton constructor.
 1. Added MainJFrame
     - added all of the widgets that are named above
     -added a few items I didn't include in the original welcome screen 

## Update the UI constructor to layout the widgets.
1. Widgets are laid out for the welcome screen using GridBagLayout (some tweaking probably still needed) 

## Add the needed widgets and containers.
1. All widgets added for welcome screen

## Update your UI to have an anonymous inner class ActionListener that is registered with a button.
1. The Search Flights Button used the controller to call the FlightManager to get the flights based upon the criteria



# TODO
 - I'd like to have the system generate the Ids (I have used the database to do this in the past)
- I need to add logic to Flight Manager to filter the flights further for available seats...may need additional methods or refactoring of availableSeats method to accommodate more than just one available. 
- I need to add the logic for the itineraries
-I need to add the number of passengers
- Add input validation to form

# Thoughts
Should I have the other views pop up in a new window or create a method on the main frame to hide and show certain elements
   


