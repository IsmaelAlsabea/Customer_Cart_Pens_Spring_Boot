package com.mq.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mq.entities.Order;

@Component
@Repository 
public interface OrderRepository extends CrudRepository<Order , Integer> {

	Set<Order> findBycId(Integer id);
}
