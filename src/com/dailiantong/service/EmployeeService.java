package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Employee;

public interface EmployeeService {
	/**
	 * 获得员工的所有信息
	 * @param user_account
	 * @return
	 */
	public List<Map<String, Object>> getListEmployee(String user_account);
	/**
	 * 删除员工
	 * @param order_id
	 * @return
	 */
	int deleteEmployee(String employee,String user_account);
	/**
	 * 添加员工
	 * @param user_account
	 * @return
	 */
	int insertEmployee(String user_account, String employee);
	/**
	 * 获得员工详细详细
	 * @param order_id
	 * @return
	 */
//	Employee findEmployee(String order_id);
//	int findEmployee(String order_id);
	List<Map<String, Object>> findEmployee(String employee);
	
}
