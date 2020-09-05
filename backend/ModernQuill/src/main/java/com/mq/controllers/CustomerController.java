package com.mq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mq.entities.Customer;
import com.mq.services.CustomerService;

@Component
@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/customers/{cid}", method = RequestMethod.GET)
	public Customer getCustomerbyId(@PathVariable int cid) {
		return this.cs.getCustomerById(cid);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.PUT)
	public Customer updateCustomerPoints(@RequestBody Customer customer) {
		Customer updatedCustomer = cs.getCustomerById(customer.getcId());
		updatedCustomer.setPoints(customer.getPoints());
		return this.cs.updateCustomer(updatedCustomer);
	}
	
	@RequestMapping(value="/customers/login",method= RequestMethod.POST)
	public Customer login(@RequestBody(required = true) Customer  customer) {
		Customer cust;
		
		try {
			cust = cs.getCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword());
			return cust;	
			
		}catch(Exception e) {
			cust = null;
		}
		return null;
	}
	
}
