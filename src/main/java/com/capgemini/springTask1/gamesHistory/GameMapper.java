package com.capgemini.springTask1.gamesHistory;

import org.springframework.stereotype.Component;

@Component
public class GameMapper {
	
	public GameDTO convert (GameEntity gameEntity){
		GameDTO gameDTO = new GameDTO(gameEntity.getPlayerId(), gameEntity.getOpponentId(), gameEntity.getPointsGot(),gameEntity.getGameNumber() );
		return gameDTO;
	}
	
	public GameEntity convert (GameDTO gameDTO){
		GameEntity gameEntity = new GameEntity(gameDTO.getPlayerId(), gameDTO.getOpponentId(), gameDTO.getPointsGot(), gameDTO.getGameNumber());
		return gameEntity;
	}

}
