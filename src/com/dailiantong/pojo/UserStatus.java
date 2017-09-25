package com.dailiantong.pojo;

public class UserStatus {
	private int user_status;         // int                            not null,
	 private String status;              // varchar(20)                    null,
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
}
