package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.TixianLogDao;
import com.dailiantong.dao.impl.TixianLogDaoImpl;
import com.dailiantong.pojo.TixianLog;
import com.dailiantong.service.TixianLogService;

public class TixianLogServiceImpl implements TixianLogService {
private TixianLogDao tixianLogDao = new TixianLogDaoImpl();
	@Override
	public int insertTixianLog(TixianLog tixianLog) {
		
		return tixianLogDao.insertTixianLog(tixianLog);
	}
	@Override
	public List<TixianLog> getListTixianLogs(String user_account) {
		
		return tixianLogDao.getListTixianLogs(user_account);
	}
	@Override
	public int delTixianLog(int tixian_id) {
		
		return tixianLogDao.delTixianLog(tixian_id);
	}

}

