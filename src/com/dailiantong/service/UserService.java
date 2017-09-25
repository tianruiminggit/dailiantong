package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserService {
	
	/**
	 * 登录
	 * @param userAccount
	 * @return
	 */
	UserAccount getUserAccount(String userAccount);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	int addUserAccount(UserAccount user);
	
	/**
	 * 查看所有用户信息
	 * @return
	 */

	List<Map<String, Object>> getListMapUser(String where);
	
	

	/**
	 * 通过用户账号删除用户
	 * @param account
	 */
	public void delUser(String account);
	
	
}
