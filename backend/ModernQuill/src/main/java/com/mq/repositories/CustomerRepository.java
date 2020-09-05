package com.mq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mq.entities.Customer;

@Component
@Repository 
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	Customer findByEmailAndPassword(String email, String password);
}
