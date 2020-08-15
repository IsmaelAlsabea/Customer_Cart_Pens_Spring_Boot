package com.mq.services;

import java.util.Set;

import com.mq.entities.Order;

public interface OrderService {

	
	Order createOrder(Order theOrder);
	
	Set<Order> getAllOrdersByCustomerId(int cid);
	
	Order getById(int oid);
}
