package com.dailiantong.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dailiantong.dao.OrderDao;
import com.dailiantong.dao.impl.OrderDaoImpl;
import com.dailiantong.pojo.Order;

public class OrderTest {
	private OrderDao orderDao;
	@Test
	public void getAllOrder(){
		orderDao = new OrderDaoImpl();
		List<Map<String, Object>> order = orderDao.getListAdminOrder();
		System.out.println(order);
	}
}
