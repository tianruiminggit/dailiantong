package com.dailiantong.service;

import com.dailiantong.pojo.Bank;

public interface BankService {

	//�����û��˺Ų�ѯ���û�ģ�����п���Ϣ
	Bank getBank(String user_account);
	
	/**
	 * ����û����п�
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
