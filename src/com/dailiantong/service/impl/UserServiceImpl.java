package com.dailiantong.service.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.UserDao;
import com.dailiantong.dao.impl.UserDaoImpl;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public UserAccount getUserAccount(String userAccount) {
		
		return userDao.getUserAccount(userAccount);
		
	}

	@Override
	public int addUserAccount(UserAccount user) {
		
		return userDao.addUserAccount(user);
	}

	@Override
	public List<Map<String,Object>> getListMapUser(String where ) {
		return userDao.getListMapUser(where);
	}
	
	@Override
	public void delUser(String account) {

		int i= userDao.delUser(account);
		if(i==1){
			System.out.println("É¾³ý"+i+"Ìõ¼ÇÂ¼");
		}
		
	}


	

}
