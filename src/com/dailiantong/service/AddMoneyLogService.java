package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.AddMoneyLog;

public interface AddMoneyLogService {
	
	/**
	 * ��ֵ �����³�ֵ��ϸ
	 * @param addMoneyLog
	 * @return
	 */
	int upMoneyLog(AddMoneyLog addMoneyLog);
	

	/**
	 * ���س�ֵ��¼
	 * @return
	 */
	List<AddMoneyLog> getAddMoneyLogs(String user_account);
	
	/**
	 * ɾ����ֵ��¼
	 * @param money_id
	 * @return
	 */
	int delAddmoneyLog(int money_id);
	
}
