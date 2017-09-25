package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.PlatformMoney;

public interface MoneyDao {
	/**
	 * ��ѯ�й��ʽ��ҵ��
	 * @param user_account
	 * @return
	 */
	PlatformMoney getListMoney(String user_account);
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
