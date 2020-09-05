Feature: Cart Interactions


	Background: Customer added stuff to cart and wants to buy them.
	
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
		
		When the guest clicks on view details of an image
		Then a pen dialogue pops up 
		When the guest sets the pen quantity
		When  the guest clicks add to cart
		Then  a confirmation pop up will appear


	Scenario: Submit order from cart page
		Given the guest is on the cart page
		When the guest clicks confirm order to open confirm order dialog
		Then Another confirmation order dialog opens
		When the customer clicks confirm order 
		
		
	Scenario: add pens to cart, and clear the cart
		
		Given the guest is on the cart page
		When the guest clicks clear cart
		Then cart gets cleared 
		
		