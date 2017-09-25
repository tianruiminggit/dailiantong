package com.dailiantong.dao;

import com.dailiantong.pojo.Bank;

public interface BankDao {

	/**
	 * 根据用户查询该用户的模拟银行卡数据信息
	 * @param user_account
	 * @return
	 */
	Bank getBank(String user_account);
	
	/**
	 * 添加银行卡表
	 * @param bank
	 * @return
	 */
	int addBank(Bank bank);
	
	/**
	 * 更新银行卡数据
	 * @param bank
	 * @return
	 */
	int upBank(Bank bank);
}
