package com.dailiantong.pojo;

public class Game {
	  private int game_id;              //int                            not null,
	  private String  game_name;          //  varchar(20)                    null,
	  private int game_typeId ;        // int  
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public int getGame_typeId() {
		return game_typeId;
	}
	public void setGame_typeId(int game_typeId) {
		this.game_typeId = game_typeId;
	}
	   
}
