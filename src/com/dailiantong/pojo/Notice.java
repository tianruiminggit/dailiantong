package com.dailiantong.pojo;

import java.util.Date;



public class Notice {
		private int notice_id;            //int                            null,
	   private String notice_title ;       // varchar(20)                    null,
	   private String notice_content;      // varchar(128)                   null,
	   private Date notice_time ;        // datetime                       null,
	   private String manager_account;      //varchar(20)
	
	   
	   public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	public String getManager_account() {
		return manager_account;
	}
	public void setManager_account(String manager_account) {
		this.manager_account = manager_account;
	}
	   
}
