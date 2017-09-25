package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.GameType;

public interface GameDao {

	List<Game> getListGame();
	
	/**
	 * 返回游戏所有类型
	 * @return
	 */
	List<GameType> getListType();
	/**
	 * 通过ID查询返回游戏信息
	 * @param id
	 * @return
	 */
	public List<Game> getListGameById(String id);
	
	/***
	 * 通过ID来删除游戏信息
	 * @return
	 */
	public int deleteGameById(String id);
	/**
	 * 添加游戏
	 * @param id
	 * @param name
	 * @param type
	 * @return
	 */
	public int addGame(String id, String name, String type);    
	/***
	 * 更新游戏信息
	 * @param id
	 * @param name
	 * @param type
	 * @return
	 */
	public int updateGame(String id, String name, String type);
	/***
	 * 通过类型来查询数据
	 * @param type
	 * @return
	 */
	public List<Game> getListGameByType(String type);
	/**
	 * 查询全部游戏名称(不分页)
	 * @return
	 */
	List<Game> getListAllGame();

}
