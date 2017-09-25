package com.dailiantong.service.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.BankDao;
import com.dailiantong.dao.DongjieDao;
import com.dailiantong.dao.EmployeeDao;
import com.dailiantong.dao.OrderDao;
import com.dailiantong.dao.PlatformMoneyDao;
import com.dailiantong.dao.UserAccountDao;
import com.dailiantong.dao.impl.BankDaoImpl;
import com.dailiantong.dao.impl.DongjieDaoImpl;
import com.dailiantong.dao.impl.EmployeeDaoImpl;
import com.dailiantong.dao.impl.OrderDaoImpl;
import com.dailiantong.dao.impl.PlatformMoneyDaoIml;
import com.dailiantong.dao.impl.UserAccountDaoImpl;
import com.dailiantong.pojo.Bank;
import com.dailiantong.pojo.DongjieLog;
import com.dailiantong.pojo.Order;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.OrderService;
import com.dailiantong.util.DataUtils;

public class OrderServiceImpl implements OrderService {
	
	private PlatformMoneyDao platformMoneyDao = new PlatformMoneyDaoIml();
	private OrderDao orderDao = new OrderDaoImpl();
	private BankDao bankDao = new BankDaoImpl();
	private UserAccountDao userAccountDao = new UserAccountDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private DongjieDao dongjieDao = new DongjieDaoImpl();
	
	@Override
	public List<Map<String, Object>> getListReleaseOrder(String user_account) {
		return orderDao.getListReleaseOrder(user_account);
	}

	@Override
	public List<Map<String, Object>> getListReceiveOrder(String use_user_account) {
		return orderDao.getListReceiveOrder(use_user_account);
	}

	@Override
	public List<Map<String, Object>> getListAllOrder(String order_status, String user_account, String type) {
		if("releaseOrder".equals(type)){
			return orderDao.getListAllOrderL(order_status, user_account);
		}
		if("receiveOrder".equals(type)){
			return orderDao.getListAllOrderC(order_status,user_account);
		}
		return orderDao.getListOrder(4,user_account);
	}

	@Override
	public List<Order> getListTodayAdminOrder() {
		return orderDao.getListTodayAdminOrder();
	}

	@Override
	public List<Order> getListTodayFinishAdminOrder() {
		return orderDao.getListTodayFinishAdminOrder();
	}

	@Override
	public List<Map<String, Object>> getListAdminOrder(int where ) {
		return orderDao.getListAdminOrder(where);
	}
	@Override
	public List<Map<String, Object>> getListAdminOrder( ) {
		return orderDao.getListAdminOrder();
	}
	@Override
	public List<Order> getListFinishAdminOrder() {
		return orderDao.getListFinishAdminOrder();
	}

