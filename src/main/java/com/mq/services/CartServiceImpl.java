package com.mq.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mq.entities.Cart;
import com.mq.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cr;
	
	@Override
	public Cart createCart(Cart cart) {
		
		return cr.save(cart);
	}

	@Override
	public Set<Cart> getAllByCartId(int cartId) {
		return cr.findBycartId(cartId);
	}

}
