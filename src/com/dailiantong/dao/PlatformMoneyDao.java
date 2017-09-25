package com.dailiantong.dao;

import com.dailiantong.pojo.PlatformMoney;

public interface PlatformMoneyDao {
	/**
	 * �����û���ѯ�Լ��˻��ĸ�ƽ̨�ʽ�
	 * @param user_account
	 * @return
	 */
	PlatformMoney getMoney (String user_account);
	
	/**
	 * �޸�ƽ̨�����ʽ�
	 * @param pMoney
	 * @return
	 */
	int upMoney(PlatformMoney pMoney);
	/**
	 * ���¿����ʽ�
	 * @param user_account
	 * @param money
	 * @return
	 */
	int updateUsableMoney(String user_account, double money);
	/**
	 * ���¶����ʽ�
	 * @param user_account
	 * @param money
	 * @return
	 */
	int updateFreezeMoney(String user_account, double money);
}
