package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.ChildUserDao;
import com.dailiantong.dao.EmployeeDao;
import com.dailiantong.pojo.ChildUser;
import com.dailiantong.pojo.Employee;
import com.dailiantong.pojo.Order;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class ChildUserDaoImpl extends JdbcUtils implements ChildUserDao{

	@Override
	public List<ChildUser> getListChildUser(String user_account) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM child_user WHERE user_account = ?";
		Object[] objects = {user_account};
		PageUtils.pagination(getList(sql, ChildUser.class, objects).size());
		
		
		sql = "SELECT * FROM child_user WHERE user_account = ? limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e=5;
		int s= (PageUtils.page-1)*5;
		
		Object[] objects2 = {user_account,s,e};
		return getList(sql, ChildUser.class, objects2);
	}

	@Override
	public int updateChildUser(ChildUser childuser) {
		String sql = "update child_user set child_name=?,child_password=?,child_money=?,child_root=? where child_id = ?";
		Object[] objects = {childuser.getChild_name(),childuser.getChild_password(),childuser.getChild_money(),childuser.getChild_root(),childuser.getChild_id()};
		return updataAll(sql, objects);
	}

	@Override
	public int deleteChildUser(String child_id) {
		String sql = "delete from child_user where child_id = ?";
		Object[] objects = {child_id};
		return updataAll(sql, objects);
	}

	@Override
	public int insertChildUser(ChildUser childuser) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO child_user VALUES (null,?,?,?,?,?,?,?); ";
		Object[] objects = {childuser.getUser_account(),childuser.getChild_account(),childuser.getChild_name(),
				childuser.getChild_password(),childuser.getChild_money(),childuser.getChild_root(),
				childuser.getChild_time()};
		return updataAll(sql, objects);
	}

	@Override
	public List<ChildUser> findChildUser(String child_id) {
		String sql = "SELECT * FROM child_user WHERE child_id = ?";
		Object[] objects = {child_id};
		return getList(sql, ChildUser.class, objects);
	}
	
	public ChildUser findByChildUser(String child_id) {
		String sql = "SELECT * FROM child_user WHERE child_id = ?";
		Object[] objects = {child_id};
		return getBean(sql, ChildUser.class, objects);
	}

}
