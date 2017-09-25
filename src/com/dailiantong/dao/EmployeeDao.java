package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Employee;

public interface EmployeeDao {
    /**
     * 查询员工的所有信息
     * @param user_account
     * @return
     */
	List<Map<String, Object>> getListEmployee(String user_account);
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
	 * 查询单个员工的信息
	 * @param employee
	 * @return
	 */
	List<Map<String, Object>> findEmployee(String employee);
	
}
