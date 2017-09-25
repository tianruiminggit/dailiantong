package com.dailiantong.pojo;

public class PlatformMoney {
	  private String user_account;         //varchar(20)                    not null,
	  private double  platform_usableMoney; //double                         null,
	  private double platform_freezeMoney; //double   
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public double getPlatform_usableMoney() {
		return platform_usableMoney;
	}
	public void setPlatform_usableMoney(double platform_usableMoney) {
		this.platform_usableMoney = platform_usableMoney;
	}
	public double getPlatform_freezeMoney() {
		return platform_freezeMoney;
	}
	public void setPlatform_freezeMoney(double platform_freezeMoney) {
		this.platform_freezeMoney = platform_freezeMoney;
	}
	  
	  
}
