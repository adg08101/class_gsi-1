#Author: ahmed.davila@generalsoftwareinc.com
#Keywords Summary : Driver/Vehicle Documents manage UHs automated Testing Examples
#Feature: Manage - Approve Documents for Drivers and Vehicles.
#Scenario:
#------------------------------------------
#As a GoHeavy Admin / Document Approver/ Fleet Owner
#I want to view the documents list of a selected driver/vehicle
#So that I can interact with the options allowed for the role.
#------------------------------------------
#Given: Some precondition step
#------------------------------------------
# Important Note:
# For better results Run Driver & Vehicle Features for Instances Creation
#1. The GoHeavy Admin / Document Approver/ Fleet Owner must be logged in the system.
#2. The GoHeavy Admin / Fleet Owner is on the "Drivers List" / "Vehicles List" view.
#------------------------------------------
#When: Some key actions
#Then: To observe outcomes or validation
#------------------------------------------
#1. Clicks on the "Manage" Driver / Vehicle Documents button.
#------------------------------------------
#And,But:
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: Given Any user is logged
#Sample Feature Definition Template

Feature: Go to manage Driver/Vehicle Documents
  As a GoHeavy Admin / Document Approver/ Fleet Owner
	I want to view the documents list of a selected driver/vehicle
	So that I can interact with the options allowed for the role.
  
  #Background:
  #  Given Any "GoHeavy Administrator / Fleet Owner" is logged
    
  Background:
  #Background for Vehicle Assign Feature
    Given Any "GoHeavy Admin / Fleet Owner" is logged

  #Scenario: Manage Driver Documents -- Clear / Approve Documents
  #  Given The user is in "Drivers List" view.
  #  When User clicks on Documents button that belong to a "Driver".
  #  Then The system displays the "Documents for Driver" view.
  #  When User clicks on "Approve" button.
  #  Then The system Saves Changes and goes back to the "Driver Documents" view.
    
  #Scenario: Manage Vehicle Documents -- Clear / Approve Documents
  #  Given The user is in "Vehicles & Insurance List" view.
  #  When User clicks on Documents button that belong to a "Vehicle".
  #  Then The system displays the "Documents for Vehicle" view.
  #  When User clicks on "Approve" button.
  #  Then The system Saves Changes and goes back to the "Vehicle Documents" view.
    
	Scenario: Assign Vehicle -- 
    Given The user is in "Vehicles & Insurance List" view.
    When User clicks on Assign button that belong to a "Vehicle".
    Then The system displays "Assign Vehicle" view.
    When User assigns the vehicle.
    #TODO Logic
    #Then The system Saves Changes and goes back to the "Vehicle Documents" view.
