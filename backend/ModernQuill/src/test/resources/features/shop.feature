Feature: add pen to cart

	Background: Login
	
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
		
	Scenario: Add pen to cart
	
		When the guest clicks on view details of an image
		Then a pen dialogue pops up 
		When the guest sets the pen quantity
		When  the guest clicks add to cart
		Then  a confirmation pop up will appear
		
	Scenario: Order pages by 
		