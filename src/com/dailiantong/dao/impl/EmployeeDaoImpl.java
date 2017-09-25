package com.dailiantong.dao.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.EmployeeDao;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.pojo.ChildUser;
import com.dailiantong.pojo.Employee;

public class EmployeeDaoImpl extends JdbcUtils implements EmployeeDao{
	
	public List<Map<String, Object>> getListEmployee(String user_account) {
		String sql = "SELECT e.user_account,e.employee,u_a.user_email,u_a.user_tel FROM employee AS e "+
	                 "INNER JOIN useraccount AS u_a ON e.employee = u_a.user_account "+
	                 "WHERE e.user_account = ?";
		
		
		Object[] objects = {user_account};
		return getListMap(sql, objects);
	}

	@Override
	public int deleteEmployee(String employee,String user_account) {
		// TODO Auto-generated method stub
		String sql = "delete from employee where employee = ? and user_account=? ";
		Object[] objects = {employee,user_account};
		return updataAll(sql, objects);
	}

	@Override
	public int insertEmployee(String user_account, String employee) {
		String sql = "INSERT INTO employee (user_account, employee) VALUES (?,?); ";
		Object[] objects = {user_account, employee};
		return updataAll(sql, objects);
	}

	@Override
	public List<Map<String, Object>> findEmployee(String employee) {
		// TODO Auto-generated method stub
		String sql="select * from useraccount where user_account = ?"; 
		 
	/*	String sql = "SELECT e.user_account,e.employee,u_a.user_email,u_a.user_tel FROM employee AS e "+
                "INNER JOIN useraccount AS u_a ON e.employee = u_a.user_account "+
                "WHERE e.employee = ?";*/
		Object[] objects = {employee};
		return getListMap(sql, objects);
	}
	
}    
