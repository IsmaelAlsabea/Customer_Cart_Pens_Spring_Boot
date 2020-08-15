package com.mq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mq.entities.Customer;
import com.mq.services.CustomerService;

@Component
@RestController
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	CustomerService cs;

	@RequestMapping(value="/login",method= RequestMethod.POST)
	public Customer login(@RequestBody(required = true) Customer  customer) {
		
		Customer cust = cs.getCustomerByEmail(customer.getEmail());
		
		if(cust.getPassword().equals(customer.getPassword())) {
			return cust;
		}
		else {
			return null;
		}
	}
	
}
