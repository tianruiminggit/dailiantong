package com.dailiantong.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dailiantong.dao.EmployeeDao;
import com.dailiantong.dao.impl.EmployeeDaoImpl;
import com.dailiantong.pojo.Employee;

public class EmployeeTest {
	@Test
	public void getListEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		List<Map<String, Object>> listEmployee = employeeDao.getListEmployee("13778736128");
		System.out.println(listEmployee);
	}
}
