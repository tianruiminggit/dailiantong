package com.dailiantong.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Appeal {
	private String appeal_id;
	private String user_account;
	private String appeal_content;
	private String appeal_status;
	private int appeal_type;
	private Date appeal_time;
	public Date getAppeal_time() {
		return appeal_time;
	}
	public void setAppeal_time(Date appeal_time) {
		this.appeal_time = appeal_time;
	}
	public String getAppeal_id() {
		return appeal_id;
	}
	public void setAppeal_id(String appeal_id) {
		this.appeal_id = appeal_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getAppeal_content() {
		return appeal_content;
	}
	public void setAppeal_content(String appeal_content) {
		this.appeal_content = appeal_content;
	}
	public String getAppeal_status() {
		return appeal_status;
	}
	public void setAppeal_status(String appeal_status) {
		this.appeal_status = appeal_status;
	}
	public int getAppeal_type() {
		return appeal_type;
	}
	public void setAppeal_type(int appeal_type) {
		this.appeal_type = appeal_type;
	}
	public Appeal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
