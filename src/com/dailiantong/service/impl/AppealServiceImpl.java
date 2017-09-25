package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.AppealDao;
import com.dailiantong.dao.impl.AppealDaoImpl;
import com.dailiantong.pojo.Appeal;
import com.dailiantong.service.AppealService;

public class AppealServiceImpl implements AppealService {

	private AppealDao appealDao = new AppealDaoImpl();
	@Override
	public List<Appeal> getListAdminAppeal() {
		
		return appealDao.getListAdminAppeal();
	}
	@Override
	public List<Appeal> getTodayAppeal() {
		return appealDao.getTodayAppeal();
	}
	@Override
	public List<Appeal> getListAppeal(String id) {
		// TODO Auto-generated method stub
		return appealDao.getListAppeal(id);
	}
	@Override
	public List<Appeal> getListTypeAppeal(String type) {
		// TODO Auto-generated method stub
		return appealDao.getListTypeAppeal(type);
	}
	@Override
	public int updateAppeal(String id) {
		
		return appealDao.updateAppeal(id);
	}
	@Override
	public int getUndoAppealNum() {
		// TODO Auto-generated method stub
		return appealDao.getUndoAppealNum();
	}
	@Override
	public List<Appeal> getListUndoAppeal() {
		// TODO Auto-generated method stub
		return appealDao.getListUndoAppeal();
	}
	

}
