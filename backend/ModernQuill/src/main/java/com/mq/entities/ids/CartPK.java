package com.mq.entities.ids;

import java.io.Serializable;


public class CartPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private int cartId;
	
	private int cId;
	
	private int pId;

	public CartPK() {
		super();
	}

	public CartPK(int cartId, int cId, int p_id) {
		super();
		this.cartId = cartId;
		this.cId = cId;
		this.pId = p_id;
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


	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "CartPK [cartId=" + cartId + ", cId=" + cId + ", pId=" + pId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + cartId;
		result = prime * result + pId;
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
		if (pId != other.pId)
			return false;
		return true;
	}
	
}
