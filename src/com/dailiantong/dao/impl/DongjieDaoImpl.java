package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.DongjieDao;
import com.dailiantong.pojo.DongjieLog;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class DongjieDaoImpl extends JdbcUtils implements DongjieDao {

	@Override
	public int addDongjieLog(DongjieLog dongjieLog) {
		String sql="insert into dongjielog values(null,?,?,?)";
		Object[] objects = {dongjieLog.getUser_account(),dongjieLog.getDongjie_time(),dongjieLog.getDongjie_money()};
		return updataAll(sql,objects);
	}

	@Override
	public int upDongjieLog(DongjieLog dongjieLog) {
		String sql="update dongjielog set user_account = ?, dongjie_time =? ,dongjie_money = ? where dongjie_id = ?";
		Object[] objects= {dongjieLog.getUser_account(),dongjieLog.getDongjie_time(),dongjieLog.getDongjie_money(),dongjieLog.getDongjie_id()};
		return updataAll(sql, objects);
	}

	@Override
	public int delDongjieLog(String dongjie_id) {
		String sql="delete from dongjielog where dongjie_id = ?";
		Object[] objects ={dongjie_id};
		return updataAll(sql, objects);
	}

	@Override
	public List<DongjieLog> querDongjieLogs(String user_account) {
		String sql="select * from dongjielog where user_account = ?";
		PageUtils.pagination(getList(sql, DongjieLog.class,user_account).size());
		
		sql ="select * from dongjielog where user_account = ? order by dongjie_time desc limit ?,?";
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		int e=5;
		int s= (PageUtils.page-1)*5;
		Object[] objects= {user_account,s,e};
		return getList(sql, DongjieLog.class, objects);
		
	}

}
