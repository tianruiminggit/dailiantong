package com.dailiantong.pojo;

public class OrderStatus {
	 private int order_status;         //int                            not null,
	 private String  status ;             // varchar(20) 
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
}
