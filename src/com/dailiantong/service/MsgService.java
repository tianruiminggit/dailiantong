package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.Notice;

public interface MsgService {
	/**
	 * 获得所有公告
	 * @return
	 */
	public List<Notice> getAll();
	
	
	/**
	 * 发布新公告
	 */
	void addNotice(Notice notice);
	
	/**
	 * 查询 公告
	 * @param i
	 * @return
	 */
	Notice findNotice(int i);
	
	/**
	 * 更新修改公告
	 * @param notice
	 */
	void updateNotice(Notice notice);

	/**
	 * 删除公告信息
	 * @param notice_id
	 */
	void delNotice(int notice_id);


	public Notice getOne();
}
