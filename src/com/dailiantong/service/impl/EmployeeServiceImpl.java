package com.dailiantong.service.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.EmployeeDao;
import com.dailiantong.dao.impl.EmployeeDaoImpl;
import com.dailiantong.pojo.Employee;
import com.dailiantong.pojo.Order;
import com.dailiantong.service.EmployeeService;
import com.google.gson.JsonElement;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public List<Map<String, Object>> getListEmployee(String user_account) {
		
		return employeeDao.getListEmployee(user_account);
	
	}

	@Override
	public int deleteEmployee(String employee,String user_account) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(employee,user_account);
	}

	@Override
	public int insertEmployee(String user_account, String employee) {
		// TODO Auto-generated method stub
		return employeeDao.insertEmployee(user_account, employee);
	}

//	public Employee findEmployee(String order_id) {
//	public int findEmployee(String order_id) {
	public List<Map<String, Object>> findEmployee(String employee) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployee(employee);
	}
}
