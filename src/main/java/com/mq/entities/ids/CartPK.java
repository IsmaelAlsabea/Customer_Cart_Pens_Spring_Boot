package com.mq.entities.ids;

import java.io.Serializable;


public class CartPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private int cartId;
	
	private int cId;
	
	private int p_id;

	public CartPK() {
		super();
	}

	public CartPK(int cartId, int cId, int p_id) {
		super();
		this.cartId = cartId;
		this.cId = cId;
		this.p_id = p_id;
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

	@Override
	public String toString() {
		return "CartPK [cartId=" + cartId + ", cId=" + cId + ", p_id=" + p_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + cartId;
		result = prime * result + p_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartPK other = (CartPK) obj;
		if (cId != other.cId)
			return false;
		if (cartId != other.cartId)
			return false;
		if (p_id != other.p_id)
			return false;
		return true;
	}
	
	
	
}
