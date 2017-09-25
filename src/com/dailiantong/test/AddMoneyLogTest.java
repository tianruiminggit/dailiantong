package com.dailiantong.test;

import java.util.Date;

import org.junit.Test;

import com.dailiantong.dao.AddMoneyLogDao;
import com.dailiantong.dao.impl.AddMoneyLogDaoImpl;
import com.dailiantong.pojo.AddMoneyLog;
import com.dailiantong.pojo.Bank;
import com.dailiantong.service.BankService;
import com.dailiantong.service.impl.BankServiceImpl;

public class AddMoneyLogTest {
	
	
	public void addMoneyTest(){
		AddMoneyLogDao addMoneyLogDao = new AddMoneyLogDaoImpl();
		AddMoneyLog addMoneyLog = new AddMoneyLog();
		addMoneyLog.setAddMoney(50);
		addMoneyLog.setCongzhi_time(new Date());
		addMoneyLog.setUser_account("137787361236");
		int i=addMoneyLogDao.insertMoneyLog(addMoneyLog);
		System.out.println(i);
	}
	
	@Test
	public void bankTest(){
		 BankService bankService = new BankServiceImpl();
		Bank bMoney = bankService.getBank("137787361236");
		//ԭ���е�-��ֵ���
	    System.out.println("��ǰ�û����п����Ϊ��"+bMoney.getBank_money()); 
	    
	    
	    
		bMoney.setBank_money(bMoney.getBank_money()-20);
		
		//�������п������� bank_money
		bankService.upBank(bMoney);
	
		
	}
}
