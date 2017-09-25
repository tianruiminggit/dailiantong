package com.dailiantong.service.impl;

import com.dailiantong.dao.BankDao;
import com.dailiantong.dao.impl.BankDaoImpl;
import com.dailiantong.pojo.Bank;
import com.dailiantong.service.BankService;

public class BankServiceImpl implements BankService {
private BankDao bankDao = new BankDaoImpl();
	@Override
	public Bank getBank(String user_account) {
		
		return bankDao.getBank(user_account);
	}
	@Override
	public int addBank(Bank bank) {
		
		return bankDao.addBank(bank);
	}
	@Override
	public int upBank(Bank bank) {
		
		return bankDao.upBank(bank);
	}

}
