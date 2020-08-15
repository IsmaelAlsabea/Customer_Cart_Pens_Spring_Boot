package com.mq.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mq.entities.Order;
import com.mq.services.OrderService;

@Component
@RestController
@CrossOrigin("*")
public class OrderController {

	@Autowired
	OrderService oServ;
	
	
	@RequestMapping (value = "/orders", method =  RequestMethod.POST)
	public Order createOrder(@RequestBody Order order) {
		
		return oServ.createOrder(order);
	}
	
	@RequestMapping (value = "/orders/{oid}", method =  RequestMethod.GET)
	public Order getOrderById(@PathVariable Integer id) {
		
		return oServ.getById(id);
	}
	
	@RequestMapping (value = "/customers/{cid}/orders", method =  RequestMethod.GET)
	public Set<Order> getCustomerOrders(@PathVariable Integer cid) {
		
		return oServ.getAllOrdersByCustomerId(cid);
	}
	


	
	
}
