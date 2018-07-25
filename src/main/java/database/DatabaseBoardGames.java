package database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.springTask1.BoardGame.BoardGameEntity;

public class DatabaseBoardGames {
	List <BoardGameEntity> boardGames = new ArrayList<>();
	
	public List getBoardGamesList(){
		List <BoardGameEntity> boardGameList = new ArrayList<>();
		boardGameList.add(new BoardGameEntity("Monopoly"));
		boardGameList.add(new BoardGameEntity("Chess"));
		boardGameList.add(new BoardGameEntity("Witcher"));
		boardGameList.add(new BoardGameEntity("Warhammer"));
		
		return boardGameList;
	}
	
}
