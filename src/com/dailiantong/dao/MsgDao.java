package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.Notice;

public interface MsgDao {
	/**
	 * 查询所有公告
	 * @return 公告集合
	 */
	public List<Notice> getAllMsg();
	
	/**
	 * 添加公告
	 * @param notice
	 * @return 
	 */
	int addNotice(Notice notice); 
	
	/**
	 * 按公告查询
	 * @param i
	 * @return
	 */
	Notice getNotice(int i);
	
	/**
	 * 更新修改公告信息
	 * @param notice
	 * @return
	 */
	int updateNotice(Notice notice);

	/**
	 * 删除公告
	 * @param notice_id
	 * @return
	 */
	 int delNotice(int notice_id);
	 
	 /**
	  * 返回第一条公告
	  * @return
	  */
	public Notice getOne();
	
	
	
}
