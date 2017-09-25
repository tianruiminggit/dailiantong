package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.TixianLog;

public interface TixianLogDao {
	/**
	 * 提现日志添加
	 * @param tixianLog
	 * @return
	 */
	int insertTixianLog(TixianLog tixianLog);
	
	/**
	 * 获得提现日志
	 */
	List<TixianLog> getListTixianLogs(String user_account);
	
	int delTixianLog(int tixian_id);
}
