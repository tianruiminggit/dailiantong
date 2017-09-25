package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.ChildUser;

public interface ChildUserDao {
	/**
	 * �����û������ʺ�
	 * @param user_account
	 * @return
	 */
	int insertChildUser(ChildUser childuser);
	/**
	 * ��ѯ�û����е����ʺ���Ϣ
	 * @param user_account
	 * @return
	 */
	List<ChildUser> getListChildUser(String user_account);
	/**
	 * �޸��û������ʺ���Ϣ
	 * @param childuser
	 * @return
	 */
	int updateChildUser(ChildUser childuser);
	/**
	 * ɾ���û������ʺ���Ϣ
	 * @param child_id
	 * @return
	 */
	int deleteChildUser(String child_id);
	/**
	 * �����û��ʺŲ�ѯ���ʺ���Ϣ
	 * @param user_account
	 * @return
	 */
	List<ChildUser> findChildUser(String child_id);
	
	ChildUser findByChildUser(String child_id);
	
}