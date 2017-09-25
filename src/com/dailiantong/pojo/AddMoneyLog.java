package com.dailiantong.pojo;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class AddMoneyLog {
private int addMoney_id;
private String user_account;
private Date congzhi_time;
private double addMoney;
public int getAddMoney_id() {
	return addMoney_id;
}
public void setAddMoney_id(int addMoney_id) {
	this.addMoney_id = addMoney_id;
}
public String getUser_account() {
	return user_account;
}
public void setUser_account(String user_account) {
	this.user_account = user_account;
}

public Date getCongzhi_time() {
	return congzhi_time;
}
public void setCongzhi_time(Date congzhi_time) {
	this.congzhi_time = congzhi_time;
}
public double getAddMoney() {
	return addMoney;
}
public void setAddMoney(double addMoney) {
	this.addMoney = addMoney;
}


}
