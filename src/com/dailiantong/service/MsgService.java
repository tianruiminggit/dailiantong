package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.Notice;

public interface MsgService {
	/**
	 * ������й���
	 * @return
	 */
	public List<Notice> getAll();
	
	
	/**
	 * �����¹���
	 */
	void addNotice(Notice notice);
	
	/**
	 * ��ѯ ����
	 * @param i
	 * @return
	 */
	Notice findNotice(int i);
	
	/**
	 * �����޸Ĺ���
	 * @param notice
	 */
	void updateNotice(Notice notice);

	/**
	 * ɾ��������Ϣ
	 * @param notice_id
	 */
	void delNotice(int notice_id);


	public Notice getOne();
}
