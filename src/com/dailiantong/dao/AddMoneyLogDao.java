package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.AddMoneyLog;

public interface AddMoneyLogDao {
	
	/**
	 * ��ӳ�ֵ��־
	 * @param addMoneyLog
	 * @return
	 */
	int insertMoneyLog(AddMoneyLog addMoneyLog);
	
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
