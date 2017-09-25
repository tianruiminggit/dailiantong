package com.dailiantong.dao;

import com.dailiantong.pojo.PlatformMoney;

public interface PlatformMoneyDao {
	/**
	 * 按照用户查询自己账户的该平台资金
	 * @param user_account
	 * @return
	 */
	PlatformMoney getMoney (String user_account);
	
	/**
	 * 修改平台个人资金
	 * @param pMoney
	 * @return
	 */
	int upMoney(PlatformMoney pMoney);
	/**
	 * 更新可用资金
	 * @param user_account
	 * @param money
	 * @return
	 */
	int updateUsableMoney(String user_account, double money);
	/**
	 * 更新冻结资金
	 * @param user_account
	 * @param money
	 * @return
	 */
	int updateFreezeMoney(String user_account, double money);
}
