package com.dailiantong.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dailiantong.dao.AppealDao;
import com.dailiantong.pojo.Appeal;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

import sun.net.www.content.text.plain;

public class AppealDaoImpl extends JdbcUtils implements AppealDao {

	@Override
	public List<Appeal> getListAdminAppeal() {
//		String sql1 = "select count(*) from appeal";
		String sql = "select * from appeal";
		PageUtils.pagination(getList(sql, Appeal.class).size());
		sql = "select * from appeal limit ?,?";
		Object[] objects = {(PageUtils.page-1)*5,5};
		return getList(sql, Appeal.class,objects);
	}

	@Override
	public List<Appeal> getTodayAppeal() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(new Date());
		Timestamp time = null;
					Date date;
					try {
						date = sdf.parse(sdate);
						time = new Timestamp(date.getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
		String sql = "select * from appeal where appeal_time > ?";
		Object[] objects = {time};
		return getList(sql, Appeal.class,objects);
	}

	@Override
	public List<Appeal> getListAppeal(String id) {
		String sql = "select * from appeal where appeal_id = ?";
		Object[] objects = {id};
		return getList(sql, Appeal.class,objects);
	}

	@Override
	public List<Appeal> getListTypeAppeal(String type) {
		String sql = "select * from appeal where appeal_type = ?";
		Object[] objects = {type};
		PageUtils.pagination(getList(sql, Appeal.class, objects).size());
		sql = "select * from appeal where appeal_type = ? limit ?,?";
		Object[] objects2 = {type,(PageUtils.page-1)*5,5};
		return getList(sql, Appeal.class, objects2);
	}

	@Override
	public int updateAppeal(String id) {
		String sql = "update appeal set appeal_status = '已处理' where appeal_id = ?";
		Object[] objects = {id};
		return updataAll(sql, objects);
	}

	@Override
	public int getUndoAppealNum() {
		String sql = "select * from appeal where appeal_status = '未处理'";
		return getList(sql, Appeal.class).size();
	}

	@Override
	public List<Appeal> getListUndoAppeal() {
		String sql = "select * from appeal where appeal_status = '未处理'";
		return getList(sql, Appeal.class);
	}

}
