package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Employee;

public interface EmployeeDao {
    /**
     * ��ѯԱ����������Ϣ
     * @param user_account
     * @return
     */
	List<Map<String, Object>> getListEmployee(String user_account);
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
	 * ��ѯ����Ա������Ϣ
	 * @param employee
	 * @return
	 */
	List<Map<String, Object>> findEmployee(String employee);
	
}