	@Override
	public String updateOrder(Order order, String payPwd) {
		UserAccount userAccount = userAccountDao.getUserAccount(order.getUser_account());
		Order order2 = orderDao.getOrders(order.getOrder_id());
		if(order2.getOrder_status() != 4) {
			return "�˵��ѽ�,�޷�ֱ���޸�,�����¼�Э��";
		}
		if(bankDao.getBank(userAccount.getUser_account()) == null) {
			return "�û�δ������п�!";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())) {
			return "֧���������";
		}
		if(order.getOrder_price()>(platformMoneyDao.getMoney(order.getUser_account()).getPlatform_usableMoney())) {
			return "�û��ʽ���";
		}
		orderDao.updateOrder(order);
		platformMoneyDao.updateUsableMoney(userAccount.getUser_account(), -(order.getOrder_price()-order2.getOrder_price()));
		platformMoneyDao.updateFreezeMoney(userAccount.getUser_account(), (order.getOrder_price()-order2.getOrder_price()));
		return "���³ɹ�";
	}
	
	@Override
	public String deleteOrder(String order_id, String userType, String methodType) {
		Order order = orderDao.getOrders(order_id);
		DongjieLog dongjieLog;
		if("releaseOrder".equals(userType)) {//�ϼҲ���
			if(order.getOrder_status() == 6) {//ɾ������
				orderDao.deleteOrder(order_id);
				return "ɾ���ɹ�";
			}
			if(order.getOrder_status() == 4){
				orderDao.deleteOrder(order_id);
				platformMoneyDao.updateUsableMoney(order.getUser_account(), (order.getOrder_price()));
				platformMoneyDao.updateFreezeMoney(order.getUser_account(), (-order.getOrder_price()));
				dongjieLog = new DongjieLog();
				dongjieLog.setUser_account(order.getUser_account());
				dongjieLog.setDongjie_time(DataUtils.getDate());
				dongjieLog.setDongjie_money("-"+(order.getOrder_price()));
				return "ɾ�������ɹ�";
			}
			if(order.getOrder_status() == 1) {//�����������
				//�ϼ�-�¼Ҷ����ʽ����--��Ǯ�����Ķ���״̬
				orderDao.updateOrder(order_id, "", 0);
				platformMoneyDao.updateUsableMoney(order.getUser_account(), (-order.getOrder_bond()));
				platformMoneyDao.updateFreezeMoney(order.getUse_user_account(), (-order.getOrder_bond()));
				platformMoneyDao.updateUsableMoney(order.getUse_user_account(), (order.getOrder_bond()+order.getOrder_price()));
				dongjieLog = new DongjieLog();
				dongjieLog.setUser_account(order.getUser_account());
				dongjieLog.setDongjie_time(DataUtils.getDate());
				dongjieLog.setDongjie_money("-"+(order.getOrder_price()));
				dongjieDao.addDongjieLog(dongjieLog);
				dongjieLog.setUser_account(order.getUse_user_account());
				dongjieLog.setDongjie_time(DataUtils.getDate());
				dongjieLog.setDongjie_money("-"+(order.getOrder_bond()));
				dongjieDao.addDongjieLog(dongjieLog);
				return "�������,�������";
			}
		}
		if("receiveOrder".equals(userType)) {//�¼Ҳ���
			if(order.getOrder_status() == 5 && "finish".equals(methodType)) {//�������,�޸Ķ���״̬
				orderDao.repealOrder(order_id, "1");
				return "�����ɹ�,�����ϼ���֤";
			}
			if(order.getOrder_status() == 6) {//ɾ������
				orderDao.updateOrder(order_id, "", 6);
				return "ɾ���ɹ�";
			}
			
		}
		/*
		 * �쳣��������--���¼Ҷ��ܲ���
		 * ���磺�˵�������---
		 */
		if(order.getOrder_status() == 3) {
			orderDao.updateOrder(order_id, "", 2);
			platformMoneyDao.updateUsableMoney(order.getUser_account(), (order.getOrder_price()));
			platformMoneyDao.updateFreezeMoney(order.getUser_account(), (-order.getOrder_price()));
			platformMoneyDao.updateFreezeMoney(order.getUse_user_account(), (-order.getOrder_bond()));
			platformMoneyDao.updateUsableMoney(order.getUse_user_account(), (order.getOrder_bond()));
			dongjieLog = new DongjieLog();
			dongjieLog.setUser_account(order.getUser_account());
			dongjieLog.setDongjie_time(DataUtils.getDate());
			dongjieLog.setDongjie_money("-"+(order.getOrder_price()));
			dongjieDao.addDongjieLog(dongjieLog);
			dongjieLog.setUser_account(order.getUse_user_account());
			dongjieLog.setDongjie_time(DataUtils.getDate());
			dongjieLog.setDongjie_money("-"+(order.getOrder_bond()));
			dongjieDao.addDongjieLog(dongjieLog);
			return "��֤�ɹ�,ͬ�⳷��";
		}
		/*
		 * ��������,���� Ϊ�쳣״̬
		 */
		if(order.getOrder_status() == 5 && "repeal".equals(methodType)) {
			orderDao.repealOrder(order_id, "3");
			return "����������,�ȴ��Է���֤";
		}
		return "�����ѱ��ӻ�δ���,�޷�ɾ��";
	}
	
	@Override
	public List<Map<String, Object>> getListOrderByGame_name(String game_Name, String user_account, String type) {
		if("releaseOrder".equals(type)) {
			return orderDao.getListOrderByGL(game_Name,user_account);
		}
		if("receiveOrder".equals(type)) {
			return orderDao.getListOrderByGC(game_Name,user_account);
		}
		return orderDao.getListOrderByG(game_Name, 4, user_account);
	}
	
	@Override
	public List<Map<String, Object>> findOrder(String order_id, String type, String user_account) {
		if("releaseOrder".equals(type)) {
			return orderDao.getOrderL(order_id, user_account);
		}
		if("receiveOrder".equals(type)) {
			return orderDao.getOrderC(order_id, user_account);
		}
		if("hallOrder".equals(type)) {
			return orderDao.getOrderA(order_id, 4, user_account);
		}
		return orderDao.getOrder(order_id);
	}

	@Override
	public List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account) {
		return orderDao.getListOrderByPrice(order_MinPrice, order_MaxPrice, i, user_account);
	}

	@Override
	public int getOrderNum() {
		return orderDao.getOrderNum();
	}
	
	@Override
	public String recevieOrder(String order_id, String user_account, String payPwd) {
		Bank bank = bankDao.getBank(user_account);
		Order order = orderDao.getOrders(order_id);
		DongjieLog dongjieLog;
		UserAccount userAccount = userAccountDao.getUserAccount(user_account);
		PlatformMoney money = platformMoneyDao.getMoney(user_account);
		if(bank == null) {
			return "�û�Ϊ������п�";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())) {
			return "֧���������";
		}
		if(money.getPlatform_usableMoney() < order.getOrder_bond()) {
			return "�û��ʽ���";
		}
		orderDao.updateOrder(order_id, user_account, 1);
		orderDao.repealOrder(order_id, "5");
		employeeDao.insertEmployee(order.getUser_account(), user_account);
		platformMoneyDao.updateUsableMoney(userAccount.getUser_account(), -order.getOrder_bond());
		platformMoneyDao.updateFreezeMoney(userAccount.getUser_account(), order.getOrder_bond());
		dongjieLog = new DongjieLog();
		dongjieLog.setUser_account(user_account);
		dongjieLog.setDongjie_time(DataUtils.getDate());
		dongjieLog.setDongjie_money("+"+(order.getOrder_bond()));
		dongjieDao.addDongjieLog(dongjieLog);
		return "�ӵ��ɹ�";
	}

	@Override
	public  List<Map<String, Object>> getListMapOrderNumByGame() {
		return orderDao.getListMapOrderNumByGame();
	}

	@Override
	public List<Map<String, Object>> getListMapOrderNumByGanmeName(String name) {
		// TODO Auto-generated method stub
		return orderDao.getListMapOrderNumByGanmeName(name);
	}

	@Override
	public String insertOrder(Order order, String payPwd) {
		DongjieLog dongjieLog;
		UserAccount userAccount = userAccountDao.getUserAccount(order.getUser_account());
		if(bankDao.getBank(userAccount.getUser_account()) == null){
			return "�û�δ������п�!";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())){
			return "֧���������";
		}
		if(order.getOrder_price()>(platformMoneyDao.getMoney(order.getUser_account()).getPlatform_usableMoney())){
			return "�û��ʽ���";
		}
		orderDao.insertOrder(order);
		orderDao.repealOrder(order.getOrder_id(), "4");
		platformMoneyDao.updateUsableMoney(userAccount.getUser_account(), -order.getOrder_price());
		platformMoneyDao.updateFreezeMoney(userAccount.getUser_account(), order.getOrder_price());
		dongjieLog = new DongjieLog();
		dongjieLog.setUser_account(order.getUser_account());
		dongjieLog.setDongjie_time(DataUtils.getDate());
		dongjieLog.setDongjie_money("+"+(order.getOrder_price()));
		dongjieDao.addDongjieLog(dongjieLog);
		return "�����ɹ�";
	}

}
