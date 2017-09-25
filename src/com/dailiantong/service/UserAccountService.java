package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserAccountService {
	
	/**
	 * 通过用户账号查询
	 * @param useraccount
	 * @return
	 */
	public List<Map<String, Object>> getListUserAccount(String useraccount);
	
	

	/**
	 * 更新用户详细信息
	 * @param userAccount
	 * @return 
	 */
	public int updateUser(UserAccount userAccount);
	
	
	/**
	 * 按照用户账号查询
	 * @param user_account
	 * @return
	 */
	UserAccount getUserAccount( String user_account);
	
}
