package com.dailiantong.pojo;

public class Bank {
	   private String bank_num;             //varchar(20)                    not null,
	   private double bank_money;            //double                         null,
	   private String bank_name ;            //varchar(20)                    null,
	   private String user_account;
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public double getBank_money() {
		return bank_money;
	}
	public void setBank_money(double bank_money) {
		this.bank_money = bank_money;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	   

}
