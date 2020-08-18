package com.mq.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mq.entities.Order;
import com.mq.repositories.OrderRepository;

@Component
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository oRepo;
	
	@Override
	public Order createOrder(Order theOrder) {
		
		return oRepo.save(theOrder);
	}

	@Override
	public Set<Order> getAllOrdersByCustomerId(int cid) {
		return oRepo.findBycId(cid);
	}

	@Override
	public Order getById(int oid) {
		
		return oRepo.findById(oid).get();
	}
	
}
