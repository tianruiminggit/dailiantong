package com.dailiantong.pojo;

import java.util.Date;

public class DongjieLog {
	private int dongjie_id;
	private String user_account;
	private Date dongjie_time;
	private String dongjie_money;
	public int getDongjie_id() {
		return dongjie_id;
	}
	public void setDongjie_id(int dongjie_id) {
		this.dongjie_id = dongjie_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public Date getDongjie_time() {
		return dongjie_time;
	}
	public void setDongjie_time(Date dongjie_time) {
		this.dongjie_time = dongjie_time;
	}
	public String getDongjie_money() {
		return dongjie_money;
	}
	public void setDongjie_money(String dongjie_money) {
		this.dongjie_money = dongjie_money;
	}
	
}
