package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.gamesHistory.GameEntity;

public class DatabaseGamesHistory {
	
	private List gamesHistory;
	
	public DatabaseGamesHistory(){
		List <GameEntity> gamesHistory = new ArrayList();
		
		gamesHistory.add(new GameEntity(0, 1, 3, 1));
		gamesHistory.add(new GameEntity(1, 0, 0, 1));
		
	}

	public List getGamesHistory(){
		return this.gamesHistory;
	}
}
