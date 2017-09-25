package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.ChildUserDao;
import com.dailiantong.dao.impl.ChildUserDaoImpl;
import com.dailiantong.pojo.ChildUser;
import com.dailiantong.service.ChildUserService;
import com.google.gson.JsonElement;

public class ChildUserServiceImpl implements ChildUserService{
	
	private ChildUserDao childuserDao = new ChildUserDaoImpl();
	
	@Override
	public List<ChildUser> getListChildUser(String user_account) {
		List<ChildUser> listChildUser = childuserDao.getListChildUser(user_account);
		for(ChildUser li : listChildUser){
			System.out.println(li);
		}
		
		return listChildUser;

	}

	public int updateChildUser(ChildUser childuser) {
		// TODO Auto-generated method stub
		return childuserDao.updateChildUser(childuser);
	}

	public int deleteChildUser(String child_id) {
		return childuserDao.deleteChildUser(child_id);
	}

	@Override
	public int insertChildUser(ChildUser childuser) {
		// TODO Auto-generated method stub
		return childuserDao.insertChildUser(childuser);
	}

	public List<ChildUser> findChildUser(String child_id) {
		// TODO Auto-generated method stub
		return childuserDao.findChildUser(child_id);
	}
	
	public ChildUser findByChildUser(String child_id) {
		// TODO Auto-generated method stub
		return childuserDao.findByChildUser(child_id);
	}
}
