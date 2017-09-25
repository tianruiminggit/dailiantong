package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserAccountService {
	
	/**
	 * ͨ���û��˺Ų�ѯ
	 * @param useraccount
	 * @return
	 */
	public List<Map<String, Object>> getListUserAccount(String useraccount);
	
	

	/**
	 * �����û���ϸ��Ϣ
	 * @param userAccount
	 * @return 
	 */
	public int updateUser(UserAccount userAccount);
	
	
	/**
	 * �����û��˺Ų�ѯ
	 * @param user_account
	 * @return
	 */
	UserAccount getUserAccount( String user_account);
	
}
