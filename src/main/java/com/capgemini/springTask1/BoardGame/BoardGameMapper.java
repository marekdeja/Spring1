package com.capgemini.springTask1.BoardGame;

import java.util.List;

public class BoardGameMapper {
	public BoardGameEntity convert(BoardGameEntity gameDTO){
		return gameDTO;
	}
	public List convert(List gamesDTO){
		return gamesDTO;
	}
}
