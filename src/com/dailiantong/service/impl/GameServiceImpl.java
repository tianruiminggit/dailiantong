package com.dailiantong.service.impl;

import java.util.List;

import com.dailiantong.dao.GameDao;
import com.dailiantong.dao.impl.GameDaoImpl;
import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.GameType;
import com.dailiantong.service.GameService;

public class GameServiceImpl implements GameService {

	private GameDao gameDao = new GameDaoImpl();
	
	/**
	 * 获得全部的游戏信息
	 */
	@Override
	public List<Game> getListGame() {
		return gameDao.getListGame();
	}

	@Override
	public List<GameType> getListType() {
		// TODO Auto-generated method stub
		return gameDao.getListType();
	}
	public List<Game> getListGameById(String id){
		return gameDao.getListGameById(id);
		
	}

	@Override
	public int deleteGameById(String id) {
		
		return gameDao.deleteGameById(id);
		
	}

	@Override
	public int addGame(String id, String name, String type) {
		
		return gameDao.addGame(id, name, type);
	}

	@Override
	public int updateGame(String id, String name, String type) {
		return gameDao.updateGame(id, name, type);
	}

	@Override
	public List<Game> getListGameByType(String type) {
		return gameDao.getListGameByType(type);
	}

	@Override
	public List<Game> getListAllGame() {
		return gameDao.getListAllGame();
	}
	

}
