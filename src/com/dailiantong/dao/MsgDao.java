package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.Notice;

public interface MsgDao {
	/**
	 * ��ѯ���й���
	 * @return ���漯��
	 */
	public List<Notice> getAllMsg();
	
	/**
	 * ��ӹ���
	 * @param notice
	 * @return 
	 */
	int addNotice(Notice notice); 
	
	/**
	 * �������ѯ
	 * @param i
	 * @return
	 */
	Notice getNotice(int i);
	
	/**
	 * �����޸Ĺ�����Ϣ
	 * @param notice
	 * @return
	 */
	int updateNotice(Notice notice);

	/**
	 * ɾ������
	 * @param notice_id
	 * @return
	 */
	 int delNotice(int notice_id);
	 
	 /**
	  * ���ص�һ������
	  * @return
	  */
	public Notice getOne();
	
	
	
}
