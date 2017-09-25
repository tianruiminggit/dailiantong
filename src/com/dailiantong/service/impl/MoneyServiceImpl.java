package com.dailiantong.service.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.MoneyDao;
import com.dailiantong.dao.impl.MoneyDaoImpl;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.service.MoneyService;

public class MoneyServiceImpl implements MoneyService {
	
	private MoneyDao moneyDao = new MoneyDaoImpl();

	@Override
	public PlatformMoney getListMoney(String user_account) {
		// TODO Auto-generated method stub
		return moneyDao.getListMoney(user_account);
	}
	
}