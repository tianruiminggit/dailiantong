package com.dailiantong.pojo;

import java.util.Date;

public class ChildUser {
	   private String child_id;            // int                            not null,
	   private String user_account ;     //   varchar(20)                    null,
	   private String child_account;     //   varchar(20)                    null,
	   private String child_name   ;      //  varchar(20)                    null,
	   private String child_password;     //  varchar(20)                    null,
	   private double child_money ;       //  double                         null,
	   private String  child_root ;         // varchar(20)                    null,
	   private Date child_time  ;        // datetime 
	public String getChild_id() {
		return child_id;
	}
	public void setChild_id(String child_id2) {
		this.child_id = child_id2;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getChild_account() {
		return child_account;
	}
	public void setChild_account(String child_account) {
		this.child_account = child_account;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public String getChild_password() {
		return child_password;
	}
	public void setChild_password(String child_password) {
		this.child_password = child_password;
	}
	public double getChild_money() {
		return child_money;
	}
	public void setChild_money(double child_money) {
		this.child_money = child_money;
	}
	public String getChild_root() {
		return child_root;
	}
	public void setChild_root(String child_root) {
		this.child_root = child_root;
	}
	public Date getChild_time() {
		return child_time;
	}
	public void setChild_time(Date child_time) {
		this.child_time = child_time;
	}

}
