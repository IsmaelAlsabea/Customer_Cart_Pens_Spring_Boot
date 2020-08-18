Feature: add pen to cart

	Background: Login
	
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page

	Scenario: Select a pen to be added to cart.
	
		Given the guest is on the shop page 
		When  the guest clicks add to cart
		Then  a pop-up box about the pen will appear
		
	Scenario: Add pen to cart pop-up
	
		Given the guest is in the pop-up box of a pen
		When the guest sets the quantity and click add to cart
		Then the pen is added to the cart
		
		
		
		