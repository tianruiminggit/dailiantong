package com.dailiantong.service.impl;

import com.dailiantong.dao.ManagerDao;
import com.dailiantong.dao.impl.ManagerDaoImpl;
import com.dailiantong.pojo.Manager;
import com.dailiantong.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	
	private ManagerDao mdao= new ManagerDaoImpl();
	@Override
	public Manager getManager(String managerAccount) {
		return mdao.getManager(managerAccount);
	}

}
