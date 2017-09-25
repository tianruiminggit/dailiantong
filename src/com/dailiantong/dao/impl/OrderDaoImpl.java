package com.dailiantong.dao.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.OrderDao;
import com.dailiantong.pojo.Order;
import com.dailiantong.util.DataUtils;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class OrderDaoImpl extends JdbcUtils implements OrderDao {

	@Override
	public List<Map<String, Object>> getListReleaseOrder(String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where user_account=?";
		Object[] objects = {user_account};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getListReceiveOrder(String use_user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where use_user_account=?";
		Object[] objects = {use_user_account};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getListAllOrderL(String order_status, String user_account) {
		
		
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status WHERE o.order_status = ? and user_account=?";
		Object[] objects ={order_status,user_account};
		PageUtils.pagination(getListMap(sql,objects).size());
		sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status WHERE o.order_status = ? and user_account=? limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e=5;
		int s=(PageUtils.page-1)*5;
		Object[] objects2 = {order_status,user_account,s,e};
		return getListMap(sql, objects2);
	}

	public List<Map<String, Object>> getListAllOrderC(String order_status, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status WHERE o.order_status = ? and o.use_user_account=?";
		Object[] objects ={order_status,user_account};
		PageUtils.pagination(getListMap(sql,objects).size());
		sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status WHERE o.order_status = ? and o.user_account=? limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e=5;
		int s=(PageUtils.page-1)*5;
		Object[] objects2 = {order_status,user_account ,s,e};
		return getListMap(sql, objects2);
	}
	
	@Override
	public List<Order> getListTodayAdminOrder() {
		String sql = "select * from orders where order_releaseTime > ?";
		Object[] objects = {DataUtils.getDateByDay()};
		return getList(sql, Order.class, objects);
	}

	@Override
	public List<Order> getListTodayFinishAdminOrder() {
		String sql = "select * from orders where order_finishTime > ?";
		Object[] objects = {DataUtils.getDate()};
		return getList(sql, Order.class, objects);
	}

	@Override
	public List<Map<String, Object>> getListAdminOrder(int where) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
				"where o.order_status=?";
		//返回分类查询的总页数
		PageUtils.pagination(getListMap(sql,where).size());
		
		//按照limit 查询出数据
		sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
				"where o.order_status=? limit ?,? ";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		//设置每次取出多少条
		int e=5;
		//设置开始位置（页码-1）*每页显示条数
		int s=(PageUtils.page-1)*e;
		
		Object[] objects={where,s,e};
		return getListMap(sql,objects);
	}

	@Override
	public List<Map<String, Object>> getListOrder(int where, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
				"where o.order_status=? and TIMESTAMPDIFF(DAY,order_releaseTime,?) <= order_deleteTime and user_account<>?";
		Object[] objects = {where ,DataUtils.getDate(),user_account};
		PageUtils.pagination(getListMap(sql, objects).size());
		sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
				"where o.order_status=? and TIMESTAMPDIFF(DAY,order_releaseTime,?) <= order_deleteTime and user_account<>? limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		//设置每次取出多少条
		int e=5;
		//设置开始位置（页码-1）*每页显示条数
		int s=(PageUtils.page-1)*e;
		Object[] objects2 ={where, DataUtils.getDate(), user_account,s,e};
		return getListMap(sql,objects2);
	}
	
	@Override
	public List<Map<String, Object>> getListAdminOrder() {
		String sql = "SELECT * FROM orders AS o  " +
				     "INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
				     "order by o.order_id desc";
		//获得总页数
		PageUtils.pagination(getListMap(sql).size());
		
		sql="SELECT * FROM orders AS o  " +
			"INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status " +
			"order by o.order_id desc LIMIT ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e = 5;
		int s =(PageUtils.page-1)*e;		
		
		Object[] objects ={s,e};
		return getListMap(sql,objects);
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "UPDATE orders SET order_price=?,order_finishTime=?," +
				"order_content=?,order_gameInfo=?," +
				"order_bond=?,order_task=? WHERE order_id=?";
		Object[] objects = {order.getOrder_price(),order.getOrder_finishTime(),
				order.getOrder_content(),order.getOrder_gameInfo(),
				order.getOrder_bond(),order.getOrder_task(),order.getOrder_id()};
		return updataAll(sql, objects);
	}
	
	@Override
	public int deleteOrder(String order_id) {
		String sql = "delete from orders where order_id = ?";
		Object[] objects = {order_id};
		return updataAll(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getListOrderByG(String game_Name, int order_status, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where order_gameName = ? and TIMESTAMPDIFF(DAY,order_releaseTime,?) <= order_deleteTime and o.order_status = ? and user_account<>?";
		Object[] objects = {game_Name, DataUtils.getDate(), order_status, user_account};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getOrder(String order) {
		String sql="SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where o.order_id= ?";
		Object[] objects = {order};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getOrderL(String order, String user_account) {
		String sql="SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where o.order_id= ? and user_account=?";
		Object[] objects = {order, user_account};
		return getListMap(sql, objects);
	}
	
	@Override
	public List<Map<String, Object>> getOrderC(String order, String use_user_account) {
		String sql="SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where o.order_id= ? and use_user_account=?";
		Object[] objects = {order, use_user_account};
		return getListMap(sql, objects);
	}
	
	@Override
	public List<Map<String, Object>> getOrderA(String order_id, int i, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status WHERE order_id = ? AND o.order_status=? and TIMESTAMPDIFF(DAY,order_releaseTime,?) <= order_deleteTime and user_account<>?";
		Object[] objects = {order_id, i, DataUtils.getDate(), user_account};
		return getListMap(sql, objects);
	}
	
	@Override
	public List<Map<String, Object>> getListOrderByGL(String game_Name, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where order_gameName = ? and user_account=?";
		Object[] objects = {game_Name,user_account};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getListOrderByGC(String game_Name, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where order_gameName = ? and use_user_account=?";
		Object[] objects = {game_Name,user_account};
		return getListMap(sql, objects);
	}

	@Override
	public List<Map<String, Object>> getListOrderByPrice(String order_MinPrice,
			String order_MaxPrice, int i, String user_account) {
		String sql = "SELECT * FROM orders AS o INNER JOIN order_status AS o_s ON o.order_status=o_s.order_status where (o.order_price BETWEEN ? AND ?) and o.order_status=? and TIMESTAMPDIFF(DAY,order_releaseTime,?) <= order_deleteTime and user_account<>?";
		Object[] objects = {order_MinPrice,order_MaxPrice, i, DataUtils.getDate(), user_account};
		return getListMap(sql, objects);
	}

	@Override
	public Order getOrders(String order_id) {
		String sql = "select * from orders where order_id=?";
		Object[] objects = {order_id};
		return getBean(sql, Order.class, objects);
	}

	@Override
	public int repealOrder(String order_id, String order_status) {
		String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?";
		Object[] objects = {order_status, order_id};
		return updataAll(sql, objects);
	}

	@Override
	public int updateOrder(String order_id, String use_user_account, int t) {
		String sql;
		if(t == 0){
			sql = "update orders set order_returnTime=?, order_status=6 where order_id=?";
			Object[] objects = {DataUtils.getDate(), order_id};
			return updataAll(sql, objects);
		}
		if(t == 1){
			sql = "update orders set use_user_account=?, order_receiveTime=? where order_id=?";
			Object[] objects = {use_user_account, DataUtils.getDate(), order_id};
			return updataAll(sql, objects);
		}
		if(t == 2){
			sql = "update orders set use_user_account=?, order_receiveTime=?, order_status=4 where order_id=?";
			Object[] objects = {null, null, order_id};
			return updataAll(sql, objects);
		}
		sql = "update orders set use_user_account=? where order_id=?";
		Object[] objects = {use_user_account, order_id};
		return updataAll(sql, objects);
	}

	@Override
	public int getOrderNum() {
		String sql = "select * from orders";
		return getList(sql, Order.class).size();
	}

	@Override
	public List getListFinishAdminOrder() {
		String sql = "select * from orders where order_status = 6";
		return getList(sql, Order.class);
	}

	@Override
	public List<Map<String, Object>> getListMapOrderNumByGame() {
		String sql = "SELECT  game_name AS name,(CASE WHEN ISNULL(orders.ordercount) THEN 0 ELSE orders.ordercount END) AS value FROM game LEFT JOIN"+ 
		"(SELECT orders.`order_gameName`, COUNT(*) AS ordercount FROM orders GROUP BY order_gameName ) AS orders"+
		 " ON game.`game_name`=orders.`order_gameName`";
		return getListMap(sql);
	}

	@Override
	public List<Map<String, Object>> getListMapOrderNumByGanmeName(String name) {
		String sql ="SELECT COUNT(*) AS value FROM orders"+ 
		" WHERE DATE_FORMAT(order_releaseTime,'%Y%m')=DATE_FORMAT( CURDATE( ) , '%Y%m' )"+
		 " AND order_gameName = ?  GROUP BY DATE_FORMAT(order_releaseTime,'%Y%m%d')";
		Object[] objects ={name};
		return getListMap(sql,objects);
	}

	@Override
	public int insertOrder(Order order) {
		String sql = "INSERT INTO orders(order_id,user_account,order_price,order_finishTime,order_deleteTime," +
				"order_content,order_gameInfo,order_bond,order_gameName,order_gameAccount," +
				"order_gamePassword,order_task,order_releaseTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objects = {order.getOrder_id(), order.getUser_account(),order.getOrder_price(),order.getOrder_finishTime(),order.getOrder_deleteTime(),order.getOrder_content()
				,order.getOrder_gameInfo(),order.getOrder_bond(),order.getOrder_gameName(),order.getOrder_gameAccount()
				,order.getOrder_gamePassword(),order.getOrder_task(),DataUtils.getDate()};
		return updataAll(sql, objects);
	}

}
