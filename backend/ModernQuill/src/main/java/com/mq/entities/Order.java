package com.mq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="cust_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "o_id")
	private int oId;
	

	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "c_id")
	private int cId;

	@Column (name = "order_date")
	private String orderDate;

	@Column (name= "order_total")
	private int orderTotal;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int oId, int cartId, int cId, String orderDate, int orderTotal) {
		super();
		this.oId = oId;
		this.cartId = cartId;
		this.cId = cId;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}

	public int getoId() {
		return oId;
	}


	public void setoId(int oId) {
		this.oId = oId;
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


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}




	public int getOrderTotal() {
		return orderTotal;
	}




	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}




	@Override
	public String toString() {
		return "Order [oId=" + oId + ", cartId=" + cartId + ", cId=" + cId + ", orderDate=" + orderDate
				+ ", orderTotal=" + orderTotal + "]";
	}





	
}

	