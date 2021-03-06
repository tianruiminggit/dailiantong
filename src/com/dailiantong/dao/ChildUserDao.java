package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.ChildUser;

public interface ChildUserDao {
	/**
	 * 增加用户的子帐号
	 * @param user_account
	 * @return
	 */
	int insertChildUser(ChildUser childuser);
	/**
	 * 查询用户所有的子帐号信息
	 * @param user_account
	 * @return
	 */
	List<ChildUser> getListChildUser(String user_account);
	/**
	 * 修改用户的子帐号信息
	 * @param childuser
	 * @return
	 */
	int updateChildUser(ChildUser childuser);
	/**
	 * 删除用户的子帐号信息
	 * @param child_id
	 * @return
	 */
	int deleteChildUser(String child_id);
	/**
	 * 按照用户帐号查询子帐号信息
	 * @param user_account
	 * @return
	 */
	List<ChildUser> findChildUser(String child_id);
	
	ChildUser findByChildUser(String child_id);
	
}
