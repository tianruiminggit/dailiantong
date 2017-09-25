package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserService {
	
	/**
	 * ��¼
	 * @param userAccount
	 * @return
	 */
	UserAccount getUserAccount(String userAccount);
	
	/**
	 * ע��
	 * @param user
	 * @return
	 */
	int addUserAccount(UserAccount user);
	
	/**
	 * �鿴�����û���Ϣ
	 * @return
	 */

	List<Map<String, Object>> getListMapUser(String where);
	
	

	/**
	 * ͨ���û��˺�ɾ���û�
	 * @param account
	 */
	public void delUser(String account);
	
	
}
