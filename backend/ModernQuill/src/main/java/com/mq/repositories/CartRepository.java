package com.mq.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mq.entities.Cart;
import com.mq.entities.ids.CartPK;

@Repository
public interface CartRepository extends CrudRepository<Cart, CartPK>{

	/*
		 we cannot do find all since cartId is NOT a primary key, it is unique for every purchase session
		 this cart doesn't have carts, it has cart items so more than one record share the same cart_id
		 the number of records that share the same cart id corresponds to the number of items the 
		 customer purchase if the customer purchased 3 items, there will be 3 records that have the same
		 cart id.
	*/
	Set<Cart> findBycartId(Integer cartId);
	
	Cart findTopByOrderByCartIdDesc();  //you should capitalize the first letter of your property id;
	
	
}
