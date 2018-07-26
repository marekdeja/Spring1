package com.capgemini.springTask1.BoardGame;

import java.util.List;

public class BoardGameMapper {
	public BoardGameDTO convert(BoardGameEntity gameEntity){
		BoardGameDTO gameDTO = null;
		gameDTO.setName(gameEntity.getName());
		return gameDTO;
	}
	
	public BoardGameEntity convert( BoardGameDTO gameDTO){
		BoardGameEntity gameEntity = null;
		gameEntity.setName(gameDTO.getName());
		return gameEntity;
	}
	
	
	public List convert(List <BoardGameEntity> gamesEntities){
		List gamesDTO = null;
		for (int i=0; i<gamesEntities.size(); i++){
			String name = gamesEntities.get(i).getName();
			( (BoardGameDTO) gamesDTO.get(i)).setName(name);
		}
		return gamesDTO;
	}
}
