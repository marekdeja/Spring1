package com.capgemini.springTask1.boardGame;

public class BoardGameDTO {
	private String name;
	
	public BoardGameDTO(){
	}
	
	public BoardGameDTO(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
