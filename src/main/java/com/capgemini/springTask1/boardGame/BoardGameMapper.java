package com.capgemini.springTask1.boardGame;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BoardGameMapper {
	public BoardGameDTO convert(BoardGameEntity gameEntity){
		BoardGameDTO gameDTO = new BoardGameDTO(gameEntity.getName());
		return gameDTO;
	}
	
	public BoardGameEntity convert( BoardGameDTO gameDTO){
		BoardGameEntity gameEntity = new BoardGameEntity(gameDTO.getName());
		return gameEntity;
	}
	
	
	public List<BoardGameDTO> convert(List <BoardGameEntity> gamesEntities){
		List <BoardGameDTO> gamesDTO = new ArrayList<>();;
		for (int i=0; i<gamesEntities.size(); i++){
			String name = gamesEntities.get(i).getName();
			( (BoardGameDTO) gamesDTO.get(i)).setName(name);
		}
		return gamesDTO;
	}
}
