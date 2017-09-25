package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.TixianLog;

public interface TixianLogService {
	/**
	 * 添加提现日志
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
