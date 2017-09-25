package com.dailiantong.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dailiantong.dao.UserDao;
import com.dailiantong.dao.impl.UserDaoImpl;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.UserAccountService;
import com.dailiantong.service.impl.UserAccountServiceImpl;

public class UserTest {
//	public static void main(String[] args) {
//		UserAccount user = new UserAccount();
//		user.setUser_account("123456");
//		user.setUser_email("321654");
//		user.setUser_nickName("asd");
//		UserDao userdao = new UserDaoImpl();
////		userdao.findAll();
//	}
	
	
	@Test
	public void showAll(){
		UserDao userDao = new UserDaoImpl();
//		int where=1;
		List<Map<String,Object>> map = userDao.getListMapUser("2");
		
		System.err.println(map);
	}
	
	
	
	public void getUserAccount(){
		UserAccountService useraccountservice =new UserAccountServiceImpl(); 
		List<Map<String, Object>> list=useraccountservice.getListUserAccount("13778736125");
		
		System.out.println(list);
	}
}