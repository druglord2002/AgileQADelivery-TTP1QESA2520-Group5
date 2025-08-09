@Booking
Feature: Booking Functionality
	
	Scenario Outline: Verify all the present fields with valid input
		Given Navigate to Booking Page 
		When Enter all the fields with valid input for "<Rows>"
		And click the Book Now button
		Then verify the valid data
		Examples:
		|Rows|
		|  1 |
		|  2 |
		
		
	Scenario Outline: Verify all the present fields with invalid input
		Given Navigate to Booking Page 
		When Enter all the fields with invalid input for "<Rows>"
		And click the Book Now button
		Then verify the invalid data
		Examples:
		|Rows|
		|  1 |
		|  2 |
		|  3 |
		|  4 |
		|  5 |
		|  6 |
		|  7 |
		|  8 |
		|  9 |
	
	Scenario: Verify all the present fields with blank input 
		Given Navigate to Booking Page
		When click the Book Now button with blank data
		Then verify blank data