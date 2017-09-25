package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.Appeal;

public interface AppealService {
	/**
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
	/***
	 *  ͨ���������ͼ���������Ϣ
	 *  admin
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
	 * ��ȡδ������������
	 * @return
	 */
	int getUndoAppealNum();
	/**
	 * ����δ��������Ϣ
	 * @return
	 */
	List<Appeal> getListUndoAppeal();
	
	
}
