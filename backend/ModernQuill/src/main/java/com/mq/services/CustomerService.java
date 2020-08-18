package com.mq.services;

import com.mq.entities.Customer;

public interface CustomerService {

	Customer getCustomerById(int id);
	Customer getCustomerByEmail(String email);
}
