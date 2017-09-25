package com.dailiantong.dao;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Order;

public interface OrderDao<T> {
	
	/**
	 * ��õ�ǰ������з���
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListReleaseOrder(String user_account);
	/**
	 * ��õ�ǰ��ҵ����нӵ�
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getListReceiveOrder(String use_user_account);
	/**
	 * ��õ������������Ķ���
	 * admin
	 * @return
	 */
	List<Order> getListTodayAdminOrder();
	/***
	 * ��õ���������ɵĶ���
	 * admin
	 * @return
	 */
	List<Order> getListTodayFinishAdminOrder();
	/***
	 * ������ж���
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder();
	/***
	 * ����״̬������ж���
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder(int where);
	/**
	 * ��״̬��ѯȫ������
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrderL(String order_status, String user_account);
	/**
	 * ��״̬��ѯȫ���ӵ�
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrderC(String order_status, String user_account);
	/**
	 * ���¶���
	 * @param order
	 * @return
	 */
	int updateOrder(Order order);
	/**
	 * ɾ������
	 * @param order_id
	 * @return
	 */
	int deleteOrder(String order_id);
	/**
	 * ��������Ϸ����(��Ϸ����)
	 * @param game_Name
	 * @return
	 */
	List<Map<String, Object>> getListOrderByG(String game_Name, int order_status, String user_account);
	/**
	 * ��������Ϸ����(�ӵ�)
	 * @param game_Name
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGL(String game_Name, String user_account);
	/**
	 * ��������Ϸ����(����)
	 * @param game_Name
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGC(String game_Name, String user_account);
	/**
	 * ���ն����Ų�ѯ
	 * @param order
	 * @return
	 */
	List<Map<String, Object>> getOrder(String order_id);
	/**
	 * ���ն����Ų�ѯ(��������)
	 * @param order
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getOrderL(String order, String user_account);
	/**
	 * ���ն����Ų�ѯ(�ӵ�����)
	 * @param order
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getOrderC(String order, String use_user_account);
	/**
	 * ���ն����Ų�ѯ(�ӵ�����)
	 * @param order_id
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getOrderA(String order_id, int i, String user_account);
	/**
	 * �����۸������ö���
	 * @param order_MinPrice
	 * @param order_MaxPrice
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account);
	/**
	 * ��ѯ7��֮�ڵ�����δ�Ӷ���(��������)
	 * @param where
	 * @return
	 */
	List<Map<String, Object>> getListOrder(int where, String user_account);
	/**
	 * ͨ��ID��ѯ����
	 * @param order_id
	 * @return
	 */
	Order getOrders(String order_id);
	/**
	 * ��������
	 * @param order_id
	 * @param order_status
	 * @return
	 */
	int repealOrder(String order_id, String order_status);
	/**
	 * ���¶���(�ӵ�/)
	 * @param order_id
	 * @param use_user_account
	 * @return
	 */
	int updateOrder(String order_id, String use_user_account, int i);
	/**
	 * ��ȡ���ж���������
	 * @return
	 */
	int getOrderNum();
	/**
	 * ���������ɵĶ���
	 * @return
	 */
	List<Order> getListFinishAdminOrder();
	/**
	 * ����ÿ����Ϸ����������
	 * @return
	 */
	 List<Map<String, Object>> getListMapOrderNumByGame();
	 /**
	  * ͨ����Ϸ�����ظ���Ϸ����Ϸ��������������
	  * @param name
	  * @return
	  */
	 List<Map<String, Object>> getListMapOrderNumByGanmeName(String name);
	 /**
	  * ���붩��
	  * @param order
	  */
	int insertOrder(Order order);
}
