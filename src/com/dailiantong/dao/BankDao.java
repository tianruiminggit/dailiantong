package com.dailiantong.dao;

import com.dailiantong.pojo.Bank;

public interface BankDao {

	/**
	 * �����û���ѯ���û���ģ�����п�������Ϣ
	 * @param user_account
	 * @return
	 */
	Bank getBank(String user_account);
	
	/**
	 * ������п���
	 * @param bank
	 * @return
	 */
	int addBank(Bank bank);
	
	/**
	 * �������п�����
	 * @param bank
	 * @return
	 */
	int upBank(Bank bank);
}
