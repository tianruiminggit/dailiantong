package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.AddMoneyLogDao;
import com.dailiantong.dao.impl.AddMoneyLogDaoImpl;
import com.dailiantong.pojo.AddMoneyLog;
import com.dailiantong.service.AddMoneyLogService;

public class AddMoneyLogServiceImpl implements AddMoneyLogService {
	private AddMoneyLogDao  addMoneyLogDao = new AddMoneyLogDaoImpl();
	@Override
	public int upMoneyLog(AddMoneyLog addMoneyLog) {
		return addMoneyLogDao.insertMoneyLog(addMoneyLog);
	}

	@Override
	public List<AddMoneyLog> getAddMoneyLogs(String user_account) {
		return addMoneyLogDao.getAddMoneyLogs(user_account);
	}

	@Override
	public int delAddmoneyLog(int money_id) {
		return addMoneyLogDao.delAddmoneyLog(money_id);
	}

}
