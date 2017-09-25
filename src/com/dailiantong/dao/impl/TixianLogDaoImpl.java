package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.TixianLogDao;
import com.dailiantong.pojo.TixianLog;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class TixianLogDaoImpl extends JdbcUtils implements TixianLogDao {

	@Override
	public int insertTixianLog(TixianLog tixianLog) {
		String sql="insert into tixianlog values(null,?,?,?)";
		Object[] objects={tixianLog.getUser_account(),tixianLog.getTixian_money(),tixianLog.getTixian_time()};
		return updataAll(sql, objects);
	}

	@Override
	public List<TixianLog> getListTixianLogs(String user_account) {
		String sql="select * from tixianlog where user_account = ?";
		PageUtils.pagination(getList(sql, TixianLog.class,user_account).size());
		
		sql="select * from tixianlog where user_account = ? order by tixian_id desc limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e=5;
		int s=(PageUtils.page-1)*5;
		Object[] objects={user_account,s,e};
		return getList(sql, TixianLog.class, objects);
	}

	@Override
	public int delTixianLog(int tixian_id) {
		String sql="delete from tixianlog where tixian_id = ?";
		Object[] objects ={tixian_id};
		return updataAll(sql, objects);
	}

}
