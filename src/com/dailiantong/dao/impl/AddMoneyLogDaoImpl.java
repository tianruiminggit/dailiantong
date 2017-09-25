package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.AddMoneyLogDao;
import com.dailiantong.pojo.AddMoneyLog;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class AddMoneyLogDaoImpl extends JdbcUtils implements AddMoneyLogDao {

	@Override
	public int insertMoneyLog(AddMoneyLog addMoneyLog) {
		String sql="insert into addmoneylog value(null,?,?,?)";
		Object[] objects={addMoneyLog.getUser_account(),addMoneyLog.getCongzhi_time(),addMoneyLog.getAddMoney()};
		return updataAll(sql, objects);
	}

	@Override
	public List<AddMoneyLog> getAddMoneyLogs(String user_account) {
		String sql="select * from addmoneylog where user_account = ?";
		//获得总页数
		PageUtils.pagination(getList(sql, AddMoneyLog.class,user_account).size());
		
		sql="select * from addmoneylog where user_account = ? order by addMoney_id desc limit ?,?";
		
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		
		//设置每页显示条数
		
		int e= 5;
		//每页显示起始位置
		int s=(PageUtils.page-1)*5;
		Object[] objects ={user_account,s,e};
		return getList(sql, AddMoneyLog.class,objects);
	}

	@Override
	public int delAddmoneyLog(int money_id) {
		String sql="delete from addmoneylog where addMoney_id = ?";
		Object[] objects={money_id};
		return updataAll(sql, objects);
	}

}
