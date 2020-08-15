package com.mq.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mq.entities.Cart;
import com.mq.entities.ids.CartPK;

@Repository
public interface CartRepository extends CrudRepository<Cart, CartPK>{

	/*
	 * 	@Column (name="cart_id")
	private int cartId;
	
	@Column(name = "c_id")
	private int cId;
	
	@Column(name="pId")
	private int p_id;
	 */
	Set<Cart> findBycartId(Integer cartId);
	
	
	
}
