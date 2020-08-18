Feature: submit a new order


	Background: Customer added stuff to cart and wants to buy them.
	
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
		
		
		Given the guest is on the shop page 
		When  the guest clicks add to cart
		Then  a pop-up box about the pen will appear
	
		Given the guest is in the pop-up box of a pen
		When the guest sets the quantity and click add to cart
		Then the pen is added to the cart
		
		

	Scenario: Submit order from cart page
		Given the guest is on the cart page
		When the guest clicks submit cart order
		Then confirmation of order is displayed