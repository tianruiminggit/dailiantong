package com.dailiantong.service;

import com.dailiantong.pojo.PlatformMoney;

public interface PlatformMoneyService {

	/**
	 * 按照用户账号查询
	 * @param user_account
	 * @return
	 */
	PlatformMoney getMoney (String user_account);
	
	/**
	 * 修改平台个人资金
	 * @param pMoney
	 * @return 
	 */
	public int updateMoney(PlatformMoney pMoney);
}
