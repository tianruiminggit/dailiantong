package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.UserAccount;

public interface UserAccountDao {
	
	/**
	 * 按照用户账号查询
	 * @param useraccount
	 * @return
	 */
	List<Map<String, Object>> getListUserAccount(String useraccount);


	//更新用户
	
	/**
	 * 用户自己修改个人资料
	 * @param userAccount
	 * @return
	 */
	int updateUser(UserAccount userAccount);
	
	
	UserAccount getUserAccount(String user_account);

}
