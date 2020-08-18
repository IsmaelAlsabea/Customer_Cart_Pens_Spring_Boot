package com.mq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mq.entities.Customer;
import com.mq.services.CustomerService;

@Component
@Controller
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/customers/{cid}", method = RequestMethod.GET)
	@ResponseBody
	public Customer getCustomerbyId(@PathVariable int cid) {
		return this.cs.getCustomerById(cid);
	}
	
}
