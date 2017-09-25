package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Employee;

public interface EmployeeService {
	/**
	 * ���Ա����������Ϣ
	 * @param user_account
	 * @return
	 */
	public List<Map<String, Object>> getListEmployee(String user_account);
	/**
	 * ɾ��Ա��
	 * @param order_id
	 * @return
	 */
	int deleteEmployee(String employee,String user_account);
	/**
	 * ���Ա��
	 * @param user_account
	 * @return
	 */
	int insertEmployee(String user_account, String employee);
	/**
	 * ���Ա����ϸ��ϸ
	 * @param order_id
	 * @return
	 */
//	Employee findEmployee(String order_id);
//	int findEmployee(String order_id);
	List<Map<String, Object>> findEmployee(String employee);
	
}
