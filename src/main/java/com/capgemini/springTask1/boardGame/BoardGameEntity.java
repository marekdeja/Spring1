package com.capgemini.springTask1.boardGame;

public class BoardGameEntity {
	private String name;
	
	public BoardGameEntity(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
