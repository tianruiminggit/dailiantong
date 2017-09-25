package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.Appeal;

public interface AppealDao {

	/***
	 * �������������Ϣ
	 * admin
	 * @return
	 */
	List<Appeal> getListAdminAppeal();
	/**
	 * ��õ���������Ϣ
	 * admin
	 * @return
	 */
	List<Appeal> getTodayAppeal();
	
	/**
	 * ͨ��ID����������Ϣ
	 * admin
	 * @return
	 */
	List<Appeal> getListAppeal(String id);
	/**
	 * ͨ���������ͼ���������Ϣ
	 * admin
	 * @param type
	 * @return
	 */
	List<Appeal> getListTypeAppeal(String type);
	/**
	 * ����������Ϣ
	 * @param id
	 * @return
	 */
	int updateAppeal(String id);
	/**
	 * ���δ������������
	 * @return
	 */
	int getUndoAppealNum();
	/**
	 * ��ȡ������ɶ�������Ϣ
	 * @return
	 */
	public List<Appeal> getListUndoAppeal();
	
}
