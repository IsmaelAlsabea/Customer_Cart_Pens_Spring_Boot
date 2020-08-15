package com.mq.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.mq.entities.ids.CartPK;

@Entity
@Table (name ="cart")
@IdClass(CartPK.class)
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="cart_id")
	private int cartId;
		
	@Id
	@Column(name = "c_id")
	private int cId;
	
	@Id
	@Column(name="pId")
	private int p_id;
	
	@Column(name= "quantity")
	private int  quantity;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, int cId, int p_id, int quantity) {
		super();
		this.cartId = cartId;
		this.cId = cId;
		this.p_id = p_id;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cId=" + cId + ", p_id=" + p_id + ", quantity=" + quantity + "]";
	}

	
	
	
	
}
