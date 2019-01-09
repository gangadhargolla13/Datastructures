package com.java.interview.RestaurantProj;

import java.util.List;

public class OrderDetails {

	private String customerName;
	
	private List<Order> orderList;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
}

