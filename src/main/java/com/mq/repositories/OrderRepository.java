package com.mq.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mq.entities.Order;

@Component
@Repository 
public interface OrderRepository extends CrudRepository<Order , Integer> {

	/*
	 * 	public Order(int oId, int cId, int pId, int quantity, String datetime) {
		super();
		this.oId = oId;
		this.cId = cId;
		this.pId = pId;
		this.quantity = quantity;
		this.orderDate = datetime;
	}

	 */

	Set<Order> findBycId(Integer id);
}
