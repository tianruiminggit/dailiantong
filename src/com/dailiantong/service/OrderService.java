package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Order;

public interface OrderService {
	
	/**
	 * 获得当前用户的所有发单
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListReleaseOrder(String user_account);
	/**
	 * 获得当前用户的所有接单
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getListReceiveOrder(String use_user_account);
	/**
	 * 获得当日所有发的订单
	 * admin
	 * @return
	 */
	List<Order> getListTodayAdminOrder();
	/***
	 * 获得当日所有完成的订单
	 * admin
	 * @return
	 */
	List<Order> getListTodayFinishAdminOrder();
	/**
	 * 按照分类获得所有订单
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder(int where );
	/**
	 * 按照分类获得所有订单
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder( );
	/**
	 * 获得所有完成的订单
	 * admin
	 * @return
	 */
	List<Order> getListFinishAdminOrder();
	/**
	 * 分状态获得全部订单
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrder(String order_status, String user_account, String type);
	/**
	 * 更新订单
	 * @param order
	 * @return
	 */
	String updateOrder(Order order, String payPwd);
	/**
	 * 删除订单
	 * @param integer
	 * @return
	 */
	String deleteOrder(String order_id, String type, String methodType);
	/**
	 * 分类获得不同游戏的订单
	 * @param game_Name
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGame_name(String game_Name, String user_account, String type);
	
	/**
	 * 按照order_id 查询
	 * @param order_id
	 * @return
	 */
	List<Map<String, Object>> findOrder(String order_id, String type, String user_account);
	/**
	 * 给定价格区域查询
	 * @param order_MinPrice
	 * @param order_MaxPrice
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account);
	/**
	 * 获取所有订单数量
	 * @return
	 */
	int getOrderNum();
	/**
	 * 用户接单
	 * @param order_id
	 * @param user_account
	 * @param order_price 
	 * @return
	 */
	String recevieOrder(String order_id, String user_account, String payPwd);
	/**
	 * 返回每个游戏订单的数量
	 * @return
	 */
	 List<Map<String, Object>> getListMapOrderNumByGame();
	 /**
	  * 通过游戏名返回该游戏的游戏名，订单总数量
	  * @return
	  */
	 List<Map<String, Object>> getListMapOrderNumByGanmeName(String name);
	 /**
	  * 插入订单
	  * @param order
	  * @param payPwd
	  * @return
	  */
	String insertOrder(Order order, String payPwd);

}
