package com.dailiantong.service;

import com.dailiantong.pojo.PlatformMoney;

public interface PlatformMoneyService {

	/**
	 * �����û��˺Ų�ѯ
	 * @param user_account
	 * @return
	 */
	PlatformMoney getMoney (String user_account);
	
	/**
	 * �޸�ƽ̨�����ʽ�
	 * @param pMoney
	 * @return 
	 */
	public int updateMoney(PlatformMoney pMoney);
}
