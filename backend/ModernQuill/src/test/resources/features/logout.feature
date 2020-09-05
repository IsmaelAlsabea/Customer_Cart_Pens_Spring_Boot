Feature: logging out


	Background:
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page

	Scenario: log out of the application
	
		When the customer clicks logout 
		Then the program will redirect customer to the login page