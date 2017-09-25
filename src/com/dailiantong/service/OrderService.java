package com.dailiantong.service;

import java.util.List;
import java.util.Map;

import com.dailiantong.pojo.Order;

public interface OrderService {
	
	/**
	 * ��õ�ǰ�û������з���
	 * @param user_account
	 * @return
	 */
	List<Map<String, Object>> getListReleaseOrder(String user_account);
	/**
	 * ��õ�ǰ�û������нӵ�
	 * @param use_user_account
	 * @return
	 */
	List<Map<String, Object>> getListReceiveOrder(String use_user_account);
	/**
	 * ��õ������з��Ķ���
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
	/**
	 * ���շ��������ж���
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder(int where );
	/**
	 * ���շ��������ж���
	 * admin
	 * @return
	 */
	List<Map<String, Object>> getListAdminOrder( );
	/**
	 * ���������ɵĶ���
	 * admin
	 * @return
	 */
	List<Order> getListFinishAdminOrder();
	/**
	 * ��״̬���ȫ������
	 * @param order_status
	 * @return
	 */
	List<Map<String, Object>> getListAllOrder(String order_status, String user_account, String type);
	/**
	 * ���¶���
	 * @param order
	 * @return
	 */
	String updateOrder(Order order, String payPwd);
	/**
	 * ɾ������
	 * @param integer
	 * @return
	 */
	String deleteOrder(String order_id, String type, String methodType);
	/**
	 * �����ò�ͬ��Ϸ�Ķ���
	 * @param game_Name
	 * @return
	 */
	List<Map<String, Object>> getListOrderByGame_name(String game_Name, String user_account, String type);
	
	/**
	 * ����order_id ��ѯ
	 * @param order_id
	 * @return
	 */
	List<Map<String, Object>> findOrder(String order_id, String type, String user_account);
	/**
	 * �����۸������ѯ
	 * @param order_MinPrice
	 * @param order_MaxPrice
	 * @param i
	 * @return
	 */
	List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account);
	/**
	 * ��ȡ���ж�������
	 * @return
	 */
	int getOrderNum();
	/**
	 * �û��ӵ�
	 * @param order_id
	 * @param user_account
	 * @param order_price 
	 * @return
	 */
	String recevieOrder(String order_id, String user_account, String payPwd);
	/**
	 * ����ÿ����Ϸ����������
	 * @return
	 */
	 List<Map<String, Object>> getListMapOrderNumByGame();
	 /**
	  * ͨ����Ϸ�����ظ���Ϸ����Ϸ��������������
	  * @return
	  */
	 List<Map<String, Object>> getListMapOrderNumByGanmeName(String name);
	 /**
	  * ���붩��
	  * @param order
	  * @param payPwd
	  * @return
	  */
	String insertOrder(Order order, String payPwd);

}
