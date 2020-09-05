package com.mq.services;

import com.mq.entities.Customer;

public interface CustomerService {

	Customer getCustomerById(int id);
	Customer getCustomerByEmailAndPassword(String email, String password);
	Customer updateCustomer(Customer customer);
}
