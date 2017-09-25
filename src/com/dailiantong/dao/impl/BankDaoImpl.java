package com.dailiantong.dao.impl;

import com.dailiantong.dao.BankDao;
import com.dailiantong.pojo.Bank;
import com.dailiantong.util.JdbcUtils;

public class BankDaoImpl extends JdbcUtils implements BankDao {

	@Override
	public Bank getBank(String user_account) {
		String sql = "select * from bank where user_account=?";
		Object[] objects = {user_account};
		return getBean(sql, Bank.class, objects);
	}

	@Override
	public int addBank(Bank bank) {
		String sql ="insert into bank values(?,?,?,?)";
		Object[] objects ={bank.getBank_num(),bank.getBank_money(),bank.getBank_name(),bank.getUser_account()};
		return updataAll(sql, objects);
	}

	@Override
	public int upBank(Bank bank) {
		String sql="update bank set bank_money =?  , bank_num = ? , bank_name = ? where user_account = ?";
		Object[] objects = {bank.getBank_money(),bank.getBank_num(),bank.getBank_num(),bank.getUser_account()};
		
		return updataAll(sql, objects);
	}

}
