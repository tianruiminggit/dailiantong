package com.dailiantong.dao.impl;



import com.dailiantong.dao.MoneyDao;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.util.JdbcUtils;

public class MoneyDaoImpl extends JdbcUtils implements MoneyDao {

	@Override
	public PlatformMoney getListMoney(String user_account) {
		String sql="select * from platformmoney where user_account = ?";
		Object[] objects={user_account};
		return getBean(sql, PlatformMoney.class, objects);
	}

	@Override
	public int updateUsableMoney(String user_account, double money) {
		String sql = "update platformmoney set platform_usableMoney = platform_usableMoney+(?) where user_account=?";
		Object[] objects = {money, user_account};
		return updataAll(sql, objects);
	}

	@Override
	public int updateFreezeMoney(String user_account, double money) {
		String sql = "update platformmoney set platform_freezeMoney = platform_freezeMoney+(?) where user_account=?";
		Object[] objects = {money, user_account};
		return updataAll(sql, objects);
	}
	
}
