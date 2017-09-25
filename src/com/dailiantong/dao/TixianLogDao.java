package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.TixianLog;

public interface TixianLogDao {
	/**
	 * ������־���
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
