package com.dailiantong.dao.impl;

import com.dailiantong.dao.ManagerDao;
import com.dailiantong.pojo.Manager;
import com.dailiantong.util.JdbcUtils;

public class ManagerDaoImpl extends JdbcUtils implements ManagerDao {

	@Override
	public Manager getManager(String managerAccount) {
		String sql = "select * from manager where manager_account = ?";
		Object[] objects = {managerAccount};
		return getBean(sql, Manager.class, objects);
	}

}
