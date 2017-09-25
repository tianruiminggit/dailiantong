package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.AddMoneyLog;

public interface AddMoneyLogDao {
	
	/**
	 * 添加充值日志
	 * @param addMoneyLog
	 * @return
	 */
	int insertMoneyLog(AddMoneyLog addMoneyLog);
	
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
