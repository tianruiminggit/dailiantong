package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.Appeal;

public interface AppealDao {

	/***
	 * 获得所有申诉信息
	 * admin
	 * @return
	 */
	List<Appeal> getListAdminAppeal();
	/**
	 * 获得当日申诉信息
	 * admin
	 * @return
	 */
	List<Appeal> getTodayAppeal();
	
	/**
	 * 通过ID检索申诉信息
	 * admin
	 * @return
	 */
	List<Appeal> getListAppeal(String id);
	/**
	 * 通过申诉类型检索申诉信息
	 * admin
	 * @param type
	 * @return
	 */
	List<Appeal> getListTypeAppeal(String type);
	/**
	 * 更新申诉信息
	 * @param id
	 * @return
	 */
	int updateAppeal(String id);
	/**
	 * 获得未处理申诉数量
	 * @return
	 */
	int getUndoAppealNum();
	/**
	 * 获取所有完成订单的信息
	 * @return
	 */
	public List<Appeal> getListUndoAppeal();
	
}
