package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.DongjieDao;
import com.dailiantong.dao.impl.DongjieDaoImpl;
import com.dailiantong.pojo.DongjieLog;
import com.dailiantong.service.DongjieLogService;

public class DongjieLogServiceImpl implements DongjieLogService{
private DongjieDao dong = new DongjieDaoImpl();

@Override
public int addDongjieLog(DongjieLog dongjieLog) {
	
	return dong.addDongjieLog(dongjieLog);
}

@Override
public int upDongjieLog(DongjieLog dongjieLog) {

	return dong.upDongjieLog(dongjieLog);
}

@Override
public int delDongjieLog(String dongjie_id) {
	
	return dong.delDongjieLog(dongjie_id);
}

@Override
public List<DongjieLog> querDongjieLogs(String user_account) {
	
	return dong.querDongjieLogs(user_account);
}
	

}
