package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserDao {
	/**
	 * 登录 
	 * @param userAccount
	 * @return
	 */
	UserAccount getUserAccount(String userAccount);
	
	/**
	 * 注册，添加用户
	 * @param user
	 * @return
	 */
	int addUserAccount(UserAccount user);
	
	/**
	 * 按照用户状态查询，返回用户列表
	 * @return
	 */
	List<Map<String,Object>> getListMapUser(String where );
	
	
	/**
	 * 按照用户账号删除
	 * @param account
	 * @return
	 */
	int delUser(String account);
	
	
//	/**
//	 * 按照用户状态查询，返回用户列表
//	 * @return
//	 */
//	List<Map<String,Object>> getListMapUser(int where);
}
