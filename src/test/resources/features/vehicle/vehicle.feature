#Author: ahmed.davila@generalsoftwareinc.com
#Keywords Summary : Vehicle UHs automated Testing Examples
#Feature: Add vehicle.
#Scenario:
#------------------------------------------
#1 The "Add Vehicle" button is not shown if the user who is accessing the "Vehicles & Insurance List" 
#view is the GoHeavy Admin, and he comes from the "Fleet Owners List" view.
#2. Two vehicles with the same Vehicle ID No. (VIN) cannot be registered in the system.
#------------------------------------------
#Given: Some precondition step
#------------------------------------------
#1. The GoHeavy Admin / Fleet Owner must be logged in the system.
#2. The GoHeavy Admin / Fleet Owner is on the "Vehicles & Insurance List" view.
#------------------------------------------
#When: Some key actions
#Then: To observe outcomes or validation
#------------------------------------------
#1. Clicks on the "Add Vehicle" button.
#------------------------------------------
#And,But:
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: Given Any user is logged
#Sample Feature Definition Template

Feature: Add Vehicle 2.2
  As a: GoHeavy Admin / Fleet Owner
  I Want To: add a Vehicle	
  So That: a new Vehicle is registered in the system.
  
  Background: 
    Given Any "GoHeavy Admin / Fleet Owner" is logged

  Scenario: Add Vehicle 2.2 -- Add Vehicle
    Given The user is in "Vehicles & Insurance List" view.
    When User clicks on "Add Vehicle" button.
    Then The system opens the "Add Vehicle" view.
    When Hover over a Vehicle document image component with an image loaded.
    When The user inserts valid data AND clicks on the "Done" button.
    Then Returns to the "Vehicles & Insurance List" view and displays "A new Vehicle was successfully created.".
    Then The System Creates a new Vehicle in "On-boarding" status.
    And The System registers the creation date.
