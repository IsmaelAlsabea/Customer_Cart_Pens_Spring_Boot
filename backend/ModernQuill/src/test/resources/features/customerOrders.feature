Feature: Check Customer Orders

	Background:
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
	
	Scenario: View Customer Orders
	
		When Customer clicks on orders
		Then Customer gets redirected to his Orders Page.