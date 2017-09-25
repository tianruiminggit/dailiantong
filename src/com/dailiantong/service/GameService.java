package com.dailiantong.service;

import java.util.List;

import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.GameType;

public interface GameService {

	List<Game> getListGame();
	/**
	 * ������Ϸ��������
	 * @return
	 */
	List<GameType> getListType();
	/**
	 * ͨ��ID��ѯ������Ϸ��Ϣ
	 * @param id
	 * @return
	 */
	public List<Game> getListGameById(String id);
	
	/***
	 * ͨ��ID��ɾ����Ϸ��Ϣ
	 * @return
	 */
	public int deleteGameById(String id);
	/**
	 * �����Ϸ
	 * @param id
	 * @param name
	 * @param type
	 * @return
	 */
	public int addGame(String id, String name, String type);
	/***
	 * ������Ϸ��Ϣ
	 * @param id
	 * @param name
	 * @param type
	 * @return
	 */
	public int updateGame(String id, String name, String type);
	/**
	 * ͨ����������ѯ����
	 * @param type
	 * @return
	 */
	public List<Game> getListGameByType(String type);
	/**
	 * ��ѯȫ����Ϸ����(����ҳ)
	 * @return
	 */
	List<Game> getListAllGame();
}
