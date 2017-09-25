package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.MsgDao;
import com.dailiantong.pojo.Notice;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class MsgDaoImpl extends JdbcUtils implements MsgDao{

	
	@Override
	public List<Notice> getAllMsg() {
		String sql="SELECT * FROM notice order by notice_time DESC ";
		
		//首先获得总的记录数
		PageUtils.pagination(getList(sql, Notice.class).size());
		
		//重写limit sql
		sql="SELECT * FROM notice order by notice_time DESC limit ?,?";
		
		if(PageUtils.page==0){
			PageUtils.page=1;
		}
		//设置显示条数
		int e = 5;
		//设置分页起始位置
		int s= (PageUtils.page-1)*e;
		
		Object[] objects = {s,e};
		return getList(sql,Notice.class,objects);
	}

	@Override
	public int addNotice(Notice notice) {
		String sql="insert into notice value(?,?,?,?,?)";
		Object[] objects={notice.getNotice_id(),notice.getNotice_title(),notice.getNotice_content(),notice.getNotice_time(),notice.getManager_account()};
		
		return updataAll(sql,objects);
		
		
		
	}

	@Override
	public Notice getNotice(int i) {
		String sql="select * from notice where notice_id= ?";
		Object[] objects={i};
		return getBean(sql, Notice.class, objects);
	}

	@Override
	public int  updateNotice(Notice notice) {
		String sql="UPDATE notice set " +
				"notice_title=?  , notice_content =? ,notice_time = ? ,manager_account=? where notice_id=?";
		Object[] objects ={notice.getNotice_title(),notice.getNotice_content(),notice.getNotice_time(),notice.getManager_account(),notice.getNotice_id()};
		return updataAll(sql, objects);
		
	}

	@Override
	public int delNotice(int notice_id) {
		String sql=" DELETE FROM notice WHERE notice_id= ?";
		Object[] objects={notice_id};
		return updataAll(sql, objects);
	}

	@Override
	public Notice getOne() {
		String sql="SELECT * FROM notice ORDER BY notice_time DESC LIMIT 0,1";
		return getBean(sql, Notice.class);
	}

}
