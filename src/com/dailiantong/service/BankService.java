package com.dailiantong.service;

import com.dailiantong.pojo.Bank;

public interface BankService {

	//根据用户账号查询出用户模拟银行卡信息
	Bank getBank(String user_account);
	
	/**
	 * 添加用户银行卡
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
