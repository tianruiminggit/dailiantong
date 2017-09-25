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
			return "账单已接,无法直接修改,请与下家协商";
		}
		if(bankDao.getBank(userAccount.getUser_account()) == null) {
			return "用户未添加银行卡!";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())) {
			return "支付密码错误";
		}
		if(order.getOrder_price()>(platformMoneyDao.getMoney(order.getUser_account()).getPlatform_usableMoney())) {
			return "用户资金不足";
		}
		orderDao.updateOrder(order);
		platformMoneyDao.updateUsableMoney(userAccount.getUser_account(), -(order.getOrder_price()-order2.getOrder_price()));
		platformMoneyDao.updateFreezeMoney(userAccount.getUser_account(), (order.getOrder_price()-order2.getOrder_price()));
		return "更新成功";
	}
	
	@Override
	public String deleteOrder(String order_id, String userType, String methodType) {
		Order order = orderDao.getOrders(order_id);
		DongjieLog dongjieLog;
		if("releaseOrder".equals(userType)) {//上家操作
			if(order.getOrder_status() == 6) {//删除订单
				orderDao.deleteOrder(order_id);
				return "删除成功";
			}
			if(order.getOrder_status() == 4){
				orderDao.deleteOrder(order_id);
				platformMoneyDao.updateUsableMoney(order.getUser_account(), (order.getOrder_price()));
				platformMoneyDao.updateFreezeMoney(order.getUser_account(), (-order.getOrder_price()));
				dongjieLog = new DongjieLog();
				dongjieLog.setUser_account(order.getUser_account());
				dongjieLog.setDongjie_time(DataUtils.getDate());
				dongjieLog.setDongjie_money("-"+(order.getOrder_price()));
				return "删除订单成功";
			}
			if(order.getOrder_status() == 1) {//订单正常完成
				//上家-下家冻结资金更新--付钱，更改订单状态
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
				return "操作完成,订单完成";
			}
		}
		if("receiveOrder".equals(userType)) {//下家操作
			if(order.getOrder_status() == 5 && "finish".equals(methodType)) {//任务完成,修改订单状态
				orderDao.repealOrder(order_id, "1");
				return "操作成功,订单上家验证";
			}
			if(order.getOrder_status() == 6) {//删除订单
				orderDao.updateOrder(order_id, "", 6);
				return "删除成功";
			}
			
		}
		/*
		 * 异常订单处理--上下家都能操作
		 * 例如：账单撤销中---
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
			return "验证成功,同意撤单";
		}
		/*
		 * 订单撤销,更新 为异常状态
		 */
		if(order.getOrder_status() == 5 && "repeal".equals(methodType)) {
			orderDao.repealOrder(order_id, "3");
			return "订单撤销中,等待对方验证";
		}
		return "订单已被接或未完成,无法删除";
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
			return "用户为添加银行卡";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())) {
			return "支付密码错误";
		}
		if(money.getPlatform_usableMoney() < order.getOrder_bond()) {
			return "用户资金不足";
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
		return "接单成功";
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
			return "用户未添加银行卡!";
		}
		if(!payPwd.equals(userAccount.getUser_payPassword())){
			return "支付密码错误";
		}
		if(order.getOrder_price()>(platformMoneyDao.getMoney(order.getUser_account()).getPlatform_usableMoney())){
			return "用户资金不足";
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
		return "发单成功";
	}

}
