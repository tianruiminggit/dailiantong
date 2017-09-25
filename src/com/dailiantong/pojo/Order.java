package com.dailiantong.pojo;

import java.util.Date;



public class Order {
	private String order_id;
	private String user_account;//������ID
	private String use_user_account;//�ӵ���ID
	private double order_price;//�����۸�
	private int order_finishTime;//���ʱ��
	private int order_deleteTime;//ɾ��ʱ��
	private int order_status;//״̬
	private String order_content;//��������
	private String order_gameInfo;//��Ϸ��ɫ����
	private double order_bond;//��֤��
	private String order_gameName;//��Ϸ����
	private String order_gameAccount;//��Ϸ�˺�
	private String order_gamePassword;//��Ϸ����
	private int order_isComplaint;//
	private Date order_releaseTime;//����ʱ��
	private Date order_receiveTime;//�ӵ�ʱ��
	private String order_task;//����Ҫ��
	private Date order_returnTime; //���ʱ��
	public Order() {
		super();
	}
	public Order(String order_id,String user_account, double order_price, int order_finishTime,
			int order_deleteTime, String order_content, String order_gameInfo,
			double order_bond, String order_gameName, String order_gameAccount,
			String order_gamePassword, String order_task) {
		super();
		this.order_id = order_id;
		this.user_account = user_account;
		this.order_price = order_price;
		this.order_finishTime = order_finishTime;
		this.order_deleteTime = order_deleteTime;
		this.order_content = order_content;
		this.order_gameInfo = order_gameInfo;
		this.order_bond = order_bond;
		this.order_gameName = order_gameName;
		this.order_gameAccount = order_gameAccount;
		this.order_gamePassword = order_gamePassword;
		this.order_task = order_task;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUse_user_account() {
		return use_user_account;
	}
	public void setUse_user_account(String use_user_account) {
		this.use_user_account = use_user_account;
	}
	public double getOrder_price() {
		return order_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public int getOrder_finishTime() {
		return order_finishTime;
	}
	public void setOrder_finishTime(int order_finishTime) {
		this.order_finishTime = order_finishTime;
	}
	public int getOrder_deleteTime() {
		return order_deleteTime;
	}
	public void setOrder_deleteTime(int order_deleteTime) {
		this.order_deleteTime = order_deleteTime;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public String getOrder_gameInfo() {
		return order_gameInfo;
	}
	public void setOrder_gameInfo(String order_gameInfo) {
		this.order_gameInfo = order_gameInfo;
	}
	public double getOrder_bond() {
		return order_bond;
	}
	public void setOrder_bond(double order_bond) {
		this.order_bond = order_bond;
	}
	public String getOrder_gameName() {
		return order_gameName;
	}
	public void setOrder_gameName(String order_gameName) {
		this.order_gameName = order_gameName;
	}
	public String getOrder_gameAccount() {
		return order_gameAccount;
	}
	public void setOrder_gameAccount(String order_gameAccount) {
		this.order_gameAccount = order_gameAccount;
	}
	public String getOrder_gamePassword() {
		return order_gamePassword;
	}
	public void setOrder_gamePassword(String order_gamePassword) {
		this.order_gamePassword = order_gamePassword;
	}
	public int getOrder_isComplaint() {
		return order_isComplaint;
	}
	public void setOrder_isComplaint(int order_isComplaint) {
		this.order_isComplaint = order_isComplaint;
	}
	public Date getOrder_releaseTime() {
		return order_releaseTime;
	}
	public void setOrder_releaseTime(Date order_releaseTime) {
		this.order_releaseTime = order_releaseTime;
	}
	public Date getOrder_receiveTime() {
		return order_receiveTime;
	}
	public void setOrder_receiveTime(Date order_receiveTime) {
		this.order_receiveTime = order_receiveTime;
	}
	public String getOrder_task() {
		return order_task;
	}
	public void setOrder_task(String order_task) {
		this.order_task = order_task;
	}
	public Date getOrder_returnTime() {
		return order_returnTime;
	}
	public void setOrder_returnTime(Date order_returnTime) {
		this.order_returnTime = order_returnTime;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_account=" + user_account
				+ ", use_user_account=" + use_user_account + ", order_price="
				+ order_price + ", order_finishTime=" + order_finishTime
				+ ", order_deleteTime=" + order_deleteTime + ", order_status="
				+ order_status + ", order_content=" + order_content
				+ ", order_gameInfo=" + order_gameInfo + ", order_bond="
				+ order_bond + ", order_gameName=" + order_gameName
				+ ", order_gameAccount=" + order_gameAccount
				+ ", order_gamePassword=" + order_gamePassword
				+ ", order_isComplaint=" + order_isComplaint
				+ ", order_releaseTime=" + order_releaseTime
				+ ", order_receiveTime=" + order_receiveTime + ", order_task="
				+ order_task + ", order_returnTime=" + order_returnTime + "]";
	}
	
}
