package com.dailiantong.pojo;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class TixianLog {
private int tixian_id;
private String user_account;
private double tixian_money;
private Date tixian_time;
public int getTixian_id() {
	return tixian_id;
}
public void setTixian_id(int tixian_id) {
	this.tixian_id = tixian_id;
}
public String getUser_account() {
	return user_account;
}
public void setUser_account(String user_account) {
	this.user_account = user_account;
}
public double getTixian_money() {
	return tixian_money;
}
public void setTixian_money(double tixian_money) {
	this.tixian_money = tixian_money;
}
public Date getTixian_time() {
	return tixian_time;
}
public void setTixian_time(Date tixian_time) {
	this.tixian_time = tixian_time;
}


}
