Feature: login to the program


	Scenario: user Login
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
	
	