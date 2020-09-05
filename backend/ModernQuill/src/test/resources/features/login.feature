Feature: login to the program


	Scenario: user Login
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their password
		When the guest clicks login
		Then the guest should be on shop page
	
	Scenario: user cannot login due to wrong username
		Given the guest is on the login
		When the guest enters their wrong email
		When the guest enters their password
		When the guest clicks login
		Then an alert pops up telling user that credentials are wrong
		
	Scenario: user cannot login due to wrong password
		Given the guest is on the login
		When the guest enters their email
		When the guest enters their wrong password
		When the guest clicks login
		Then an alert pops up telling user that credentials are wrong
	
	Scenario: user cannot login due to wrong username and password
		Given the guest is on the login
		When the guest enters their wrong email
		When the guest enters their wrong password
		When the guest clicks login
		Then an alert pops up telling user that credentials are wrong
	
	  