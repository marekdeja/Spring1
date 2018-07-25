package com.capgemini.springTask1.BoardGame;

public class BoardGameDTO {
	private String name;
	
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
