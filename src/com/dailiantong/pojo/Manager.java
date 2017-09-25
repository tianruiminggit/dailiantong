package com.dailiantong.pojo;

public class Manager {
	 	private String manager_account;      //varchar(20)                    not null,
	   private String manager_password;     //varchar(20)                    null,
	   private String manager_nickName;     //varchar(20)                    null,
	public String getManager_account() {
		return manager_account;
	}
	public void setManager_account(String manager_account) {
		this.manager_account = manager_account;
	}
	public String getManager_password() {
		return manager_password;
	}
	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}
	public String getManager_nickName() {
		return manager_nickName;
	}
	public void setManager_nickName(String manager_nickName) {
		this.manager_nickName = manager_nickName;
	}

}
