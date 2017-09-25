package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.PlatformMoney;

public interface MoneyDao {
	/**
	 * 查询有关资金的业务
	 * @param user_account
	 * @return
	 */
	PlatformMoney getListMoney(String user_account);
	/**
	 * 更新可以资金
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
