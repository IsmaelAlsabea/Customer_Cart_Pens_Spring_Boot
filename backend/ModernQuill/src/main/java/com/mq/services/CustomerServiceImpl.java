package com.mq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mq.entities.Customer;
import com.mq.repositories.CustomerRepository;

@Component
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cr;

	@Override
	public Customer getCustomerById(int id) {
		return cr.findById(id).get();
	}
	
	@Override
	public Customer getCustomerByEmail(String email) {
		return cr.findByEmail(email);
	}
}
