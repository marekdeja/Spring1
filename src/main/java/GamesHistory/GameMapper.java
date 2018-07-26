package GamesHistory;

public class GameMapper {
	
	public GameDTO convert (GameEntity gameEntity){
		GameDTO gameDTO = null;
		
		gameDTO.setPlayerId(gameEntity.getPlayerId());
		gameDTO.setOpponentId(gameEntity.getOpponentId());
		gameDTO.setPointsGot(gameEntity.getPointsGot());
		gameDTO.setGameNumber(gameEntity.getGameNumber());
		
		return gameDTO;
	}
	
	public GameEntity convert (GameDTO gameDTO){
		GameEntity gameEntity = null;
		
		gameEntity.setPlayerId(gameDTO.getPlayerId());
		gameEntity.setOpponentId(gameDTO.getOpponentId());
		gameEntity.setPointsGot(gameDTO.getPointsGot());
		gameEntity.setGameNumber(gameDTO.getGameNumber());
		
		return gameEntity;
	}

}
