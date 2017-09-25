package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.AddMoneyLog;

public interface AddMoneyLogService {
	
	/**
	 * 充值 ，更新充值明细
	 * @param addMoneyLog
	 * @return
	 */
	int upMoneyLog(AddMoneyLog addMoneyLog);
	

	/**
	 * 返回充值记录
	 * @return
	 */
	List<AddMoneyLog> getAddMoneyLogs(String user_account);
	
	/**
	 * 删除充值记录
	 * @param money_id
	 * @return
	 */
	int delAddmoneyLog(int money_id);
	
}
