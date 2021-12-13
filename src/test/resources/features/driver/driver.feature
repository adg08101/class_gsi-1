#Author: ahmed.davila@generalsoftwareinc.com
#Keywords Summary : Driver UHs automated Testing Examples
#Feature: Add Driver.
#Scenario:
#------------------------------------------
#Mobile numbers and email addresses should be associated with only one Driver.
#A user registered in the system as Customer and/or Fleet owner can also be registered as Driver.
#A user registered in the system as Admin or Dispatcher cannot be registered as Driver.
#The "Add Driver" button is not shown if the user who is accessing the "Drivers List" view is the GoHeavy Admin, and he comes from the "Fleet Owners List" view.
#The minimum value allowed for the years of experience will be 3 years.
#------------------------------------------
#Given: Some precondition step
#------------------------------------------
#1. The GoHeavy Admin / Fleet Owner must be logged in the system.
#2. The GoHeavy Admin / Fleet Owner is on the "Drivers List" view.
#------------------------------------------
#When: Some key actions
#Then: To observe outcomes or validation
#------------------------------------------
#1. Clicks on the "Add Driver" button.
#------------------------------------------
#And,But:
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: Given Any user is logged
#Sample Feature Definition Template

Feature: Add Driver 2.3
  As a: GoHeavy Admininstrator / Fleet Owner
  I Want To: add a Driver	
  So That: a new Driver is registered in the system.
  
  Background:
    #1. Scenario for Pure Driver Create
    #Given Any "GoHeavy Administrator / Fleet Owner" is logged
    #2. Scenario for Driver - Vehicle Assign
    Given Any "GoHeavy Adm / Fleet Owner" is logged

  #Scenario: Add Vehicle 2.2 -- Add Driver
  #  Given The user is in "Drivers List" view.
  #  When User clicks on "Add Driver" button.
  #  Then The system opens the "Add Driver" view.
  #  When The user inserts valid driver data AND clicks on the "Done" button.
  #  Then The System Creates a new Driver in "On-boarding" status.
  #  And The System registers the creation date.
    
  #As a GoHeavy Admin / Fleet Owner/ Document Approver
	#I want to edit the personal information of a Driver
	#So that I can update the Driver's data allowed for the role and his Status.

  Scenario: Add Vehicle 2.2 -- Edit Driver
    Given The user is in "Drivers List" view.
    When User clicks on "Edit Driver" button.
    #Added Logic Set Status to GoHeavy Ready
    Then The system opens the "Edit Driver" view.
    When The user inserts valid driver data AND clicks on the "Update" button.
    #TODO: Here
    #Then The System Creates a new Driver in "On-boarding" status.
    #And The System registers the creation date.
    