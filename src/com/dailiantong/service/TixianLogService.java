package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.TixianLog;

public interface TixianLogService {
	/**
	 * ���������־
	 * @param tixianLog
	 * @return
	 */
	int insertTixianLog(TixianLog tixianLog);
	
	
	/**
	 * ���������־
	 */
	List<TixianLog> getListTixianLogs(String user_account);
	
	int delTixianLog(int tixian_id);
}
