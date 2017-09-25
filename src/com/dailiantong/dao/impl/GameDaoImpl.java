package com.dailiantong.dao.impl;

import java.util.List;

import com.dailiantong.dao.GameDao;
import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.GameType;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class GameDaoImpl extends JdbcUtils implements GameDao {
	
	/**
	 * 获得全部的游戏名字
	 */
	@Override
	public List<Game> getListGame() {
		String sql = "SELECT * FROM game";
		PageUtils.pagination(getList(sql, Game.class).size());
		sql = "SELECT * FROM game limit ?,?";
		Object[] objects = {(PageUtils.page-1)*5,5};
		return getList(sql, Game.class,objects);
	}
	
	@Override
	public List<Game> getListAllGame() {
		String sql = "SELECT * FROM game";
		return getList(sql, Game.class);
	}
	
	@Override
	public List<GameType> getListType() {
		String sql = "SELECT * FROM game_type";
		return getList(sql, GameType.class);
	}

	@Override
	public List<Game> getListGameById(String id) {
		String sql = "SELECT * FROM game where game_id = ?";
		Object[] objects = {id};
		return getList(sql, Game.class, objects);
	}

	@Override
	public int deleteGameById(String id) {
		String sql = "delete from game where game_id = ?";
		Object[] objects = {id};
		return updataAll(sql, objects);
	}

	@Override
	public int addGame(String id, String name, String type) {
		String sql = "insert into game (`game_id`,`game_name`,`game_typeId`) VALUES(?,?,?)";
		Object[] objects = {id,name,type};
		System.out.println("=====>"+"add");
		return updataAll(sql, objects);
	}

	@Override
	public int updateGame(String id, String name, String type) {
		String sql = "update game set game_name = ? , game_typeId = ? where game_id = ?";
		Object[] objects = {name,type,id};
		return updataAll(sql, objects);
	}

	@Override
	public List<Game> getListGameByType(String type) {
		String sql = "select * from game where game_typeid = ?";
		Object[] objects = {type};
		PageUtils.pagination(getList(sql, Game.class, objects).size());
		sql = "select * from game where game_typeid = ? limit ?,?";
		Object[] objects2 = {type,(PageUtils.page-1)*5,5};
		return getList(sql, Game.class, objects2);
	}
}
