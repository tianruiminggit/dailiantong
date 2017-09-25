package com.dailiantong.dao.impl;

import com.dailiantong.dao.PlatformMoneyDao;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.util.JdbcUtils;

public class PlatformMoneyDaoIml extends JdbcUtils implements PlatformMoneyDao {

	@Override
	public PlatformMoney getMoney(String user_account) {
		String sql="select * from platformmoney where user_account = ?";
		Object[] objects={user_account};
		return getBean(sql, PlatformMoney.class, objects);
	}

	@Override
	public int upMoney(PlatformMoney pMoney) {
		String sql="update platformmoney set platform_usableMoney=?,platform_freezeMoney=? where user_account = ?";
		Object[] objects={pMoney.getPlatform_usableMoney(),pMoney.getPlatform_freezeMoney(),pMoney.getUser_account()};
		
		return updataAll(sql, objects);
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
