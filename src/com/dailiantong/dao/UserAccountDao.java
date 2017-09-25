package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserAccountDao {
	
	/**
	 * �����û��˺Ų�ѯ
	 * @param useraccount
	 * @return
	 */
	List<Map<String, Object>> getListUserAccount(String useraccount);


	//�����û�
	
	/**
	 * �û��Լ��޸ĸ�������
	 * @param userAccount
	 * @return
	 */
	int updateUser(UserAccount userAccount);
	
	
	UserAccount getUserAccount(String user_account);

}
