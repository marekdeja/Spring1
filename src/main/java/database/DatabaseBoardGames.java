package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.boardGame.BoardGameEntity;

public class DatabaseBoardGames {
	
	private List boardGameList;
	
	public DatabaseBoardGames(){
		List <BoardGameEntity> boardGameList = new ArrayList<>();
		
		boardGameList.add(new BoardGameEntity("Monopoly"));
		boardGameList.add(new BoardGameEntity("Chess"));
		boardGameList.add(new BoardGameEntity("Witcher"));
		boardGameList.add(new BoardGameEntity("Warhammer"));
	
	}
	
	public List getBoardGamesList(){
		return this.boardGameList;
	}
	
}
