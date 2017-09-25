package com.dailiantong.pojo;

public class Complaint {
	  private int complaint_id;         //int                            null,
	  private String complaint_content;    //varchar(128)                   null,
	  private String order_id;             //int                            null
	
	  
	  
	public int getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}
	public String getComplaint_content() {
		return complaint_content;
	}
	public void setComplaint_content(String complaint_content) {
		this.complaint_content = complaint_content;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	  
}
