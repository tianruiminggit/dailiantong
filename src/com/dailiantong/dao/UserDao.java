package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserDao {
	/**
	 * ��¼ 
	 * @param userAccount
	 * @return
	 */
	UserAccount getUserAccount(String userAccount);
	
	/**
	 * ע�ᣬ����û�
	 * @param user
	 * @return
	 */
	int addUserAccount(UserAccount user);
	
	/**
	 * �����û�״̬��ѯ�������û��б�
	 * @return
	 */
	List<Map<String,Object>> getListMapUser(String where );
	
	
	/**
	 * �����û��˺�ɾ��
	 * @param account
	 * @return
	 */
	int delUser(String account);
	
	
//	/**
//	 * �����û�״̬��ѯ�������û��б�
//	 * @return
//	 */
//	List<Map<String,Object>> getListMapUser(int where);
}
