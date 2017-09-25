package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Order;

public interface OrderDao<T> {
	
	/**
	 * 获得当前玩家所有发单
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListReleaseOrder(String user_account);
	/**
	 * 获得当前玩家的所有接单
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getListReceiveOrder(String use_user_account);
	/**
	 * 获得当日所有所发的订单
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
	/***
	 * 获得所有订单
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder();
	/***
	 * 按照状态获得所有订单
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder(int where);
	/**
	 * 按状态查询全部发单
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrderL(String order_status, String user_account);
	/**
	 * 按状态查询全部接单
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrderC(String order_status, String user_account);
	/**
	 * 更新订单
	 * @param order
	 * @return
	 */
	int updateOrder(Order order);
	/**
	 * 删除订单
	 * @param order_id
	 * @return
	 */
	int deleteOrder(String order_id);
	/**
	 * 分类获得游戏订单(游戏大厅)
	 * @param game_Name
	 * @return
	 */
	List<Map<String, Object>> getListOrderByG(String game_Name, int order_status, String user_account);
	/**
	 * 分类获得游戏订单(接单)
	 * @param game_Name
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGL(String game_Name, String user_account);
	/**
	 * 分类获得游戏订单(发单)
	 * @param game_Name
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGC(String game_Name, String user_account);
	/**
	 * 按照订单号查询
	 * @param order
	 * @return
	 */
	List<Map<String, Object>> getOrder(String order_id);
	/**
	 * 按照订单号查询(发单界面)
	 * @param order
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getOrderL(String order, String user_account);
	/**
	 * 按照订单号查询(接单界面)
	 * @param order
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getOrderC(String order, String use_user_account);
	/**
	 * 按照订单号查询(接单大厅)
	 * @param order_id
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getOrderA(String order_id, int i, String user_account);
	/**
	 * 给定价格区域获得订单
	 * @param order_MinPrice
	 * @param order_MaxPrice
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account);
	/**
	 * 查询7天之内的所有未接订单(订单大厅)
	 * @param where
	 * @return
	 */
	List<Map<String, Object>> getListOrder(int where, String user_account);
	/**
	 * 通过ID查询订单
	 * @param order_id
	 * @return
	 */
	Order getOrders(String order_id);
	/**
	 * 撤销订单
	 * @param order_id
	 * @param order_status
	 * @return
	 */
	int repealOrder(String order_id, String order_status);
	/**
	 * 更新订单(接单/)
	 * @param order_id
	 * @param use_user_account
	 * @return
	 */
	int updateOrder(String order_id, String use_user_account, int i);
	/**
	 * 获取所有订单的数量
	 * @return
	 */
	int getOrderNum();
	/**
	 * 获得所有完成的订单
	 * @return
	 */
	List<Order> getListFinishAdminOrder();
	/**
	 * 返回每个游戏订单的数量
	 * @return
	 */
	 List<Map<String, Object>> getListMapOrderNumByGame();
	 /**
	  * 通过游戏名返回该游戏的游戏名，订单总数量
	  * @param name
	  * @return
	  */
	 List<Map<String, Object>> getListMapOrderNumByGanmeName(String name);
	 /**
	  * 插入订单
	  * @param order
	  */
	int insertOrder(Order order);
}
