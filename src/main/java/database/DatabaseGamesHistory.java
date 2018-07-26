package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.gamesHistory.GameEntity;

public class DatabaseGamesHistory {
	
	List <GameEntity> gamesHistory = new ArrayList<GameEntity>();
	
	public DatabaseGamesHistory(){
		
		gamesHistory.add(new GameEntity(0, 1, 3, 1));
		gamesHistory.add(new GameEntity(1, 0, 0, 1));
		
	}

	public List<GameEntity> getGamesHistory(){
		return this.gamesHistory;
	}
}
