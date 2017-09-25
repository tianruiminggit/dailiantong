package com.dailiantong.service.impl;

import com.dailiantong.dao.PlatformMoneyDao;
import com.dailiantong.dao.impl.PlatformMoneyDaoIml;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.service.PlatformMoneyService;

public class PlatformMoneyServiceImpl implements PlatformMoneyService {
	private PlatformMoneyDao PlatformMoney= new PlatformMoneyDaoIml();
	@Override
	public PlatformMoney getMoney(String user_account) {
	
		return PlatformMoney.getMoney(user_account);
	}
	@Override
	public int  updateMoney(PlatformMoney pMoney) {
		int i=PlatformMoney.upMoney(pMoney);
		if(i==1){
			System.out.println("修改资金成功"+i+"条记录");
		}
		
		return i;
	}
	

}
