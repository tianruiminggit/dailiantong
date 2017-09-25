package com.dailiantong.pojo;

public class GameType {
	 	private int game_typeId ;         //int                            not null,
	 	private String game_typeName ;      // varchar(20)    
		public int getGame_typeId() {
			return game_typeId;
		}
		public void setGame_typeId(int game_typeId) {
			this.game_typeId = game_typeId;
		}
		public String getGame_typeName() {
			return game_typeName;
		}
		public void setGame_typeName(String game_typeName) {
			this.game_typeName = game_typeName;
		}
	 	
}
