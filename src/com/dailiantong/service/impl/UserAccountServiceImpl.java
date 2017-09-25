package com.dailiantong.service.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.UserAccountDao;
import com.dailiantong.dao.impl.UserAccountDaoImpl;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.UserAccountService;

public class UserAccountServiceImpl implements UserAccountService {
	private UserAccountDao useraccountdao = new UserAccountDaoImpl();
	@Override
	public List<Map<String, Object>> getListUserAccount(String useraccount) {
		
		return useraccountdao.getListUserAccount(useraccount);
	}

	

//	public List<UserAccount> getListUserAccount(String useraccount) {
//		// TODO Auto-generated method stub
//		UserAccountDaoImpl useraccountDao = null;
//		List<UserAccount> listEmployee = useraccountDao.getListUserAccount("13778736128");
//		for(UserAccount li : listUserAccount ){
//			System.out.println(li);
//		}
//		return getListUserAccount(null);
//	}
	
	
	@Override
	public int updateUser(UserAccount userAccount) {
		
		int i= useraccountdao.updateUser(userAccount);
		if(i==1){
			
			System.out.println("更新用户"+i+"条记录");
		}
		return i;
		
	}

	@Override
	public UserAccount getUserAccount(String user_account) {
	return useraccountdao.getUserAccount(user_account);
	}
	
}
